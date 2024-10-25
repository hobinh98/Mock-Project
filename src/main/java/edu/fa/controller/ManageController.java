package edu.fa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.fa.dto.DtoEntitys;
import edu.fa.dto.DtoPropertiesEntitys;
import edu.fa.dto.DtoResponseValidate;
import edu.fa.dto.Search;
import edu.fa.model.HinhAnhHS;
import edu.fa.model.HocSinh;
import edu.fa.model.PhuHuynhHS;
import edu.fa.model.TrangThaiHS;
import edu.fa.service.IDtoEntitysService;
import edu.fa.service.IHinhAnhHSService;
import edu.fa.service.IHocPhiHSService;
import edu.fa.service.IHocSinhService;
import edu.fa.service.IPhuHuynhHSService;
import edu.fa.service.ITrangThaiHSService;

/**
 * ManageController XỬ LÝ CÁC YÊU CẦU HTTP LIÊN QUAN ĐẾN QUẢN LÝ HỌC SINH
 * (HocSinh) VÀ CÁC THỰC THỂ LIÊN QUAN NHƯ PHỤ HUYNH (PhuHuynhHS), HÌNH ẢNH
 * (HinhAnhHS),VÀ TRẠNG THÁI (TrangThaiHS).
 * 
 * NGÀY TẠO         NGƯỜI TẠO
 * --------------------------
 * 01-06-2024       HO BINH
 * 
 */
@RestController
@RequestMapping(value = "/manage")
public class ManageController {

	@Autowired
	private IHocSinhService iHocSinhService;

	@Autowired
	private IPhuHuynhHSService iPhuHuynhHSService;

	@Autowired
	private IHinhAnhHSService iHinhAnhHSService;

	@Autowired
	private ITrangThaiHSService iTrangThaiHSService;

	@Autowired
	private IHocPhiHSService iHocPhiHSService;

	@Autowired
	private IDtoEntitysService iDtoEntitysService;

	/**
	 * 
	 * LẤY DANH SÁCH TẤT CẢ HỌC SINH HIỆN CÓ TRONG database CÙNG TẤT CẢ CÁC THÔNG
	 * TIN BẰNG DtoPropertiesEntitys.
	 * 
	 * @return DANH SÁCH HỌC SINH THEO DtoPropertiesEntitys
	 * 
	 */
	@GetMapping("/list")
	public List<DtoPropertiesEntitys> listObject() {
		return iDtoEntitysService.list();
	}

	/**
	 * 
	 * TÌM KIẾM HỌC SINH BẰNG DtoPropertiesEntitys DỰA TRÊN TIÊU CHÍ TÌM KIẾM ĐƯỢC
	 * CUNG CẤP.
	 * 
	 * @param search ĐỐI TƯỢNG CHỨA CÁC TIÊU CHÍ TÌM KIẾM
	 * 
	 * @return DANH SÁCH HỌC SINH THEO DtoPropertiesEntitys PHÙ HỢP VỚI TIÊU CHÍ TÌM
	 *         KIẾM
	 * 
	 */
	@PostMapping("/listsearch")
	public List<DtoPropertiesEntitys> listSearchObject(@RequestBody Search search) {
		return iDtoEntitysService.listSearch(search);
	}

	/**
	 * 
	 * THÊM MỚI MỘT HỌC SINH CÙNG CÁC THÔNG TIN ĐI THEO BẰNG CÁCH SỬ DỤNG DtoEntitys
	 * ĐỂ CHỨA DỮ LIỆU CẦN ĐƯA VÀO database.
	 * 
	 * @param dtoEntitys ĐỐI TƯỢNG TẠM CHỨA DỮ LIỆU CẦN LƯU VÀO database (insert)
	 * 
	 * @return PHẢN HỒI CHỨA TRẠNG THÁI KIỂM TRA HỢP LỆ VÀ CÁC LỖI NẾU CÓ
	 * 
	 */
	@PostMapping("/insert")
	public DtoResponseValidate insertObject(@RequestBody DtoEntitys dtoEntitys) {

		DtoResponseValidate response = new DtoResponseValidate();

		if (!iHinhAnhHSService.exists(dtoEntitys.getHinhAnhHS().getTenHinhAnh())) {
			response.setSuccess(false);
			response.setMessage("Vui lòng chọn lại ảnh đúng thư mục");
			return response;
		}

		// LƯU THÔNG TIN HỌC SINH
		HocSinh hocSinh = dtoEntitys.getHocSinh();
		iHocSinhService.save(hocSinh);

		// LƯU THÔNG TIN PHỤ HUYNH
		PhuHuynhHS phuHuynhHS = dtoEntitys.getPhuHuynhHS();
		phuHuynhHS.setHocSinh(hocSinh);
		iPhuHuynhHSService.save(phuHuynhHS);

		// LƯU HÌNH ẢNH HỌC SINH
		HinhAnhHS hinhAnhHS = dtoEntitys.getHinhAnhHS();
		hinhAnhHS.setHocSinh(hocSinh);
		iHinhAnhHSService.save(hinhAnhHS);

		// LƯU TRẠNG THÁI HỌC SINH
		TrangThaiHS trangThaiHS = dtoEntitys.getTrangThaiHS();
		trangThaiHS.setHocSinh(hocSinh);
		iTrangThaiHSService.save(trangThaiHS);

		response.setSuccess(true);
		response.setMessage("");
		return response;
	}

	/**
	 * 
	 * CẬP NHẬP THÔNG TIN HỌC SINH BẰNG CÁCH SỬ DỤNG DtoEntitys CHỨA DỮ LIỆU VỀ
	 * THÔNG TIN HỌC SINH HIỆN CÓ TRONG database.
	 * 
	 * @param dtoEntitys ĐỐI TƯỢNG TẠM LƯU TRỮ THÔNG TIN CỦA HỌC SINH CẦN CẬP NHẬP
	 *                   (update)
	 * 
	 * @return PHẢN HỒI CHỨA TRẠNG THÁI KIỂM TRA HỢP LỆ VÀ CÁC LỖI NẾU CÓ
	 * 
	 */
	@PostMapping("/update")
	public DtoResponseValidate updateObject(@RequestBody DtoEntitys dtoEntitys) {

		DtoResponseValidate response = new DtoResponseValidate();

		if (!iHinhAnhHSService.exists(dtoEntitys.getHinhAnhHS().getTenHinhAnh())) {
			response.setSuccess(false);
			response.setMessage("Vui lòng chọn lại ảnh đúng thư mục");
			return response;
		}

		// LẤY ĐỐI TƯỢNG CẦN update HIỆN CÓ TRONG database ĐỂ XỬ LÝ id CHO CÁC THỰC THỂ QUAN HỆ
		HocSinh hocSinhById = iHocSinhService.findById(dtoEntitys.getHocSinh().getMaHocSinh());

		// set LẠI id HỌC SINH LƯU THÔNG TIN HỌC SINH
		HocSinh hocSinh = dtoEntitys.getHocSinh();
		iHocSinhService.saveOrUpdate(hocSinh);

		// set LẠI id PHỤ HUYNH VÀ LƯU THÔNG TIN PHỤ HUYNH
		PhuHuynhHS phuHuynhHS = dtoEntitys.getPhuHuynhHS();
		phuHuynhHS.setMaPhuHuynh(hocSinhById.getPhuHuynhHS().getMaPhuHuynh());
		phuHuynhHS.setHocSinh(hocSinh);
		iPhuHuynhHSService.saveOrUpdate(phuHuynhHS);

		// set LẠI id HÌNH ẢNH VÀ LƯU HÌNH ẢNH HỌC SINH
		HinhAnhHS hinhAnhHS = dtoEntitys.getHinhAnhHS();
		hinhAnhHS.setMaHinhAnh(hocSinhById.getHinhAnhHS().getMaHinhAnh());
		hinhAnhHS.setHocSinh(hocSinh);
		iHinhAnhHSService.saveOrUpdate(hinhAnhHS);

		// set LẠI id TRẠNG THÁI VÀ LƯU TRẠNG THÁI HỌC SINH
		TrangThaiHS trangThaiHS = dtoEntitys.getTrangThaiHS();
		trangThaiHS.setMaTrangThai(hocSinhById.getTrangThaiHS().getMaTrangThai());
		// set LẠI NGÀY BẢO LƯU --> KHÔNG CHO PHÉP BẢO LƯU Ở "CAP NHAP"
		trangThaiHS.setNgayBaoLuu(hocSinhById.getTrangThaiHS().getNgayBaoLuu());
		trangThaiHS.setHocSinh(hocSinh);
		iTrangThaiHSService.saveOrUpdate(trangThaiHS);

		response.setSuccess(true);
		response.setMessage("");
		return response;
	}

	/**
	 * 
	 * CẬP NHẬP TRẠNG THÁI CỦA MỘT HỌC SINH THÀNH 'baoLuu'.
	 * 
	 * @param maHocSinh   MÃ HỌC SINH
	 * @param trangThaiHS ĐỐI TƯỢNG CHỨA THÔNG TIN TRẠNG THÁI BẢO LƯU CỦA HỌC SINH
	 *                    CẦN CẬP NHẬP (update ngayBaoLuu)
	 * @return true GỬI PHẢN HỒI ĐỂ THÔNG BÁO THÔNG TIN CẬP NHẬP CHO NGƯỜI DÙNG
	 * 
	 */
	@PostMapping("/baoluu")
	public boolean baoLuuObject(@RequestParam(name = "maHocSinh") Long maHocSinh, @RequestBody TrangThaiHS trangThaiHS) {
		// LẤY HỌC SINH CẦN BẢO LƯU ĐỂ set LẠI NGÀY BẢO LƯU
		// CascadeType.ALL
		HocSinh hocSinhById = iHocSinhService.findById(maHocSinh);
		hocSinhById.getTrangThaiHS().setNgayBaoLuu(trangThaiHS.getNgayBaoLuu());
		iHocSinhService.saveOrUpdate(hocSinhById);
		return true;
	}

	/**
	 * 
	 * XOÁ MỘT HỌC SINH THEO MÃ NẾU HỌC SINH ỨNG VỚI MÃ NÀY KHÔNG CÒN NỢ HỌC PHÍ.
	 * 
	 * @param maHocSinh MÃ HỌC SINH CẦN XOÁ
	 * 
	 * @return true GỬI PHẢN HỒI ĐỂ THÔNG BÁO THÔNG TIN XOÁ CHO NGƯỜI DÙNG
	 * 
	 */
	@PostMapping("/delete")
	public boolean deleteObject(@RequestBody Long maHocSinh) {
		if (iHocPhiHSService.hocPhi(maHocSinh) < 0f) {
			return false;
		}
		iHocSinhService.delete(maHocSinh);
		return true;
	}

	/**
	 * 
	 * TẠO MÃ HỌC SINH MỚI CHO CHỨC NĂNG THÊM MỚI (insert) BẰNG CÁCH LẤY GIÁ TRỊ MÃ
	 * LỚN NHẤT TRONG DANH SÁCH HỌC SINH HIỆN CÓ CỘNG THÊM 1 (MAX(maHocSinh)+1).
	 * 
	 * @return MAX(maHocSinh) + 1
	 * 
	 */
	@GetMapping("/selectnewid")
	public Long selectNewId() {
		return iHocSinhService.selectNewId();
	}

	@GetMapping("/namhocsearch")
	public List<String> namHocSearch() {
		return iDtoEntitysService.namHocSearch();
	}

	@GetMapping("/lophocsearch")
	public List<String> lopHocSearch() {
		return iDtoEntitysService.lopHocSearch();
	}
}

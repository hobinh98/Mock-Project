package edu.fa.repository.imp;

import java.math.BigInteger;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.fa.dto.DtoPropertiesEntitys;
import edu.fa.dto.Search;
import edu.fa.repository.IDtoEntitysRepository;

/**
 * class DtoEntitysRepository LÀ MỘT TRIỂN KHAI CỦA interface
 * IDtoEntitysRepository. NÓ CUNG CẤP CÁC method ĐỂ TRUY XUẤT VÀ TÌM KIẾM CÁC
 * THÔNG TIN CỦA HỌC SINH VÀ CÁC THỰC THỂ LIÊN QUAN NHƯ PHỤ HUYNH (PhuHuynhHS),
 * HÌNH ẢNH (HinhAnhHS),VÀ TRẠNG THÁI (TrangThaiHS) TỪ database ĐƯỢC LƯU TRỮ TẠM
 * Ở ĐỐI TƯỢNG DtoPropertiesEntitys.
 * 
 * NGÀY TẠO NGƯỜI TẠO -------------------------- 01-06-2024 HO BINH
 * 
 */
@Repository
public class DtoEntitysRepository implements IDtoEntitysRepository {

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * CHUYỂN Object[] SANG DtoPropertiesEntitys.
	 * 
	 * @param resultList DANH SÁCH CÁC Object[]
	 * 
	 * @return DANH SÁCH CÁC DtoPropertiesEntitys
	 * 
	 */
	public List<DtoPropertiesEntitys> convertObjectToDto(List<Object[]> resultList) {
		List<DtoPropertiesEntitys> dtos = new ArrayList<DtoPropertiesEntitys>();
		for (Object[] objects : resultList) {
			Long maHocSinh = ((BigInteger) objects[0]).longValue();
			String hoTen = (String) objects[1];
			String tenThanMat = (String) objects[2];
			Boolean gioiTinh = (Boolean) objects[3];
			LocalDate ngaySinh = null;
			if (objects[4] != null) {
				ngaySinh = ((Date) objects[4]).toLocalDate();
			}
			String doiTuong = (String) objects[5];
			String diaChi = (String) objects[6];
			String danToc = (String) objects[7];
			String lopHienTai = (String) objects[8];
			String tonGiao = (String) objects[9];
			String namHoc = (String) objects[10];
			String tinhCachThoiQuen = (String) objects[11];
			String hoTenCha = (String) objects[12];
			LocalDate namSinhCha = null;
			if (objects[13] != null) {
				namSinhCha = ((Date) objects[13]).toLocalDate();
			}
			String ngheNghiepCha = (String) objects[14];
			String hoTenMe = (String) objects[15];
			LocalDate namSinhMe = null;
			if (objects[16] != null) {
				namSinhMe = ((Date) objects[16]).toLocalDate();
			}
			String ngheNghiepMe = (String) objects[17];
			String dienThoai = (String) objects[18];
			String email = (String) objects[19];
			String ghiChuPhuHuynh = (String) objects[20];
			String tenHinhAnh = (String) objects[21];
			LocalDate ngayVaoHoc = null;
			if (objects[22] != null) {
				ngayVaoHoc = ((Date) objects[22]).toLocalDate();
			}
			LocalDate ngayNghiHoc = null;
			if (objects[23] != null) {
				ngayNghiHoc = ((Date) objects[23]).toLocalDate();
			}
			LocalDate ngayBaoLuu = null;
			if (objects[24] != null) {
				ngayBaoLuu = ((Date) objects[24]).toLocalDate();
			}
			String ghiChuTrangThai = (String) objects[25];
			DtoPropertiesEntitys dto = new DtoPropertiesEntitys(maHocSinh, hoTen, tenThanMat, gioiTinh, ngaySinh,
					doiTuong, diaChi, danToc, lopHienTai, tonGiao, namHoc, tinhCachThoiQuen, hoTenCha, namSinhCha,
					ngheNghiepCha, hoTenMe, namSinhMe, ngheNghiepMe, dienThoai, email, ghiChuPhuHuynh, tenHinhAnh,
					ngayVaoHoc, ngayNghiHoc, ngayBaoLuu, ghiChuTrangThai);
			dtos.add(dto);
		}
		return dtos;
	}

	public final String dtoJoin = "SELECT "// 1
			+ "HS.MaHocSinh, HS.HoTen, HS.TenThanMat, HS.GioiTinh, HS.NgaySinh, HS.DoiTuong, "// 2
			+ "HS.DiaChi, HS.DanToc, HS.LopHienTai, HS.TonGiao, HS.NamHoc, HS.TinhCachThoiQuen, "// 3
			+ "PH.HoTenCha, PH.NamSinhCha, PH.NgheNghiepCha, PH.HoTenMe, " // 4
			+ "PH.NamSinhMe, PH.NgheNghiepMe, PH.DienThoai, PH.Email, PH.GhiChuPhuHuynh, "// 5
			+ "HA.TenHinhAnh, "// 6
			+ "TT.NgayVaoHoc, TT.NgayNghiHoc, TT.NgayBaoLuu, TT.GhiChuTrangThai "// 7
			+ "FROM THONGTINHOCSINH HS " + "\n"// 8
			+ "LEFT JOIN THONGTINPHUHUYNH PH ON PH.MaHocSinh = HS.MaHocSinh "// 9
			+ "LEFT JOIN HINHANHHOCSINH HA ON HA.MaHocSinh = HS.MaHocSinh "// 10
			+ "LEFT JOIN TRANGTHAIHOCSINH TT ON TT.MaHocSinh = HS.MaHocSinh ";// 11

	/**
	 * LẤY DANH SÁCH THÔNG TIN HỌC SINH TỪ database DƯỚI DẠNG ĐỐI TƯỢNG
	 * DtoPropertiesEntitys.
	 * 
	 * @return DANH SÁCH CÁC DtoPropertiesEntitys
	 * 
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<DtoPropertiesEntitys> list() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createNativeQuery(dtoJoin);
		List<Object[]> resultList = query.getResultList();
		return convertObjectToDto(resultList);
	}

	/**
	 * TÌM KIẾM THÔNG TIN DANH SÁCH HỌC SINH ĐƯỢC LƯU TRỮ DƯỚI DẠNG ĐỐI TƯỢNG
	 * DtoPropertiesEntitys DỰA TRÊN CÁC TIÊU CHÍ TÌM KIẾM ĐƯỢC CUNG CẤP.
	 * 
	 * @param search ĐỐI TƯỢNG CHỨA CÁC TIÊU CHÍ TÌM KIẾM
	 * 
	 * @return DANH SÁCH CÁC DtoPropertiesEntitys PHÙ HỢP VỚI TIÊU CHÍ TÌM KIẾM
	 * 
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<DtoPropertiesEntitys> listSearch(Search search) {
		String namHocSearch = search.namHocSearch;
		String lopHocSrarch = search.lopHocSearch;
		Boolean theoId = search.theoId;
		String theoIdSearch = search.theoIdSearch;
		Boolean theoTen = search.theoTen;
		String theoTenSearch = search.theoTenSearch;

		String whereId = "\n WHERE HS.NamHoc = :namHocSearch AND HS.LopHienTai = :lopHocSrarch AND  HS.MaHocSinh = :theoIdSearch ";
		String whereName = "\n WHERE HS.NamHoc = :namHocSearch AND HS.LopHienTai = :lopHocSrarch AND HS.HoTen LIKE :theoTenSearch ";
		String whereNotNameId = "\n WHERE HS.NamHoc = :namHocSearch OR HS.LopHienTai = :lopHocSrarch ";
		String whereAll = "\n WHERE HS.NamHoc = :namHocSearch AND HS.LopHienTai = :lopHocSrarch AND "
				+ " HS.MaHocSinh = :theoIdSearch AND HS.HoTen LIKE :theoTenSearch ";
		String sqlSearchId = dtoJoin + whereId;
		String sqlSearchName = dtoJoin + whereName;
		String sqlSearchNotIdName = dtoJoin + whereNotNameId;
		String sqlSearchAll = dtoJoin + whereAll;
		Session session = sessionFactory.getCurrentSession();
		Query query = null;
		if (theoId != null && theoTen == null) {
			query = session.createNativeQuery(sqlSearchId);
			query.setParameter("namHocSearch", namHocSearch);
			query.setParameter("lopHocSrarch", lopHocSrarch);
			query.setParameter("theoIdSearch", theoIdSearch);
		} else if (theoId == null && theoTen != null) {
			query = session.createNativeQuery(sqlSearchName);
			query.setParameter("namHocSearch", namHocSearch);
			query.setParameter("lopHocSrarch", lopHocSrarch);
			theoTenSearch = "%" + theoTenSearch + "%";
			query.setParameter("theoTenSearch", theoTenSearch);
		} else if (theoId == null && theoTen == null) {
			query = session.createNativeQuery(sqlSearchNotIdName);
			query.setParameter("namHocSearch", namHocSearch);
			query.setParameter("lopHocSrarch", lopHocSrarch);
		} else if (theoId != null && theoTen != null) {
			query = session.createNativeQuery(sqlSearchAll);
			query.setParameter("namHocSearch", namHocSearch);
			query.setParameter("lopHocSrarch", lopHocSrarch);
			query.setParameter("theoIdSearch", theoIdSearch);
			theoTenSearch = "%" + theoTenSearch + "%";
			query.setParameter("theoTenSearch", theoTenSearch);
		}
		List<Object[]> resultList = query.getResultList();
		return convertObjectToDto(resultList);
	}

	/**
	 * LẤY DANH SÁCH GIÁ TRỊ KHÁC NHAU HIỆN CÓ TRONG database Ở CỘT NamHoc CỦA BẢNG
	 * THONGTINHOCSINH.
	 * 
	 * @return DANH SÁCH CÁC GIÁ TRỊ NĂM HỌC KHÁC NHAU
	 * 
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<String> namHocSearch() {
		String dtoJoin = "SELECT DISTINCT NamHoc FROM THONGTINHOCSINH ";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createNativeQuery(dtoJoin);
		List<String> resultList = query.getResultList();
		List<String> namHocSearch = new ArrayList<>(resultList);
		return namHocSearch;
	}

	/**
	 * LẤY DANH SÁCH GIÁ TRỊ KHÁC NHAU HIỆN CÓ TRONG database Ở CỘT LopHienTai CỦA
	 * BẢNG THONGTINHOCSINH.
	 * 
	 * @return DANH SÁCH CÁC GIÁ TRỊ LỚP HIỆN TẠI KHÁC NHAU KHÁC NHAU
	 * 
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<String> lopHocSearch() {
		String dtoJoin = "SELECT DISTINCT LopHienTai FROM THONGTINHOCSINH ";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createNativeQuery(dtoJoin);
		List<String> resultList = query.getResultList();
		List<String> lopHocSearch = new ArrayList<>(resultList);
		return lopHocSearch;
	}
}

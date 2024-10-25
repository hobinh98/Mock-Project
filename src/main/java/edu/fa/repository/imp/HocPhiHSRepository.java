package edu.fa.repository.imp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.fa.model.HocPhiHS;
import edu.fa.repository.IHocPhiHSRepository;

/**
 * class HocPhiHSRepository LÀ MỘT TRIỂN KHAI CỦA interface IHocPhiHSRepository.
 * NÓ CUNG CẤP CÁC method ĐỂ THAO TÁC VỚI CÁC ĐỐI TƯỢNG HocPhiHS TRONG database.
 * 
 * NGÀY TẠO         NGƯỜI TẠO
 * --------------------------
 * 01-06-2024       HO BINH
 * 
 */
@Repository
public class HocPhiHSRepository implements IHocPhiHSRepository {

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * TÌM KIẾM MỘT ĐỐI TƯỢNG HocPhiHS THEO MÃ ID.
	 * 
	 * @param id MÃ ID CỦA ĐỐI TƯỢNG HocPhiHS CẦN TÌM
	 * 
	 * @return ĐỐI TƯỢNG HocPhiHS NẾU TÌM THẤY, NGƯỢC LẠI TRẢ VỀ null
	 * 
	 */
	@Override
	public HocPhiHS findById(String id) {
		Session session = sessionFactory.getCurrentSession();
		return session.find(HocPhiHS.class, id);
	}

	/**
	 * LƯU MỘT ĐỐI TƯỢNG HocPhiHS VÀO database.
	 * 
	 * @param hocPhiHS ĐỐI TƯỢNG HocPhiHS CẦN LƯU
	 * 
	 */
	@Override
	public void save(HocPhiHS hocPhiHS) {
		Session session = sessionFactory.getCurrentSession();
		session.save(hocPhiHS);
	}

	/**
	 * CẬP NHẬP MỘT ĐỐI TƯỢNG HocPhiHS TRONG database.
	 * 
	 * @param hocPhiHS ĐỐI TƯỢNG HocPhiHS CẦN CẬP NHẬP
	 * 
	 */
	@Override
	public void saveOrUpdate(HocPhiHS hocPhiHS) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(hocPhiHS);
	}

	/**
	 * XOÁ MỘT ĐỐI TƯỢNG HocPhiHS KHỎI database.
	 * 
	 * @param hocPhiHS ĐỐI TƯỢNG HocPhiHS CẦN XOÁ
	 * 
	 */
	@Override
	public void delete(HocPhiHS hocPhiHS) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(hocPhiHS);
	}

	/**
	 * LẤY DANH SÁCH TẤT CẢ CÁC ĐỐI TƯỢNG HocPhiHS TRONG database.
	 * 
	 * @return DANH SÁCH TẤT CẢ CÁC ĐỐI TƯỢNG HocPhiHS
	 * 
	 */
	@Override
	public List<HocPhiHS> list() {
		Session session = sessionFactory.getCurrentSession();
		NativeQuery<HocPhiHS> nativeQuery = session.createNativeQuery("SELECT * FROM THONGTINHOCPHI", HocPhiHS.class);
		List<HocPhiHS> models = nativeQuery.list();
		return models;
	}

	/**
	 * TÍNH TOÁN HỌC PHÍ CỦA MỘT HỌC SINH DỰA TRÊN MÃ HỌC SINH.
	 * 
	 * @param maHocSinh MÃ HỌC SINH
	 * 
	 * @return SỐ TIỀN HỌC PHÍ ĐÃ TÍNH TOÁN
	 * 
	 */
	@Override
	public Float hocPhi(Long maHocSinh) {
		Session session = sessionFactory.getCurrentSession();
		String sql = "SELECT * FROM THONGTINHOCPHI WHERE MaHocSinh = :maHocSinh";
		NativeQuery<HocPhiHS> nativeQuery = session.createNativeQuery(sql, HocPhiHS.class);
		nativeQuery.setParameter("maHocSinh", maHocSinh);
		List<HocPhiHS> models = nativeQuery.list();
		float tienDaThu = 0f;
		float tienGiamTru = 0f;
		float hocPhi = 0f;
		for (HocPhiHS hocPhiHS : models) {
			if (hocPhiHS.getTienDaThu() != null) {
				tienDaThu = tienDaThu + hocPhiHS.getTienDaThu();
			}
			if (hocPhiHS.getTienGiamTru() != null) {
				tienGiamTru = tienGiamTru + hocPhiHS.getTienGiamTru();
			}
			if (hocPhiHS.getHocPhi() != null) {
				hocPhi = hocPhi + hocPhiHS.getHocPhi();
			}
		}
		return tienDaThu + tienGiamTru - hocPhi;
	}
}

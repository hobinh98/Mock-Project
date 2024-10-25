package edu.fa.repository.imp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.fa.model.HocSinh;
import edu.fa.repository.IHocSinhRepository;

/**
 * class HocSinhRepository LÀ MỘT TRIỂN KHAI CỦA interface IHocSinhRepository.
 * NÓ CUNG CẤP CÁC method THAO TÁC VỚI CÁC ĐỐI TƯỢNG HocSinh TRONG database.
 * 
 * NGÀY TẠO         NGƯỜI TẠO
 * --------------------------
 * 01-06-2024       HO BINH
 * 
 */
@Repository
public class HocSinhRepository implements IHocSinhRepository {

	@Autowired
	private SessionFactory sessionFactory;
	
	/**
     * TÌM KIẾM MỘT ĐỐI TƯỢNG HocSinh THEO MÃ ID.
     * 
     * @param id MÃ ID CỦA ĐỐI TƯỢNG HocSinh CẦN TÌM
     * 
     * @return ĐỐI TƯỢNG HocSinh NẾU TÌM THẤY, NGƯỢC LẠI TRẢ VỀ null
     * 
     */
	@Override
	public HocSinh findById(Long id) {
		Session session = sessionFactory.getCurrentSession();
		return session.find(HocSinh.class, id);
	}
	
	/**
     * LƯU MỘT ĐỐI TƯỢNG HocSinh VÀO database.
     * 
     * @param hocSinh ĐỐI TƯỢNG HocSinh CẦN LƯU
     * 
     */
	@Override
	public void save(HocSinh hocSinh) {
		Session session = sessionFactory.getCurrentSession();
		session.save(hocSinh);
	}
	
	/**
     * CẬP NHẬP MỘT ĐỐI TƯỢNG HocSinh TRONG database.
     * 
     * @param hocSinh ĐỐI TƯỢNG HocSinh CẦN CẬP NHẬP
     * 
     */
	@Override
	public void saveOrUpdate(HocSinh hocSinh) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(hocSinh);
	}
	
	/**
     * XOÁ MỘT ĐỐI TƯỢNG HocSinh KHỎI database.
     * 
     * @param hocSinh ĐỐI TƯỢNG HocSinh CẦN XOÁ
     * 
     */
	@Override
	public void delete(HocSinh hocSinh) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(hocSinh);
	}
	
	/**
     * LẤY DANH SÁCH TẤT CẢ CÁC ĐỐI TƯỢNG HocSinh TỪ database.
     *
     * @return DANH SÁCH CÁC ĐỐI TƯỢNG HocSinh
     * 
     */
	@Override
	public List<HocSinh> list() {
		Session session = sessionFactory.getCurrentSession();
		NativeQuery<HocSinh> nativeQuery = session.createNativeQuery("SELECT * FROM THONGTINHOCSINH", HocSinh.class);
		List<HocSinh> models = nativeQuery.list();
		return models;
	}
	
	/**
	 * LẤY MÃ HỌC SINH MỚI NHẤT TRONG database VÀ TĂNG MÃ NÀY LÊN 1.
	 * NẾU KHÔNG TÌM THẤY MÃ HỌC SINH NÀO THÌ TRẢ VỀ MÃ KHỞI ĐẦU LÀ 100.
     *
     * @return MÃ HỌC SINH MỚI
     * 
     */
	@Override
	public Long selectNewId() {
		Session session = sessionFactory.getCurrentSession();
		String sql = "SELECT MAX(MaHocSinh) FROM THONGTINHOCSINH";
		NativeQuery<?> nativeQuery = session.createNativeQuery(sql);
		Number result = (Number) nativeQuery.uniqueResult();
		if (result != null) {
			return result.longValue() + 1L;
		}
		return 0L + 100L;
	}
}

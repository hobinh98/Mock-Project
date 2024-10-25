package edu.fa.repository.imp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.fa.model.TrangThaiHS;
import edu.fa.repository.ITrangThaiHSRepository;

/**
 * class TrangThaiHSRepository LÀ MỘT TRIỂN KHAI CỦA GIAO DIỆN ITrangThaiHSRepository.
 * NÓ CUNG CẤP CÁC method ĐỂ THAO TÁC VỚI CÁC ĐÔI TƯỢNG TrangThaiHS TRONG database.
 * 
 * NGÀY TẠO         NGƯỜI TẠO
 * --------------------------
 * 01-06-2024       HO BINH
 * 
 */
@Repository
public class TrangThaiHSRepository implements ITrangThaiHSRepository {

	@Autowired
	private SessionFactory sessionFactory;
	
	/**
     * TÌM KIẾM MỘT ĐỐI TƯỢNG TrangThaiHS THEO MÃ ID.
     *
     * @param id MÃ ID CỦA ĐỐI TƯỢNG TrangThaiHS CẦN TÌM
     * 
     * @return ĐỐI TƯỢNG TrangThaiHS NẾU TÌM THẤY, NGƯỢC LẠI TRẢ VỀ null
     * 
     */
	@Override
	public TrangThaiHS findById(Long id) {
		Session session = sessionFactory.getCurrentSession();
		return session.find(TrangThaiHS.class, id);
	}
	
	/**
     * LƯU MỘT ĐỐI TƯỢNG TrangThaiHS VÀO database.
     *
     * @param trangThaiHS ĐỐI TƯỢNG TrangThaiHS CẦN LƯU
     * 
     */
	@Override
	public void save(TrangThaiHS trangThaiHS) {
		Session session = sessionFactory.getCurrentSession();
		session.save(trangThaiHS);
	}
	
	 /**
     * CẬP NHẬP MỘT ĐỐI TƯỢNG TrangThaiHS TRONG database.
     *
     * @param trangThaiHS ĐỐI TƯỢNG TrangThaiHS CẦN CẬP NHẬP
     * 
     */
	@Override
	public void saveOrUpdate(TrangThaiHS trangThaiHS) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(trangThaiHS);
	}
	
	/**
     * XOÁ MỘT ĐỐI TƯỢNG TrangThaiHS KHỎI database.
     *
     * @param trangThaiHS ĐỐI TƯỢNG TrangThaiHS CẦN XOÁ
     * 
     */
	@Override
	public void delete(TrangThaiHS trangThaiHS) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(trangThaiHS);
	}
	
	/**
     * LẤY DANH SÁCH TẤT CẢ CÁC ĐỐI TƯỢNG TrangThaiHS TỪ database.
     *
     * @return DANH SÁCH CÁC ĐỐI TƯỢNG TrangThaiHS
     * 
     */
	@Override
	public List<TrangThaiHS> list() {
		Session session = sessionFactory.getCurrentSession();
		NativeQuery<TrangThaiHS> nativeQuery = session.createNativeQuery("SELECT * FROM TRANGTHAIHOCSINH",
				TrangThaiHS.class);
		List<TrangThaiHS> models = nativeQuery.list();
		return models;
	}
}

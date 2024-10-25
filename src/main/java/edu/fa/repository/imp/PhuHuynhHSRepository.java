package edu.fa.repository.imp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.fa.model.PhuHuynhHS;
import edu.fa.repository.IPhuHuynhHSRepository;

/**
 * class PhuHuynhHSRepository LÀ MỘT TRIỂN KHAI CỦA interface IPhuHuynhHSRepository.
 * NÓ CUNG CẤP CÁC method ĐỂ THAO TÁC VỚI CÁC ĐỐI TƯỢNG TRONG PhuHuynhHS database.
 * 
 * NGÀY TẠO         NGƯỜI TẠO
 * --------------------------
 * 01-06-2024       HO BINH
 * 
 */
@Repository
public class PhuHuynhHSRepository implements IPhuHuynhHSRepository {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	/**
     * TÌM KIẾM MỘT ĐỐI TƯỢNG PhuHuynhHS THEO MÃ ID.
     *
     * @param id MÃ ID CỦA ĐỐI TƯỢNG PhuHuynhHS CẦN TÌM
     * 
     * @return ĐỐI TƯỢNG PhuHuynhHS NẾU TÌM THẤY, NGƯỢC LẠI TRẢ VỀ null
     * 
     */
	@Override
	public PhuHuynhHS findById(Long id) {
		Session session = sessionFactory.getCurrentSession();
		return session.find(PhuHuynhHS.class, id);
	}
	
	 /**
     * LƯU MỘT ĐỐI TƯỢNG PhuHuynhHS VÀO database.
     *
     * @param phuHuynhHS ĐỐI TƯỢNG PhuHuynhHS CẦN LƯU
     * 
     */
	@Override
	public void save(PhuHuynhHS phuHuynhHS) {
		Session session = sessionFactory.getCurrentSession();
		session.save(phuHuynhHS);
	}
	
	/**
     * CẬP NHẬP MỘT ĐỐI TƯỢNG PhuHuynhHS TRONG database.
     *
     * @param phuHuynhHS ĐỐI TƯỢNG PhuHuynhHS CẦN CẬP NHẬP
     * 
     */
	@Override
	public void saveOrUpdate(PhuHuynhHS phuHuynhHS) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(phuHuynhHS);
	}
	
	/**
     * XOÁ MỘT ĐỐI TƯỢNG PhuHuynhHS KHỎI database.
     *
     * @param phuHuynhHS ĐỐI TƯỢNG PhuHuynhHS CẦN XOÁ
     * 
     */
	@Override
	public void delete(PhuHuynhHS phuHuynhHS) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(phuHuynhHS);
	}
	
	/**
     * LẤY DANH SÁCH TẤT CẢ CÁC ĐỐI TƯỢNG PhuHuynhHS TỪ database.
     *
     * @return DANH SÁCH CÁC ĐỐI TƯỢNG PhuHuynhHS
     * 
     */
	@Override
	public List<PhuHuynhHS> list() {
		Session session = sessionFactory.getCurrentSession();
		NativeQuery<PhuHuynhHS> nativeQuery = session.createNativeQuery("SELECT * FROM THONGTINPHUHUYNH",
				PhuHuynhHS.class);
		List<PhuHuynhHS> models = nativeQuery.list();
		return models;
	}
}

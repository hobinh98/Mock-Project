package edu.fa.repository.imp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.fa.model.HinhAnhHS;
import edu.fa.repository.IHinhAnhHSRepository;

/**
 * class HinhAnhHSRepository LÀ MỘT TRIỂN KHAI CỦA interface IHinhAnhHSRepository.
 * NÓ CUNG CẤP CÁC method ĐỂ THAO TÁC VỚI CÁC ĐỐI TƯỢNG HinhAnhHS TRONG database.
 * 
 * NGÀY TẠO         NGƯỜI TẠO
 * --------------------------
 * 01-06-2024       HO BINH
 * 
 */
@Repository
public class HinhAnhHSRepository implements IHinhAnhHSRepository {

	@Autowired
	private SessionFactory sessionFactory;
	
	/**
     * TÌM KIẾM MỘT ĐỐI TƯỢNG HinhAnhHS THEO MÃ ID.
     *
     * @param id MÃ ID CỦA ĐỐI TƯỢNG HinhAnhHS CẦN TÌM
     * 
     * @return ĐỐI TƯỢNG HinhAnhHS NẾU TÌM THẤY, NGƯỢC LẠI TRẢ VỀ null
     * 
     */
	@Override
	public HinhAnhHS findById(Long id) {
		Session session = sessionFactory.getCurrentSession();
		return session.find(HinhAnhHS.class, id);
	}
	
	/**
     * LƯU MỘT ĐỐI TƯỢNG HinhAnhHS VÀO database.
     *
     * @param hinhAnhHS ĐỐI TƯỢNG HinhAnhHS CẦN LƯU
     * 
     */
	@Override
	public void save(HinhAnhHS hinhAnhHS) {
		Session session = sessionFactory.getCurrentSession();
		session.save(hinhAnhHS);
	}
	
	/**
     * CẬP NHẬP MỘT ĐỐI TƯỢNG HinhAnhHS TRONG database.
     *
     * @param hinhAnhHS ĐỐI TƯỢNG HinhAnhHS CẦN CẬP NHẬP
     * 
     */
	@Override
	public void saveOrUpdate(HinhAnhHS hinhAnhHS) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(hinhAnhHS);
	}
	
	/**
     * XOÁ MỘT ĐỐI TƯỢNG HinhAnhHS KHỎI database.
     *
     * @param hinhAnhHS ĐỐI TƯỢNG HinhAnhHS CẦN XOÁ
     * 
     */
	@Override
	public void delete(HinhAnhHS hinhAnhHS) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(hinhAnhHS);
	}
	
	/**
     * LẤY DANH SÁCH TẤT CẢ CÁC ĐỐI TƯỢNG HinhAnhHS TỪ database.
     *
     * @return DANH SÁCH CÁC ĐỐI TƯỢNG HinhAnhHS
     * 
     */
	@Override
	public List<HinhAnhHS> list() {
		Session session = sessionFactory.getCurrentSession();
		NativeQuery<HinhAnhHS> nativeQuery = session.createNativeQuery("SELECT * FROM HINHANHHOCSINH", HinhAnhHS.class);
		List<HinhAnhHS> hinhAnhHSs = nativeQuery.list();
		return hinhAnhHSs;
	}
}

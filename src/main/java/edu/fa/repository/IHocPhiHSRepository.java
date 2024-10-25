package edu.fa.repository;

import java.util.List;

import edu.fa.model.HocPhiHS;

public interface IHocPhiHSRepository {
	
	public HocPhiHS findById(String id);

	public void save(HocPhiHS hocPhiHS);

	public void saveOrUpdate(HocPhiHS hocPhiHS);

	public void delete(HocPhiHS hocPhiHS);

	public List<HocPhiHS> list();
	
	public Float hocPhi(Long maHocSinh);
}

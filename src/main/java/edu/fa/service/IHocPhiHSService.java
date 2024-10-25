package edu.fa.service;

import java.util.List;

import edu.fa.model.HocPhiHS;

public interface IHocPhiHSService {

	public HocPhiHS findById(String id);

	public void save(HocPhiHS hocPhiHS);

	public void saveOrUpdate(HocPhiHS hocPhiHS);

	public void delete(String id);

	public List<HocPhiHS> list();

	public Float hocPhi(Long maHocSinh);
}

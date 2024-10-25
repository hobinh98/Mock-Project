package edu.fa.service;

import java.util.List;

import edu.fa.model.HocSinh;

public interface IHocSinhService {

	public HocSinh findById(Long id);

	public void save(HocSinh hocSinh);

	public void saveOrUpdate(HocSinh hocSinh);

	public void delete(Long id);

	public List<HocSinh> list();

	public Long selectNewId();
}

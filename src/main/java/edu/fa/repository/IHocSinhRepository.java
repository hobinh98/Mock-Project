package edu.fa.repository;

import java.util.List;

import edu.fa.model.HocSinh;

public interface IHocSinhRepository {

	public HocSinh findById(Long id);

	public void save(HocSinh hocSinh);

	public void saveOrUpdate(HocSinh hocSinh);

	public void delete(HocSinh hocSinh);

	public List<HocSinh> list();

	public Long selectNewId();
}

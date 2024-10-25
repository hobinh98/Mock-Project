package edu.fa.repository;

import java.util.List;

import edu.fa.model.HinhAnhHS;

public interface IHinhAnhHSRepository {

	public HinhAnhHS findById(Long id);

	public void save(HinhAnhHS hinhAnhHS);

	public void saveOrUpdate(HinhAnhHS hinhAnhHS);

	public void delete(HinhAnhHS hinhAnhHS);

	public List<HinhAnhHS> list();
}

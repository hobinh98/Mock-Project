package edu.fa.repository;

import java.util.List;

import edu.fa.model.TrangThaiHS;

public interface ITrangThaiHSRepository {

	public TrangThaiHS findById(Long id);

	public void save(TrangThaiHS trangThaiHS);

	public void saveOrUpdate(TrangThaiHS trangThaiHS);

	public void delete(TrangThaiHS trangThaiHS);

	public List<TrangThaiHS> list();
}

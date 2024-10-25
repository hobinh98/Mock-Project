package edu.fa.service;

import java.util.List;

import edu.fa.model.TrangThaiHS;

public interface ITrangThaiHSService {

	public TrangThaiHS findById(Long id);

	public void save(TrangThaiHS trangThaiHS);

	public void saveOrUpdate(TrangThaiHS trangThaiHS);

	public void delete(Long id);

	public List<TrangThaiHS> list();
}

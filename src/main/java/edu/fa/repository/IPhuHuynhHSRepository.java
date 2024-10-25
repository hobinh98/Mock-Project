package edu.fa.repository;

import java.util.List;

import edu.fa.model.PhuHuynhHS;

public interface IPhuHuynhHSRepository {

	public PhuHuynhHS findById(Long id);

	public void save(PhuHuynhHS phuHuynhHS);

	public void saveOrUpdate(PhuHuynhHS phuHuynhHS);

	public void delete(PhuHuynhHS phuHuynhHS);

	public List<PhuHuynhHS> list();
}

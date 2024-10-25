package edu.fa.service;

import java.util.List;

import edu.fa.model.PhuHuynhHS;

public interface IPhuHuynhHSService {

	public PhuHuynhHS findById(Long id);

	public void save(PhuHuynhHS phuHuynhHS);

	public void saveOrUpdate(PhuHuynhHS phuHuynhHS);

	public void delete(Long id);

	public List<PhuHuynhHS> list();
}

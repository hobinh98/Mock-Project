package edu.fa.service;

import java.util.List;

import edu.fa.model.HinhAnhHS;

public interface IHinhAnhHSService {

	public HinhAnhHS findById(Long id);

	public void save(HinhAnhHS hinhAnhHS);

	public void saveOrUpdate(HinhAnhHS hinhAnhHS);

	public void delete(Long id);

	public List<HinhAnhHS> list();

	public boolean exists(String nameFile);
}

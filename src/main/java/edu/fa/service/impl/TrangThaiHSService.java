package edu.fa.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.fa.model.TrangThaiHS;
import edu.fa.repository.ITrangThaiHSRepository;
import edu.fa.service.ITrangThaiHSService;

@Service
@Transactional
public class TrangThaiHSService implements ITrangThaiHSService {

	@Autowired
	private ITrangThaiHSRepository iTrangThaiHSRepository;

	@Override
	public TrangThaiHS findById(Long id) {
		return iTrangThaiHSRepository.findById(id);
	}

	@Override
	public void save(TrangThaiHS trangThaiHS) {
		iTrangThaiHSRepository.save(trangThaiHS);
	}

	@Override
	public void saveOrUpdate(TrangThaiHS trangThaiHS) {
		iTrangThaiHSRepository.saveOrUpdate(trangThaiHS);
	}

	@Override
	public void delete(Long id) {
		TrangThaiHS model = findById(id);
		if (model != null) {
			iTrangThaiHSRepository.delete(model);
		}
	}

	@Override
	public List<TrangThaiHS> list() {
		return iTrangThaiHSRepository.list();
	}
}

package edu.fa.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.fa.model.PhuHuynhHS;
import edu.fa.repository.IPhuHuynhHSRepository;
import edu.fa.service.IPhuHuynhHSService;

@Service
@Transactional
public class PhuHuynhHSService implements IPhuHuynhHSService {

	@Autowired
	private IPhuHuynhHSRepository iPhuHuynhHSRepository;

	@Override
	public PhuHuynhHS findById(Long id) {
		return iPhuHuynhHSRepository.findById(id);
	}

	@Override
	public void save(PhuHuynhHS phuHuynhHS) {
		iPhuHuynhHSRepository.save(phuHuynhHS);
	}

	@Override
	public void saveOrUpdate(PhuHuynhHS phuHuynhHS) {
		iPhuHuynhHSRepository.saveOrUpdate(phuHuynhHS);
	}

	@Override
	public void delete(Long id) {
		PhuHuynhHS phuHuynhHS = findById(id);
		if (phuHuynhHS != null) {
			iPhuHuynhHSRepository.delete(phuHuynhHS);
		}
	}

	@Override
	public List<PhuHuynhHS> list() {
		return iPhuHuynhHSRepository.list();
	}
}

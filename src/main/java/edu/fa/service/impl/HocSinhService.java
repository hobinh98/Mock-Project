package edu.fa.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.fa.model.HocSinh;
import edu.fa.repository.IHocSinhRepository;
import edu.fa.service.IHocSinhService;

@Service
@Transactional
public class HocSinhService implements IHocSinhService {

	@Autowired
	private IHocSinhRepository iHocSinhRepository;

	@Override
	public HocSinh findById(Long id) {
		return iHocSinhRepository.findById(id);
	}

	@Override
	public void save(HocSinh hocSinh) {
		iHocSinhRepository.save(hocSinh);
	}

	@Override
	public void saveOrUpdate(HocSinh hocSinh) {
		iHocSinhRepository.saveOrUpdate(hocSinh);
	}

	@Override
	public void delete(Long id) {
		HocSinh hocSinh = findById(id);
		if (hocSinh != null) {
			iHocSinhRepository.delete(hocSinh);
		}
	}

	@Override
	public List<HocSinh> list() {
		return iHocSinhRepository.list();
	}

	@Override
	public Long selectNewId() {
		return iHocSinhRepository.selectNewId();
	}
}

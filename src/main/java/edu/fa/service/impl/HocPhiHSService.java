package edu.fa.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.fa.model.HocPhiHS;
import edu.fa.repository.IHocPhiHSRepository;
import edu.fa.service.IHocPhiHSService;

@Service
@Transactional
public class HocPhiHSService implements IHocPhiHSService {

	@Autowired
	private IHocPhiHSRepository iHocPhiHSRepository;

	@Override
	public HocPhiHS findById(String id) {
		return iHocPhiHSRepository.findById(id);
	}

	@Override
	public void save(HocPhiHS hocPhiHS) {
		iHocPhiHSRepository.save(hocPhiHS);

	}

	@Override
	public void saveOrUpdate(HocPhiHS hocPhiHS) {
		iHocPhiHSRepository.saveOrUpdate(hocPhiHS);
	}

	@Override
	public void delete(String id) {
		HocPhiHS hocPhiHS = findById(id);
		if (hocPhiHS != null) {
			iHocPhiHSRepository.delete(hocPhiHS);
		}
	}

	@Override
	public List<HocPhiHS> list() {
		return iHocPhiHSRepository.list();
	}

	@Override
	public Float hocPhi(Long maHocSinh) {
		return iHocPhiHSRepository.hocPhi(maHocSinh);
	}
}

package edu.fa.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import edu.fa.model.HinhAnhHS;
import edu.fa.repository.IHinhAnhHSRepository;
import edu.fa.service.IHinhAnhHSService;
import edu.fa.xulyfile.XulyFile;

@Service
@Transactional
public class HinhAnhHSService implements IHinhAnhHSService {

	@Autowired
	private IHinhAnhHSRepository iHinhAnhHSRepository;

	@Override
	public HinhAnhHS findById(Long id) {
		return iHinhAnhHSRepository.findById(id);
	}

	@Override
	public void save(HinhAnhHS hinhAnhHS) {
		iHinhAnhHSRepository.save(hinhAnhHS);
	}

	@Override
	public void saveOrUpdate(HinhAnhHS hinhAnhHS) {
		iHinhAnhHSRepository.saveOrUpdate(hinhAnhHS);
	}

	@Override
	public void delete(Long id) {
		HinhAnhHS hinhAnhHS = findById(id);
		if (hinhAnhHS != null) {
			iHinhAnhHSRepository.delete(hinhAnhHS);
		}
	}

	@Override
	public List<HinhAnhHS> list() {
		return iHinhAnhHSRepository.list();
	}

	@Value("${urlFile}")
	private String urlFile;

	@Override
	public boolean exists(String nameFile) {
		return XulyFile.exists(urlFile + nameFile);
	}
}

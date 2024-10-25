package edu.fa.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.fa.dto.DtoPropertiesEntitys;
import edu.fa.dto.Search;
import edu.fa.repository.IDtoEntitysRepository;
import edu.fa.service.IDtoEntitysService;

@Service
@Transactional
public class DtoEntitysService implements IDtoEntitysService {

	@Autowired
	private IDtoEntitysRepository iDtoEntitysRepository;

	@Override
	public List<DtoPropertiesEntitys> list() {
		return iDtoEntitysRepository.list();
	}

	@Override
	public List<DtoPropertiesEntitys> listSearch(Search search) {
		return iDtoEntitysRepository.listSearch(search);
	}

	@Override
	public List<String> namHocSearch() {
		return iDtoEntitysRepository.namHocSearch();
	}

	@Override
	public List<String> lopHocSearch() {
		return iDtoEntitysRepository.lopHocSearch();
	}
}

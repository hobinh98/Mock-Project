package edu.fa.repository;

import java.util.List;

import edu.fa.dto.DtoPropertiesEntitys;
import edu.fa.dto.Search;

public interface IDtoEntitysRepository {

	public List<DtoPropertiesEntitys> list();

	public List<DtoPropertiesEntitys> listSearch(Search search);

	public List<String> namHocSearch();

	public List<String> lopHocSearch();
}

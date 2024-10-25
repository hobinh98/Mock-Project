package edu.fa.dto;

public class Search {

	public String namHocSearch;
	public String lopHocSearch;
	public Boolean theoId;
	public String theoIdSearch;
	public Boolean theoTen;
	public String theoTenSearch;

	public Search() {
		super();
	}

	public Search(String namHocSearch, String lopHocSearch, Boolean theoId, String theoIdSearch, Boolean theoTen,
			String theoTenSearch) {
		super();
		this.namHocSearch = namHocSearch;
		this.lopHocSearch = lopHocSearch;
		this.theoId = theoId;
		this.theoIdSearch = theoIdSearch;
		this.theoTen = theoTen;
		this.theoTenSearch = theoTenSearch;
	}

	public String getNamHocSearch() {
		return namHocSearch;
	}

	public void setNamHocSearch(String namHocSearch) {
		this.namHocSearch = namHocSearch;
	}

	public String getLopHocSearch() {
		return lopHocSearch;
	}

	public void setLopHocSearch(String lopHocSearch) {
		this.lopHocSearch = lopHocSearch;
	}

	public Boolean getTheoId() {
		return theoId;
	}

	public void setTheoId(Boolean theoId) {
		this.theoId = theoId;
	}

	public String getTheoIdSearch() {
		return theoIdSearch;
	}

	public void setTheoIdSearch(String theoIdSearch) {
		this.theoIdSearch = theoIdSearch;
	}

	public Boolean getTheoTen() {
		return theoTen;
	}

	public void setTheoTen(Boolean theoTen) {
		this.theoTen = theoTen;
	}

	public String getTheoTenSearch() {
		return theoTenSearch;
	}

	public void setTheoTenSearch(String theoTenSearch) {
		this.theoTenSearch = theoTenSearch;
	}

	@Override
	public String toString() {
		return "Search [namHocSearch=" + namHocSearch + ", lopHocSearch=" + lopHocSearch + ", theoId=" + theoId
				+ ", theoIdSearch=" + theoIdSearch + ", theoTen=" + theoTen + ", theoTenSearch=" + theoTenSearch + "]";
	}
}

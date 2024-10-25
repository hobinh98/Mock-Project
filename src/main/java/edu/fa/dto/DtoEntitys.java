package edu.fa.dto;

import edu.fa.model.HinhAnhHS;
import edu.fa.model.HocSinh;
import edu.fa.model.PhuHuynhHS;
import edu.fa.model.TrangThaiHS;

public class DtoEntitys {

	HocSinh hocSinh;

	PhuHuynhHS phuHuynhHS;

	HinhAnhHS hinhAnhHS;

	TrangThaiHS trangThaiHS;

	public DtoEntitys() {
		super();
	}

	public DtoEntitys(HocSinh hocSinh, PhuHuynhHS phuHuynhHS, HinhAnhHS hinhAnhHS, TrangThaiHS trangThaiHS) {
		super();
		this.hocSinh = hocSinh;
		this.phuHuynhHS = phuHuynhHS;
		this.hinhAnhHS = hinhAnhHS;
		this.trangThaiHS = trangThaiHS;
	}

	public HocSinh getHocSinh() {
		return hocSinh;
	}

	public void setHocSinh(HocSinh hocSinh) {
		this.hocSinh = hocSinh;
	}

	public PhuHuynhHS getPhuHuynhHS() {
		return phuHuynhHS;
	}

	public void setPhuHuynhHS(PhuHuynhHS phuHuynhHS) {
		this.phuHuynhHS = phuHuynhHS;
	}

	public HinhAnhHS getHinhAnhHS() {
		return hinhAnhHS;
	}

	public void setHinhAnhHS(HinhAnhHS hinhAnhHS) {
		this.hinhAnhHS = hinhAnhHS;
	}

	public TrangThaiHS getTrangThaiHS() {
		return trangThaiHS;
	}

	public void setTrangThaiHS(TrangThaiHS trangThaiHS) {
		this.trangThaiHS = trangThaiHS;
	}
}

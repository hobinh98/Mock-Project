package edu.fa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import edu.fa.model.serializable.SeriaHocPhiId;

@Entity
@Table(name = "THONGTINHOCPHI")
@IdClass(SeriaHocPhiId.class)
public class HocPhiHS {

	@Id
	@Column(name = "Thang")
	private Integer thang;

	@Id
	@Column(name = "NamHoc")
	private Integer namHoc;

	@Id
	@ManyToOne
	@JoinColumn(name = "MaHocSinh")
	private HocSinh hocSinh;

	@Column(name = "HocPhi")
	private Float hocPhi;

	@Column(name = "TienGiamTru")
	private Float tienGiamTru;

	@Column(name = "TienNoThangTruoc")
	private Float tienNoThangTruoc;

	@Column(name = "TienDaThu")
	private Float tienDaThu;

	@Column(name = "DichVuCongThem")
	private String dichVuCongThem;

	@Column(name = "GhiChu")
	private String ghiChu;

	public HocPhiHS() {
		super();
	}

	public HocPhiHS(Integer thang, Integer namHoc, HocSinh hocSinh, Float hocPhi, Float tienGiamTru,
			Float tienNoThangTruoc, Float tienDaThu, String dichVuCongThem, String ghiChu) {
		super();
		this.thang = thang;
		this.namHoc = namHoc;
		this.hocSinh = hocSinh;
		this.hocPhi = hocPhi;
		this.tienGiamTru = tienGiamTru;
		this.tienNoThangTruoc = tienNoThangTruoc;
		this.tienDaThu = tienDaThu;
		this.dichVuCongThem = dichVuCongThem;
		this.ghiChu = ghiChu;
	}

	public Integer getThang() {
		return thang;
	}

	public void setThang(Integer thang) {
		this.thang = thang;
	}

	public Integer getNamHoc() {
		return namHoc;
	}

	public void setNamHoc(Integer namHoc) {
		this.namHoc = namHoc;
	}

	public HocSinh getHocSinh() {
		return hocSinh;
	}

	public void setHocSinh(HocSinh hocSinh) {
		this.hocSinh = hocSinh;
	}

	public Float getHocPhi() {
		return hocPhi;
	}

	public void setHocPhi(Float hocPhi) {
		this.hocPhi = hocPhi;
	}

	public Float getTienGiamTru() {
		return tienGiamTru;
	}

	public void setTienGiamTru(Float tienGiamTru) {
		this.tienGiamTru = tienGiamTru;
	}

	public Float getTienNoThangTruoc() {
		return tienNoThangTruoc;
	}

	public void setTienNoThangTruoc(Float tienNoThangTruoc) {
		this.tienNoThangTruoc = tienNoThangTruoc;
	}

	public Float getTienDaThu() {
		return tienDaThu;
	}

	public void setTienDaThu(Float tienDaThu) {
		this.tienDaThu = tienDaThu;
	}

	public String getDichVuCongThem() {
		return dichVuCongThem;
	}

	public void setDichVuCongThem(String dichVuCongThem) {
		this.dichVuCongThem = dichVuCongThem;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	@Override
	public String toString() {
		return "HocPhiHS [thang=" + thang + ", namHoc=" + namHoc + ", hocPhi=" + hocPhi + ", tienGiamTru=" + tienGiamTru
				+ ", tienNoThangTruoc=" + tienNoThangTruoc + ", tienDaThu=" + tienDaThu + ", dichVuCongThem="
				+ dichVuCongThem + ", ghiChu=" + ghiChu + "]";
	}
}

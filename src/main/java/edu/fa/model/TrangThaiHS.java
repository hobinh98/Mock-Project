package edu.fa.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import edu.fa.validation.NgayBaoLuu;
import edu.fa.validation.NgayNghiHoc;
import edu.fa.validation.NgayVaoHoc;

@Entity
@Table(name = "TRANGTHAIHOCSINH")
@NgayVaoHoc
@NgayNghiHoc
@NgayBaoLuu
public class TrangThaiHS {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MaTrangThai")
	private Long maTrangThai;// 1

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "NgayVaoHoc")
	@NotNull
	private LocalDate ngayVaoHoc;// 2

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "NgayNghiHoc")
	private LocalDate ngayNghiHoc;// 3

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "NgayBaoLuu")
	private LocalDate ngayBaoLuu;// 4

	@Column(name = "GhiChuTrangThai")
	private String ghiChuTrangThai;// 5

	@OneToOne
	@JoinColumn(name = "MaHocSinh")
	private HocSinh hocSinh;

	public TrangThaiHS() {
		super();
	}

	public TrangThaiHS(Long maTrangThai, LocalDate ngayVaoHoc, LocalDate ngayNghiHoc, LocalDate ngayBaoLuu,
			String ghiChuTrangThai, HocSinh hocSinh) {
		super();
		this.maTrangThai = maTrangThai;
		this.ngayVaoHoc = ngayVaoHoc;
		this.ngayNghiHoc = ngayNghiHoc;
		this.ngayBaoLuu = ngayBaoLuu;
		this.ghiChuTrangThai = ghiChuTrangThai;
		this.hocSinh = hocSinh;
	}

	public TrangThaiHS(LocalDate ngayVaoHoc, LocalDate ngayNghiHoc, LocalDate ngayBaoLuu, String ghiChuTrangThai,
			HocSinh hocSinh) {
		super();
		this.ngayVaoHoc = ngayVaoHoc;
		this.ngayNghiHoc = ngayNghiHoc;
		this.ngayBaoLuu = ngayBaoLuu;
		this.ghiChuTrangThai = ghiChuTrangThai;
		this.hocSinh = hocSinh;
	}

	public Long getMaTrangThai() {
		return maTrangThai;
	}

	public void setMaTrangThai(Long maTrangThai) {
		this.maTrangThai = maTrangThai;
	}

	public LocalDate getNgayVaoHoc() {
		return ngayVaoHoc;
	}

	public void setNgayVaoHoc(LocalDate ngayVaoHoc) {
		this.ngayVaoHoc = ngayVaoHoc;
	}

	public LocalDate getNgayNghiHoc() {
		return ngayNghiHoc;
	}

	public void setNgayNghiHoc(LocalDate ngayNghiHoc) {
		this.ngayNghiHoc = ngayNghiHoc;
	}

	public LocalDate getNgayBaoLuu() {
		return ngayBaoLuu;
	}

	public void setNgayBaoLuu(LocalDate ngayBaoLuu) {
		this.ngayBaoLuu = ngayBaoLuu;
	}

	public String getGhiChuTrangThai() {
		return ghiChuTrangThai;
	}

	public void setGhiChuTrangThai(String ghiChuTrangThai) {
		this.ghiChuTrangThai = ghiChuTrangThai;
	}

	public HocSinh getHocSinh() {
		return hocSinh;
	}

	public void setHocSinh(HocSinh hocSinh) {
		this.hocSinh = hocSinh;
	}

	@Override
	public String toString() {
		return "TrangThaiHS [maTrangThai=" + maTrangThai + ", ngayVaoHoc=" + ngayVaoHoc + ", ngayNghiHoc=" + ngayNghiHoc
				+ ", ngayBaoLuu=" + ngayBaoLuu + ", ghiChuTrangThai=" + ghiChuTrangThai + "]";
	}

}

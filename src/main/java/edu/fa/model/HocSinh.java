package edu.fa.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import edu.fa.validation.MinText;
import edu.fa.validation.NgaySinh;

@Entity
@Table(name = "THONGTINHOCSINH")
public class HocSinh {

	@Id
	@Column(name = "MaHocSinh")
	private Long maHocSinh;// 1
	
	@MinText
	@Column(name = "HoTen")
	@NotBlank
	private String hoTen;// 2

	@Column(name = "TenThanMat")
	private String tenThanMat;// 3

	@Column(name = "GioiTinh")
	@NotNull
	private Boolean gioiTinh;// 4

	@NgaySinh
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "NgaySinh")
	@NotNull
	private LocalDate ngaySinh;// 5

	@Column(name = "DoiTuong")
	@NotBlank
	private String doiTuong;// 6
	
	@MinText
	@Column(name = "DiaChi")
	@NotBlank
	private String diaChi;// 7

	@Column(name = "DanToc")
	@NotBlank
	private String danToc;// 8

	@Column(name = "LopHienTai")
	@NotBlank
	private String lopHienTai;// 9

	@Column(name = "TonGiao")
	private String tonGiao;// 10

	@Column(name = "NamHoc")
	@NotBlank
	private String namHoc;// 11

	@Column(name = "TinhCachThoiQuen")
	private String tinhCachThoiQuen;// 12

	@OneToOne(mappedBy = "hocSinh", cascade = CascadeType.ALL)
	private PhuHuynhHS phuHuynhHS;// 13

	@OneToOne(mappedBy = "hocSinh", cascade = CascadeType.ALL)
	private HinhAnhHS hinhAnhHS;// 14

	@OneToOne(mappedBy = "hocSinh", cascade = CascadeType.ALL)
	private TrangThaiHS trangThaiHS;// 15

	@OneToMany(mappedBy = "hocSinh", cascade = CascadeType.ALL)
	private List<HocPhiHS> dangKyMonHocs = new ArrayList<HocPhiHS>();

	public HocSinh() {
		super();
	}

	public HocSinh(Long maHocSinh, String hoTen, String tenThanMat, Boolean gioiTinh, LocalDate ngaySinh,
			String doiTuong, String diaChi, String danToc, String lopHienTai, String tonGiao, String namHoc,
			String tinhCachThoiQuen, PhuHuynhHS phuHuynhHS, HinhAnhHS hinhAnhHS, TrangThaiHS trangThaiHS,
			List<HocPhiHS> dangKyMonHocs) {
		super();
		this.maHocSinh = maHocSinh;
		this.hoTen = hoTen;
		this.tenThanMat = tenThanMat;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.doiTuong = doiTuong;
		this.diaChi = diaChi;
		this.danToc = danToc;
		this.lopHienTai = lopHienTai;
		this.tonGiao = tonGiao;
		this.namHoc = namHoc;
		this.tinhCachThoiQuen = tinhCachThoiQuen;
		this.phuHuynhHS = phuHuynhHS;
		this.hinhAnhHS = hinhAnhHS;
		this.trangThaiHS = trangThaiHS;
		this.dangKyMonHocs = dangKyMonHocs;
	}

	public HocSinh(String hoTen, String tenThanMat, Boolean gioiTinh, LocalDate ngaySinh, String doiTuong,
			String diaChi, String danToc, String lopHienTai, String tonGiao, String namHoc, String tinhCachThoiQuen) {
		super();
		this.hoTen = hoTen;
		this.tenThanMat = tenThanMat;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.doiTuong = doiTuong;
		this.diaChi = diaChi;
		this.danToc = danToc;
		this.lopHienTai = lopHienTai;
		this.tonGiao = tonGiao;
		this.namHoc = namHoc;
		this.tinhCachThoiQuen = tinhCachThoiQuen;
	}

	public Long getMaHocSinh() {
		return maHocSinh;
	}

	public void setMaHocSinh(Long maHocSinh) {
		this.maHocSinh = maHocSinh;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getTenThanMat() {
		return tenThanMat;
	}

	public void setTenThanMat(String tenThanMat) {
		this.tenThanMat = tenThanMat;
	}

	public Boolean getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(Boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public LocalDate getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(LocalDate ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getDoiTuong() {
		return doiTuong;
	}

	public void setDoiTuong(String doiTuong) {
		this.doiTuong = doiTuong;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getDanToc() {
		return danToc;
	}

	public void setDanToc(String danToc) {
		this.danToc = danToc;
	}

	public String getLopHienTai() {
		return lopHienTai;
	}

	public void setLopHienTai(String lopHienTai) {
		this.lopHienTai = lopHienTai;
	}

	public String getTonGiao() {
		return tonGiao;
	}

	public void setTonGiao(String tonGiao) {
		this.tonGiao = tonGiao;
	}

	public String getNamHoc() {
		return namHoc;
	}

	public void setNamHoc(String namHoc) {
		this.namHoc = namHoc;
	}

	public String getTinhCachThoiQuen() {
		return tinhCachThoiQuen;
	}

	public void setTinhCachThoiQuen(String tinhCachThoiQuen) {
		this.tinhCachThoiQuen = tinhCachThoiQuen;
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

	public List<HocPhiHS> getDangKyMonHocs() {
		return dangKyMonHocs;
	}

	public void setDangKyMonHocs(List<HocPhiHS> dangKyMonHocs) {
		this.dangKyMonHocs = dangKyMonHocs;
	}

	@Override
	public String toString() {
		return "HocSinh [maHocSinh=" + maHocSinh + ", hoTen=" + hoTen + ", tenThanMat=" + tenThanMat + ", gioiTinh="
				+ gioiTinh + ", ngaySinh=" + ngaySinh + ", doiTuong=" + doiTuong + ", diaChi=" + diaChi + ", danToc="
				+ danToc + ", lopHienTai=" + lopHienTai + ", tonGiao=" + tonGiao + ", namHoc=" + namHoc
				+ ", tinhCachThoiQuen=" + tinhCachThoiQuen + "]";
	}

}

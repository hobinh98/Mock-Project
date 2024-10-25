package edu.fa.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class DtoPropertiesEntitys {

	private Long maHocSinh;// 1
	private String hoTen;// 2
	private String tenThanMat;// 3
	private Boolean gioiTinh;// 4
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate ngaySinh;// 5
	private String doiTuong;// 6
	private String diaChi;// 7
	private String danToc;// 8
	private String lopHienTai;// 9
	private String tonGiao;// 10
	private String namHoc;// 11
	private String tinhCachThoiQuen;// 12

	private String hoTenCha;// 2
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate namSinhCha;// 3
	private String ngheNghiepCha;// 4
	private String hoTenMe;// 5
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate namSinhMe;// 6
	private String ngheNghiepMe;// 7
	private String dienThoai;// 8
	private String email;// 9
	private String ghiChuPhuHuynh;// 10

	private String tenHinhAnh;// 2

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate ngayVaoHoc;// 2
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate ngayNghiHoc;// 3
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate ngayBaoLuu;// 4
	private String ghiChuTrangThai;// 5

	public DtoPropertiesEntitys() {
		super();
	}

	public DtoPropertiesEntitys(Long maHocSinh, String hoTen, String tenThanMat, Boolean gioiTinh, LocalDate ngaySinh,
			String doiTuong, String diaChi, String danToc, String lopHienTai, String tonGiao, String namHoc,
			String tinhCachThoiQuen, String hoTenCha, LocalDate namSinhCha, String ngheNghiepCha, String hoTenMe,
			LocalDate namSinhMe, String ngheNghiepMe, String dienThoai, String email, String ghiChuPhuHuynh,
			String tenHinhAnh, LocalDate ngayVaoHoc, LocalDate ngayNghiHoc, LocalDate ngayBaoLuu,
			String ghiChuTrangThai) {
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
		this.hoTenCha = hoTenCha;
		this.namSinhCha = namSinhCha;
		this.ngheNghiepCha = ngheNghiepCha;
		this.hoTenMe = hoTenMe;
		this.namSinhMe = namSinhMe;
		this.ngheNghiepMe = ngheNghiepMe;
		this.dienThoai = dienThoai;
		this.email = email;
		this.ghiChuPhuHuynh = ghiChuPhuHuynh;
		this.tenHinhAnh = tenHinhAnh;
		this.ngayVaoHoc = ngayVaoHoc;
		this.ngayNghiHoc = ngayNghiHoc;
		this.ngayBaoLuu = ngayBaoLuu;
		this.ghiChuTrangThai = ghiChuTrangThai;
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

	public String getHoTenCha() {
		return hoTenCha;
	}

	public void setHoTenCha(String hoTenCha) {
		this.hoTenCha = hoTenCha;
	}

	public LocalDate getNamSinhCha() {
		return namSinhCha;
	}

	public void setNamSinhCha(LocalDate namSinhCha) {
		this.namSinhCha = namSinhCha;
	}

	public String getNgheNghiepCha() {
		return ngheNghiepCha;
	}

	public void setNgheNghiepCha(String ngheNghiepCha) {
		this.ngheNghiepCha = ngheNghiepCha;
	}

	public String getHoTenMe() {
		return hoTenMe;
	}

	public void setHoTenMe(String hoTenMe) {
		this.hoTenMe = hoTenMe;
	}

	public LocalDate getNamSinhMe() {
		return namSinhMe;
	}

	public void setNamSinhMe(LocalDate namSinhMe) {
		this.namSinhMe = namSinhMe;
	}

	public String getNgheNghiepMe() {
		return ngheNghiepMe;
	}

	public void setNgheNghiepMe(String ngheNghiepMe) {
		this.ngheNghiepMe = ngheNghiepMe;
	}

	public String getDienThoai() {
		return dienThoai;
	}

	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGhiChuPhuHuynh() {
		return ghiChuPhuHuynh;
	}

	public void setGhiChuPhuHuynh(String ghiChuPhuHuynh) {
		this.ghiChuPhuHuynh = ghiChuPhuHuynh;
	}

	public String getTenHinhAnh() {
		return tenHinhAnh;
	}

	public void setTenHinhAnh(String tenHinhAnh) {
		this.tenHinhAnh = tenHinhAnh;
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

	@Override
	public String toString() {
		return "DtoPropertiesEntitys [maHocSinh=" + maHocSinh + ", hoTen=" + hoTen + ", tenThanMat=" + tenThanMat
				+ ", gioiTinh=" + gioiTinh + ", ngaySinh=" + ngaySinh + ", doiTuong=" + doiTuong + ", diaChi=" + diaChi
				+ ", danToc=" + danToc + ", lopHienTai=" + lopHienTai + ", tonGiao=" + tonGiao + ", namHoc=" + namHoc
				+ ", tinhCachThoiQuen=" + tinhCachThoiQuen + ", hoTenCha=" + hoTenCha + ", namSinhCha=" + namSinhCha
				+ ", ngheNghiepCha=" + ngheNghiepCha + ", hoTenMe=" + hoTenMe + ", namSinhMe=" + namSinhMe
				+ ", ngheNghiepMe=" + ngheNghiepMe + ", dienThoai=" + dienThoai + ", email=" + email
				+ ", ghiChuPhuHuynh=" + ghiChuPhuHuynh + ", tenHinhAnh=" + tenHinhAnh + ", ngayVaoHoc=" + ngayVaoHoc
				+ ", ngayNghiHoc=" + ngayNghiHoc + ", ngayBaoLuu=" + ngayBaoLuu + ", ghiChuTrangThai=" + ghiChuTrangThai
				+ "]";
	}
}

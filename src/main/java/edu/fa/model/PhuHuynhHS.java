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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import edu.fa.validation.MinText;
import edu.fa.validation.NamSinh;

@Entity
@Table(name = "THONGTINPHUHUYNH")
public class PhuHuynhHS {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MaPhuHuynh")
	private Long maPhuHuynh;// 1
	
	@MinText
	@Column(name = "HoTenCha")
	@NotBlank
	private String hoTenCha;// 2

	@NamSinh
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "NamSinhCha")
	@NotNull
	private LocalDate namSinhCha;// 3

	@MinText
	@Column(name = "NgheNghiepCha")
	@NotBlank
	private String ngheNghiepCha;// 4

	@MinText
	@Column(name = "HoTenMe")
	@NotBlank
	private String hoTenMe;// 5

//	@NamSinh
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "NamSinhMe")
	@NotNull
	private LocalDate namSinhMe;// 6

	@MinText
	@Column(name = "NgheNghiepMe")
	@NotBlank
	private String ngheNghiepMe;// 7

	@Column(name = "DienThoai")
	@NotBlank
	private String dienThoai;// 8

	@Column(name = "Email")
	private String email;// 9

	@Column(name = "GhiChuPhuHuynh")
	private String ghiChuPhuHuynh;// 10

	@OneToOne
	@JoinColumn(name = "MaHocSinh")
	private HocSinh hocSinh;

	public PhuHuynhHS() {
		super();
	}

	public PhuHuynhHS(Long maPhuHuynh, @NotBlank String hoTenCha, @NotNull LocalDate namSinhCha,
			@NotBlank String ngheNghiepCha, @NotBlank String hoTenMe, @NotNull LocalDate namSinhMe,
			@NotBlank String ngheNghiepMe, @NotBlank String dienThoai, String email, String ghiChuPhuHuynh,
			HocSinh hocSinh) {
		super();
		this.maPhuHuynh = maPhuHuynh;
		this.hoTenCha = hoTenCha;
		this.namSinhCha = namSinhCha;
		this.ngheNghiepCha = ngheNghiepCha;
		this.hoTenMe = hoTenMe;
		this.namSinhMe = namSinhMe;
		this.ngheNghiepMe = ngheNghiepMe;
		this.dienThoai = dienThoai;
		this.email = email;
		this.ghiChuPhuHuynh = ghiChuPhuHuynh;
		this.hocSinh = hocSinh;
	}

	public PhuHuynhHS(@NotBlank String hoTenCha, @NotNull LocalDate namSinhCha, @NotBlank String ngheNghiepCha,
			@NotBlank String hoTenMe, @NotNull LocalDate namSinhMe, @NotBlank String ngheNghiepMe,
			@NotBlank String dienThoai, String email, String ghiChuPhuHuynh, HocSinh hocSinh) {
		super();
		this.hoTenCha = hoTenCha;
		this.namSinhCha = namSinhCha;
		this.ngheNghiepCha = ngheNghiepCha;
		this.hoTenMe = hoTenMe;
		this.namSinhMe = namSinhMe;
		this.ngheNghiepMe = ngheNghiepMe;
		this.dienThoai = dienThoai;
		this.email = email;
		this.ghiChuPhuHuynh = ghiChuPhuHuynh;
		this.hocSinh = hocSinh;
	}

	public Long getMaPhuHuynh() {
		return maPhuHuynh;
	}

	public void setMaPhuHuynh(Long maPhuHuynh) {
		this.maPhuHuynh = maPhuHuynh;
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

	public HocSinh getHocSinh() {
		return hocSinh;
	}

	public void setHocSinh(HocSinh hocSinh) {
		this.hocSinh = hocSinh;
	}

	@Override
	public String toString() {
		return "PhuHuynhHS [maPhuHuynh=" + maPhuHuynh + ", hoTenCha=" + hoTenCha + ", namSinhCha=" + namSinhCha
				+ ", ngheNghiepCha=" + ngheNghiepCha + ", hoTenMe=" + hoTenMe + ", namSinhMe=" + namSinhMe
				+ ", ngheNghiepMe=" + ngheNghiepMe + ", dienThoai=" + dienThoai + ", email=" + email
				+ ", ghiChuPhuHuynh=" + ghiChuPhuHuynh + "]";
	}
}

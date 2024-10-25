package edu.fa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "HINHANHHOCSINH")
public class HinhAnhHS {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MaHinhAnh")
	private Long maHinhAnh;

	@Column(name = "TenHinhAnh")
	@NotBlank
	private String tenHinhAnh;

	@OneToOne
	@JoinColumn(name = "MaHocSinh")
	private HocSinh hocSinh;

	public HinhAnhHS() {
		super();
	}

	public HinhAnhHS(Long maHinhAnh, String tenHinhAnh, HocSinh hocSinh) {
		super();
		this.maHinhAnh = maHinhAnh;
		this.tenHinhAnh = tenHinhAnh;
		this.hocSinh = hocSinh;
	}

	public HinhAnhHS(String tenHinhAnh, HocSinh hocSinh) {
		super();
		this.tenHinhAnh = tenHinhAnh;
		this.hocSinh = hocSinh;
	}

	public Long getMaHinhAnh() {
		return maHinhAnh;
	}

	public void setMaHinhAnh(Long maHinhAnh) {
		this.maHinhAnh = maHinhAnh;
	}

	public String getTenHinhAnh() {
		return tenHinhAnh;
	}

	public void setTenHinhAnh(String tenHinhAnh) {
		this.tenHinhAnh = tenHinhAnh;
	}

	public HocSinh getHocSinh() {
		return hocSinh;
	}

	public void setHocSinh(HocSinh hocSinh) {
		this.hocSinh = hocSinh;
	}

	@Override
	public String toString() {
		return "HinhAnhHS [maHinhAnh=" + maHinhAnh + ", tenHinhAnh=" + tenHinhAnh + "]";
	}

}

package edu.fa.validation;

import edu.fa.model.TrangThaiHS;

import java.time.LocalDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NgayVaoHocValidator implements ConstraintValidator<NgayVaoHoc, TrangThaiHS> {

	@Override
	public boolean isValid(TrangThaiHS trangThaiHS, ConstraintValidatorContext context) {
		// NẾU GIÁ TRỊ TIÊU CHÍ CẦN XỬ LÝ LÝ LÀ null THÌ LOẠI BỎ RÀNG BUỘC HIỆN TẠI
		if (trangThaiHS.getNgayVaoHoc() == null || trangThaiHS.getHocSinh().getNgaySinh() == null) {
			return true;
		}
		// ĐIỀU KIỆN NHẬN insert
		int yearNgaySinh = trangThaiHS.getHocSinh().getNgaySinh().getYear();
		int yearNgayVaoHoc = trangThaiHS.getNgayVaoHoc().getYear();
		boolean afterNgaySinh3Nam = yearNgayVaoHoc - yearNgaySinh >= 3;
		boolean beforeNgayHienTai = trangThaiHS.getNgayVaoHoc().isBefore(LocalDate.now());
		boolean equalNgayHienTai = trangThaiHS.getNgayVaoHoc().isEqual(LocalDate.now());
		boolean trueNgayVaoHoc = afterNgaySinh3Nam && beforeNgayHienTai || equalNgayHienTai;

		if (!trueNgayVaoHoc) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(LocalDate.now().toString() + " Error @NgayVaoHoc")
					.addConstraintViolation();
		}

		return trueNgayVaoHoc;
	}
}
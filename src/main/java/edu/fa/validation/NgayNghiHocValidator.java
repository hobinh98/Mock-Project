package edu.fa.validation;

import edu.fa.model.TrangThaiHS;

import java.time.LocalDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NgayNghiHocValidator implements ConstraintValidator<NgayNghiHoc, TrangThaiHS> {

	@Override
	public boolean isValid(TrangThaiHS trangThaiHS, ConstraintValidatorContext context) {
		// NẾU GIÁ TRỊ TIÊU CHÍ CẦN XỬ LÝ LÝ LÀ null THÌ LOẠI BỎ RÀNG BUỘC HIỆN TẠI
		if (trangThaiHS.getNgayVaoHoc() == null || trangThaiHS.getNgayNghiHoc() == null) {
			return true;
		}
		// ĐIỀU KIỆN NHẬN insert
		boolean afterNgayVaoHoc = trangThaiHS.getNgayNghiHoc().isAfter(trangThaiHS.getNgayVaoHoc());
		boolean beforeNgayHienTai = trangThaiHS.getNgayNghiHoc().isBefore(LocalDate.now());
		boolean equalNgayHienTai = trangThaiHS.getNgayNghiHoc().isEqual(LocalDate.now());
		boolean trueNgayVaoHoc = afterNgayVaoHoc && beforeNgayHienTai || equalNgayHienTai;

		if (!trueNgayVaoHoc) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(LocalDate.now().toString() + " Error @NgayNghiHoc")
					.addConstraintViolation();
		}

		return trueNgayVaoHoc;
	}
}
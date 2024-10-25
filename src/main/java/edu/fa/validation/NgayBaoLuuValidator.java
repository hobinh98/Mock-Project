package edu.fa.validation;

import edu.fa.model.TrangThaiHS;

import java.time.LocalDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NgayBaoLuuValidator implements ConstraintValidator<NgayBaoLuu, TrangThaiHS> {

	@Override
	public boolean isValid(TrangThaiHS trangThaiHS, ConstraintValidatorContext context) {
		// NẾU GIÁ TRỊ TIÊU CHÍ CẦN XỬ LÝ LÝ LÀ null THÌ LOẠI BỎ RÀNG BUỘC HIỆN TẠI
		if (trangThaiHS.getNgayVaoHoc() == null || trangThaiHS.getNgayBaoLuu() == null) {
			return true;
		}
		// ĐIỀU KIỆN NHẬN insert
		boolean afterNgayVaoHoc = trangThaiHS.getNgayBaoLuu().isAfter(trangThaiHS.getNgayVaoHoc());
		boolean beforeNgayHienTai = trangThaiHS.getNgayBaoLuu().isBefore(LocalDate.now());
		boolean equalNgayHienTai = trangThaiHS.getNgayBaoLuu().isEqual(LocalDate.now());
		boolean trueNgayBaoLuu = afterNgayVaoHoc && beforeNgayHienTai || equalNgayHienTai;

		if (!trueNgayBaoLuu) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(LocalDate.now().toString() + " Error @NgayBaoLuu")
					.addConstraintViolation();
		}

		return trueNgayBaoLuu;
	}
}
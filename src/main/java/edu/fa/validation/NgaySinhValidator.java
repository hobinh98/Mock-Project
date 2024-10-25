package edu.fa.validation;

import java.time.LocalDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NgaySinhValidator implements ConstraintValidator<NgaySinh, LocalDate> {

	@Override
	public void initialize(NgaySinh constraintAnnotation) {
	}

	@Override
	public boolean isValid(LocalDate ngaySinh, ConstraintValidatorContext context) {
		// NẾU GIÁ TRỊ TIÊU CHÍ CẦN XỬ LÝ LÝ LÀ null THÌ LOẠI BỎ RÀNG BUỘC HIỆN TẠI
		if (ngaySinh == null) {
			return true;
		}
		// ĐIỀU KIỆN NHẬN insert
		LocalDate now = LocalDate.now();
		int namNow = now.getYear();
		int namNgaySinh = ngaySinh.getYear();
		int dkNamSinh = namNow - namNgaySinh;
		boolean trueNgaySinh = dkNamSinh >= 3 && dkNamSinh <= 6;

		if (!trueNgaySinh) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(LocalDate.now().toString() + " Error @NgaySinh")
					.addConstraintViolation();
		}

		return trueNgaySinh;
	}
}
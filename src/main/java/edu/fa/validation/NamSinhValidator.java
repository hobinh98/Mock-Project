package edu.fa.validation;

import java.time.LocalDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NamSinhValidator implements ConstraintValidator<NamSinh, LocalDate> {

	@Override
	public void initialize(NamSinh constraintAnnotation) {
	}

	@Override
	public boolean isValid(LocalDate namSinh, ConstraintValidatorContext context) {
		// NẾU GIÁ TRỊ TIÊU CHÍ CẦN XỬ LÝ LÝ LÀ null THÌ LOẠI BỎ RÀNG BUỘC HIỆN TẠI
		if (namSinh == null) {
			return true;
		}
		// ĐIỀU KIỆN NHẬN insert
		int nam = namSinh.getYear();
		boolean trueNamSinh = nam >= 1960 && nam <= 2003;

		if (!trueNamSinh) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(LocalDate.now().toString() + " Error @NamSinh")
					.addConstraintViolation();
		}

		return trueNamSinh;
	}
}
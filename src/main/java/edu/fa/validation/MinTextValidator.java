package edu.fa.validation;

import java.time.LocalDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MinTextValidator implements ConstraintValidator<MinText, String> {

	@Override
	public void initialize(MinText constraintAnnotation) {
	}

	@Override
	public boolean isValid(String text, ConstraintValidatorContext context) {
		// NẾU GIÁ TRỊ TIÊU CHÍ CẦN XỬ LÝ LÝ LÀ null THÌ LOẠI BỎ RÀNG BUỘC HIỆN TẠI
		if (text == null) {
			return true;
		}
		// ĐIỀU KIỆN NHẬN insert
		boolean trueMinText = text.length() >= 4;

		if (!trueMinText) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(LocalDate.now().toString() + " Error @MinText")
					.addConstraintViolation();
		}

		return trueMinText;
	}
}
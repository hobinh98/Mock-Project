package edu.fa.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = NgayNghiHocValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface NgayNghiHoc {
	String message() default "message";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
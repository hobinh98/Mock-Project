package edu.fa.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = NgayVaoHocValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface NgayVaoHoc {
	String message() default "message";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
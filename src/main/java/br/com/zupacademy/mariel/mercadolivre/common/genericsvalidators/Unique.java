package br.com.zupacademy.mariel.mercadolivre.common.genericsvalidators;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = GaranteAtributoComValorUnico.class)
public @interface Unique {

	String message() default "Atributo permite apenas valores únicos";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	String value() default "";

	String attribute();

	Class<?> entity();


}

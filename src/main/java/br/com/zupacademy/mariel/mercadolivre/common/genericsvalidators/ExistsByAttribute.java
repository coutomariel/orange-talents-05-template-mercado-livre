package br.com.zupacademy.mariel.mercadolivre.common.genericsvalidators;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = GaranteQueExisteObjetoPeloAtributoInformado.class)
public @interface ExistsByAttribute {
	
	String message() default "Recurso não encontrado para reste ID";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	String value() default "";

	Class<?> entity();

	String attribute();

}

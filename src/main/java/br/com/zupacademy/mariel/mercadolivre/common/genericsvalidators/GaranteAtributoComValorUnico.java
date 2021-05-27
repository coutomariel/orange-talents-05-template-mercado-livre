package br.com.zupacademy.mariel.mercadolivre.common.genericsvalidators;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class GaranteAtributoComValorUnico implements ConstraintValidator<Unique, Object> {

	@PersistenceContext
	private EntityManager entityManager;

	private Class<?> entity;
	private String attribute;

	@Override
	public void initialize(Unique constraintAnnotation) {
		this.entity = constraintAnnotation.entity();
		this.attribute = constraintAnnotation.attribute();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		
		String jpql = "select 1 from " + this.entity.getName() + " where " + this.attribute + " = :value";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("value", value);
		
		List<?> result = query.getResultList();
		
		return result.isEmpty();
	}

}

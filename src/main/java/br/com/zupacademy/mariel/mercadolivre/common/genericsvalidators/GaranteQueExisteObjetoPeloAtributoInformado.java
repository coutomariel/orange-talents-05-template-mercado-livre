package br.com.zupacademy.mariel.mercadolivre.common.genericsvalidators;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class GaranteQueExisteObjetoPeloAtributoInformado implements ConstraintValidator<ExistsByAttribute, Object> {

	@PersistenceContext
	private EntityManager em;

	private Class<?> entity;
	private String attribute;

	@Override
	public void initialize(ExistsByAttribute annotation) {
		this.entity = annotation.entity();
		this.attribute = annotation.attribute();

	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		
		if(value != null) {
			String jpql = "select 1 from " + this.entity.getName() + " where " + this.attribute + " = :value";
			Query query = em.createQuery(jpql);
			query.setParameter("value", value);
			
			boolean existeRegistro = !query.getResultList().isEmpty(); 
			
			return existeRegistro;
		}
		
		return true;
	}

}

package br.com.zupacademy.mariel.mercadolivre.common.errors;

import java.util.ArrayList;
import java.util.List;

public class ErrorsResponseDto {

	private List<ValidationError> errors = new ArrayList<ValidationError>();

	public List<ValidationError> getErrors() {
		return errors;
	}
}
package br.com.zupacademy.mariel.mercadolivre.common.errors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ValidationExceptionHandler {

	@Autowired
	private MessageSource messageSource;

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErrorsResponseDto MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException exception) {
		ErrorsResponseDto errorsResponseDto = new ErrorsResponseDto();
		exception.getFieldErrors().stream().forEach(e -> {
			String message = messageSource.getMessage(e, LocaleContextHolder.getLocale());
			errorsResponseDto.getErrors().add(new ValidationError(e.getField(), message));
		});

		return errorsResponseDto;
	}

}
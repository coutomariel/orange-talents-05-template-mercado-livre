package br.com.zupacademy.mariel.mercadolivre.common.errors;

public class ValidationError {

	private String campo;
	private String mensagem;
	
	public ValidationError(String campo, String mensagem) {
		this.campo = campo;
		this.mensagem = mensagem;
	}

	public String getCampo() {
		return campo;
	}

	public String getMensagem() {
		return mensagem;
	}

}
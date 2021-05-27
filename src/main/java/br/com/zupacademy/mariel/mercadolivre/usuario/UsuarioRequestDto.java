package br.com.zupacademy.mariel.mercadolivre.usuario;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UsuarioRequestDto {

	@Email
	@NotBlank
	private String email;

	@NotBlank
	private String senha;

	public UsuarioRequestDto(@Email @NotBlank String email, @NotBlank String senha) {
		this.email = email;
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

	public Usuario toModel() {
		return new Usuario(this.email, this.senha);
	}
	
}

package br.com.zupacademy.mariel.mercadolivre.usuario;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

public class UsuarioRequestDto {

	@Email
	@NotBlank
	private String email;

	@NotBlank
	@Length(min = 6)
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

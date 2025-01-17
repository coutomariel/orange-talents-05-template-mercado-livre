package br.com.zupacademy.mariel.mercadolivre.usuario;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Column(nullable = false, unique = true)
	private String email;

	@NotBlank
	@Length(min = 6)
	@Column(nullable = false)
	private String senha;

	@NotNull
	@Column(nullable = false)
	private LocalDateTime criacao = LocalDateTime.now();

	/**
	 * @deprecated construtor para exclusivo do hibernate
	 */
	@Deprecated
	public Usuario() {
	}

	public Usuario(@NotBlank String email, @NotBlank String senha) {
		this.email = email;
		this.senha = new BCryptPasswordEncoder().encode(senha);
	}

}

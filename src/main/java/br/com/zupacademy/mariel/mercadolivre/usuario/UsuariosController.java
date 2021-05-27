package br.com.zupacademy.mariel.mercadolivre.usuario;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

	@Autowired
	private UsuariosRepository usuariosRepository;

	@PostMapping
	@Transactional
	public void criarUsuario(@RequestBody @Valid UsuarioRequestDto request) {
		usuariosRepository.save(request.toModel());
	}

}

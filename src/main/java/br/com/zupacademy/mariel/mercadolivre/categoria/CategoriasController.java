package br.com.zupacademy.mariel.mercadolivre.categoria;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categorias")
public class CategoriasController {
	
	@Autowired
	private CategoriasRepository categoriasRepository;
	
	@PostMapping
	public void criarCategoria(@RequestBody @Valid CategoriaRequestDto request) {
		Categoria categoria = request.toModel(categoriasRepository);
		categoriasRepository.save(categoria);
	}

}

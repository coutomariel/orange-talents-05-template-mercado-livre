package br.com.zupacademy.mariel.mercadolivre.categoria;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import br.com.zupacademy.mariel.mercadolivre.common.genericsvalidators.ExistsByAttribute;
import br.com.zupacademy.mariel.mercadolivre.common.genericsvalidators.Unique;

public class CategoriaRequestDto {

	@NotBlank
	@Unique(entity = Categoria.class, attribute = "nome")
	private String nome;
	
	@Positive
	@ExistsByAttribute(entity = Categoria.class, attribute = "id", message = "Não foi encontrada categoria com o ID informado")
	private Long idCategoriaMae;

	
	public String getNome() {
		return nome;
	}

	public Long getIdCategoriaMae() {
		return idCategoriaMae;
	}

	public Categoria toModel(CategoriasRepository categoriasRepository) {
		Categoria categoria = new Categoria(this.nome);
		if(this.idCategoriaMae != null) {
			Categoria categoriaMae = categoriasRepository.findById(this.idCategoriaMae).get();
			categoria.setCategoriaMae(categoriaMae);
		}
		return categoria;
	}
	
}

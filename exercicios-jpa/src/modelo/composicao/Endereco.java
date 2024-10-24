package modelo.composicao;

import javax.persistence.Embeddable;

@Embeddable // ele perciste os atributos nas tabelas no qual foi colocado como atributo.
			// exemplos na classe fornecedor e funcionario no qual menciona essa classe e os
			// atributos dela estão em suas tabelas.
public class Endereco {

	private String logradouro;
	private String complemento;

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

}

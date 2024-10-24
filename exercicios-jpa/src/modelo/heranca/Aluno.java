package modelo.heranca;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
// @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) cria 2 tabelas de acordo com a herança
//@Inheritance(strategy = InheritanceType.JOINED) cria 2 tabelas, e na tabela bolsa ele irá criar uma fk com a matricula e o valor da bolsa.
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo", length = 2, discriminatorType = DiscriminatorType.STRING) // aqui demos um nome para
																								// coluna, o tamanho de
																								// ccaracter que ela irá
																								// aceitar, e qual é o
																								// tipo de dado que ela
																								// vai receber.
@DiscriminatorValue("AL") // tipo que irá ficar na coluna
public class Aluno {

	@Id
	private Long matricula;

	private String nome;

	public Aluno() {
		// TODO Auto-generated constructor stub
	}

	public Aluno(Long matricula, String nome) {
		super();
		this.matricula = matricula;
		this.nome = nome;
	}

	public Long getMatricula() {
		return matricula;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}

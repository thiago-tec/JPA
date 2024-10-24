package modelo.muitosparamuitos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "filmes")
public class Filme {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	private double nota;

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "atores_filmes", // nome da tabela que vai juntar os 2 id
			joinColumns = @JoinColumn(name = "filme_id", referencedColumnName = "id"), // relacionado a classe atual, ou
																						// seja... definir o nome da
																						// coluna que vai puxar a
																						// referencia da tabela da
																						// classe atual que no caso
																						// daqui seria "filme" e a
																						// coluna que iremos puxar para
																						// fazer o join é o id.

			inverseJoinColumns = @JoinColumn(name = "ator_id", referencedColumnName = "id")// a mesma coisa do cima,
																							// porém da outra classe que
																							// nesse caso é o ator
	)
	private List<Ator> atores;

	public Filme() {
		// TODO Auto-generated constructor stub
	}

	public Filme(String nome, double nota) {
		super();
		this.nome = nome;
		this.nota = nota;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	public List<Ator> getAtores() {
		if (atores == null) {
			atores = new ArrayList<Ator>();
		}
		return atores;
	}

	public void setAtores(List<Ator> atores) {
		this.atores = atores;
	}

	public void adicionarAtor(Ator ator) {
		if (ator != null && !getAtores().contains(ator)) {
			getAtores().add(ator);
			if (!ator.getFilmes().contains(this)) {
				ator.getFilmes().add(this);
			}
		}
	}

}

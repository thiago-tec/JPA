package modelo.basico;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity //dizendo que é uma entidade no banco de dados e o nome da tabela por padrão é exatamente o mesmo nome da classe
public class Usuario {
	
	@Id //declara o id da coluna
	@GeneratedValue(strategy = GenerationType.IDENTITY)//auto incremento
	private Long id;
	
//	@Transient para quando vc não quiser que ele seja mapeado para o banco de dados.
	
	private String nome;
	
	
	private String email;
	
	public Usuario() { //ter que ter o construtor padrão
		
	}

	public Usuario(String nome, String email) {
		super();
		this.nome = nome;
		this.email = email;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}

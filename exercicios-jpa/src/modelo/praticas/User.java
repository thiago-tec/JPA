package modelo.praticas;

import java.util.Scanner;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "UserLogin")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	private String usuario;

	private String senha;


	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String nome, String usuario, String senha) {
		super();
		this.nome = nome;
		this.usuario = usuario;
		this.senha = senha;
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

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void comparar() {
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Digite seu usuario: ");
		String resUsuario = entrada.nextLine();
		
		System.out.println("Digite seu senha: ");
		String resSenha = entrada.nextLine();
		
		if (resSenha.equals(this.senha) && resUsuario.equals(this.usuario)) {
			System.out.println("login sucessedido");
		} else {
			System.out.println("usuario incorreto !");
		}
		
		entrada.close();
	}

}

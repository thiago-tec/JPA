package teste.basico;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import modelo.basico.Usuario;

public class ObterUsuarios {

	public static void main(String[] args) {
		

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager();

		String jpql = "select u from Usuario u";
		TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);
		/*
		 * TypedQuery é uma consulta com tipo que nesse caso o tipo é Usuario e depois
		 * tem que passar o comando sql e a classe onde irá fazer a busca, o .class a
		 * gente consegue ver dentro da classe e ele usa isso para fazer as buscas através dos
		 * métodos etc.
		 */
		query.setMaxResults(5);//define o tamanho da busca
		
		/* 
		 *  da para definir em uma linha só todo o código.
		 * 
		 * List<Usuario> usuarios = em 
		 * .createQuery("select u from Usuario u",Usuario.class) 
		 * .setMaxResults(5) 
		 * .getResultList();
		 */
		
		List<Usuario> usuarios = query.getResultList();//aqui ele vai trazer a consulta e vai armazenar em uma lista da classe usuarios.
		
		for (Usuario usuario : usuarios) {
			System.out.println("id: " + usuario.getId() + " e-mail: " + usuario.getEmail());
		}
		
		em.close();
		emf.close();
		
	}

}

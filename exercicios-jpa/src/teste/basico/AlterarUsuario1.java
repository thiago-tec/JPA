package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class AlterarUsuario1 {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();//abre a transição
		
		Usuario usuario = em.find(Usuario.class, 1l);
		usuario.setNome("Diego");
		usuario.setEmail("diego@hotmail.com");
		
		em.merge(usuario);//faz o update, tem que passar o objeto no qual é responsavel pela entidade
		
		em.getTransaction().commit(); //envia transição
		
		em.close();
		emf.close();
		
	}

}

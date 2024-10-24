package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class AlterarUsuario2 {

	public static void main(String[] args) {

		/*
		 * neste exemplo ele se encontra eum estado gerenciado, então independente se
		 * tiver ou não o merge, ele irá executar o update. No exemplo do
		 * AlterarUsuario3 vai mostrar como fechar esse estado.
		 */
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();//abre a transição
		
		Usuario usuario = em.find(Usuario.class, 1l); //deixa em estado gerenciado mesmo se o merge estiver comentado e irá fazer o update
		usuario.setNome("Diego");
		usuario.setEmail("diego@hotmail.com");
		
		em.merge(usuario);//faz o update, tem que passar o objeto no qual é responsavel pela entidade
		
		em.getTransaction().commit(); //envia transição
		
		em.close();
		emf.close();
		
	}
	
}

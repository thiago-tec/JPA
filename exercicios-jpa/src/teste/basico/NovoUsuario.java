package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class NovoUsuario {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");//responsavel por criar um entitymanager caso queira varias conexões ele que irá ser responsavel por gerenciar todas elas.
																							// e vc passa para ele a unidade de persistencia declarada no persistence.xml
		
		EntityManager em = emf.createEntityManager(); //faz alteração, exclusão, consulta e tbm representa uma conexão.
		
		
		Usuario u1 = new Usuario("e", "e@e.com"); 
		
		//sempre ter q ter uma transação em caso de inserção, mas em consulta não necessita
		
		em.getTransaction().begin(); // responsavel por abrir uma transação 
		em.persist(u1); //persiste as informações
		em.getTransaction().commit(); // envia a para o banco transação 
		
		
		em.close();
		emf.close();
	}

}

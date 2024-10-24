package infra;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class DAO<E> {

	private static EntityManagerFactory emf; // não pode inicilizar no construtor pois ele está como atributo static
	private EntityManager em; // pode inicializar no bloco construtor
	private Class<E> classe; // responsavel por pegar o nome da classe

	static { // para inicializar um atributo static tem q ser criado um bloco static. Esse
				// bloco é chamado uma única vez quando a classe for carregada
				// porém tem que tomar cuidado pois se gerar um erro ele irá falhar todo o
				// sistema. então sempre bom tratar.
		try {
			emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		} catch (Exception e) {
			// logar -> log4j
		}
	}

	public DAO() {
		this(null);
	}

	public DAO(Class<E> classe) {

		this.classe = classe;
		em = emf.createEntityManager();

	}

	public DAO<E> abrirT() {
		em.getTransaction().begin();
		return this;
	}

	public DAO<E> fecharT() {
		em.getTransaction().commit();
		return this;
	}

	public DAO<E> incluir(E entidade) {
		em.persist(entidade);
		return this;
	}

	public DAO<E> incluirAtomico(E entidade) { // faz tudo de uma vez, abre transação... inclui dados e depois fecha.
		return this.abrirT().incluir(entidade).fecharT();
	}

	public E obterPorID(Object id) {
		return em.find(classe, id);
	}

	public List<E> obterTodos() {
		return this.obterTodos(10, 0);
	}

	public List<E> obterTodos(int qtde, int deslocamento) {

		if (classe == null)
			throw new UnsupportedOperationException("Classe nula."); // se caso não existir a entidade ele irá retornar
																		// a mensagem

		String jpql = "select e from " + classe.getName() + " e"; // classe.getName() pega o nome da classe passada e
																	// incrimenta no metodo direto
		
		TypedQuery<E> query = em.createQuery(jpql, classe);// expliquei no obterUsuarios
		query.setMaxResults(qtde);
		query.setFirstResult(deslocamento);

		return query.getResultList();
	}

	public List<E> consultar(String nomeConsulta, Object... params) {
		TypedQuery<E> query = em.createNamedQuery(nomeConsulta, classe);

		for (int i = 0; i < params.length; i += 2) {
			query.setParameter(params[i].toString(), params[i + 1]);
		}

		return query.getResultList();
	}

	public E consultarUm(String nomeConsulta, Object... params) {
		List<E> lista = consultar(nomeConsulta, params);
		return lista.isEmpty() ? null : lista.get(0);
	}

	public DAO<E> dadosAtualizar(E entidade) {
		em.merge(entidade);
		return this;
	}

	public DAO<E> dadosRemover(E entidade) {
		em.remove(entidade);
		return this;
	}

	public void fechar() { // aqui fechamos o DAO, não fechamos o factory pois ele vai servir para todos os
							// DAO que iremos criar. Por isso é static
		em.close();
	}

}

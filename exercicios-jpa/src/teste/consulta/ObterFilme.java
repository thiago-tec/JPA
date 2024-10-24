package teste.consulta;

import java.util.List;

import infra.DAO;
import modelo.muitosparamuitos.Ator;
import modelo.muitosparamuitos.Filme;

public class ObterFilme {

	public static void main(String[] args) {

		DAO<Filme> dao = new DAO<>(Filme.class);
		List<Filme> filmes = dao.consultar("filmesNotaMaiorQue", "nota", 8.0);// passando o nome do query criado no xml,
																				// passando o nome da coluna e qual a
																				// nota para base

		for (Filme filme : filmes) {
			System.out.println(filme.getNome()+ "  " + filme.getNota());
			
			for (Ator atores : filme.getAtores()) {
				System.out.print(atores.getNome());
			}
		}
	}

}

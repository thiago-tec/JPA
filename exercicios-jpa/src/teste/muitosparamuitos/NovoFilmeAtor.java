package teste.muitosparamuitos;

import infra.DAO;
import modelo.muitosparamuitos.Ator;
import modelo.muitosparamuitos.Filme;

public class NovoFilmeAtor {

	public static void main(String[] args) {
		
		
		Filme filmeA = new Filme("Star Wars",5.8);
		Filme filmeB = new Filme("Godzila",8.3);
		
		Ator atorA = new Ator("Harrison");
		Ator atorB = new Ator("Carrie");
		
		filmeA.adicionarAtor(atorA);
		filmeA.adicionarAtor(atorB);
		
		filmeB.adicionarAtor(atorA);
		
		DAO<Filme> dao = new DAO<Filme>();
		dao.incluirAtomico(filmeA);
	}

}

package teste.basico;

import infra.DAO;
import modelo.basico.Produto;

public class NovoProduto {

	public static void main(String[] args) {
		
		Produto produto = new Produto("monitor 23", 789.98);
		
		DAO<Produto> dao = new DAO<>(Produto.class);
//		dao.abrirTransacao().incluir(produto).fecharTransacao();
		dao.incluirAtomico(produto).fechar();
		
		System.out.println("id do produto " + produto.getId());

	}

}

package teste.basico;

import infra.DAO;
import modelo.basico.Produto;

public class NovoProduto {

	public static void main(String[] args) {

		Produto produto = new Produto("notebook", 2010.45);
		
		DAO<Produto> dao = new DAO<>(Produto.class);
		dao.abrirT().incluir(produto).fecharT();
		
		//dao.incluirAtomico(produto).fechar();
		
	}

}

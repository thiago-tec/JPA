package teste.umparamuitos;

import infra.DAO;
import modelo.basico.Produto;
import modelo.umparamuitos.ItemPedido;
import modelo.umparamuitos.Pedido;

public class NovoPedido {

	public static void main(String[] args) {
		
		DAO<Object> dao = new DAO<>();
		
		Produto produto = new Produto("Geladeira", 3254.99);
		Pedido pedido = new Pedido();
		ItemPedido item = new ItemPedido(pedido, produto, 10);
		
		dao
		.abrirT()
		.incluir(produto)
		.incluir(pedido)
		.incluir(item)
		.fecharT()
		.fechar();
		
	}
	
}

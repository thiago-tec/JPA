package teste.umparamuitos;

import infra.DAO;
import modelo.umparamuitos.ItemPedido;
import modelo.umparamuitos.Pedido;

public class ObterPedido {
	
	public static void main(String[] args) {
		
		
		DAO<Pedido> dao = new DAO<>(Pedido.class);
		
		Pedido pedido = dao.obterPorID(1l);
		
		for (ItemPedido item : pedido.getItens()) {
			System.out.println(item.getProduto().getNome() +" "+ item.getQuantidade());
		}
		
		dao.fechar();
	}
}

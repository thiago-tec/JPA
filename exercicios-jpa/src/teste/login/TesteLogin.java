package teste.login;

import infra.DAO;
import modelo.praticas.User;

public class TesteLogin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DAO<User> dao  = new DAO<>(User.class);
//		dao.incluirAtomico(user);
		
//		User user = dao.obterPorID(2l);
		User user = dao.obterPorID(1l);
		user.comparar();
		
//		dao.abrirT().dadosAtualizar(user).fecharT();
//		dao.fechar();
		
		
		
	}

}

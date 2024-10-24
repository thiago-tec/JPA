package teste.muitosparamuitos;

import infra.DAO;
import modelo.muitosparamuitos.Sobrinho;
import modelo.muitosparamuitos.Tio;

public class NovoTioSobrinho {

	public static void main(String[] args) {
		
		Sobrinho s1 = new Sobrinho("Ana");
		Sobrinho s2 = new Sobrinho("Bia");
		
		Tio t1 = new Tio("Maria");
		Tio t2 = new Tio("Jose");

		t1.getSobrinhos().add(s1);
		s1.getTios().add(t1);
		
		t2.getSobrinhos().add(s1);
		s1.getTios().add(t2);
		
		t2.getSobrinhos().add(s2);
		s2.getTios().add(t2);

		t1.getSobrinhos().add(s2);
		s2.getTios().add(t1);
		
		DAO<Object> dao = new DAO<>();
		dao.abrirT()
		.incluir(t1)
		.incluir(t2)
		.incluir(s1)
		.incluir(s2)
		.fecharT().fechar();
	}

}

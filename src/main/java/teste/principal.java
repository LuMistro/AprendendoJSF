package teste;

import java.util.Date;

import sc.senac.br.cadastropessoa.dao.PessoaDao;
import sc.senac.br.cadastropessoa.model.Pessoa;

public class principal {
	public static void main(String[] args) {
		Pessoa p = new Pessoa();
		p.setEmail("luiza@gmail.com");
		p.setNome("luiza");
		p.setNascimento(new Date(28/10/1999));
		PessoaDao dao = new PessoaDao(); 
		dao.salvar(p);
	}
}

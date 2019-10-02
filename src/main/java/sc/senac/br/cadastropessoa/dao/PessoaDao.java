package sc.senac.br.cadastropessoa.dao;

import net.bytebuddy.implementation.bind.annotation.Super;
import sc.senac.br.cadastropessoa.model.Pessoa;

public class PessoaDao extends GenericDao<Pessoa, Integer> {
	public PessoaDao() {
		super(Pessoa.class);
	}

}

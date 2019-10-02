package sc.senac.br.cadastropessoa.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import sc.senac.br.cadastropessoa.dao.PessoaDao;
import sc.senac.br.cadastropessoa.model.Pessoa;

@ViewScoped
@ManagedBean
public class CadastroPessoaController implements Serializable {

	private static final long serialVersionUID = 1L;

	private Pessoa pessoa;
	private PessoaDao dao;
	private List<Pessoa> pessoas;
	
//	public CadastroPessoaController() {
//		pessoa = new Pessoa();
//		dao = new PessoaDao();
//		pessoas = new ArrayList<>();
//	}
	
	@PostConstruct
	public void init() {
		pessoa = new Pessoa();
		dao = new PessoaDao();
		pessoas = new ArrayList<>();
		pessoas.addAll(dao.getList());
		
		
	}

	public void cadastrar() {
		pessoas.add(pessoa);
		dao.salvar(pessoa);
		pessoa = new Pessoa();
	}

	public void limpar() {
		pessoa = new Pessoa();
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

}

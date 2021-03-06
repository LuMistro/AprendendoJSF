package sc.senac.br.cadastropessoa.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

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

	public void excluir() {
		dao.remover(pessoa);
		limpar();
		buscar();

		FacesMessage mensagem = new FacesMessage();
		mensagem.setSeverity(FacesMessage.SEVERITY_INFO);
		mensagem.setSummary("Pessoa excluída com sucesso!");
		FacesContext.getCurrentInstance().addMessage(null, mensagem);

	}

	public void editar() {
		System.out.println("Editou!");
	}

	public void cadastrar() {
		if (pessoa.getId() == null) {
			dao.salvar(pessoa);
		} else {
			dao.atualizar(pessoa);
		}

		limpar();
		buscar();
	}

	public void buscar() {
		pessoas = dao.getList();
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

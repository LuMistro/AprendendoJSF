package sc.senac.br.cadastropessoa.model;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class Pessoa {

	private String nome;

	private String email;

	private Date nascimento;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public int getIdade() {
		LocalDate data = Instant.ofEpochMilli(nascimento.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
		return Period.between(data, LocalDate.now()).getYears();
	}

}

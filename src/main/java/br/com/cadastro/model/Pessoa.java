package br.com.cadastro.model;

import java.time.LocalDate;
import java.util.List;

import br.com.cadastro.dto.PessoaDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;

@Entity(name = "pessoa")
public class Pessoa {

	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 100, nullable = false)
	private String nome;
	@Column(nullable = false)
	private LocalDate dataNascimento;
	@OneToMany(mappedBy = "pessoa")
	private List<Endereco> endereco;

	public static Pessoa of(PessoaDto pessoaDto) {
		Pessoa pessoa = new Pessoa();
		pessoa.setId(pessoaDto.getId());
		pessoa.setNome(pessoaDto.getNome());
		pessoa.setDataNascimento(pessoaDto.getDataNascimento());
		pessoa.setEndereco(pessoaDto.getEndereco().stream().map(endereco -> Endereco.of(endereco)).toList());
		return pessoa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<Endereco> getEndereco() {
		return endereco;
	}

	public void setEndereco(List<Endereco> endereco) {
		this.endereco = endereco;
	}

}

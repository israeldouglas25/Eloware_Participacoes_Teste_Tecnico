package br.com.cadastro.dto;

import java.time.LocalDate;
import java.util.List;

import br.com.cadastro.model.Pessoa;

public class PessoaDto {

	private Long id;
	private String nome;
	private LocalDate dataNascimento;
	private List<EnderecoDto> endereco;

	public static PessoaDto of(Pessoa pessoa) {
		PessoaDto pessoaDto = new PessoaDto();
		pessoaDto.setId(pessoa.getId());
		pessoaDto.setNome(pessoa.getNome());
		pessoaDto.setDataNascimento(pessoa.getDataNascimento());
		pessoaDto.setEndereco(pessoa.getEndereco().stream().map(endereco -> EnderecoDto.of(endereco)).toList());
		return pessoaDto;

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

	public List<EnderecoDto> getEndereco() {
		return endereco;
	}

	public void setEndereco(List<EnderecoDto> endereco) {
		this.endereco = endereco;
	}

}

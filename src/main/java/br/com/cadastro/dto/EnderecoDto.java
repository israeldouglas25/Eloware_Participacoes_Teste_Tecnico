package br.com.cadastro.dto;

import java.util.List;

import br.com.cadastro.model.Endereco;
import br.com.cadastro.model.Pessoa;

public class EnderecoDto {
	private Long id;
	private String logradouro;
	private String cep;
	private int numero;
	private String cidade;
	private Pessoa pessoa;
	private boolean isPrincipal;

	public static EnderecoDto of(Endereco endereco) {
		EnderecoDto enderecoDto = new EnderecoDto();
		enderecoDto.setId(endereco.getId());
		enderecoDto.setLogradouro(endereco.getLogradouro());
		enderecoDto.setCep(endereco.getCep());
		enderecoDto.setNumero(endereco.getNumero());
		enderecoDto.setCidade(endereco.getCidade());
		enderecoDto.setPessoa(endereco.getPessoa());
		enderecoDto.setPrincipal(endereco.isPrincipal());
		return enderecoDto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public boolean isPrincipal() {
		return isPrincipal;
	}

	public void setPrincipal(boolean isPrincipal) {
		this.isPrincipal = isPrincipal;
	}

	public static EnderecoDto filterEnderecoPrincipal(List<Endereco> enderecos) {
		EnderecoDto enderecoDto = EnderecoDto.of(enderecos.stream().filter(endereco -> endereco.isPrincipal()).findFirst().get());
		return enderecoDto;
	}

}

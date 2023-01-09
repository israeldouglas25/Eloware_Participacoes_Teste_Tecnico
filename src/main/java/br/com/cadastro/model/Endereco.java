package br.com.cadastro.model;

import br.com.cadastro.dto.EnderecoDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;

@Entity(name = "endereco")
public class Endereco {

	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String logradouro;
	@Column(nullable = false)
	private String cep;
	@Column(nullable = false)
	private int numero;
	@Column(nullable = false)
	private String cidade;
	@ManyToOne(fetch = FetchType.EAGER)
	private Pessoa pessoa;
	private boolean isPrincipal;

	public static Endereco of(EnderecoDto enderecoDto) {
		Endereco endereco = new Endereco();
		endereco.setId(enderecoDto.getId());
		endereco.setLogradouro(enderecoDto.getLogradouro());
		endereco.setCep(enderecoDto.getCep());
		endereco.setNumero(enderecoDto.getNumero());
		endereco.setCidade(enderecoDto.getCidade());
		endereco.setPessoa(enderecoDto.getPessoa());
		endereco.setPrincipal(enderecoDto.isPrincipal());
		return endereco;
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

}

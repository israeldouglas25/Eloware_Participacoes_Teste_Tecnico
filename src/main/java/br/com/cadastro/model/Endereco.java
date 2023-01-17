package br.com.cadastro.model;

import br.com.cadastro.dto.EnderecoDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
	@Column(nullable = false)
	private Boolean isPrincipal;

	public static Endereco of(EnderecoDto enderecoDto) {
		Endereco endereco = new Endereco();
		endereco.setId(enderecoDto.getId());
		endereco.setLogradouro(enderecoDto.getLogradouro());
		endereco.setCep(enderecoDto.getCep());
		endereco.setNumero(enderecoDto.getNumero());
		endereco.setCidade(enderecoDto.getCidade());
		endereco.setIsPrincipal(enderecoDto.getIsPrincipal());
		return endereco;
	}
}

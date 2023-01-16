package br.com.cadastro.dto;

import java.util.List;

import br.com.cadastro.model.Endereco;
import br.com.cadastro.model.Pessoa;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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

	public static EnderecoDto filterEnderecoPrincipal(List<Endereco> enderecos) {
		EnderecoDto enderecoDb = EnderecoDto.of(enderecos
				.stream()
				.filter(endereco -> endereco.isPrincipal())
				.findFirst()
				.orElseThrow(() -> new RuntimeException("Addres main not found!")));
		return enderecoDb;
	}

}

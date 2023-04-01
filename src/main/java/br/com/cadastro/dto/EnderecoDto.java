package br.com.cadastro.dto;

import java.util.List;

import br.com.cadastro.model.Endereco;
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
	private Boolean isPrincipal;

	public static EnderecoDto of(Endereco endereco) {
		EnderecoDto enderecoDto = new EnderecoDto();
		enderecoDto.setId(endereco.getId());
		enderecoDto.setLogradouro(endereco.getLogradouro());
		enderecoDto.setCep(endereco.getCep());
		enderecoDto.setNumero(endereco.getNumero());
		enderecoDto.setCidade(endereco.getCidade());
		enderecoDto.setIsPrincipal(endereco.getIsPrincipal());
		return enderecoDto;
	}

	public static EnderecoDto filterEnderecoPrincipal(List<Endereco> enderecos) {
		EnderecoDto enderecoDb = EnderecoDto.of(enderecos
				.stream()
				.filter(Endereco::getIsPrincipal)
				.findFirst()
				.orElseThrow(() -> new RuntimeException("Principal addres not found!")));
		return enderecoDb;
	}

}

//public static List<EnderecoDto> filterEnderecoPrincipal(List<Endereco> enderecos) {
//	Optional<Endereco> principalAddress = enderecos
//			.stream()
//			.filter(endereco -> endereco.getIsPrincipal())
//			.findFirst();
//	
//	return principalAddress.isPresent() ? List.of(EnderecoDto.of(principalAddress.get())) 
//			: enderecos.stream().map(e -> EnderecoDto.of(e)).toList();
//}

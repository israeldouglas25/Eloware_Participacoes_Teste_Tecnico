package br.com.cadastro.dto;

import java.time.LocalDate;
import java.util.List;

import br.com.cadastro.model.Pessoa;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
}

package br.com.cadastro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cadastro.dto.EnderecoDto;
import br.com.cadastro.dto.PessoaDto;
import br.com.cadastro.model.Endereco;
import br.com.cadastro.model.Pessoa;
import br.com.cadastro.repository.EnderecoRepository;
import br.com.cadastro.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	public Pessoa findById(Long id) {
		return pessoaRepository.getReferenceById(id);
	}

	public PessoaDto save(Pessoa pessoa) {
//		Salva primeiro o endereco para ter ID
		Pessoa saved = pessoaRepository.save(pessoa);

//		Seta o ID da pessoa salva dentro dos enderecos do objeto pessoa(com enderecos)
		pessoa.getEndereco().forEach(endereco -> endereco.setPessoa(saved));

//		Salva os enderecos
		List<Endereco> enderecos = enderecoRepository.saveAll(pessoa.getEndereco());

//		Filtra e traz apenas o endereço principal
		EnderecoDto enderecoPrincipal = EnderecoDto.filterEnderecoPrincipal(enderecos);

//		Cria DTO de retorno a partir do objeto pessoa (sem enderecos) que foi salvo
		PessoaDto pessoaDto = PessoaDto.of(saved);

//		Seta o endereco principal no objeto de retorno
		pessoaDto.setEndereco(enderecos);

		return pessoaDto;

	}

}

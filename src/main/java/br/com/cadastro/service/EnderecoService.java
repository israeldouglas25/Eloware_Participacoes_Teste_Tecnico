package br.com.cadastro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cadastro.dto.EnderecoDto;
import br.com.cadastro.model.Endereco;
import br.com.cadastro.model.Pessoa;
import br.com.cadastro.repository.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private PessoaService pessoaService;

	public List<EnderecoDto> findAll() {
		return enderecoRepository.findAll()
				.stream()
				.map(EnderecoDto::of)
				.toList();
	}

	public EnderecoDto save(Endereco endereco) {
		return EnderecoDto.of(enderecoRepository.save(endereco))
;	}

	public List<EnderecoDto> findAllByPessoa(Long id) {
		Pessoa pessoa = Pessoa.of(pessoaService.findById(id));
		return enderecoRepository.findEnderecoByPessoa(pessoa)
				.stream()
				.map(EnderecoDto::of)
				.toList();
	}

	public EnderecoDto findById(Long id) {
		Endereco endereco = enderecoRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Address not found."));
		return EnderecoDto.of(endereco);
	}

	public EnderecoDto update(Long id, Endereco endereco) {
		Endereco enderecoDb = enderecoRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Address not found."));

		enderecoDb.setLogradouro(endereco.getLogradouro());
		enderecoDb.setNumero(endereco.getNumero());
		enderecoDb.setCep(endereco.getCep());
		enderecoDb.setCidade(endereco.getCidade());
		enderecoDb.setIsPrincipal(endereco.getIsPrincipal());

		enderecoRepository.save(enderecoDb);
		return EnderecoDto.of(enderecoDb);
	}

	public void delete(Long id) {
		enderecoRepository.deleteById(id);
	}

}
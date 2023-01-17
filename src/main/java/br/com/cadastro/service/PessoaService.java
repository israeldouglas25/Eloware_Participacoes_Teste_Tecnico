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
import jakarta.transaction.Transactional;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	public List<PessoaDto> findAll() {
		return pessoaRepository.findAll()
				.stream()
				.map(pessoa -> PessoaDto.of(pessoa))
				.toList();
	}

	public PessoaDto findById(Long id) {
		Pessoa pessoa = pessoaRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("User not found."));
		return PessoaDto.of(pessoa);
	}

	public PessoaDto update(Long id, Pessoa pessoa) {
		Pessoa pessoaDb = pessoaRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("User not found."));

		pessoaDb.setNome(pessoa.getNome());
		pessoaDb.setDataNascimento(pessoa.getDataNascimento());

		pessoaRepository.save(pessoaDb);
		return PessoaDto.of(pessoaDb);
	}

	@Transactional
	public PessoaDto save(Pessoa pessoa) {
		Pessoa saved = pessoaRepository.save(pessoa);
		pessoa.getEndereco().forEach(endereco -> endereco.setPessoa(saved));
		
		List<Endereco> enderecos = enderecoRepository.saveAll(pessoa.getEndereco());

		EnderecoDto enderecoPrincipal = EnderecoDto.filterEnderecoPrincipal(enderecos);

		PessoaDto pessoaDto = PessoaDto.of(saved);
		pessoaDto.setEndereco(List.of(enderecoPrincipal));

		return pessoaDto;

	}

}

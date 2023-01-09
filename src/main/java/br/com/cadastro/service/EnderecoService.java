package br.com.cadastro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cadastro.model.Endereco;
import br.com.cadastro.model.Pessoa;
import br.com.cadastro.repository.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private PessoaService pessoaService;

	public List<Endereco> findAll() {
		return enderecoRepository.findAll();
	}

	public List<Endereco> findAllByPessoa(Long id) {
		Pessoa pessoa = pessoaService.findById(id);
		return enderecoRepository.findEnderecoByPessoa(pessoa);
	}

}

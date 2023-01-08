package br.com.cadastro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cadastro.model.Pessoa;
import br.com.cadastro.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;

	public Pessoa findById(Long id) {
		return pessoaRepository.getReferenceById(id);
	}

}

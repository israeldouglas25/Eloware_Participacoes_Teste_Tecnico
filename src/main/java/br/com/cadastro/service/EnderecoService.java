package br.com.cadastro.service;

import java.util.List;
import java.util.Optional;

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

	public Endereco save(Endereco endereco) {
		return enderecoRepository.save(endereco);
	}

	public List<Endereco> findAllByPessoa(Long id) {
		Pessoa pessoa = pessoaService.findById(id);
		return enderecoRepository.findEnderecoByPessoa(pessoa);
	}

	public Endereco findById(Long id) {
		Optional<Endereco> endereco = enderecoRepository.findById(id);
		return endereco.get();
	}

	public Endereco update(Long id, Endereco endereco) {
		Optional<Endereco> enderecoDb = enderecoRepository.findById(id);

		enderecoDb.get().setLogradouro(endereco.getLogradouro());
		enderecoDb.get().setNumero(endereco.getNumero());
		enderecoDb.get().setCep(endereco.getCep());
		enderecoDb.get().setCidade(endereco.getCidade());
		enderecoDb.get().setPrincipal(endereco.isPrincipal());

		enderecoRepository.save(enderecoDb.get());
		return enderecoDb.get();
	}

	public void delete(Long id) {
		enderecoRepository.deleteById(id);
	}

}
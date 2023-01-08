package br.com.cadastro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cadastro.model.Endereco;
import br.com.cadastro.model.Pessoa;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
	List<Endereco> findEnderecoByPessoa(Pessoa pessoa);
}

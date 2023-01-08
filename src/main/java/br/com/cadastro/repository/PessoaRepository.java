package br.com.cadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cadastro.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}

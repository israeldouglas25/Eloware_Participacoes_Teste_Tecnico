package br.com.cadastro.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cadastro.dto.PessoaDto;
import br.com.cadastro.model.Pessoa;
import br.com.cadastro.repository.PessoaRepository;
import br.com.cadastro.service.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private PessoaService pessoaService;

	@GetMapping
	public ResponseEntity<List<Pessoa>> findAll() {
		return ResponseEntity.ok(pessoaRepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Pessoa> findById(@PathVariable Long id) {
		Optional<Pessoa> pessoa = pessoaRepository.findById(id);
		return ResponseEntity.ok(pessoa.get());
	}

	@PostMapping
	public ResponseEntity<PessoaDto> insert(@RequestBody Pessoa pessoa) {
		return ResponseEntity.ok(pessoaService.save(pessoa));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Pessoa> update(@PathVariable Long id, @RequestBody Pessoa pessoa) {
		Optional<Pessoa> pessoaDb = pessoaRepository.findById(id);

		pessoaDb.get().setNome(pessoa.getNome());
		pessoaDb.get().setDataNascimento(pessoa.getDataNascimento());

		pessoaRepository.save(pessoaDb.get());

		return ResponseEntity.ok(pessoaDb.get());
	}

}

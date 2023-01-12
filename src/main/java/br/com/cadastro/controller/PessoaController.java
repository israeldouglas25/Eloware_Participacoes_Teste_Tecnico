package br.com.cadastro.controller;

import java.util.List;

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
import br.com.cadastro.service.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;

	@GetMapping
	public ResponseEntity<List<PessoaDto>> findAll() {
		return ResponseEntity.ok(pessoaService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<PessoaDto> findById(@PathVariable Long id) {
		return ResponseEntity.ok(pessoaService.findById(id));
	}

	@PostMapping
	public ResponseEntity<PessoaDto> insert(@RequestBody PessoaDto pessoaDto) {
		return ResponseEntity.ok(pessoaService.save(Pessoa.of(pessoaDto)));
	}

	@PutMapping("/{id}")
	public ResponseEntity<PessoaDto> update(@PathVariable Long id, @RequestBody Pessoa pessoa) {
		return ResponseEntity.ok(pessoaService.update(id, pessoa));
	}

}

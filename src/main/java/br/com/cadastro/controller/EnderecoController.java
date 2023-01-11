package br.com.cadastro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cadastro.model.Endereco;
import br.com.cadastro.service.EnderecoService;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

	@Autowired
	private EnderecoService enderecoService;

	@GetMapping
	public ResponseEntity<List<Endereco>> findAll() {
		return ResponseEntity.ok(enderecoService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Endereco> findById(@PathVariable Long id) {
		return ResponseEntity.ok(enderecoService.findById(id));
	}

	@GetMapping("/{id}")
	public ResponseEntity<List<Endereco>> findAllByPessoa(@PathVariable Long id) {
		return ResponseEntity.ok(enderecoService.findAllByPessoa(id));
	}

	@PostMapping
	public ResponseEntity<Endereco> save(@RequestBody Endereco endereco) {
		return ResponseEntity.ok(enderecoService.save(endereco));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Endereco> update(@PathVariable Long id, @RequestBody Endereco endereco) {
		return ResponseEntity.ok(enderecoService.update(id, endereco));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Endereco> delete(@PathVariable Long id) {
		enderecoService.delete(id);
		return ResponseEntity.ok().build();
	}

}

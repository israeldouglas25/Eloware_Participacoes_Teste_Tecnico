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

import br.com.cadastro.dto.EnderecoDto;
import br.com.cadastro.model.Endereco;
import br.com.cadastro.service.EnderecoService;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

	@Autowired
	private EnderecoService enderecoService;

	@GetMapping
	public ResponseEntity<List<EnderecoDto>> findAll() {
		return ResponseEntity.ok(enderecoService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<EnderecoDto> findById(@PathVariable Long id) {
		return ResponseEntity.ok(enderecoService.findById(id));
	}

	@GetMapping("/pessoa/{id}")
	public ResponseEntity<List<EnderecoDto>> findAllByPessoa(@PathVariable Long id) {
		return ResponseEntity.ok(enderecoService.findAllByPessoa(id));
	}

	@PostMapping
	public ResponseEntity<EnderecoDto> save(@RequestBody EnderecoDto enderecoDto) {
		return ResponseEntity.ok(enderecoService.save(Endereco.of(enderecoDto)));
	}

	@PutMapping("/{id}")
	public ResponseEntity<EnderecoDto> update(@PathVariable Long id, @RequestBody EnderecoDto enderecoDto) {
		return ResponseEntity.ok(enderecoService.update(id, Endereco.of(enderecoDto)));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<EnderecoDto> delete(@PathVariable Long id) {
		enderecoService.delete(id);
		return ResponseEntity.ok().build();
	}

}

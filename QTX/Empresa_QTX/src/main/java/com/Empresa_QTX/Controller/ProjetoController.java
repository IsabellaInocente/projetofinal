package com.Empresa_QTX.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Empresa_QTX.Service.ProjetoService;
import com.Empresa_QTX.entities.ProjetoEntities;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Projeto", description = "API REST DE GERENCIAMENTO DE PROJETO")
@RestController
@RequestMapping("/projeto")
@CrossOrigin(origins="*")
public class ProjetoController {

	private final ProjetoService projetoService;

	@Autowired
	public ProjetoController(ProjetoService projetoservice) {
		this.projetoService = projetoservice;
	}

	@GetMapping("/{id}")
	@Operation(summary = "Localiza Projeto por ID")
	public ResponseEntity<ProjetoEntities> buscaProjetoControlId(@PathVariable Long id) {
		ProjetoEntities Projeto = projetoService.buscaProjetoId(id);
		if (Projeto != null) {
			return ResponseEntity.ok(Projeto);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping
	@Operation(summary = "Apresenta todos os Projetos")
	public ResponseEntity<List<ProjetoEntities>> buscaTodosProjetoControl() {
		List<ProjetoEntities> Projeto = projetoService.buscaTodosProjeto();
		return ResponseEntity.ok(Projeto);
	}

	@PostMapping
	@Operation(summary = "Cadastra os Projeto")
	public ResponseEntity<ProjetoEntities> salvaProjetoControl(@RequestBody @Valid ProjetoEntities Projeto) {
		ProjetoEntities salvaProjeto = projetoService.salvaFornecedor(Projeto);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaProjeto);
	}

	@PutMapping("/{id}")
	@Operation(summary = "Altera um Projeto")
	public ResponseEntity<ProjetoEntities> alteraProjetoControl(@PathVariable Long id, @RequestBody @Valid ProjetoEntities Projeto) {
		ProjetoEntities alteraProjeto = projetoService.alterarProjeto(id, Projeto);
		if (alteraProjeto != null) {
			return ResponseEntity.ok(Projeto);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Exclui um Projeto")
	public ResponseEntity<ProjetoEntities> apagaProjetoControl(@PathVariable Long id) {
		boolean apagar = projetoService.apagarProjeto(id);
		if (apagar) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}



}	

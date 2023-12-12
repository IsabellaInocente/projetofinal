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

import com.Empresa_QTX.Service.FornecedorService;
import com.Empresa_QTX.entities.FornecedorEntities;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Fornecedor", description = "API REST DE GERENCIAMENTO DE FORNECEDOR")
@RestController
@RequestMapping("/fornecedor")
@CrossOrigin(origins="*")
public class FornecedorController {

	private final FornecedorService fornecedorService;

	@Autowired
	public FornecedorController(FornecedorService fornecedorservice) {
		this.fornecedorService = fornecedorservice;
	}

	@GetMapping("/{id}")
	@Operation(summary = "Localiza Fornecedor por ID")
	public ResponseEntity<FornecedorEntities> buscaFornecedorControlId(@PathVariable Long id) {
		FornecedorEntities fornecedor = fornecedorService.buscaFornecedorId(id);
		if (fornecedor != null) {
			return ResponseEntity.ok(fornecedor);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping
	@Operation(summary = "Apresenta todos os Fornecedores")
	public ResponseEntity<List<FornecedorEntities>> buscaTodosFornecedorControl() {
		List<FornecedorEntities> Fornecedor = fornecedorService.buscaTodosFornecedor();
		return ResponseEntity.ok(Fornecedor);
	}

	@PostMapping
	@Operation(summary = "Cadastra um Fornecedor")
	public ResponseEntity<FornecedorEntities> salvaFornecedorControl(@RequestBody FornecedorEntities fornecedor) {
		FornecedorEntities salvaFornecedor = fornecedorService.salvaFornecedor(fornecedor);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaFornecedor);
	}

	@PutMapping("/{id}")
	@Operation(summary = "Altera um Fornecedor")
	public ResponseEntity<FornecedorEntities> alteraFornecedorControl(@PathVariable Long id, @RequestBody @Valid FornecedorEntities fornecedor) {
		FornecedorEntities alteraFornecedor = fornecedorService.alterarFornecedor(id, fornecedor);
		if (alteraFornecedor != null) {
			return ResponseEntity.ok(fornecedor);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Exclui um Fornecedor")
	public ResponseEntity<FornecedorEntities> apagaFornecedorControl(@PathVariable Long id) {
		boolean apagar = fornecedorService.apagarFornecedor(id);
		if (apagar) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
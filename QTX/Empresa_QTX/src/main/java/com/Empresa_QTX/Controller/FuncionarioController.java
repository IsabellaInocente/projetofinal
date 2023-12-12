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

import com.Empresa_QTX.Service.FuncionarioService;
import com.Empresa_QTX.entities.FuncionarioEntities;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Funcionario", description = "API REST DE GERENCIAMENTO DE FUNCIONARIO")
@RestController
@RequestMapping("/funcionario")
@CrossOrigin(origins="*")
public class FuncionarioController {

	private final FuncionarioService FuncionarioService;

	@Autowired
	public FuncionarioController(FuncionarioService Funcionarioservice) {
		this.FuncionarioService = Funcionarioservice;
	}

	@GetMapping("/{id}")
	@Operation(summary = "Localiza Funcionario por ID")
	public ResponseEntity<FuncionarioEntities> buscaFuncionarioControlId(@PathVariable Long id) {
		FuncionarioEntities Funcionario = FuncionarioService.buscaFuncionarioId(id);
		if (Funcionario != null) {
			return ResponseEntity.ok(Funcionario);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping
	@Operation(summary = "Apresenta todos os Funcionarios")
	public ResponseEntity<List<FuncionarioEntities>> buscaTodosFuncionarioControl() {
		List<FuncionarioEntities> Funcionario = FuncionarioService.buscaTodosFuncionario();
		return ResponseEntity.ok(Funcionario);
	}

	@PostMapping
	@Operation(summary = "Cadastra os Funcionario")
	public ResponseEntity<FuncionarioEntities> salvaFuncionarioControl(@RequestBody FuncionarioEntities Funcionario) {
		FuncionarioEntities salvaFuncionario = FuncionarioService.salvaFornecedor(Funcionario);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaFuncionario);
	}

	@PutMapping("/{id}")
	@Operation(summary = "Altera um Funcionario")
	public ResponseEntity<FuncionarioEntities> alteraFuncionarioControl(@PathVariable Long id, @RequestBody @Valid FuncionarioEntities Funcionario) {
		FuncionarioEntities alteraFuncionario = FuncionarioService.alterarFuncionario(id, Funcionario);
		if (alteraFuncionario != null) {
			return ResponseEntity.ok(Funcionario);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Exclui um Funcionario")
	public ResponseEntity<FuncionarioEntities> apagaFuncionarioControl(@PathVariable Long id) {
		boolean apagar = FuncionarioService.apagarFuncionario(id);
		if (apagar) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}



}	

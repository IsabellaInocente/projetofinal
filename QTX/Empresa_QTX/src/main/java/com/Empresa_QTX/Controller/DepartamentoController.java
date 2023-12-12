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

import com.Empresa_QTX.Service.DepartamentoService;
import com.Empresa_QTX.entities.DepartamentoEntities;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;


@Tag(name = "Departamento", description = "API REST DE GERENCIAMENTO DE DEPARTAMENTO")
@RestController
@RequestMapping("/departamento")
@CrossOrigin(origins="*")
public class DepartamentoController {

	private final DepartamentoService DepartamentoService;

	@Autowired
	public DepartamentoController(DepartamentoService Departamentoservice) {
		this.DepartamentoService = Departamentoservice;
	}

	@GetMapping("/{id}")
	@Operation(summary = "Localiza Departamento por ID")
	public ResponseEntity<DepartamentoEntities> buscaDepartamentoControlId(@PathVariable Long id) {
		DepartamentoEntities Departamento= DepartamentoService.buscaDepartamentoId(id);
		if (Departamento != null) {
			return ResponseEntity.ok(Departamento);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping
	@Operation(summary = "Apresenta todos os Departamento")
	public ResponseEntity<List<DepartamentoEntities>> buscaTodosDepartamentoControl() {
		List<DepartamentoEntities> Departamento = DepartamentoService.buscaTodosDepartamento();
		return ResponseEntity.ok(Departamento);
	}

	@PostMapping
	@Operation(summary = "Cadastra os Departamento")
	public ResponseEntity<DepartamentoEntities> salvaDepartamentoControl(@RequestBody DepartamentoEntities Departamento) {
		DepartamentoEntities salvaDepartamento = DepartamentoService.salvaDepartamento(Departamento);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaDepartamento);
	}

	@PutMapping("/{id}")
	@Operation(summary = "Altera os Departamento")
	public ResponseEntity<DepartamentoEntities> alteraDepartamentoControl(@PathVariable Long id, @RequestBody @Valid DepartamentoEntities Departamento) {
		DepartamentoEntities alteraDepartamento = DepartamentoService.alterarDepartamento(id, Departamento);
		if (alteraDepartamento != null) {
			return ResponseEntity.ok(Departamento);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Exclui um Departamento")
	public ResponseEntity<DepartamentoEntities> apagaDepartamentoControl(@PathVariable Long id) {
		boolean apagar = DepartamentoService.apagarDepartamento(id);
		if (apagar) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}



}

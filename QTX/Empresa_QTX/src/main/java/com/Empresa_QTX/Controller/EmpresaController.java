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

import com.Empresa_QTX.Service.EmpresaService;
import com.Empresa_QTX.entities.EmpresaEntities;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Empresa", description = "API REST DE GERENCIAMENTO DE EMPRESA")
@RestController
@RequestMapping("/empresa")
@CrossOrigin(origins="*")
public class EmpresaController {

	private final EmpresaService EmpresaService;

	@Autowired
	public EmpresaController(EmpresaService Empresaservice) {
		this.EmpresaService = Empresaservice;
	}

	@GetMapping("/{id}")
	@Operation(summary = "Localiza Empresa por ID")
	public ResponseEntity<EmpresaEntities> buscaEmpresaControlId(@PathVariable Long id) {
		EmpresaEntities Empresa = EmpresaService.buscaEmpresaId(id);
		if (Empresa != null) {
			return ResponseEntity.ok(Empresa);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping
	@Operation(summary = "Apresenta todos as Empresa")
	public ResponseEntity<List<EmpresaEntities>> buscaTodosEmpresaControl() {
		List<EmpresaEntities> Empresa = EmpresaService.buscaTodosEmpresa();
		return ResponseEntity.ok(Empresa);
	}

	@PostMapping
	@Operation(summary = "Cadastra os Empresa")
	public ResponseEntity<EmpresaEntities> salvaEmpresaControl(@RequestBody EmpresaEntities Empresa) {
		EmpresaEntities salvaEmpresa = EmpresaService.salvaEmpresa(Empresa);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaEmpresa);
	}

	@PutMapping("/{id}")
	@Operation(summary = "Altera um Empresa")
	public ResponseEntity<EmpresaEntities> alteraEmpresaControl(@PathVariable Long id, @RequestBody @Valid EmpresaEntities Empresa) {
		EmpresaEntities alteraEmpresa = EmpresaService.alterarEmpresa(id, Empresa);
		if (alteraEmpresa != null) {
			return ResponseEntity.ok(Empresa);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Exclui um Empresa")
	public ResponseEntity<EmpresaEntities> apagaEmpresaControl(@PathVariable Long id) {
		boolean apagar = EmpresaService.apagarEmpresa(id);
		if (apagar) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}



}	

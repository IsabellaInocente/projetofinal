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

import com.Empresa_QTX.Service.ClienteService;
import com.Empresa_QTX.entities.ClienteEntities;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Cliente", description = "API REST DE GERENCIAMENTO DE CLIENTE")
@RestController
@RequestMapping("/cliente")
@CrossOrigin(origins="*")
public class ClienteController {

	private final ClienteService clienteService;

	@Autowired
	public ClienteController(ClienteService clienteservice) {
		this.clienteService = clienteservice;
	}

	@GetMapping("/{id}")
	@Operation(summary = "Localiza Cliente por ID")
	public ResponseEntity<ClienteEntities> buscaClienteControlId(@PathVariable Long id) {
		ClienteEntities cliente = clienteService.buscaClienteId(id);
		if (cliente != null) {
			return ResponseEntity.ok(cliente);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping
	@Operation(summary = "Apresenta todos os Cliente")
	public ResponseEntity<List<ClienteEntities>> buscaTodosClienteControl() {
		List<ClienteEntities> Cliente = clienteService.buscaTodosCliente();
		return ResponseEntity.ok(Cliente);
	}

	@PostMapping
	@Operation(summary = "Cadastra um Cliente")
	public ResponseEntity<ClienteEntities> salvaClienteControl(@RequestBody ClienteEntities cliente) {
		ClienteEntities salvaCliente = clienteService.salvaCliente(cliente);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaCliente);
	}

	@PutMapping("/{id}")
	@Operation(summary = "Altera um Cliente")
	public ResponseEntity<ClienteEntities> alteraClienteControl(@PathVariable Long id, @RequestBody @Valid ClienteEntities Cliente) {
		ClienteEntities alteraCliente = clienteService.alterarCliente(id, Cliente);
		if (alteraCliente != null) {
			return ResponseEntity.ok(Cliente);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Exclui um Cliente")
	public ResponseEntity<ClienteEntities> apagaClienteControl(@PathVariable Long id) {
		boolean apagar = clienteService.apagarCliente(id);
		if (apagar) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
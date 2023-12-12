package com.Empresa_QTX.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Empresa_QTX.Service.ClienteService;
import com.Empresa_QTX.Service.DepartamentoService;
import com.Empresa_QTX.Service.EmpresaService;
import com.Empresa_QTX.Service.FornecedorService;
import com.Empresa_QTX.Service.FuncionarioService;
import com.Empresa_QTX.Service.ProjetoService;
import com.Empresa_QTX.entities.ClienteEntities;
import com.Empresa_QTX.entities.DepartamentoEntities;
import com.Empresa_QTX.entities.EmpresaEntities;
import com.Empresa_QTX.entities.FornecedorEntities;
import com.Empresa_QTX.entities.FuncionarioEntities;
import com.Empresa_QTX.entities.ProjetoEntities;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "API_Externa", description = "API REST DE GERENCIAMENTO DE Modulos")
@RestController
@RequestMapping("/API_Externa")
@CrossOrigin(origins = "*")
public class API_ExternaController {

	private final ClienteService clienteService;
	private final DepartamentoService DepartamentoService;
	private final EmpresaService EmpresaService;
	private final FornecedorService fornecedorService;
	private final FuncionarioService FuncionarioService;
	private final ProjetoService ProjetoService;

	@Autowired
		public API_ExternaController(ClienteService clienteService,DepartamentoService Departamentoservice, EmpresaService Empresaservice, FornecedorService fornecedorservice, FuncionarioService Funcionarioservice, ProjetoService Projetoservice) {
			this.clienteService = clienteService;
			this.DepartamentoService = Departamentoservice;
			this.EmpresaService = Empresaservice;
			this.fornecedorService = fornecedorservice;
			this.FuncionarioService = Funcionarioservice;
			this.ProjetoService = Projetoservice;
		}

	@GetMapping("/apiclientes")
	@Operation(summary = "Apresenta todos os Cliente")
	public ResponseEntity<List<ClienteEntities>> buscaTodosClienteControl() {
		List<ClienteEntities> Cliente = clienteService.buscaTodosCliente();
		return ResponseEntity.ok(Cliente);
	}

	@GetMapping("/apidepartamento")
	@Operation(summary = "Apresenta todos os Departamento")
	public ResponseEntity<List<DepartamentoEntities>> buscaTodosDepartamentoControl() {
		List<DepartamentoEntities> Departamento = DepartamentoService.buscaTodosDepartamento();
		return ResponseEntity.ok(Departamento);
	}

	@GetMapping("/apiempresa")
	@Operation(summary = "Apresenta todos as Empresa")
	public ResponseEntity<List<EmpresaEntities>> buscaTodosEmpresaControl() {
		List<EmpresaEntities> Empresa = EmpresaService.buscaTodosEmpresa();
		return ResponseEntity.ok(Empresa);
	}

	@GetMapping("/apifornecedores")
	@Operation(summary = "Apresenta todos os Fornecedores")
	public ResponseEntity<List<FornecedorEntities>> buscaTodosFornecedorControl() {
		List<FornecedorEntities> Fornecedor = fornecedorService.buscaTodosFornecedor();
		return ResponseEntity.ok(Fornecedor);
	}

	@GetMapping("/apifuncionarios")
	@Operation(summary = "Apresenta todos os Funcionarios")
	public ResponseEntity<List<FuncionarioEntities>> buscaTodosFuncionarioControl() {
		List<FuncionarioEntities> Funcionario = FuncionarioService.buscaTodosFuncionario();
		return ResponseEntity.ok(Funcionario);
	}

	@GetMapping("/apiprojetos")
	@Operation(summary = "Apresenta todos os Projetos")
	public ResponseEntity<List<ProjetoEntities>> buscaTodosProjetoControl() {
		List<ProjetoEntities> Projeto = ProjetoService.buscaTodosProjeto();
		return ResponseEntity.ok(Projeto);
	}

}

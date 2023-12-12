package com.Empresa_QTX.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Empresa_QTX.Repository.ClienteRepository;
import com.Empresa_QTX.entities.ClienteEntities;
@Service
public class ClienteService {

	private final ClienteRepository clienteRepository;

	@Autowired
	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	public List<ClienteEntities> buscaTodosCliente(){
		return clienteRepository.findAll();
	}
	public ClienteEntities buscaClienteId(Long id) {
		Optional <ClienteEntities> Cliente = clienteRepository.findById(id);
		return Cliente.orElse(null);
	}
	public ClienteEntities salvaCliente(ClienteEntities Cliente) {
		return clienteRepository.save(Cliente);
	}
	public ClienteEntities alterarCliente(Long id, ClienteEntities alterarC) {
		Optional <ClienteEntities> existeCliente = clienteRepository.findById(id);
		if(existeCliente.isPresent()) {
			alterarC.setId(id);
			return clienteRepository.save(alterarC);
		}
		return null;
	}
	public boolean apagarCliente(Long id) {
		Optional <ClienteEntities> existeCliente = clienteRepository.findById(id);
		if (existeCliente.isPresent()) {
			clienteRepository.deleteById(id);
			return true;
		}
		return false;
		}
	
	}

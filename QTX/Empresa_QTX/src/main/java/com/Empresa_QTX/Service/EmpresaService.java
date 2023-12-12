package com.Empresa_QTX.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Empresa_QTX.Repository.EmpresaRepository;
import com.Empresa_QTX.entities.EmpresaEntities;
@Service
public class EmpresaService {

	private final EmpresaRepository empresaRepository;

	@Autowired
	public EmpresaService(EmpresaRepository empresaRepository) {
		this.empresaRepository = empresaRepository;
	}
	public List<EmpresaEntities> buscaTodosEmpresa(){
		return empresaRepository.findAll();
	}
	public EmpresaEntities buscaEmpresaId(Long id) {
		Optional <EmpresaEntities> empresa = empresaRepository.findById(id);
		return empresa.orElse(null);
	}
	public EmpresaEntities salvaEmpresa(EmpresaEntities empresa) {
		return empresaRepository.save(empresa);
	}
	public EmpresaEntities alterarEmpresa(Long id, EmpresaEntities alterarE) {
		Optional <EmpresaEntities> existeEmpresa = empresaRepository.findById(id);
		if(existeEmpresa.isPresent()) {
			alterarE.setId(id);
			return empresaRepository.save(alterarE);
		}
		return null;
	}
	public boolean apagarEmpresa(Long id) {
		Optional <EmpresaEntities> existeEmpresa = empresaRepository.findById(id);
		if (existeEmpresa.isPresent()) {
			empresaRepository.deleteById(id);
			return true;
		}
		return false;
		}
	
	}




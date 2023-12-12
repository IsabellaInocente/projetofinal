package com.Empresa_QTX.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Empresa_QTX.Repository.DepartamentoRepository;
import com.Empresa_QTX.entities.DepartamentoEntities;

@Service
public class DepartamentoService {

	private final DepartamentoRepository DepartamentoRepository;

	@Autowired
	public DepartamentoService(DepartamentoRepository DepartamentoRepository) {
		this.DepartamentoRepository = DepartamentoRepository;
	}
	public List<DepartamentoEntities> buscaTodosDepartamento(){
		return DepartamentoRepository.findAll();
	}
	public DepartamentoEntities buscaDepartamentoId(Long id) {
		Optional <DepartamentoEntities> Departamento = DepartamentoRepository.findById(id);
		return Departamento.orElse(null);
	}
	public DepartamentoEntities salvaDepartamento(DepartamentoEntities Departamento) {
		return DepartamentoRepository.save(Departamento);
	}
	public DepartamentoEntities alterarDepartamento(Long id, DepartamentoEntities alterarDepartamento) {
		Optional <DepartamentoEntities> existeDepartamento = DepartamentoRepository.findById(id);
		if(existeDepartamento.isPresent()) {
			alterarDepartamento.setId(id);
			return DepartamentoRepository.save(alterarDepartamento);
		}
		return null;
	}
	public boolean apagarDepartamento(Long id) {
		Optional <DepartamentoEntities> existeDepartamento = DepartamentoRepository.findById(id);
		if (existeDepartamento.isPresent()) {
			DepartamentoRepository.deleteById(id);
			return true;
		}
		return false;
	}

}

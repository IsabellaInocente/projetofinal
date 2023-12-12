package com.Empresa_QTX.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Empresa_QTX.Repository.FornecedorRepository;
import com.Empresa_QTX.entities.FornecedorEntities;
@Service
public class FornecedorService {

	private final FornecedorRepository fornecedorRepository;

	@Autowired
	public FornecedorService(FornecedorRepository fornecedorRepository) {
		this.fornecedorRepository = fornecedorRepository;
	}
	public List<FornecedorEntities> buscaTodosFornecedor(){
		return fornecedorRepository.findAll();
	}
	public FornecedorEntities buscaFornecedorId(Long id) {
		Optional <FornecedorEntities> Fornecedor = fornecedorRepository.findById(id);
		return Fornecedor.orElse(null);
	}
	public FornecedorEntities salvaFornecedor(FornecedorEntities Fornecedor) {
		return fornecedorRepository.save(Fornecedor);
	}
	public FornecedorEntities alterarFornecedor(Long id, FornecedorEntities alterarF) {
		Optional <FornecedorEntities> existeFornecedor = fornecedorRepository.findById(id);
		if(existeFornecedor.isPresent()) {
			alterarF.setId(id);
			return fornecedorRepository.save(alterarF);
		}
		return null;
	}
	public boolean apagarFornecedor(Long id) {
		Optional <FornecedorEntities> existeFornecedor = fornecedorRepository.findById(id);
		if (existeFornecedor.isPresent()) {
			fornecedorRepository.deleteById(id);
			return true;
		}
		return false;
		}
	
	}




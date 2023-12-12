package com.Empresa_QTX.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Empresa_QTX.Repository.FuncionarioRepository;
import com.Empresa_QTX.entities.FuncionarioEntities;

@Service
	public class FuncionarioService {

		private final FuncionarioRepository FuncionarioRepository;

		@Autowired
		public FuncionarioService(FuncionarioRepository FuncionarioRepository) {
			this.FuncionarioRepository = FuncionarioRepository;
		}
		public List<FuncionarioEntities> buscaTodosFuncionario(){
			return FuncionarioRepository.findAll();
		}
		public FuncionarioEntities buscaFuncionarioId(Long id) {
			Optional <FuncionarioEntities> Funcionario = FuncionarioRepository.findById(id);
			return Funcionario.orElse(null);
		}
		public FuncionarioEntities salvaFornecedor(FuncionarioEntities Funcionario) {
			return FuncionarioRepository.save(Funcionario);
		}
		public FuncionarioEntities alterarFuncionario(Long id, FuncionarioEntities alterarFuncionario) {
			Optional <FuncionarioEntities> existeFuncionario = FuncionarioRepository.findById(id);
			if(existeFuncionario.isPresent()) {
				alterarFuncionario.setId(id);
				return FuncionarioRepository.save(alterarFuncionario);
			}
			return null;
		}
		public boolean apagarFuncionario(Long id) {
			Optional <FuncionarioEntities> existeFuncionario = FuncionarioRepository.findById(id);
			if (existeFuncionario.isPresent()) {
				FuncionarioRepository.deleteById(id);
				return true;
			}
			return false;
			}
		
		}

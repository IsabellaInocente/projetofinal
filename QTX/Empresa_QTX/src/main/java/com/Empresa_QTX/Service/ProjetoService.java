package com.Empresa_QTX.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Empresa_QTX.Repository.ProjetoRepository;
import com.Empresa_QTX.entities.ProjetoEntities;

@Service
	public class ProjetoService {

		private final ProjetoRepository ProjetoRepository;

		@Autowired
		public ProjetoService(ProjetoRepository ProjetoRepository) {
			this.ProjetoRepository = ProjetoRepository;
		}
		public List<ProjetoEntities> buscaTodosProjeto(){
			return ProjetoRepository.findAll();
		}
		public ProjetoEntities buscaProjetoId(Long id) {
			Optional <ProjetoEntities> Projeto = ProjetoRepository.findById(id);
			return Projeto.orElse(null);
		}
		public ProjetoEntities salvaFornecedor(ProjetoEntities Projeto) {
			return ProjetoRepository.save(Projeto);
		}
		public ProjetoEntities alterarProjeto(Long id, ProjetoEntities alterarProjeto) {
			Optional <ProjetoEntities> existeProjeto = ProjetoRepository.findById(id);
			if(existeProjeto.isPresent()) {
				alterarProjeto.setId(id);
				return ProjetoRepository.save(alterarProjeto);
			}
			return null;
		}
		public boolean apagarProjeto(Long id) {
			Optional <ProjetoEntities> existeProjeto = ProjetoRepository.findById(id);
			if (existeProjeto.isPresent()) {
				ProjetoRepository.deleteById(id);
				return true;
			}
			return false;
			}
		
		}

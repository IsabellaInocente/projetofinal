package com.Empresa_QTX.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Empresa_QTX.entities.FornecedorEntities;

public interface FornecedorRepository extends JpaRepository<FornecedorEntities, Long> {
	
	// Nenhuma implementação é necessária. Spring Data JPA cuidará disso.
}
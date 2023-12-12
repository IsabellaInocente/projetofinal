package com.Empresa_QTX.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Empresa_QTX.entities.ClienteEntities;

public interface ClienteRepository extends JpaRepository<ClienteEntities, Long> {
	
	// Nenhuma implementação é necessária. Spring Data JPA cuidará disso.
}
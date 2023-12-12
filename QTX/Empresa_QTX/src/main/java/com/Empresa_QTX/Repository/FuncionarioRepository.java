package com.Empresa_QTX.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Empresa_QTX.entities.FuncionarioEntities;

public interface FuncionarioRepository extends JpaRepository<FuncionarioEntities, Long> {

}

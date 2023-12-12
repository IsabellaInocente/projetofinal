package com.Empresa_QTX.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Empresa_QTX.entities.DepartamentoEntities;

public interface DepartamentoRepository  extends JpaRepository<DepartamentoEntities, Long> {

}

package com.Empresa_QTX.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Empresa_QTX.entities.EmpresaEntities;

public interface EmpresaRepository extends JpaRepository<EmpresaEntities, Long> {

}

package com.Empresa_QTX.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Cliente")
public class ClienteEntities {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull

	private String nome;
	
	@NotNull

	private String cpf;
	
	@NotNull

	private String rg;
	
	@NotNull

	private String endereco;
	
	@NotNull
    @Email(message="Informe o Email corretamente")
	private String email;
}
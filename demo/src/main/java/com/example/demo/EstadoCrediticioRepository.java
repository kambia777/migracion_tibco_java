package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoCrediticioRepository extends JpaRepository<EstadoCrediticio, Long> {
	
	EstadoCrediticio findByCodigoCliente(Long codigoCliente);
	
}

package com.example.demo;



import java.util.List;

import org.springframework.stereotype.Service;



@Service
public class EstadoCrediticioService {
	
	private final EstadoCrediticioRepository estadoCrediticioRepository;

    public EstadoCrediticioService (EstadoCrediticioRepository estadoCrediticioRepository) {
        this.estadoCrediticioRepository = estadoCrediticioRepository;
    }
    
    public List<EstadoCrediticio> obtenerTodosEstadoCrediticio() {
        return estadoCrediticioRepository.findAll();
    }

    
    public EstadoCrediticio obtenerEstadoCrediticioPorId(Long id) {
    	
        return estadoCrediticioRepository.findById(id).orElse(null);
    }
    
    public EstadoCrediticio obtenerEstadoCrediticioPorCodigoCliente(Long codigoCliente) {
    	EstadoCrediticio aux = estadoCrediticioRepository.findByCodigoCliente(codigoCliente);
    	System.out.println("es deudor: " + aux.isEsDeudor());
        return aux;
    }

}

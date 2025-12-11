package com.example.demo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/estados-crediticios")
public class EstadoCrediticioController {
	
	private final EstadoCrediticioService estadoCrediticioService;

    public EstadoCrediticioController(EstadoCrediticioService estadoCrediticioService) {
        this.estadoCrediticioService = estadoCrediticioService;
    }
    
    /*@GetMapping
    public List<EstadoCrediticio> getAllEstadoCrediticio() {
    	List<EstadoCrediticio> aux = estadoCrediticioService.obtenerTodosEstadoCrediticio();
        return aux; // Llama al Service
    }*/
    
    @GetMapping
    public EstadoCrediticio getEstadoCrediticioCodigoCliente(@RequestParam Long codigoCliente) {
    	System.out.println("codigo cliente: " + codigoCliente);
    	EstadoCrediticio aux = estadoCrediticioService.obtenerEstadoCrediticioPorCodigoCliente(Long.valueOf(codigoCliente));
    	System.out.println("es deudor: " + aux.isEsDeudor());
        return aux; // Llama al Service
    }

    @GetMapping("/{codigoCliente}/estado-crediticio")
    public EstadoCrediticio getEstadoCrediticio(@PathVariable Long codigoCliente) {
    	System.out.println("codigo cliente: " + codigoCliente);
    	EstadoCrediticio aux = estadoCrediticioService.obtenerEstadoCrediticioPorCodigoCliente(codigoCliente);
    	System.out.println("es deudor: " + aux.isEsDeudor());
        return aux; // Llama al Service
    }

}

package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "estado_crediticio", schema = "tfg_apiterceros")
public class EstadoCrediticio {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column(name = "codigo_cliente") 
	private Long codigoCliente;
	private String nombre;
	@Column(name = "es_deudor") 
    private boolean esDeudor;
	@Column(name = "monto_pendiente") 
    private Double montoPendiente;
   
	
    
	public EstadoCrediticio() {

	}
	public EstadoCrediticio(Long id, Long codigoCliente, String nombre, boolean esDeudor, Double montoPendiente) {
		super();
		this.id = id;
		this.codigoCliente = codigoCliente;
		this.nombre = nombre;
		this.esDeudor = esDeudor;
		this.montoPendiente = montoPendiente;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCodigoCliente() {
		return codigoCliente;
	}
	public void setCodigoCliente(Long codigoCliente) {
		this.codigoCliente = codigoCliente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean isEsDeudor() {
		return esDeudor;
	}
	public void setEsDeudor(boolean esDeudor) {
		this.esDeudor = esDeudor;
	}
	public Double getMontoPendiente() {
		return montoPendiente;
	}
	public void setMonto_pendiente(Double montoPendiente) {
		this.montoPendiente = montoPendiente;
	}
    

}

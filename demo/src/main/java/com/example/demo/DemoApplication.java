package com.example.demo;


import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;






@SpringBootApplication
public class DemoApplication {


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	/**@Bean
	public CommandLineRunner run(XmlFileService xmlFileService) {
	    return args -> {
	        xmlFileService.printXml("src/main/resources/testfiles/input.xml", "cliente");
	    };
	}**/
	
	/**public CommandLineRunner testConnection(DataSource dataSource) {
	    return args -> {
	        System.out.println("DataSource: " + dataSource.getConnection());
	    };
	}**/
	
    /*public CommandLineRunner showClientes(ClienteRepository clienteRepository) {
        return args -> {
            List<Cliente> clientes = clienteRepository.findAll();
            System.out.println("Clientes en la base de datos:");
            clientes.forEach(c -> System.out.println(c.getId() + " | " + c.getCodigo()));
        };
    }*/
	@Bean
	public CommandLineRunner demo(ClienteService clienteService) {
	    return args -> {
	        List<Cliente> clientes = clienteService.obtenerTodosClientes();
	        System.out.println("Clientes en la base de datos:");
	        clientes.forEach(c -> System.out.println(c.getId() + " | " + c.getCodigo()));
	    };
	}

}

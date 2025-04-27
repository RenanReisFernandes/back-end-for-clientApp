package com.renan.clientApp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.renan.clientApp.entities.Client;
import com.renan.clientApp.services.ClienteService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/cliente")
@CrossOrigin("*")
@RequiredArgsConstructor
public class ClienteController {
	
	private final ClienteService clienteService;
	
	@PostMapping
	public ResponseEntity<Client> salvar(@RequestBody Client cliente){
		Client clienteCriado = clienteService.createClient(cliente);
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteCriado);
	}
	
	@GetMapping
	public ResponseEntity<List<Client>> listarTodos(){
		List<Client> list = clienteService.findAllClients();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Client> buscarPorId(@PathVariable("id") Long id) {
	    Optional<Client> optionalCliente = clienteService.findClientById(id);

	    if (optionalCliente.isEmpty()) {
	    	return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	        
	    } else {
	    	return ResponseEntity.ok(optionalCliente.get());
	    }
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Client> updateClient(@PathVariable("id") Long id, @RequestBody Client cliente){
	    Optional<Client> clienteAtualizado = clienteService.updateClient(cliente, id);
	    if (clienteAtualizado.isEmpty()) {
	        System.out.println("Cliente não encontrado");
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	    } else {
	        return ResponseEntity.ok(clienteAtualizado.get());
	    }
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteClient(@PathVariable("id") Long id){
		clienteService.deleteClient(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	

}

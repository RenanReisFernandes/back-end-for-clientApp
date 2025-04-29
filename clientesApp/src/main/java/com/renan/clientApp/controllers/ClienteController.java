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

import com.renan.clientApp.Mapper.ClientMapper;
import com.renan.clientApp.Request.ClientRequest;
import com.renan.clientApp.Response.ClientResponse;
import com.renan.clientApp.entities.Client;
import com.renan.clientApp.services.ClienteService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/cliente")
@CrossOrigin("*")
@RequiredArgsConstructor
public class ClienteController {
	
	private final ClienteService clienteService;
	private final ClientMapper mapper;
	
	@PostMapping
	public ResponseEntity<ClientResponse> salvar(@RequestBody ClientRequest clienteRequest){
		Client clienteCriado = mapper.toClient(clienteRequest);
		Client clienteSalvo = clienteService.createClient(clienteCriado);
		ClientResponse clienteConvertido = mapper.toClientResponse(clienteSalvo);
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteConvertido);
	}
	
	@GetMapping
	public ResponseEntity<List<ClientResponse>> listarTodos(){
		List<Client> list = clienteService.findAllClients();
		List<ClientResponse> clientResponse = mapper.toClientresponseList(list);
		return ResponseEntity.status(HttpStatus.OK).body(clientResponse);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ClientResponse> buscarPorId(@PathVariable("id") Long id) {
	    Optional<Client> optionalCliente = clienteService.findClientById(id);

	    if (optionalCliente.isEmpty()) {
	    	return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	        
	    } else {
	    	return ResponseEntity.status(HttpStatus.OK).body(mapper.toClientResponse(optionalCliente.get()));
	    }
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ClientResponse> updateClient(@PathVariable("id") Long id, @RequestBody ClientRequest clienteRequest){
		Client clienteConvertido = mapper.toClient(clienteRequest);
	    Optional<Client> clienteAtualizado = clienteService.updateClient(clienteConvertido, id);
	    if (clienteAtualizado.isEmpty()) {
	        System.out.println("Cliente não encontrado");
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	    } else {
	    	
	        ClientResponse response = mapper.toClientResponse(clienteAtualizado.get());
	        return ResponseEntity.ok(response);
	    }
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteClient(@PathVariable("id") Long id){
		clienteService.deleteClient(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	

}

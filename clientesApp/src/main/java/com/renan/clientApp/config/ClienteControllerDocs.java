package com.renan.clientApp.config;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.renan.clientApp.Request.ClientRequest;
import com.renan.clientApp.Response.ClientResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

public interface ClienteControllerDocs {

	@Operation(summary = "Salvar novo cliente")
    ResponseEntity<ClientResponse> salvar(ClientRequest clienteRequest);

    @Operation(summary = "Listar todos os clientes")
    ResponseEntity<List<ClientResponse>> listarTodos();

    @Operation(summary = "Buscar cliente por ID",
        responses = {
            @ApiResponse(responseCode = "200", description = "Cliente encontrado"),
            @ApiResponse(responseCode = "404", description = "Cliente não encontrado")
        })
    ResponseEntity<ClientResponse> buscarPorId(Long id);

    @Operation(summary = "Atualizar cliente por ID")
    ResponseEntity<ClientResponse> updateClient(Long id, ClientRequest clienteRequest);

    @Operation(summary = "Excluir cliente por ID")
    ResponseEntity<Void> deleteClient(Long id);
}

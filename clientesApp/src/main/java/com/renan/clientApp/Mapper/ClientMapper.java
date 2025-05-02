package com.renan.clientApp.Mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.renan.clientApp.Request.ClientRequest;
import com.renan.clientApp.Response.ClientResponse;
import com.renan.clientApp.entities.Client;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ClientMapper {
	
	private final ModelMapper mapper;
	
	public Client toClient(ClientRequest request) {
		return mapper.map(request, Client.class);
	}
	
	public ClientResponse toClientResponse(Client client) {
		return mapper.map(client, ClientResponse.class);
	}
	
	public List<ClientResponse> toClientresponseList(List<Client> clientList){
		return  clientList.stream()
				.map(this:: toClientResponse)
				.collect(Collectors.toList());
	}
	
	//public static Client toClient(ClientRequest request) {
	//	Client cliente = new Client();
	//	cliente.setNome(request.getNome());
	//	cliente.setTelefone(request.getTelefone());
	//	cliente.setEndereco(request.getEndereco());
	//	cliente.setCpf(request.getCpf());
	//	return cliente;
    //	}
	
//	public static ClientResponse toClientResponse(Client client) {
//		ClientResponse clientResponse = new ClientResponse();
//		clientResponse.setId(client.getId());
//		clientResponse.setNome(client.getNome());
//		clientResponse.setCpf(client.getCpf());
//		clientResponse.setDataCadastro(client.getDataCadastro());
//		return clientResponse;
//	}
	
//	public static List<ClientResponse> toClientresponseList(List<Client> clientList){
//		List<ClientResponse> response = new ArrayList<>();
//		for(Client client: clientList) {
//			response.add(toClientResponse(client));
//		}
//		return response;
//	}

}

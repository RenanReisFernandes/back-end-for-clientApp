package com.renan.clientApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.renan.clientApp.entities.Client;
import com.renan.clientApp.repositories.ClienteRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class ClienteService {

	private final ClienteRepository clienteRepository;

	public Client createClient(Client cliente) {
		Optional<Client> clienteEncontrado = clienteRepository.findById(cliente.getId());
		if (clienteEncontrado.isPresent()) {
			System.out.println("Cliente já cadastrado!");
			return clienteEncontrado.get();
		} else {
			return clienteRepository.save(cliente);
		}
	}

	public Optional<Client> findClientById(Long id) {
		return clienteRepository.findById(id);

	}

	public List<Client> findAllClients() {
		return clienteRepository.findAll();

	}

	public Optional<Client> updateClient(Client cliente, Long id) {

		Optional<Client> clienteEncontrado = clienteRepository.findById(id);
		if (clienteEncontrado.isEmpty()) {
			System.out.println("Cliente não encontrado!");
			return Optional.of(clienteEncontrado.get());
		} else {
			Client clienteAtualizado = clienteEncontrado.get();
			clienteAtualizado.setNome(cliente.getNome());
			clienteAtualizado.setEndereco(cliente.getEndereco());
			clienteAtualizado.setTelefone(cliente.getTelefone());
			clienteAtualizado.setCpf(cliente.getCpf());

			Client clienteConcluido = clienteRepository.save(clienteAtualizado);
			return Optional.of(clienteConcluido);
		}

	}

	public void deleteClient(Long id) {
		clienteRepository.deleteById(id);

	}
}

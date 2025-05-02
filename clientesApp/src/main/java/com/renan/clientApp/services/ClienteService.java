package com.renan.clientApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.renan.clientApp.entities.Client;
import com.renan.clientApp.exceptions.NotFoundException;
import com.renan.clientApp.repositories.ClienteRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class ClienteService {

	private final ClienteRepository clienteRepository;

	public Client createClient(Client cliente) {
	    Optional<Client> clienteExistente = clienteRepository.findByCpf(cliente.getCpf());

	    if (clienteExistente.isPresent()) {
	        throw new RuntimeException("Já existe um cliente com o CPF: " + cliente.getCpf());
	    }

	    return clienteRepository.save(cliente);
	}
	
	public Optional<Client> findClientById(Long id) {
		return clienteRepository.findById(id);

	}

	public List<Client> findAllClients() {
		return clienteRepository.findAll();

	}

	public Optional<Client> updateClient(Client cliente, Long id) {

		Client clienteEncontrado = clienteRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Cliente com ID " + id + " não encontrado"));

		clienteEncontrado.setNome(cliente.getNome());
		clienteEncontrado.setEndereco(cliente.getEndereco());
		clienteEncontrado.setTelefone(cliente.getTelefone());
		clienteEncontrado.setCpf(cliente.getCpf());

		return Optional.of(clienteRepository.save(clienteEncontrado));

	}

	public void deleteClient(Long id) {
		if (!clienteRepository.existsById(id)) {
			throw new RuntimeException("Cliente não encontrado para deletar");
		}
		clienteRepository.deleteById(id);
	}
}

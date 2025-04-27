package com.renan.clientApp.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.renan.clientApp.entities.Client;

@Repository
public interface ClienteRepository extends JpaRepository<Client, Long > {
	
	Optional<Client> findByCpf(String cpf);

}

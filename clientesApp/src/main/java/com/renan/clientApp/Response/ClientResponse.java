package com.renan.clientApp.Response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientResponse {
	private Long id;
	private String nome;
	private String cpf;
	private LocalDateTime dataCadastro;

}

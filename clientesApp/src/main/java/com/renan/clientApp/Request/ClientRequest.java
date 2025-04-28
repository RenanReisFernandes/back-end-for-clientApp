package com.renan.clientApp.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientRequest {

	private String nome;
	private Long telefone;
	private String endereco;
	private String cpf;

}

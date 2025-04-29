package com.renan.clientApp.Request;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientRequest {

	@NotBlank(message = "Campo nome é obrigatório")
	private String nome;
	private Long telefone;
	@NotBlank(message = "Campo endereço é obrigatório")
	private String endereco;
	@NotBlank(message = "Campo CPF é obrigatório")
	@CPF
	private String cpf;

}

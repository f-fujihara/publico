package br.com.ffujihara.exemplo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PessoaDto{

	private Long cpf;
	private String nome;
	private String sobrenome;

}

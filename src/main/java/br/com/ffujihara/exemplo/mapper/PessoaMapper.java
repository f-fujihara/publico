package br.com.ffujihara.exemplo.mapper;

import br.com.ffujihara.exemplo.dto.PessoaDto;
import br.com.ffujihara.exemplo.entity.PessoaEntity;

public class PessoaMapper {
	public static PessoaDto mapToPessoaDto(PessoaEntity pessoaEntity) {
		return new PessoaDto(
				pessoaEntity.getCpf(),
				pessoaEntity.getNome(),
				pessoaEntity.getSobrenome()
		);
	}
	public static PessoaEntity mapToPessoaEntity(PessoaDto pessoaDto){
		return new PessoaEntity(
				pessoaDto.getCpf(),
				pessoaDto.getNome(),
				pessoaDto.getSobrenome()
		);
	}
}

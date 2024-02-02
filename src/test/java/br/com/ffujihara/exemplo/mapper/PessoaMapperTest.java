package br.com.ffujihara.exemplo.mapper;

import br.com.ffujihara.exemplo.dto.PessoaDto;
import br.com.ffujihara.exemplo.entity.PessoaEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class PessoaMapperTest {
    private static final Long cpf = 123456789L;
    private static final String nome = "Nome";
    private static final String sobrenome = "Sobrenome";

    @Test
    void mapToPessoaDto() {
        PessoaEntity entity = new PessoaEntity(cpf,nome,sobrenome);
        PessoaDto result = PessoaMapper.mapToPessoaDto(entity);
        PessoaDto dto = new PessoaDto(cpf,nome,sobrenome);
        Assertions.assertEquals(dto.getNome(), result.getNome());
        Assertions.assertEquals(dto.getSobrenome(), result.getSobrenome());
        Assertions.assertEquals(dto.getCpf(), result.getCpf());
    }

    @Test
    void mapToPessoaEntity() {
        PessoaDto dto = new PessoaDto(cpf,nome,sobrenome);
        PessoaEntity result = PessoaMapper.mapToPessoaEntity(dto);
        PessoaEntity entity = new PessoaEntity(cpf,nome,sobrenome);
        Assertions.assertEquals(entity.getCpf(), result.getCpf());
        Assertions.assertEquals(entity.getNome(), result.getNome());
        Assertions.assertEquals(entity.getSobrenome(), result.getSobrenome());

    }
}
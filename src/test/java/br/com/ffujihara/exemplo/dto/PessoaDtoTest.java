package br.com.ffujihara.exemplo.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PessoaDtoTest {
    private static final Long cpf = 123456789L;
    private static final String nome = "Nome";
    private static final String sobrenome = "Sobrenome";
    private static final Long id = 1L;

    @Test
    void DtoTest(){
        PessoaDto dto1 = new PessoaDto();
        dto1.setCpf(cpf);
        dto1.setNome(nome);
        dto1.setSobrenome(sobrenome);
        PessoaDto dto2 = new PessoaDto(cpf,nome,sobrenome);

        Assertions.assertEquals(dto1.getCpf(), dto2.getCpf());
        Assertions.assertEquals(dto1.getNome(), dto2.getNome());
        Assertions.assertEquals(dto1.getSobrenome(), dto2.getSobrenome());
    }
}
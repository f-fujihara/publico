package br.com.ffujihara.exemplo.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PessoaEntityTest {
    private static final Long cpf = 123456789L;
    private static final String nome = "Nome";
    private static final String sobrenome = "Sobrenome";
    private static final Long id = 1L;

    @Test
    void EntityTest(){
        PessoaEntity entity1 = new PessoaEntity();
        entity1.setCpf(cpf);
        entity1.setNome(nome);
        entity1.setSobrenome(sobrenome);
        PessoaEntity entity2 = new PessoaEntity(cpf,nome,sobrenome);

        Assertions.assertEquals(entity1.getCpf(), entity2.getCpf());
        Assertions.assertEquals(entity1.getNome(), entity2.getNome());
        Assertions.assertEquals(entity1.getSobrenome(), entity2.getSobrenome());
    }

}
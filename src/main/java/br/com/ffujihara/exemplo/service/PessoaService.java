package br.com.ffujihara.exemplo.service;

import br.com.ffujihara.exemplo.dto.PessoaDto;

import java.util.List;

public interface PessoaService {
    PessoaDto createPessoa(PessoaDto pessoaDto);

    PessoaDto getPessoaByCpf(Long cpf);

    List<PessoaDto> getAllPessoas();

    PessoaDto updatePessoa(Long cpf,PessoaDto updatePessoaDto);

    void deletePessoa(Long pessoaId);


}

package br.com.ffujihara.exemplo.service;

import br.com.ffujihara.exemplo.dto.PessoaDto;

import java.util.List;

public interface PessoaService {
    PessoaDto createPessoa(PessoaDto pessoaDto);

    PessoaDto getPessoaById(Long pessoaId);

    List<PessoaDto> getAllPessoas();

    PessoaDto updatePessoa(Long pessoaId,PessoaDto updatePessoaDto);

    void deletePessoa(Long pessoaId);


}

package br.com.ffujihara.exemplo.service.impl;

import br.com.ffujihara.exemplo.dto.PessoaDto;
import br.com.ffujihara.exemplo.entity.PessoaEntity;
import br.com.ffujihara.exemplo.exception.DataValidationException;
import br.com.ffujihara.exemplo.exception.PessoaNotFoundException;
import br.com.ffujihara.exemplo.mapper.PessoaMapper;
import br.com.ffujihara.exemplo.repository.PessoaRepository;
import br.com.ffujihara.exemplo.service.PessoaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PessoaServiceImpl implements PessoaService {

    private PessoaRepository pessoaRepository;

    @Override
    public PessoaDto createPessoa(PessoaDto pessoaDto) {
        if(pessoaDto.getNome().isEmpty() || pessoaDto.getSobrenome().isEmpty())
            throw new DataValidationException("Nome ou Sobrenome não podem estar em branco");
        if(!cpfValido(pessoaDto.getCpf()))
            throw new DataValidationException("CPF inválido");
        PessoaEntity pessoaEntity = PessoaMapper.mapToPessoaEntity(pessoaDto);
        PessoaEntity pessoaSalva =  pessoaRepository.save(pessoaEntity);
        return PessoaMapper.mapToPessoaDto(pessoaSalva);
    }

    @Override
    public PessoaDto getPessoaByCpf(Long cpf) {
        if(!cpfValido(cpf))
            throw new DataValidationException("CPF inválido");
        PessoaEntity pessoaEntity= pessoaRepository.findById(cpf)
                .orElseThrow(
                        () -> new PessoaNotFoundException("Não existe cadastro de pessoa com este cpf ")
                );
        return PessoaMapper.mapToPessoaDto(pessoaEntity);
    }

    @Override
    public List<PessoaDto> getAllPessoas() {
        List<PessoaEntity> pessoaEntities = pessoaRepository.findAll();
        return pessoaEntities.stream().map((pessoaEntity) -> PessoaMapper.mapToPessoaDto(pessoaEntity))
                .collect(Collectors.toList());
    }

    @Override
    public PessoaDto updatePessoa(Long cpf, PessoaDto updatePessoaDto) {

        if(updatePessoaDto.getNome().isEmpty() || updatePessoaDto.getSobrenome().isEmpty())
            throw new DataValidationException("Nome ou Sobrenome não podem estar em branco");
        if(!cpfValido(updatePessoaDto.getCpf()))
            throw new DataValidationException("CPF inválido");

       PessoaEntity pessoaEntity = pessoaRepository.findById(cpf)
               .orElseThrow(
                () ->  new PessoaNotFoundException("Não existe cadastro de pessoa com este cpf")
       );

       pessoaEntity.setNome(updatePessoaDto.getNome());
       pessoaEntity.setSobrenome(updatePessoaDto.getSobrenome());

       PessoaEntity updatedPessoa = pessoaRepository.save(pessoaEntity);
       return PessoaMapper.mapToPessoaDto(updatedPessoa);
    }

    @Override
    public void deletePessoa(Long cpf) {
        if(!cpfValido(cpf))
            throw new DataValidationException("CPF inválido");
        PessoaEntity pessoaEntity = pessoaRepository.findById(cpf)
                .orElseThrow(
                        () ->  new PessoaNotFoundException("Não existe cadastro de pessoa com este CPF")
                );
        pessoaRepository.deleteById(cpf);
    }

    private boolean cpfValido(Long cpf){
        if (cpf<1)
            return false;
        String cpfString = cpf.toString();
        if(cpfString.length()!=11 || cpfString.equals("00000000000") )
            return false;
        int soma =0;
        Integer resto =0;
        for (int i=1; i<=9; i++)
            soma = soma + Integer.parseInt(cpfString.substring(i-1, i)) * (11 - i);

        resto = (soma * 10) % 11;
        if (resto.equals(10) || resto.equals(11))
            resto = 0;

        if (!resto.toString().equals(cpfString.substring(9, 10)))
            return false;
        soma = 0;
        for (int i=1; i<=10; i++)
            soma = soma + Integer.parseInt(cpfString.substring(i-1, i)) * (12 - i);

        resto = (soma * 10) % 11;
        if (resto.equals(10) || resto.equals(11))
            resto = 0;

        if (!resto.toString().equals(cpfString.substring(10, 11)))
            return false;
        return true;
    }
}

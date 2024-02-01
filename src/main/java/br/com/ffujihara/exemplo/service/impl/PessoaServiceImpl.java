package br.com.ffujihara.exemplo.service.impl;

import br.com.ffujihara.exemplo.dto.PessoaDto;
import br.com.ffujihara.exemplo.entity.PessoaEntity;
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
        PessoaEntity pessoaEntity = PessoaMapper.mapToPessoaEntity(pessoaDto);
        PessoaEntity pessoaSalva =  pessoaRepository.save(pessoaEntity);
        return PessoaMapper.mapToPessoaDto(pessoaSalva);
    }

    @Override
    public PessoaDto getPessoaById(Long pessoaId) {
        PessoaEntity pessoaEntity= pessoaRepository.findById(pessoaId)
                .orElseThrow(
                        () -> new PessoaNotFoundException("Não existe pessoa com este Id: " +pessoaId)
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
    public PessoaDto updatePessoa(Long pessoaId, PessoaDto updatePessoaDto) {
       PessoaEntity pessoaEntity = pessoaRepository.findById(pessoaId)
               .orElseThrow(
                () ->  new PessoaNotFoundException("Não existe pessoa com este Id: " +pessoaId)
       );
       pessoaEntity.setNome(updatePessoaDto.getNome());
       pessoaEntity.setSobrenome(updatePessoaDto.getSobrenome());
       pessoaEntity.setCpf(updatePessoaDto.getCpf());

       PessoaEntity updatedPessoa = pessoaRepository.save(pessoaEntity);
       return PessoaMapper.mapToPessoaDto(updatedPessoa);
    }

    @Override
    public void deletePessoa(Long pessoaId) {
        PessoaEntity pessoaEntity = pessoaRepository.findById(pessoaId)
                .orElseThrow(
                        () ->  new PessoaNotFoundException("Não existe pessoa com este Id: " +pessoaId)
                );
        pessoaRepository.deleteById(pessoaId);
    }


}

package br.com.ffujihara.exemplo.controller;

import br.com.ffujihara.exemplo.dto.PessoaDto;
import br.com.ffujihara.exemplo.service.PessoaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pessoas")
@AllArgsConstructor
public class PessoaController {
	private PessoaService pessoaService;

	@PostMapping("/novo")
	public ResponseEntity<PessoaDto> CreatePessoa (@RequestBody PessoaDto pessoaDto){
		PessoaDto pessoaSalva = pessoaService.createPessoa(pessoaDto);
		return new ResponseEntity<>(pessoaSalva, HttpStatus.CREATED);
	}

	@GetMapping("{cpf}")
	public ResponseEntity<PessoaDto> getPessoaById(@PathVariable("cpf") Long cpf){
		PessoaDto pessoaDto = pessoaService.getPessoaByCpf(cpf);
		return ResponseEntity.ok(pessoaDto);
	}

	@GetMapping("/todos")
	public ResponseEntity<List<PessoaDto>> getAllPessoas(){
		List<PessoaDto> pessoas = pessoaService.getAllPessoas();
		return ResponseEntity.ok(pessoas);
	}

	@PutMapping("{cpf}")
	public ResponseEntity<PessoaDto> updatePessoa(@PathVariable("cpf") Long cpf, @RequestBody PessoaDto updatePessoa){
		PessoaDto updatedPessoa= pessoaService.updatePessoa(cpf,updatePessoa);
		return ResponseEntity.ok(updatedPessoa);
	}
	@DeleteMapping("{cpf}")
	public ResponseEntity<String> deletePessoa(@PathVariable("cpf") Long cpf){
		pessoaService.deletePessoa(cpf);
		return ResponseEntity.ok("Pessoa deletada com sucesso");
	}
}

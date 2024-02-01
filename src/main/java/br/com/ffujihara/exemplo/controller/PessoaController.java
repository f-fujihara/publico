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

	@GetMapping("{id}")
	public ResponseEntity<PessoaDto> getPessoaById(@PathVariable("id") Long pessoaId){
		PessoaDto pessoaDto = pessoaService.getPessoaById(pessoaId);
		return ResponseEntity.ok(pessoaDto);
	}

	@GetMapping("/todos")
	public ResponseEntity<List<PessoaDto>> getAllPessoas(){
		List<PessoaDto> pessoas = pessoaService.getAllPessoas();
		return ResponseEntity.ok(pessoas);
	}

	@PutMapping("{id}")
	public ResponseEntity<PessoaDto> updatePessoa(@PathVariable("id") Long pessoaId, @RequestBody PessoaDto updatePessoa){
		PessoaDto updatedPessoa= pessoaService.updatePessoa(pessoaId,updatePessoa);
		return ResponseEntity.ok(updatedPessoa);
	}
	@DeleteMapping("{id}")
	public ResponseEntity<String> deletePessoa(@PathVariable("id") Long pessoaId){
		pessoaService.deletePessoa(pessoaId);
		return ResponseEntity.ok("Pessoa deletada com sucesso");
	}
}

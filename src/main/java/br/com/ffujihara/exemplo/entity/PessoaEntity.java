package br.com.ffujihara.exemplo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter 
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PESSOAS")
public class PessoaEntity {

    @Id
    @Column(nullable = false, name = "CPF", unique = true)
    private Long cpf;
	
	@Column(nullable = false, name = "NOME")
    private String nome;
	
	@Column(nullable = false, name = "SOBRENOME")
    private String sobrenome;


    
    
}

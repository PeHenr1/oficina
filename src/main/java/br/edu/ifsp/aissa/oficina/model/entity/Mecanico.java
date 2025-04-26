package br.edu.ifsp.aissa.oficina.model.entity;

import br.edu.ifsp.aissa.oficina.model.dto.DadosMecanico;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Mecanico {
    private String nome;
    private String experiencia;

    public Mecanico(DadosMecanico dados){
        this.nome = dados.nome();
        this.experiencia = dados.experiencia();
    }

    public void atualizarInformacoes(DadosMecanico dadosMecanico) {
        if (dadosMecanico.nome() != null){
            this.nome = dadosMecanico.nome();
        }

        if (dadosMecanico.experiencia() != null){
            this.experiencia = dadosMecanico.experiencia();
        }
    }
}
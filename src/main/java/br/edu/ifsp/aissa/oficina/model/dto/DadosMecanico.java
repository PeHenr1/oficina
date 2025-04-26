package br.edu.ifsp.aissa.oficina.model.dto;

import jakarta.validation.constraints.NotBlank;

public record DadosMecanico(
        @NotBlank (message = "Campo obrigatório: 'nome'.") String nome,
        String experiencia
) {}

package br.edu.ifsp.aissa.oficina.model.dto;

import jakarta.validation.constraints.NotBlank;

public record DadosAuthenticator(
        @NotBlank String login,
        @NotBlank String senha) {
}

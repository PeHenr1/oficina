package br.edu.ifsp.aissa.oficina.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosVeiculo(
        @NotBlank(message = "Campo obrigatório: 'marca'.") String marca,
        @NotBlank(message = "Campo obrigatório: 'modelo'.") String modelo,
        @NotBlank(message = "Campo obrigatório: 'ano'.")
        @Pattern(regexp = "^\\d{4}$", message = "O campo 'ano' deve ter 4 números.") String ano,
        String cor
) {}
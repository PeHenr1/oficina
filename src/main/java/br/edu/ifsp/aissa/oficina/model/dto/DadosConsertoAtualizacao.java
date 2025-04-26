package br.edu.ifsp.aissa.oficina.model.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosConsertoAtualizacao(
        @NotNull Long id,
        @Pattern(regexp = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$" , message = "A data deve estar no formato DD/MM/AAAA.")
        String dataSaida,
        DadosMecanico mecanico)
{ }
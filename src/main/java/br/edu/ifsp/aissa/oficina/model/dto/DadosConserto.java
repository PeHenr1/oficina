package br.edu.ifsp.aissa.oficina.model.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosConserto(
        @NotBlank(message = "Campo obrigatório: 'data-entrada'.")
        @Pattern(regexp = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$" , message = "A data deve estar no formato DD/MM/AAAA.")
        String dataEntrada,

        @NotBlank(message = "Campo obrigatório: 'data-saida'.")
        @Pattern(regexp = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$" , message = "A data deve estar no formato DD/MM/AAAA.")
        String dataSaida,

        @NotNull @Valid DadosVeiculo veiculo,
        @NotNull @Valid DadosMecanico mecanico
) {}

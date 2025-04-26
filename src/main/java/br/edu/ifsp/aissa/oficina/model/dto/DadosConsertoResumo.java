package br.edu.ifsp.aissa.oficina.model.dto;

import br.edu.ifsp.aissa.oficina.model.entity.Conserto;

public record DadosConsertoResumo(Long id, String dataEntrada, String dataSaida, String nome, String marca, String modelo) {

    public DadosConsertoResumo(Conserto conserto) {
        this(conserto.getId(), conserto.getDataEntrada(), conserto.getDataSaida(), conserto.getMecanico().getNome(),
                conserto.getVeiculo().getMarca(), conserto.getVeiculo().getModelo());
    }
}


package br.edu.ifsp.aissa.oficina.model.dto;

import br.edu.ifsp.aissa.oficina.model.entity.Conserto;
import br.edu.ifsp.aissa.oficina.model.entity.Mecanico;
import br.edu.ifsp.aissa.oficina.model.entity.Veiculo;

public record DadosConsertoDetalhado(Long id, String dataEntrada, String dataSaida, Mecanico mecanico, Veiculo veiculo, boolean ativo) {

    public DadosConsertoDetalhado(Conserto conserto){
        this(conserto.getId(), conserto.getDataEntrada(), conserto.getDataSaida(),
                conserto.getMecanico(), conserto.getVeiculo(), conserto.getAtivo());
    }
}

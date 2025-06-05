package br.edu.ifsp.aissa.oficina.model.entity;

import br.edu.ifsp.aissa.oficina.model.dto.DadosConserto;
import br.edu.ifsp.aissa.oficina.model.dto.DadosConsertoAtualizacao;
import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Table(name = "conserto")
@Entity(name = "Conserto")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Conserto {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String dataEntrada;
    private String dataSaida;

    @Embedded
    private Mecanico mecanico;

    @Embedded
    private Veiculo veiculo;
    private Boolean ativo;

    @EqualsAndHashCode.Include
    @Column(nullable = false, unique = true, updatable = false)
    private final String uuid = UUID.randomUUID().toString();

    public Conserto (DadosConserto dados){
        this.ativo = true;
        this.dataEntrada = dados.dataEntrada();
        this.dataSaida = dados.dataSaida();
        this.mecanico = new Mecanico(dados.mecanico());
        this.veiculo = new Veiculo(dados.veiculo());
    }

    public void excluir(){
        this.ativo = false;
    }

    public void atualizarInformacoes(DadosConsertoAtualizacao dados) {
        if (dados.dataSaida() != null){
            this.dataSaida = dados.dataSaida();
        }

        if (dados.mecanico() != null){
            this.mecanico.atualizarInformacoes(dados.mecanico());
        }
    }

    public static Conserto from(DadosConserto dados) {
        return new Conserto(dados);
    }
}
package eco.cyan.demo.model;

import eco.cyan.demo.dto.pontoColeta.AtualizarPontoColeta;
import eco.cyan.demo.dto.pontoColeta.PontoColetaDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "ponto_de_coleta")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class PontoColeta {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pontoColeta")
    @SequenceGenerator(name = "pontoColeta", sequenceName = "seq_ponto_coleta", allocationSize = 1)
    @Id
    @Column(name = "id_ponto_col", nullable = false)
    private Long idPontoCol;

    @Column(name = "nm_ponto_col", nullable = false, length = 30)
    private String nmPontoCol;

    @Column(name = "end_ponto_col", nullable = false, length = 150)
    private String endPontoCol;

    @Column(name = "contato_ponto_col", nullable = false, length = 150)
    private String contatoPontoCol;

    @ManyToOne
    @JoinColumn(name = "entrega_lixo_id", referencedColumnName = "id_entrega_lixo", nullable = false)
    private EntregaLixo entregaLixo;

    @OneToOne
    private EntregaLixo entregaFeita;

    public PontoColeta(PontoColetaDTO dados) {
        this.nmPontoCol = dados.nmPontoCol();
        this.endPontoCol = dados.endPontoCol();
        this.contatoPontoCol = dados.contatoPontoCol();
    }


    public void atualizarInformacoes(AtualizarPontoColeta dados) {
        if (dados.nmPontoCol() != null) {
            this.nmPontoCol = dados.nmPontoCol();
        }
        if (dados.endPontoCol() != null) {
            this.endPontoCol = dados.endPontoCol();
        }
        if (dados.contatoPontoCol() != null) {
            this.contatoPontoCol = dados.contatoPontoCol();
        }
    }

}

package eco.cyan.demo.model;

import eco.cyan.demo.dto.entregaLixo.AtualizarEntregaLixo;
import eco.cyan.demo.dto.entregaLixo.EntregaLixoDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "entrega_lixo")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class EntregaLixo {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "entregaLixo")
    @SequenceGenerator(name = "entregaLixo", sequenceName = "seq_entrega_lixo", allocationSize = 1)
    @Id
    @Column(name = "id_entrega_lixo", nullable = false)
    private Long idEntregaLixo;

    @Column(name = "dt_entrega", nullable = false)
    private String dtEntrega;

    @OneToOne(mappedBy = "entregaFeita")
    private PontoColeta pontoColeta;

    @OneToOne
    @JoinColumn(name = "IdLixoColetado", referencedColumnName = "id_lixo_coletado")
    private LixoColetado lixoColetado;


    public EntregaLixo(EntregaLixoDTO dados) {
        this.dtEntrega = dados.dtEntrega();
    }


    public void atualizarInformacoes(AtualizarEntregaLixo dados) {
        if (dados.dtEntrega() != null){
            this.dtEntrega = dados.dtEntrega();
        }
    }
}

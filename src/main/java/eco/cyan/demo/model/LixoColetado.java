package eco.cyan.demo.model;

import eco.cyan.demo.dto.lixoColetado.AtualizarLixoColetado;
import eco.cyan.demo.dto.lixoColetado.DetalhesLixoColetadoDTO;
import eco.cyan.demo.dto.lixoColetado.LixoColetadoDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "lixo_coletado")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class LixoColetado {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lixoColetado")
    @SequenceGenerator(name = "lixoColetado", sequenceName = "seq_lixo_coletado", allocationSize = 1)
    @Id
    @Column(name = "id_lixo_coletado", nullable = false)
    private Long idLixoColetado;

    @Column(name = "tp_lixo", nullable = false, length = 15)
    private String tpLixo;

    @Column(name = "quantidade_lixo", nullable = false, length = 10)
    private String quantidadeLixo;

    @Column(name = "local_coleta", nullable = false, length = 150)
    private String localColeta;

    @ManyToOne
    @JoinColumn(name = "USUARIOS_ID_USER", nullable = false)
    private Usuarios usuario;

    @OneToOne(mappedBy = "lixoColetado",cascade = CascadeType.ALL, orphanRemoval = true)
    private EntregaLixo entrega;



    public LixoColetado(LixoColetadoDTO dados, Usuarios usuario) {
        tpLixo = dados.tpLixo();
        quantidadeLixo = dados.quantidadeLixo();
        localColeta = dados.localColeta();
        this.usuario = usuario;
    }

    public void atualizarInformacoes(AtualizarLixoColetado dados) {
        if (dados.tpLixo() != null) {
            this.tpLixo = dados.tpLixo();
        }
        if (dados.quantidadeLixo() != null) {
            this.quantidadeLixo = dados.quantidadeLixo();
        }
        if (dados.localColeta() != null) {
            this.localColeta = dados.localColeta();
        }
    }
    }


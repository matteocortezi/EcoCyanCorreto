package eco.cyan.demo.model;

import eco.cyan.demo.dto.reciclagem.AtualizarReciclagem;
import eco.cyan.demo.dto.reciclagem.ReciclagemDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "reciclagem")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Reciclagem {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reciclagem")
    @SequenceGenerator(name = "reciclagem", sequenceName = "seq_reciclagem", allocationSize = 1)
    @Id
    @Column(name = "id_reciclagem", nullable = false)
    private Long idReciclagem;

    @Column(name = "dt_reciclagem", nullable = false, length = 10)
    private String dtReciclagem;

    @Column(name = "qnt_reciclada", nullable = false, length = 10)
    private String qntReciclada;


    @ManyToOne
    @JoinColumn(name = "USUARIOS_ID_USER", nullable = false)
    private Usuarios usuario;

    public Reciclagem(ReciclagemDTO dados, Usuarios usuario) {
        this.dtReciclagem = dados.dtReciclagem();
        this.qntReciclada = dados.qntReciclada();
        this.usuario = usuario;
    }

    public void atualizarInformacoes(AtualizarReciclagem dados) {
        if (dados.dtReciclagem() != null) {
            this.dtReciclagem = dados.dtReciclagem();
        }
        if (dados.qntReciclada() != null) {
            this.qntReciclada = dados.qntReciclada();
        }
}}

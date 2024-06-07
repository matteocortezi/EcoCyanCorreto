package eco.cyan.demo.model;

import eco.cyan.demo.dto.usuarios.AtualizarUsuarios;
import eco.cyan.demo.dto.usuarios.UsuariosDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "usuarios")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Usuarios {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuarios")
    @SequenceGenerator(name = "usuarios", sequenceName = "seq_usuarios", allocationSize = 1)
    @Id
    @Column(name = "id_user", nullable = false)
    private Long idUser;

    @Column(name = "nm_user", nullable = false, length = 50)
    private String nmUser;

    @Column(name = "email_user", nullable = false, length = 150)
    private String emailUser;

    @Column(name = "senha_user", nullable = false, length = 30)
    private String senhaUser;

    @Column(name = "tp_user", nullable = false, length = 10)
    private String tpUser;

    @OneToMany(mappedBy = "usuario" , cascade = CascadeType.ALL)
    private List<Reciclagem> reciclagens;

    @OneToMany(mappedBy = "usuario" , cascade = CascadeType.ALL)
    private List<LixoColetado> lixoColetado;

    public Usuarios(UsuariosDTO dados) {
        this.nmUser = dados.nmUser();
        this.emailUser = dados.emailUser();
        this.senhaUser = dados.senhaUser();
        this.tpUser = dados.tpUser();
    }

    public void atualizarInformacoes(AtualizarUsuarios dados) {
        if (dados.nmUser() != null) {
            this.nmUser = dados.nmUser();
        }
        if (dados.emailUser() != null) {
            this.emailUser = dados.emailUser();
        }
        if (dados.senhaUser() != null) {
            this.senhaUser = dados.senhaUser();
        }
        if (dados.tpUser() != null) {
            this.tpUser = dados.tpUser();
        }
    }
}

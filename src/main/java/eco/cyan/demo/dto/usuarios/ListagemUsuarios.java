package eco.cyan.demo.dto.usuarios;

import eco.cyan.demo.model.Usuarios;

public record ListagemUsuarios(
        Long idUser,
        String nmUser,

        String emailUser,

        String senhaUser,

        String tpUser
        ) {
    public ListagemUsuarios(Usuarios usuario){
        this(usuario.getIdUser(),usuario.getNmUser(), usuario.getEmailUser(), usuario.getSenhaUser(), usuario.getTpUser());
    }
}

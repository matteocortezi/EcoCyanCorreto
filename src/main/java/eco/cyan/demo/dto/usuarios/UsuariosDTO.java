package eco.cyan.demo.dto.usuarios;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuariosDTO(
        @NotBlank(message = "O nome do usuário não pode estar em branco")
        @Size(max = 50, message = "O nome do usuário deve ter no máximo 50 caracteres")
        String nmUser,

        @NotBlank(message = "O e-mail do usuário não pode estar em branco")
        @Email(message = "O e-mail do usuário deve ser um e-mail válido")
        @Size(max = 150, message = "O e-mail do usuário deve ter no máximo 150 caracteres")
        String emailUser,

        @NotBlank(message = "A senha do usuário não pode estar em branco")
        @Size(max = 30, message = "A senha do usuário deve ter no máximo 30 caracteres")
        String senhaUser,

        @NotBlank(message = "O tipo de usuário não pode estar em branco")
        @Size(max = 10, message = "O tipo de usuário deve ter no máximo 10 caracteres")
        String tpUser) {
}
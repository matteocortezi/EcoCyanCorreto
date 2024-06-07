package eco.cyan.demo.dto.lixoColetado;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LixoColetadoDTO(
        @NotBlank(message = "O tipo de lixo não pode estar em branco")
        @Size(max = 15, message = "O tipo de lixo deve ter no máximo 15 caracteres")
        String tpLixo,

        @NotBlank(message = "A quantidade de lixo não pode estar em branco")
        @Size(max = 10, message = "A quantidade de lixo deve ter no máximo 10 caracteres")
        String quantidadeLixo,

        @NotBlank(message = "O local de coleta não pode estar em branco")
        @Size(max = 150, message = "O local de coleta deve ter no máximo 150 caracteres")
        String localColeta
) {
}

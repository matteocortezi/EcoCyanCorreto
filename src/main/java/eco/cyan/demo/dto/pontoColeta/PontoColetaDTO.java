package eco.cyan.demo.dto.pontoColeta;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record PontoColetaDTO(
        @NotBlank(message = "O nome do ponto de coleta não pode estar em branco")
        @Size(max = 30, message = "O nome do ponto de coleta deve ter no máximo 30 caracteres")
        String nmPontoCol,

        @NotBlank(message = "O endereço do ponto de coleta não pode estar em branco")
        @Size(max = 150, message = "O endereço do ponto de coleta deve ter no máximo 150 caracteres")
        String endPontoCol,

        @NotBlank(message = "O contato do ponto de coleta não pode estar em branco")
        @Size(max = 150, message = "O contato do ponto de coleta deve ter no máximo 150 caracteres")
        String contatoPontoCol) {
}

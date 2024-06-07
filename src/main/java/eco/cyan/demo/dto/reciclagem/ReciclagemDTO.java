package eco.cyan.demo.dto.reciclagem;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record ReciclagemDTO(
        @NotBlank(message = "A data da reciclagem não pode estar em branco")
        @Pattern(regexp = "^\\d{2}-\\d{2}-\\d{4}$", message = "A data da reciclagem deve estar no formato dd-MM-yyyy")
        @Size(min = 10, max = 10, message = "A data da reciclagem deve ter exatamente 10 caracteres")
        String dtReciclagem,

        @NotBlank(message = "A quantidade reciclada não pode estar em branco")
        @Size(max = 10, message = "A quantidade reciclada deve ter no máximo 10 caracteres e especificar que é em kg")
        String qntReciclada) {
}


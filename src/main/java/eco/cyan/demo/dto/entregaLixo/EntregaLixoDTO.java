package eco.cyan.demo.dto.entregaLixo;

import eco.cyan.demo.dto.lixoColetado.LixoColetadoDTO;
import jakarta.validation.constraints.Pattern;

public record EntregaLixoDTO(
        @Pattern(regexp = "\\d{2}-\\d{2}-\\d{4}", message = "A data deve estar no formato dd-MM-yyyy")
        String dtEntrega, LixoColetadoDTO lixoColetadoDTO
) {}
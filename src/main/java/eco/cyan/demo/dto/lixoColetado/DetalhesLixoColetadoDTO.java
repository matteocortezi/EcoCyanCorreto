package eco.cyan.demo.dto.lixoColetado;

import eco.cyan.demo.model.LixoColetado;


public record DetalhesLixoColetadoDTO(
        String tpLixo,
        String quantidadeLixo,
        String localColeta){
    public DetalhesLixoColetadoDTO(LixoColetado lixo){
        this(lixo.getTpLixo(), lixo.getQuantidadeLixo(), lixo.getLocalColeta());
}
}


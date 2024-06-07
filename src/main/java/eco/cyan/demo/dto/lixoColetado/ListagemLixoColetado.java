package eco.cyan.demo.dto.lixoColetado;

import eco.cyan.demo.model.LixoColetado;

public record ListagemLixoColetado(Long idLixoColetado,String tpLixo, String quantidadeLixo, String localColeta) {
    public ListagemLixoColetado(LixoColetado lixo){
        this(lixo.getIdLixoColetado(),lixo.getTpLixo(), lixo.getQuantidadeLixo(), lixo.getLocalColeta());
    }
}

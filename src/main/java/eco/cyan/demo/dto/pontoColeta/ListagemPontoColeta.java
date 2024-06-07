package eco.cyan.demo.dto.pontoColeta;

import eco.cyan.demo.model.PontoColeta;

public record ListagemPontoColeta(Long idPontoCol, String nmPontoCol, String endPontoCol, String contatoPontoCol) {
    public ListagemPontoColeta(PontoColeta pontoColeta){
        this(pontoColeta.getIdPontoCol(),pontoColeta.getNmPontoCol(), pontoColeta.getEndPontoCol(), pontoColeta.getContatoPontoCol());
    }
}

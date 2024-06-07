package eco.cyan.demo.dto.reciclagem;

import eco.cyan.demo.model.Reciclagem;

public record ListagemReciclagem(
        Long idReciclagem,
        String dtReciclagem,
        String qntReciclada) {
    public ListagemReciclagem(Reciclagem reciclagem) {
        this(reciclagem.getIdReciclagem(),reciclagem.getDtReciclagem(), reciclagem.getQntReciclada());
    }
}

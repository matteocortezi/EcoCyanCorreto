package eco.cyan.demo.dto.reciclagem;

import eco.cyan.demo.model.Reciclagem;

public record DetalhesReciclagemDTO(
        Long id,
        String dtReciclagem,
        String qntReciclada) {

    public DetalhesReciclagemDTO(Reciclagem reciclagem) {
        this(reciclagem.getIdReciclagem(), reciclagem.getDtReciclagem(), reciclagem.getQntReciclada());
    }

}
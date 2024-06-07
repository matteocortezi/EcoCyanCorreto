package eco.cyan.demo.dto.entregaLixo;

import eco.cyan.demo.model.EntregaLixo;

public record ListagemEntregaLixo(Long idEntregaLixo,String dtEntrega) {
    public ListagemEntregaLixo(EntregaLixo entrega){
        this(entrega.getIdEntregaLixo(),entrega.getDtEntrega());
    }
}

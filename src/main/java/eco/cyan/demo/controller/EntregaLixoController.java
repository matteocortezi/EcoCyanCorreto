package eco.cyan.demo.controller;

import eco.cyan.demo.dto.entregaLixo.AtualizarEntregaLixo;
import eco.cyan.demo.dto.entregaLixo.EntregaLixoDTO;
import eco.cyan.demo.dto.entregaLixo.ListagemEntregaLixo;
import eco.cyan.demo.model.EntregaLixo;
import eco.cyan.demo.repository.EntregaLixoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("entrega-lixo")

public class EntregaLixoController {

    @Autowired
    private EntregaLixoRepository entregaLixoRepository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody EntregaLixoDTO dados){
        entregaLixoRepository.save(new EntregaLixo(dados));
    }

    @GetMapping
    public Page<ListagemEntregaLixo> listar(Pageable paginacao){
        return entregaLixoRepository.findAll(paginacao).map(ListagemEntregaLixo::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid AtualizarEntregaLixo dados){
        var entregaLixo = entregaLixoRepository.getReferenceById(dados.idEntregaLixo());
        entregaLixo.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        entregaLixoRepository.deleteById(id);
    }


}

package eco.cyan.demo.controller;

import eco.cyan.demo.dto.reciclagem.AtualizarReciclagem;
import eco.cyan.demo.dto.reciclagem.ListagemReciclagem;
import eco.cyan.demo.repository.ReciclagemRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("reciclagem")

public class ReciclagemController {

    @Autowired
    private ReciclagemRepository reciclagemRepository;

    @GetMapping
    public Page<ListagemReciclagem> listar(Pageable paginacao){
        return reciclagemRepository.findAll(paginacao).map(ListagemReciclagem::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid AtualizarReciclagem dados){
        var reciclagem = reciclagemRepository.getReferenceById(dados.idReciclagem());
        reciclagem.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        reciclagemRepository.deleteById(id);
    }




}

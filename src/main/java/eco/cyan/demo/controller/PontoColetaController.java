package eco.cyan.demo.controller;

import eco.cyan.demo.dto.pontoColeta.AtualizarPontoColeta;
import eco.cyan.demo.dto.pontoColeta.ListagemPontoColeta;
import eco.cyan.demo.dto.pontoColeta.PontoColetaDTO;
import eco.cyan.demo.model.PontoColeta;
import eco.cyan.demo.repository.PontoColetaRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ponto-coleta")

public class PontoColetaController {

    @Autowired
    private PontoColetaRepository pontoColetaRepository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody PontoColetaDTO dados){
        pontoColetaRepository.save(new PontoColeta(dados));
    }


    @GetMapping
    public Page<ListagemPontoColeta> listar(Pageable paginacao){
        return pontoColetaRepository.findAll(paginacao).map(ListagemPontoColeta::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid AtualizarPontoColeta dados){
        var pontoColeta = pontoColetaRepository.getReferenceById(dados.idPontoCol());
        pontoColeta.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        pontoColetaRepository.deleteById(id);
    }
}

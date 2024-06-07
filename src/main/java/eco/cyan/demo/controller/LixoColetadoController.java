package eco.cyan.demo.controller;


import eco.cyan.demo.dto.lixoColetado.AtualizarLixoColetado;
import eco.cyan.demo.dto.lixoColetado.ListagemLixoColetado;
import eco.cyan.demo.repository.LixoColetadoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("lixo-coletado")

public class LixoColetadoController {

    @Autowired
    private LixoColetadoRepository lixoColetadoRepository;

    @GetMapping
    public Page<ListagemLixoColetado> listar(Pageable paginacao){
        return lixoColetadoRepository.findAll(paginacao).map(ListagemLixoColetado::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid AtualizarLixoColetado dados){
        var lixoColetado = lixoColetadoRepository.getReferenceById(dados.idLixoColetado());
        lixoColetado.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        lixoColetadoRepository.deleteById(id);
    }


}

package eco.cyan.demo.controller;

import eco.cyan.demo.dto.lixoColetado.DetalhesLixoColetadoDTO;
import eco.cyan.demo.dto.lixoColetado.LixoColetadoDTO;
import eco.cyan.demo.dto.reciclagem.DetalhesReciclagemDTO;
import eco.cyan.demo.dto.reciclagem.ReciclagemDTO;
import eco.cyan.demo.dto.usuarios.AtualizarUsuarios;
import eco.cyan.demo.dto.usuarios.UsuariosDTO;
import eco.cyan.demo.dto.usuarios.ListagemUsuarios;
import eco.cyan.demo.model.LixoColetado;
import eco.cyan.demo.model.Reciclagem;
import eco.cyan.demo.model.Usuarios;
import eco.cyan.demo.repository.LixoColetadoRepository;
import eco.cyan.demo.repository.ReciclagemRepository;
import eco.cyan.demo.repository.UsuariosRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("usuarios")

public class UsuariosController {

    @Autowired
    private UsuariosRepository usuariosRepository;
    @Autowired
    private ReciclagemRepository reciclagemRepository;
    @Autowired
    private LixoColetadoRepository lixoColetadoRepository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid UsuariosDTO dados){
        usuariosRepository.save(new Usuarios(dados));
    }

    @PostMapping("{id}/reciclagem")
    @Transactional
    public ResponseEntity<DetalhesReciclagemDTO> post(@PathVariable("id") Long id,
                                                        @RequestBody @Valid ReciclagemDTO dto,
                                                        UriComponentsBuilder uriBuilder){
        var usuario = usuariosRepository.getReferenceById(id);
        var reciclagem = new Reciclagem(dto,usuario);
        reciclagemRepository.save(reciclagem);
        var uri = uriBuilder.path("reciclagem/{id}").buildAndExpand(reciclagem.getIdReciclagem()).toUri();
        return ResponseEntity.created(uri).body(new DetalhesReciclagemDTO(reciclagem));
    }

    @PostMapping("{id}/lixo-coletado")
    @Transactional
    public ResponseEntity<DetalhesLixoColetadoDTO> post(@PathVariable("id") Long id,
                                                      @RequestBody @Valid LixoColetadoDTO dto,
                                                      UriComponentsBuilder uriBuilder){
        var usuario = usuariosRepository.getReferenceById(id);
        var lixo = new LixoColetado(dto, usuario);
        lixoColetadoRepository.save(lixo);
        var uri = uriBuilder.path("lixo-coletado/{id}").buildAndExpand(lixo.getIdLixoColetado()).toUri();
        return ResponseEntity.created(uri).body(new DetalhesLixoColetadoDTO(lixo));
    }

    @GetMapping
    public Page<ListagemUsuarios> listar(Pageable paginacao){
        return usuariosRepository.findAll(paginacao).map(ListagemUsuarios::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid AtualizarUsuarios dados){
        var usuario = usuariosRepository.getReferenceById(dados.idUser());
        usuario.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        usuariosRepository.deleteById(id);
    }

}

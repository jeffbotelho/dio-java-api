package joalheria.controller;

import joalheria.model.Joia;
import joalheria.repository.JoiaRepository;
import joalheria.service.JoiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class Controller {

    // @Autowired
    // JoiaRepository joiaRepository;

    @Autowired
    JoiaService joiaService;

    // lista todas as joias
    @GetMapping("/joias")
    public ResponseEntity<List<Joia>> listaJoias() {

        return ResponseEntity.ok(joiaService.listaJoias());
    }

    @PostMapping("/joia/inserir")
    public ResponseEntity<Joia> salvaJoia(@RequestBody Joia joia, UriComponentsBuilder uriBuilder) {

        // sera enviado os dados para o banco de dados onde sera salvo e as informacoes
        // ficarao guardadas na minha variavel j
        // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        Joia j = joiaService.adicionaJoia(joia);

        URI uri = uriBuilder
                .path("/joia/{id}")
                .buildAndExpand(joia.getNumIdentificacao())
                .toUri();

        // caso sucesso sera gerado um status code 201 e o id gerado sera exibido na
        // minha url que foi capturado pela minha variavel j
        // <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
        return ResponseEntity.created(uri).body(j);
    }

    // deleta o item pelo id identificado por RequestParam e retorna um status code
    // 204
    @DeleteMapping("/joia/excluir")
    public ResponseEntity<?> deletaJoia(@RequestParam(required = false, name = "numero-identificacao") Integer joiaId) {
        this.joiaService.deletaJoia(joiaId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    // O id e passado na URI atraves do RequestParam e os dados a serem att enviados
    // via RequestBody
    @PutMapping("/joia/atualizar")
    public ResponseEntity<Joia> atualizaJoia(@RequestBody Joia joia,
            @RequestParam(required = false, name = "numero-identificacao") Integer id) {

        this.joiaService.atualizaJoia(joia, id);
        return ResponseEntity.ok().body(joia);
    }

}

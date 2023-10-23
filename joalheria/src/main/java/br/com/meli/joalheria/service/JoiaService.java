package joalheria.service;

import joalheria.model.Joia;
import joalheria.repository.JoiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Service
public class JoiaService {

    @Autowired
    private JoiaRepository joiaRepository;

    public List<Joia> listaJoias() {
        return joiaRepository.findAll();
    }

    // adiciona uma joia
    public Joia adicionaJoia(Joia joia) {
        Joia resultJoia = joiaRepository.save(joia);
        return resultJoia;
    }

    // deleta a joia
    public void deletaJoia(Integer joiaId) {

        joiaRepository.deleteById(joiaId);
    }

    // atualiza por RerequestBody e RequestParam
    public void atualizaJoia(Joia joia, Integer joiaId) {
        joia.setNumIdentificacao(joiaId);
        joiaRepository.save(joia);
    }
}

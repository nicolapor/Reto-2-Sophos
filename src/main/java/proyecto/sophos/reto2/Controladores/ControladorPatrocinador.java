package proyecto.sophos.reto2.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import proyecto.sophos.reto2.Modelos.Patrocinadores;
import proyecto.sophos.reto2.Repositorios.RepositorioPatrocinador;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/patrocinadores")

public class ControladorPatrocinador {
    @Autowired
    private RepositorioPatrocinador miRepositorioPatrocinador;

    @GetMapping("")
    public List<Patrocinadores> index(){
        return this.miRepositorioPatrocinador.findAll();
    }
}

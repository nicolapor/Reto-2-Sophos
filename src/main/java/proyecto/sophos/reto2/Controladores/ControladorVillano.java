package proyecto.sophos.reto2.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import proyecto.sophos.reto2.Modelos.Villanos;
import proyecto.sophos.reto2.Repositorios.RepositorioVillano;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/villanos")

public class ControladorVillano {
    @Autowired
    private RepositorioVillano miRepositorioVillano;

    @GetMapping("")
    public List<Villanos> index(){
        return miRepositorioVillano.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Villanos create(@RequestBody Villanos infoVillano){
        return miRepositorioVillano.save(infoVillano);
    }

}

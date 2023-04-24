package proyecto.sophos.reto2.Controladores;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import proyecto.sophos.reto2.Modelos.Enfrentamientos;
import proyecto.sophos.reto2.Repositorios.RepositorioEnfrentamiento;
import proyecto.sophos.reto2.Repositorios.RepositorioHeroe;
import proyecto.sophos.reto2.Repositorios.RepositorioVillano;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/enfrentamientos")

public class ControladorEnfrentamiento {

    @Autowired
    private RepositorioEnfrentamiento miRepositorioEnfrentamiento;

    @Autowired
    private RepositorioHeroe miRepositorioHeroe;

    @Autowired
    private RepositorioVillano miRepositorioVillano;

    @GetMapping("")
    public List<Enfrentamientos> index(){
        return miRepositorioEnfrentamiento.findAll();
    }
}

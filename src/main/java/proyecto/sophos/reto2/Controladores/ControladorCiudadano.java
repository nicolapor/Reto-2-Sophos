package proyecto.sophos.reto2.Controladores;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import proyecto.sophos.reto2.Modelos.Ciudadano;
import proyecto.sophos.reto2.Repositorios.RepositorioCiudadano;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/ciudadano")

public class ControladorCiudadano {
    @Autowired
    RepositorioCiudadano miRepositorioCiudadano;

    @GetMapping("")
    public List<Ciudadano> index(){
        return miRepositorioCiudadano.findAll();
    }

}

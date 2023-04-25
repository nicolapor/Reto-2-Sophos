package proyecto.sophos.reto2.Controladores;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import proyecto.sophos.reto2.Modelos.Ciudadano;
import proyecto.sophos.reto2.Modelos.Heroes;
import proyecto.sophos.reto2.Repositorios.RepositorioCiudadano;
import proyecto.sophos.reto2.Repositorios.RepositorioHeroe;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/ciudadano")

public class ControladorCiudadano {
    @Autowired
    private RepositorioCiudadano miRepositorioCiudadano;

    @Autowired
    private RepositorioHeroe miRepositorioHeroe;

    @GetMapping("")
    public List<Ciudadano> index(){
        return miRepositorioCiudadano.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Ciudadano create(@RequestBody Ciudadano infoCiudadano){
        return this.miRepositorioCiudadano.save(infoCiudadano);
    }

    @GetMapping("{id}")
    public Ciudadano show(@PathVariable int id){
        Ciudadano ciudadanoActual = this.miRepositorioCiudadano
                .findById(id)
                .orElse(null);
        return ciudadanoActual;
    }

    @PutMapping("{id}")
    public Ciudadano update(@PathVariable int id, @RequestBody Ciudadano infoCiudadano){
        Ciudadano ciudadanoActual = this.miRepositorioCiudadano
                .findById(id)
                .orElse(null);
        if(ciudadanoActual != null){
            ciudadanoActual.setNombre(infoCiudadano.getNombre());
            ciudadanoActual.setEdad(infoCiudadano.getEdad());
            ciudadanoActual.setRelacion_personal(infoCiudadano.getRelacion_personal());
            return this.miRepositorioCiudadano.save(ciudadanoActual);
        } else {
            return null;
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        Ciudadano ciudadanoActual = this.miRepositorioCiudadano
                .findById(id)
                .orElse(null);
        if(ciudadanoActual != null){
            this.miRepositorioCiudadano.delete(ciudadanoActual);
        }
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("id/{id_ciudadano}/heroe/{id_heroe}")
    public Ciudadano asignarHeroeCiudadano(@PathVariable int id_heroe){
        Ciudadano nuevoCiudadano = new Ciudadano();
        Heroes elHeroe = miRepositorioHeroe.findById(id_heroe).orElse(null);
        if(elHeroe != null){
            nuevoCiudadano.setHeroe((elHeroe));
            return this.miRepositorioCiudadano.save(nuevoCiudadano);
        } else{
            return null;
        }
    }


}














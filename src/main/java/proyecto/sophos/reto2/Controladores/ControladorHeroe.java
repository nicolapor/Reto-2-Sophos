package proyecto.sophos.reto2.Controladores;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import proyecto.sophos.reto2.Modelos.Heroes;
import proyecto.sophos.reto2.Modelos.Villanos;
import proyecto.sophos.reto2.Repositorios.RepositorioHeroe;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/heroes")

public class ControladorHeroe {

    @Autowired
    private RepositorioHeroe miRepositorioHeroe;

    @GetMapping("")
    public List<Heroes> index(){
        return miRepositorioHeroe.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Heroes create(@RequestBody Heroes infoHeroe){
        return miRepositorioHeroe.save(infoHeroe);
    }

    @GetMapping("{id}")
    public Heroes show(@PathVariable int id){
        Heroes heroeActual = this.miRepositorioHeroe
                .findById(id)
                .orElse(null);
        return heroeActual;
    }

    @PutMapping("{id}")
    public Heroes update(@PathVariable int id, @RequestBody Heroes infoHeroe){
        Heroes heroeActual = this.miRepositorioHeroe
                .findById(id)
                .orElse(null);
        if (heroeActual != null){
            heroeActual.setNombre(infoHeroe.getNombre());
            heroeActual.setEdad(infoHeroe.getEdad());
            heroeActual.setHabilidades(infoHeroe.getHabilidades());
            heroeActual.setOrigen(infoHeroe.getOrigen());
            heroeActual.setDebilidades(infoHeroe.getDebilidades());
            heroeActual.setPoder(infoHeroe.getPoder());
            return this.miRepositorioHeroe.save(heroeActual);
        } else {
            return null;
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        Heroes heroeActual = this.miRepositorioHeroe
                .findById(id)
                .orElse(null);
        if (heroeActual != null){
            this.miRepositorioHeroe.delete(heroeActual);
        }
    }


}

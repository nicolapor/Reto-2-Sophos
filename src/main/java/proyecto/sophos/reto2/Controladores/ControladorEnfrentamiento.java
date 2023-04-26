package proyecto.sophos.reto2.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import proyecto.sophos.reto2.Modelos.Enfrentamientos;
import proyecto.sophos.reto2.Modelos.Heroes;
import proyecto.sophos.reto2.Modelos.Villanos;
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

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Enfrentamientos create(@RequestBody Enfrentamientos infoEnfrentamiento){
        return this.miRepositorioEnfrentamiento.save(infoEnfrentamiento);
    }

    @GetMapping("{id}")
    public Enfrentamientos show(@PathVariable int id){
        Enfrentamientos enfrentamientoActual = this.miRepositorioEnfrentamiento
                .findById(id)
                .orElse(null);
        return enfrentamientoActual;
    }

    @PutMapping("{id}")
    public Enfrentamientos update(@PathVariable int id, @RequestBody Enfrentamientos infoEnfrentamiento){
        Enfrentamientos enfrentamientoActual = this.miRepositorioEnfrentamiento
                .findById(id)
                .orElse(null);
        if (enfrentamientoActual != null){
            enfrentamientoActual.setResultado(infoEnfrentamiento.getResultado());
            return this.miRepositorioEnfrentamiento.save(enfrentamientoActual);
        } else {
            return null;
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        Enfrentamientos enfrentamientoActual = this.miRepositorioEnfrentamiento
                .findById(id)
                .orElse(null);
        if (enfrentamientoActual != null){
            this.miRepositorioEnfrentamiento.delete(enfrentamientoActual);
        }
    }

    //---------------------ESTA ES LA QUE SI FUNCIONA.
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("heroe/{id_heroe}/villano/{id_villano}")
    public Enfrentamientos asignarResultado(@RequestBody Enfrentamientos infoEnfrentamiento, @PathVariable int id_heroe, @PathVariable int id_villano){
        Enfrentamientos nuevoEnfrentamiento = new Enfrentamientos();
        Heroes elHeroe = this.miRepositorioHeroe.findById(id_heroe).orElse(null);
        Villanos elVillano = this.miRepositorioVillano.findById(id_villano).orElse(null);
        if(elHeroe != null && elVillano != null ){
            nuevoEnfrentamiento.setResultado(infoEnfrentamiento.getResultado());
            nuevoEnfrentamiento.setHeroe(elHeroe);
            nuevoEnfrentamiento.setVillano(elVillano);
            return this.miRepositorioEnfrentamiento.save(nuevoEnfrentamiento);
        } else {
            return null;
        }
    }

    /*

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("{id_enfrentamiento}/heroe/{id_heroe}/villano/{id_villano}")
    public Enfrentamientos asignarResultado(@PathVariable int id_enfrentamiento, @PathVariable int id_heroe, @PathVariable int id_villano){
        Enfrentamientos nuevoEnfrentamiento = new Enfrentamientos();
        Enfrentamientos elEnfrentamiento = this.miRepositorioEnfrentamiento.findById(id_enfrentamiento).orElse(null);
        Heroes elHeroe = this.miRepositorioHeroe.findById(id_heroe).orElse(null);
        Villanos elVillano = this.miRepositorioVillano.findById(id_villano).orElse(null);
        if(elHeroe != null && elVillano != null && elEnfrentamiento != null){
            nuevoEnfrentamiento.setResultado(elEnfrentamiento.getResultado());
            nuevoEnfrentamiento.setHeroe(elHeroe);
            nuevoEnfrentamiento.setVillano(elVillano);
            return this.miRepositorioEnfrentamiento.save(nuevoEnfrentamiento);
        } else {
            return null;
        }
    }
    */


}

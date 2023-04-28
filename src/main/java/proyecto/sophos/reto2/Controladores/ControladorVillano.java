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
        return this.miRepositorioVillano.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Villanos create(@RequestBody Villanos infoVillano){
        return this.miRepositorioVillano.save(infoVillano);
    }

    @GetMapping("{id}")
    public Villanos show(@PathVariable int id){
        Villanos villanoActual = this.miRepositorioVillano
                .findById(id)
                .orElse(null);
        return villanoActual;
    }
    @PutMapping("{id}")
    public Villanos update(@PathVariable int id, @RequestBody Villanos infoVillano){
        Villanos villanoActual = this.miRepositorioVillano
                .findById(id)
                .orElse(null);
        if (villanoActual != null){
            villanoActual.setNombre(infoVillano.getNombre());
            villanoActual.setEdad(infoVillano.getEdad());
            villanoActual.setHabilidades(infoVillano.getHabilidades());
            villanoActual.setOrigen(infoVillano.getOrigen());
            villanoActual.setDebilidades(infoVillano.getDebilidades());
            villanoActual.setPoder(infoVillano.getPoder());
            return this.miRepositorioVillano.save(villanoActual);
        } else {
            return null;
        }
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        Villanos villanoActual = this.miRepositorioVillano
                .findById(id)
                .orElse(null);
        if (villanoActual != null){
            this.miRepositorioVillano.delete(villanoActual);
        }
    }

    @PostMapping("/nombre")
    public List<Villanos> getNombresVillanos(@RequestBody Villanos infoVillano){
        return this.miRepositorioVillano.filtraNombreVillanos(infoVillano.getNombre());
    }

    @PostMapping("/origen")
    public List<Villanos> getOrigenVillanos(@RequestBody Villanos infoVillano){
        return this.miRepositorioVillano.filtrarOrigenVillanos(infoVillano.getOrigen());
    }

    @PostMapping("/debilidad")
    public List<Villanos> getDebilidadesVillanos(@RequestBody Villanos infoVillano){
        return this.miRepositorioVillano.filtraDebilidadesVillanos(infoVillano.getDebilidades());
    }


}

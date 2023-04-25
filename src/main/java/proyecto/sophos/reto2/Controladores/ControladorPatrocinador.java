package proyecto.sophos.reto2.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
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

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Patrocinadores create(@RequestBody Patrocinadores infoPatrocinador){
        return this.miRepositorioPatrocinador.save(infoPatrocinador);
    }

    @GetMapping("{id}")
    public Patrocinadores show(@PathVariable int id){
        Patrocinadores patrocinadorActual = this.miRepositorioPatrocinador
                .findById(id)
                .orElse(null);
        return patrocinadorActual;
    }

    @PutMapping("{id}")
    public Patrocinadores update(@PathVariable int id, @RequestBody Patrocinadores infoPatrocinador){
        Patrocinadores patrocinadorActual = this.miRepositorioPatrocinador
                .findById(id)
                .orElse(null);
        if (patrocinadorActual != null){
            patrocinadorActual.setNombre(infoPatrocinador.getNombre());
            patrocinadorActual.setPago_heroe(infoPatrocinador.getPago_heroe());
            patrocinadorActual.setOrigen_dinero(infoPatrocinador.getOrigen_dinero());
            return this.miRepositorioPatrocinador.save(patrocinadorActual);
        } else {
            return null;
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        Patrocinadores patrocinadorActual = this.miRepositorioPatrocinador
                .findById(id)
                .orElse(null);
        if (patrocinadorActual != null){
            this.miRepositorioPatrocinador.delete(patrocinadorActual);
        }
    }


}

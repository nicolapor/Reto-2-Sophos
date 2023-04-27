package proyecto.sophos.reto2.Controladores;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import proyecto.sophos.reto2.Modelos.Agenda;
import proyecto.sophos.reto2.Modelos.Heroes;
import proyecto.sophos.reto2.Modelos.Patrocinadores;
import proyecto.sophos.reto2.Modelos.Villanos;
import proyecto.sophos.reto2.Repositorios.RepositorioAgenda;
import proyecto.sophos.reto2.Repositorios.RepositorioHeroe;
import proyecto.sophos.reto2.Repositorios.RepositorioPatrocinador;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/heroes")

public class ControladorHeroe {

    @Autowired
    private RepositorioHeroe miRepositorioHeroe;

    @Autowired
    private RepositorioAgenda miRepositorioAgenda;

    @Autowired
    private RepositorioPatrocinador miRepositorioPatrocinador;

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

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("id/{id_heroe}/patrocinador/{id_patrocinador}/agenda/{id_agenda}")
    public Heroes asignarPatrocinadorAgenda(@PathVariable int id_heroe, @PathVariable int id_patrocinador, @PathVariable int id_agenda){
        Heroes nuevoHeroe = new Heroes();
        Heroes elHeroe = this.miRepositorioHeroe.findById(id_heroe).orElse(null);
        Patrocinadores elPatrocinador = this.miRepositorioPatrocinador.findById(id_patrocinador).orElse(null);
        Agenda laAgenda = this.miRepositorioAgenda.findById(id_agenda).orElse(null);
        if(elHeroe != null && elPatrocinador != null && laAgenda != null){
            nuevoHeroe.setId_heroes(elHeroe.getId_heroes());
            nuevoHeroe.setNombre(elHeroe.getNombre());
            nuevoHeroe.setEdad(elHeroe.getEdad());
            nuevoHeroe.setHabilidades(elHeroe.getHabilidades());
            nuevoHeroe.setOrigen(elHeroe.getOrigen());
            nuevoHeroe.setDebilidades(elHeroe.getDebilidades());
            nuevoHeroe.setPoder(elHeroe.getPoder());
            nuevoHeroe.setPatrocinador(elPatrocinador);
            nuevoHeroe.setAgenda(laAgenda);
            return this.miRepositorioHeroe.save(nuevoHeroe);
        } else {
            return null;
        }
    }

}












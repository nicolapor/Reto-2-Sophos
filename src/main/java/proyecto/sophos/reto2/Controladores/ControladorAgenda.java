package proyecto.sophos.reto2.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import proyecto.sophos.reto2.Modelos.Agenda;
import proyecto.sophos.reto2.Repositorios.RepositorioAgenda;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/agenda")

public class ControladorAgenda {

    @Autowired
    private RepositorioAgenda miRepositorioAgenda;

    @GetMapping("")
    public List<Agenda> index(){
        return this.miRepositorioAgenda.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Agenda create(@RequestBody Agenda infoAgenda){
        return this.miRepositorioAgenda.save(infoAgenda);
    }

    @GetMapping("{id}")
    public Agenda show(@PathVariable int id){
        Agenda agendaActual = this.miRepositorioAgenda
                .findById(id)
                .orElse(null);
        return agendaActual;
    }

    @PutMapping("{id}")
    public Agenda update(@PathVariable int id, @RequestBody Agenda infoAgenda){
        Agenda agendaActual = this.miRepositorioAgenda
                .findById(id)
                .orElse(null);
        if (agendaActual != null){
            agendaActual.setEscuela(infoAgenda.getEscuela());
            agendaActual.setReunion_familiar(infoAgenda.getReunion_familiar());
            agendaActual.setTrabajo(infoAgenda.getTrabajo());
            return this.miRepositorioAgenda.save(agendaActual);
        } else {
            return null;
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        Agenda agendaActual = this.miRepositorioAgenda
                .findById(id)
                .orElse(null);
        if (agendaActual != null){
            this.miRepositorioAgenda.delete(agendaActual);
        }
    }

}

package proyecto.sophos.reto2.Controladores;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

}

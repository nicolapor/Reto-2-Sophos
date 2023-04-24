package proyecto.sophos.reto2.Modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Agenda {
    @Id
    private int id_agenda;
    private String escuela;
    private String reunion_familiar;
    private String trabajo;

    public Agenda() {
    }

    public Agenda(String escuela, String reunion_familiar, String trabajo) {
        this.escuela = escuela;
        this.reunion_familiar = reunion_familiar;
        this.trabajo = trabajo;
    }

    public int getId_agenda() {
        return id_agenda;
    }

    public String getEscuela() {
        return escuela;
    }

    public void setEscuela(String escuela) {
        this.escuela = escuela;
    }

    public String getReunion_familiar() {
        return reunion_familiar;
    }

    public void setReunion_familiar(String reunion_familiar) {
        this.reunion_familiar = reunion_familiar;
    }

    public String getTrabajo() {
        return trabajo;
    }

    public void setTrabajo(String trabajo) {
        this.trabajo = trabajo;
    }
}

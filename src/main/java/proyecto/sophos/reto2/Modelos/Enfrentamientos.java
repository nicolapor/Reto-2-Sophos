package proyecto.sophos.reto2.Modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Enfrentamientos {
    @Id
    private int id_enfrentamiento;
    private String resultado;

    @ManyToOne
    @JoinColumn(name = "fk_id_heroes")
    private Heroes heroe;

    @ManyToOne
    @JoinColumn(name = "fk_id_villanos")
    private Villanos villano;

    public Enfrentamientos() {
    }

    public Enfrentamientos(String resultado) {
        this.resultado = resultado;
    }

    public int getId_enfrentamiento() {
        return id_enfrentamiento;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public Heroes getHeroe() {
        return heroe;
    }

    public Villanos getVillano() {
        return villano;
    }
}

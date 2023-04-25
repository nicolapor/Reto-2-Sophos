package proyecto.sophos.reto2.Modelos;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity

public class Ciudadano {
    @Id
    private int id_ciudadano;
    private String nombre;
    private int edad;
    private String relacion_personal;
    @ManyToOne
    @JoinColumn(name = "fk_id_heroes")
    private Heroes heroe;

    public Ciudadano() {
    }

    public Ciudadano(String nombre, int edad, String relacion_personal) {
        this.nombre = nombre;
        this.edad = edad;
        this.relacion_personal = relacion_personal;
    }

    public int getId_ciudadano() {
        return id_ciudadano;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getRelacion_personal() {
        return relacion_personal;
    }

    public void setRelacion_personal(String relacion_personal) {
        this.relacion_personal = relacion_personal;
    }

    public Heroes getHeroe() {
        return heroe;
    }

    public void setHeroe(Heroes heroe) {
        this.heroe = heroe;
    }
}

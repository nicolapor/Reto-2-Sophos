package proyecto.sophos.reto2.Modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Villanos {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private int id_villanos;
    private String nombre;
    private int edad;
    private String habilidades;
    private String origen;
    private String debilidades;
    private String poder;

    public Villanos() {
    }

    public Villanos(String nombre, int edad, String habilidades, String origen, String debilidades, String poder) {
        this.nombre = nombre;
        this.edad = edad;
        this.habilidades = habilidades;
        this.origen = origen;
        this.debilidades = debilidades;
        this.poder = poder;
    }

    public int getId_villanos() {
        return id_villanos;
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

    public String getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(String habilidades) {
        this.habilidades = habilidades;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDebilidades() {
        return debilidades;
    }

    public void setDebilidades(String debilidades) {
        this.debilidades = debilidades;
    }

    public String getPoder() {
        return poder;
    }

    public void setPoder(String poder) {
        this.poder = poder;
    }
}

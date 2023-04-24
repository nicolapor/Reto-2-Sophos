package proyecto.sophos.reto2.Modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Patrocinadores {
    @Id
    private int id_patrocinador;
    private String nombre;
    private int pago_heroe;
    private String origen_dinero;

    public Patrocinadores() {
    }

    public Patrocinadores(String nombre, int pago_heroe, String origen_dinero) {
        this.nombre = nombre;
        this.pago_heroe = pago_heroe;
        this.origen_dinero = origen_dinero;
    }

    public int getId_patrocinador() {
        return id_patrocinador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPago_heroe() {
        return pago_heroe;
    }

    public void setPago_heroe(int pago_heroe) {
        this.pago_heroe = pago_heroe;
    }

    public String getOrigen_dinero() {
        return origen_dinero;
    }

    public void setOrigen_dinero(String origen_dinero) {
        this.origen_dinero = origen_dinero;
    }
}

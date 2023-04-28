package proyecto.sophos.reto2.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import proyecto.sophos.reto2.Modelos.Villanos;

import java.util.List;

@Repository
public interface RepositorioVillano extends JpaRepository<Villanos, Integer> {

    @Query("SELECT v FROM Villanos v WHERE v.nombre = :nombre")
    List<Villanos> filtraNombreVillanos(@Param("nombre") String nombre);

    @Query("SELECT v FROM Villanos v WHERE v.origen = :origen")
    List<Villanos> filtrarOrigenVillanos(@Param("origen") String origen);

    @Query("SELECT v FROM Villanos v WHERE v.debilidades = :debilidades")
    List<Villanos> filtraDebilidadesVillanos(@Param("debilidades") String debilidades);



}

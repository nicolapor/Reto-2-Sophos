package proyecto.sophos.reto2.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import proyecto.sophos.reto2.Modelos.Heroes;

import java.util.List;

@Repository
public interface RepositorioHeroe extends JpaRepository<Heroes, Integer> {

    @Query("SELECT v FROM Heroes v WHERE v.nombre = :nombre")
    List<Heroes> filtrarNombreHeroes(@Param("nombre") String nombre);

    @Query("SELECT v FROM Heroes v WHERE v.habilidades = :habilidades")
    List<Heroes> filtrarHabilidadHeroes(@Param("habilidades") String habilidades);




}


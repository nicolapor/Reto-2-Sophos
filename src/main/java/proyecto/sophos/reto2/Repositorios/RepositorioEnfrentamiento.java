package proyecto.sophos.reto2.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import proyecto.sophos.reto2.Modelos.Enfrentamientos;
import proyecto.sophos.reto2.Modelos.Heroes;

import java.util.List;

@Repository
public interface RepositorioEnfrentamiento extends JpaRepository<Enfrentamientos, Integer> {

    /*
    @Query("SELECT her.nombre, COUNT(enf.resultado) AS num_victorias\n" +
            "FROM Enfrentamientos enf\n" +
            "INNER JOIN heroes her ON her.id_heroes = enf.fk_id_heroes\n" +
            "WHERE enf.resultado = 'VICTORIA HEROE'\n" +
            "GROUP BY enf.fk_id_heroes\n" +
            "ORDER BY COUNT(enf.resultado) DESC\n" +
            "LIMIT 3")
    List<Heroes> filtrarVictoriasHeroes();

     */

}

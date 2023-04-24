package proyecto.sophos.reto2.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyecto.sophos.reto2.Modelos.Enfrentamientos;

@Repository
public interface RepositorioEnfrentamiento extends JpaRepository<Enfrentamientos, Integer> {


}

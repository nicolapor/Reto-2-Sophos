package proyecto.sophos.reto2.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyecto.sophos.reto2.Modelos.Heroes;

@Repository
public interface RepositorioHeroe extends JpaRepository<Heroes, Integer> {


}

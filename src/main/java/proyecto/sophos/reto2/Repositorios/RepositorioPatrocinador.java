package proyecto.sophos.reto2.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyecto.sophos.reto2.Modelos.Patrocinadores;

@Repository
public interface RepositorioPatrocinador extends JpaRepository<Patrocinadores, Integer> {

}

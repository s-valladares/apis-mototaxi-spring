package universidad.project.mototaxis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import universidad.project.mototaxis.domains.Ubicacion;


public interface IUbicacionDao extends JpaRepository<Ubicacion, Long> {


}

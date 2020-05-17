package universidad.project.mototaxis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import universidad.project.mototaxis.domains.Ubicacion;

import java.util.List;

public interface IUbicacionDao extends JpaRepository<Ubicacion, Long> {


}

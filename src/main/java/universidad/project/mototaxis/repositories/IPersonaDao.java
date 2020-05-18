package universidad.project.mototaxis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import universidad.project.mototaxis.domains.Persona;

public interface IPersonaDao extends JpaRepository<Persona, Long> {
}

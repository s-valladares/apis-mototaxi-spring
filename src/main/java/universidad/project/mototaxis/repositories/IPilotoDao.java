package universidad.project.mototaxis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import universidad.project.mototaxis.domains.Piloto;

public interface IPilotoDao extends JpaRepository<Piloto, Long> {
}

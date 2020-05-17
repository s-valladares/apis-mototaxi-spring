package universidad.project.mototaxis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import universidad.project.mototaxis.domains.Piloto;


public interface IPilotoDao extends JpaRepository<Piloto, Long> {

    // Mostrar pilotos por id de usuario
    @Query("SELECT p FROM Piloto p WHERE p.usuario.id = ?1")
    Piloto verPilotoPorIdUsuario(Long id);
}

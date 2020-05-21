package universidad.project.mototaxis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import universidad.project.mototaxis.domains.Persona;
import universidad.project.mototaxis.domains.Usuario;

public interface IUsuarioDao extends JpaRepository<Usuario, Long> {

    @Query("SELECT u FROM Usuario u WHERE u.email = ?1")
    Usuario findByEmail(String email);

    @Query("SELECT u.persona FROM Usuario u WHERE u.id = ?1")
    Persona findPersonaByUsuarioId(Long id);
}

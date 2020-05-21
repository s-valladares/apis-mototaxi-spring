package universidad.project.mototaxis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import universidad.project.mototaxis.domains.Usuario;

public interface IUsuarioDao extends JpaRepository<Usuario, Long> {
    public Usuario findByEmail(String email);
}

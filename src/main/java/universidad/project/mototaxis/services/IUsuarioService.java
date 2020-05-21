package universidad.project.mototaxis.services;

import universidad.project.mototaxis.domains.Persona;
import universidad.project.mototaxis.domains.Usuario;

import java.util.List;

public interface IUsuarioService {
    List<Usuario> getAll();
    Usuario getId(Long id);
    Usuario create(Usuario p);
    void delete(Long id);

    Usuario findByEmail(String email);

    Persona findPersonaByUsuarioId(Long id);
}

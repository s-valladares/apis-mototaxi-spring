package universidad.project.mototaxis.services;

import universidad.project.mototaxis.domains.Persona;

import java.util.List;

public interface IPersonaService {
    List<Persona> getAll();
    Persona getId(Long id);
    Persona create(Persona p);
    void delete(Long id);

}

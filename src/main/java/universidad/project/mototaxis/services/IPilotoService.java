package universidad.project.mototaxis.services;

import universidad.project.mototaxis.domains.Piloto;

import java.util.List;

public interface IPilotoService {
    List<Piloto> getAll();
    Piloto getId(Long id);
    Piloto create(Piloto p);
    void delete(Long id);
    Piloto verPilotoPorIdUsuario(Long id);
}

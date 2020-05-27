package universidad.project.mototaxis.services;

import universidad.project.mototaxis.domains.Ubicacion;

import java.util.List;

public interface IUbicacionService {
    List<Ubicacion> getAll();
    Ubicacion getId(Long id);
    Ubicacion create(Ubicacion p);
    void delete(Long id);
    Ubicacion createUbicacionAndUpdatePiloto(Ubicacion obj, boolean activo);
}

package universidad.project.mototaxis.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import universidad.project.mototaxis.domains.Piloto;
import universidad.project.mototaxis.domains.Ubicacion;
import universidad.project.mototaxis.repositories.IUbicacionDao;
import universidad.project.mototaxis.services.IPilotoService;
import universidad.project.mototaxis.services.IUbicacionService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UbicacionImpl implements IUbicacionService {

    @Autowired
    private IUbicacionDao objDao;

    @Autowired
    private IPilotoService pilotoService;

    @Override
    @Transactional(readOnly = true)
    public List<Ubicacion> getAll() {
        return (List<Ubicacion>) objDao.findAll();
    }

    @Override
    public Ubicacion getId(Long id) {
        return objDao.findById(id).orElse(null);
    }

    @Override
    public Ubicacion create(Ubicacion obj) {
        return objDao.save(obj);
    }

    @Override
    @Transactional
    public Ubicacion createUbicacionAndUpdatePiloto(Ubicacion obj, boolean activo) {

        Ubicacion ubicacion = null;
        Piloto pActual = pilotoService.verPilotoPorIdUsuario(obj.getUsuario().getId());

        if (activo) {
            ubicacion = objDao.save(obj);
            pActual.setLat(ubicacion.getLatitud());
            pActual.setLng(ubicacion.getLongitud());
        } else {
            // System.out.println("Id a eliminar: " + obj.getId());
            // objDao.deleteById(obj.getId());
        }



        try {
            System.out.println("Actualizado: " + obj.getUsuario().getId());
            System.out.println("Lat: " + obj.getLatitud());
            System.out.println("Lng: " + obj.getLongitud());

            pActual.setActivo(activo);

            pilotoService.create(pActual);
        } catch (DataAccessException ex) {
            System.out.println("NO se pudo actualizar piloto activo");
        }

        return ubicacion;
    }

    @Override
    public void delete(Long id) {
        objDao.deleteById(id);
    }
}

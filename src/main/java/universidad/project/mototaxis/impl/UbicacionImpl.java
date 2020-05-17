package universidad.project.mototaxis.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import universidad.project.mototaxis.domains.Piloto;
import universidad.project.mototaxis.domains.Ubicacion;
import universidad.project.mototaxis.repositories.IUbicacionDao;
import universidad.project.mototaxis.services.IUbicacionService;

import java.util.List;

@Service
public class UbicacionImpl implements IUbicacionService {

    @Autowired
    private IUbicacionDao objDao;

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
    public void delete(Long id) {
        objDao.deleteById(id);
    }
}

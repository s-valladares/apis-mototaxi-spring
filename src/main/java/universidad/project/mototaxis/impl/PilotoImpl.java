package universidad.project.mototaxis.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import universidad.project.mototaxis.domains.Piloto;
import universidad.project.mototaxis.repositories.IPilotoDao;
import universidad.project.mototaxis.services.IPilotoService;

import java.util.List;

@Service
public class PilotoImpl implements IPilotoService {
    @Autowired
    private IPilotoDao objDao;

    @Override
    @Transactional(readOnly = true)
    public List<Piloto> getAll() {
        return (List<Piloto>) objDao.findAll();
    }

    @Override
    public Piloto getId(Long id) {
        return objDao.findById(id).orElse(null);
    }

    @Override
    public Piloto create(Piloto obj) {
        return objDao.save(obj);
    }

    @Override
    public void delete(Long id) {
        objDao.deleteById(id);
    }

    @Override
    public Piloto verPilotoPorIdUsuario(Long id) {
        return  objDao.verPilotoPorIdUsuario(id);
    }

    @Override
    public List<Piloto> verPilotoDisponible() {
        return  objDao.verPilotoDisponible();
    }
}

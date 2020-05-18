package universidad.project.mototaxis.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import universidad.project.mototaxis.domains.Persona;
import universidad.project.mototaxis.repositories.IPersonaDao;
import universidad.project.mototaxis.services.IPersonaService;

import java.util.List;

@Service
public class PersonaImpl implements IPersonaService {

    @Autowired
    IPersonaDao objDao;

    @Override
    public List<Persona> getAll() {
        return objDao.findAll();
    }

    @Override
    public Persona getId(Long id) {
        return objDao.findById(id).orElse(null);
    }

    @Override
    public Persona create(Persona p) {
        return objDao.save(p);
    }

    @Override
    public void delete(Long id) {
        objDao.deleteById(id);
    }
}

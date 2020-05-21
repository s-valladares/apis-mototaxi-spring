package universidad.project.mototaxis.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import universidad.project.mototaxis.domains.Persona;
import universidad.project.mototaxis.domains.Usuario;
import universidad.project.mototaxis.repositories.IUsuarioDao;
import universidad.project.mototaxis.services.IUsuarioService;
import java.util.List;

@Service
public class UsuarioImpl implements IUsuarioService {

    @Autowired
    IUsuarioDao objDao;

    @Transactional

    @Override
    public List<Usuario> getAll() {
        return objDao.findAll();
    }

    @Override
    public Usuario getId(Long id) {
        return objDao.findById(id).orElse(null);
    }

    @Override
    public Usuario create(Usuario p) {
        return objDao.save(p);
    }

    @Override
    public void delete(Long id) {
        objDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario findByEmail(String email) {
        return objDao.findByEmail(email);
    }

    @Override
    public Persona findPersonaByUsuarioId(Long id) {
        return objDao.findPersonaByUsuarioId(id);
    }


}

package universidad.project.mototaxis.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import universidad.project.mototaxis.domains.Usuario;
import universidad.project.mototaxis.repositories.IUsuarioDao;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Primary
public class AuthUsuarioService implements UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(UsuarioImpl.class);

    @Autowired
    IUsuarioDao objDao;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        Usuario usuario = objDao.findByEmail(s);

        if(usuario == null) {
            logger.error("No existe el usuario");
            throw new UsernameNotFoundException("No existe el usuario");
        }

        List<GrantedAuthority> authorities = usuario.getRoles()
                .stream()
                .map(rol -> new SimpleGrantedAuthority(rol.getNombre()))
                .peek(authority -> logger.info("Rol: " + authority.getAuthority()))
                .collect(Collectors.toList());

        return new User(usuario.getEmail(), usuario.getPassword(), usuario.getEnabled(), true, true, true, authorities);


    }
}

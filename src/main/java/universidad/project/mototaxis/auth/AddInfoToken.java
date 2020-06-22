package universidad.project.mototaxis.auth;

import org.hibernate.exception.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;
import universidad.project.mototaxis.domains.Persona;
import universidad.project.mototaxis.domains.Piloto;
import universidad.project.mototaxis.domains.Usuario;
import universidad.project.mototaxis.services.IPilotoService;
import universidad.project.mototaxis.services.IUsuarioService;

import java.util.HashMap;
import java.util.Map;

@Component
public class AddInfoToken implements TokenEnhancer {

    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    private IPilotoService pilotoServiceService;

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {

        Map<String, Object> info = new HashMap<>();

        Usuario usuario = usuarioService.findByEmail(oAuth2Authentication.getName());
        Persona persona = usuarioService.findPersonaByUsuarioId(usuario.getId());
        Piloto piloto = null;
        try {
            piloto = pilotoServiceService.verPilotoPorIdUsuario(usuario.getId());
            if(piloto != null) {
                info.put("piloto_id", piloto.getId());
            }

        } catch (DataException e) {

        }

        // INFORMACIÓN QUE VA A DVEOLVER EL TOKEN
        info.put("info_adicional", "Hola que tal" + oAuth2Authentication.getName());
        info.put("id_usuario", usuario.getId());
        info.put("email", usuario.getEmail());
        info.put("persona_nombre", persona.getNombres());
        info.put("persona_apellidos", persona.getApellidos());
        info.put("persona_telefono", persona.getTelefono());





        ((DefaultOAuth2AccessToken) oAuth2AccessToken).setAdditionalInformation(info);

        return oAuth2AccessToken;
    }
}

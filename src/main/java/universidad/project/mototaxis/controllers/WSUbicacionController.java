package universidad.project.mototaxis.controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import universidad.project.mototaxis.domains.Ubicacion;

@Controller
public class WSUbicacionController {

    @MessageMapping("ubicacion")
    @SendTo("/ubicaciones/ubicacion")
    public Ubicacion nuevaUbicacion(Ubicacion ubicacion){

        ubicacion.setLatitud(ubicacion.getLatitud());
        ubicacion.setLongitud(ubicacion.getLongitud());
        ubicacion.setUsuario(ubicacion.getUsuario());

        return ubicacion;
    }
}

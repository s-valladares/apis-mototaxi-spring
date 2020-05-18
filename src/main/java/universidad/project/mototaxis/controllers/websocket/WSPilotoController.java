package universidad.project.mototaxis.controllers.websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import universidad.project.mototaxis.domains.Piloto;


@Controller
public class WSPilotoController {

    @MessageMapping("/piloto-conectado")
    @SendTo("/ubicaciones/piloto-conectado")
    public Piloto getPilotoConectado(Piloto p) {
        return p;
    }


}

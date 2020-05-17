package universidad.project.mototaxis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import universidad.project.mototaxis.domains.Piloto;
import universidad.project.mototaxis.services.IPilotoService;

import java.util.HashMap;
import java.util.Map;

@Controller
public class WSPilotoController {

    @MessageMapping("/piloto-conectado")
    @SendTo("/ubicaciones/piloto-conectado")
    public Piloto getPilotoConectado(Piloto p) {
        return p;
    }


}

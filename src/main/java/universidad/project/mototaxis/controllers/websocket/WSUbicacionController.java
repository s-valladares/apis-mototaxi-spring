package universidad.project.mototaxis.controllers.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import universidad.project.mototaxis.domains.Ubicacion;
import universidad.project.mototaxis.services.IUbicacionService;

import java.util.HashMap;
import java.util.Map;

@Controller
public class WSUbicacionController {

    @Autowired
    private IUbicacionService objService;

    private  Logger log = LoggerFactory.getLogger(WSUbicacionController.class);

    Map<String, Object> response = new HashMap<>();
    Ubicacion objNew = null;

    @MessageMapping("/piloto-on")
    @SendTo("/ubicaciones/piloto-on")
    public ResponseEntity<?> createUbicacionOn(Ubicacion ub) {

        response.clear();

        try {
            objNew = objService.createUbicacionAndUpdatePiloto(ub, true);

        } catch (DataAccessException ex) {
            response.put("mensaje", "Error al insertar en la base de datos");
            response.put("error", ex.getMessage().concat(": ").concat(ex.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "OK");
        response.put("RES", objNew);

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

    }

    @MessageMapping("/piloto-off")
    @SendTo("/ubicaciones/piloto-off")
    public ResponseEntity<?> deleteUbicacionOff(Ubicacion ub) {
        System.out.println("Este es el id:" + ub.getId());
        response.clear();

        try {
            objNew = objService.createUbicacionAndUpdatePiloto(ub, false);

        } catch (DataAccessException ex) {
            response.put("mensaje", "Error al eliminar de la base de datos");
            response.put("error", ex.getMessage().concat(": ").concat(ex.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "OK");
        response.put("RES", objNew);

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

    }





}

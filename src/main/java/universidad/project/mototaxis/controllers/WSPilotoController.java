package universidad.project.mototaxis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import universidad.project.mototaxis.domains.Piloto;
import universidad.project.mototaxis.services.IPilotoService;

import java.util.HashMap;
import java.util.Map;

public class WSPilotoController {

    @Autowired
    private IPilotoService objService;

    Map<String, Object> response = new HashMap<>();

    @MessageMapping("/ubicacion")
    @SendTo("/ubicaciones/piloto")
    public ResponseEntity<?> verPilotoPorIdUsuario(Long id) {

        Piloto obj = null;

        try {
            obj = objService.getId(id);
        } catch (DataAccessException ex) {
            response.put("mensaje", "Error al consultar base de datos");
            response.put("error", ex.getMessage().concat(": ").concat(ex.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (obj == null) {
            response.put("mensaje", "piloto".toUpperCase() + " ID: ".concat(id.toString().concat(" No existe en la base de datos")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Piloto>(obj, HttpStatus.OK);
    }
}

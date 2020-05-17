package universidad.project.mototaxis.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import universidad.project.mototaxis.domains.Piloto;
import universidad.project.mototaxis.domains.Ubicacion;
import universidad.project.mototaxis.repositories.IUbicacionDao;
import universidad.project.mototaxis.services.IUbicacionService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class WSUbicacionController {

    @Autowired
    private IUbicacionService objService;

    private  Logger log = LoggerFactory.getLogger(WSUbicacionController.class);

    Map<String, Object> response = new HashMap<>();

    @MessageMapping("/piloto")
    @SendTo("/ubicaciones/piloto")
    public ResponseEntity<?> createUbicacion(Ubicacion x) {

        Ubicacion objNew = null;
        Map<String, Object> response = new HashMap<>();

        try {
            //System.out.print(x.getApellidos());
            objNew = objService.createUbicacionAndUpdatePiloto(x);

        } catch (DataAccessException ex) {
            response.put("mensaje", "Error al insertar en la base de datos");
            response.put("error", ex.getMessage().concat(": ").concat(ex.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "OK");
        response.put("RES", objNew);

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

    }



}

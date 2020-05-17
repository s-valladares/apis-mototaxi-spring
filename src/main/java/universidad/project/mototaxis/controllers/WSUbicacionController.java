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

    @MessageMapping("/ubicacion")
    @SendTo("/ubicaciones/ubicacion")
    public Ubicacion createUbicacion(Ubicacion x) {
        log.info("create: ");
        return objService.create(x);


    }



}

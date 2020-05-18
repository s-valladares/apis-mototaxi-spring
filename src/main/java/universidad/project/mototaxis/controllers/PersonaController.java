package universidad.project.mototaxis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import universidad.project.mototaxis.config.UrlBaseApi;
import universidad.project.mototaxis.domains.Persona;
import universidad.project.mototaxis.services.IPersonaService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping(UrlBaseApi.URL_API)
public class PersonaController {

    private final String entidad = "/personas";

    @Autowired
    private IPersonaService objService;
    Map<String, Object> response = new HashMap<>();

    @PostMapping(entidad)
    public ResponseEntity<?> create(@Valid @RequestBody Persona x, BindingResult result) {

        Persona objNew = null;

        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors().stream().map(err -> {
                return "El campo '" + err.getField() + "' " + err.getDefaultMessage();
            }).collect(Collectors.toList());

            response.put("errors", errors);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }

        try {
            objNew = objService.create(x);

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

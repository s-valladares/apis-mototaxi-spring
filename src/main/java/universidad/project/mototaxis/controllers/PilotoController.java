package universidad.project.mototaxis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import universidad.project.mototaxis.config.UrlBaseApi;
import universidad.project.mototaxis.domains.Piloto;
import universidad.project.mototaxis.services.IPilotoService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(UrlBaseApi.URL_API)
@CrossOrigin(origins = "http://localhost:8100", maxAge = 3600)
public class PilotoController {
    private final String entidad = "/pilotos";

    @Autowired
    private IPilotoService objService;
    Map<String, Object> response = new HashMap<>();

    @GetMapping(entidad)
    public ResponseEntity<?> index() {
        List<Piloto> objNew = null;

        try {
            objNew = objService.getAll();
        } catch (DataAccessException ex) {
            response.put("mensaje", "Error al obtener de la base de datos");
            response.put("error", ex.getMessage().concat(": ").concat(ex.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("size", objNew.size());
        response.put("rows", objNew);

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
}

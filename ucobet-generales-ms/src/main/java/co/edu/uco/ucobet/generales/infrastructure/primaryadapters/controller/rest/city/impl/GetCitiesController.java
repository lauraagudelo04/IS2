package co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.rest.city.impl;

import co.edu.uco.ucobet.generales.application.primaryports.dto.GetCitiesDTO;
import co.edu.uco.ucobet.generales.application.primaryports.interactor.city.GetCitiesInteractor;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.UcoBetException;
import co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.response.GetCitiesResponse;
import co.edu.uco.ucobet.generales.crosscutting.helpers.MessageHelper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/general/api/v1/cities")

public class GetCitiesController {

    private final GetCitiesInteractor getCitiesInteractor;

    public GetCitiesController(final GetCitiesInteractor getCitiesInteractor) {
        this.getCitiesInteractor = getCitiesInteractor;
    }

    @GetMapping
    public ResponseEntity<GetCitiesResponse> execute() {
        var httpStatusCode = HttpStatus.OK;
        var cityResponse = new GetCitiesResponse();

        try {
            // Ejecuta el interactor para obtener la lista de ciudades
            List<GetCitiesDTO> cities = getCitiesInteractor.execute(null);
            cityResponse.setDatos(cities);
            cityResponse.getMensajes().add(MessageHelper.getMessage("M006"));

        } catch (final UcoBetException excepcion) {
            httpStatusCode = HttpStatus.BAD_REQUEST;
            cityResponse.getMensajes().add(excepcion.getUserMessage());


        } catch (final Exception excepcion) {
            httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
            cityResponse.getMensajes().add(MessageHelper.getMessage("M007"));

        }

        return new ResponseEntity<>(cityResponse, httpStatusCode);
    }
}
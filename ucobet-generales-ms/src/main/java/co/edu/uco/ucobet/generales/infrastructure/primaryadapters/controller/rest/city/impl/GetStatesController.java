package co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.rest.city.impl;

import co.edu.uco.ucobet.generales.application.primaryports.dto.StateDTO;
import co.edu.uco.ucobet.generales.application.primaryports.interactor.states.GetStatesInteractor;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.UcoBetException;
import co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.response.GetStatesResponse;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.redis.MessageHelper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/general/api/v1/states")

public class GetStatesController {

    private final GetStatesInteractor getStatesInteractor;

    public GetStatesController(GetStatesInteractor getStatesInteractor) {
        this.getStatesInteractor = getStatesInteractor;
    }

    @GetMapping
    public ResponseEntity<GetStatesResponse> getStates() {
        var httpStatusCode = HttpStatus.OK;
        var stateResponse = new GetStatesResponse();

        try {
            // Ejecuta el interactor para obtener la lista de ciudades
            var stateDTO= StateDTO.create();
            stateResponse.setDatos(getStatesInteractor.execute(stateDTO));
            stateResponse.getMensajes().add(MessageHelper.getMessage("M004"));

        } catch (final UcoBetException excepcion) {
            httpStatusCode = HttpStatus.BAD_REQUEST;
            stateResponse.getMensajes().add(excepcion.getUserMessage());
            excepcion.printStackTrace();

        } catch (final Exception excepcion) {
            httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
            stateResponse.getMensajes().add(MessageHelper.getMessage("M005"));
            excepcion.printStackTrace();
        }

        return new ResponseEntity<>(stateResponse, httpStatusCode);
    }
}

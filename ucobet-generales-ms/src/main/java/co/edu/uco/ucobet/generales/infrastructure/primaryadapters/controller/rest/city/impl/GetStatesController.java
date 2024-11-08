package co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.rest.city.impl;

import co.edu.uco.ucobet.generales.application.primaryports.dto.StateDTO;
import co.edu.uco.ucobet.generales.application.primaryports.interactor.states.GetStatesInteractor;
import co.edu.uco.ucobet.generales.application.secondaryports.service.telemetry.TelemetryService;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.UcoBetException;
import co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.response.GetStatesResponse;
import co.edu.uco.ucobet.generales.crosscutting.helpers.MessageHelper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/general/api/v1/states")

public class GetStatesController {

    private final GetStatesInteractor getStatesInteractor;
    private final TelemetryService telemetryService;

    public GetStatesController(GetStatesInteractor getStatesInteractor, TelemetryService telemetryService) {
        this.getStatesInteractor = getStatesInteractor;
        this.telemetryService = telemetryService;
    }

    @GetMapping
    public ResponseEntity<GetStatesResponse> getStates() {
        var httpStatusCode = HttpStatus.OK;
        var stateResponse = new GetStatesResponse();

        try {
            // Ejecuta el interactor para obtener la lista de ciudades
            var stateDTO = StateDTO.create();
            var states = getStatesInteractor.execute(stateDTO); // Almacena el resultado en una variable
            stateResponse.setDatos(states);
            stateResponse.getMensajes().add(MessageHelper.getMessage("M004"));
            Map<String, String> successProps = new HashMap<>();
            successProps.put(MessageHelper.getMessage("M0030"), String.valueOf(states.size()));
            telemetryService.trackEvent(MessageHelper.getMessage("M0031"), successProps);

        } catch (final UcoBetException excepcion) {
            httpStatusCode = HttpStatus.BAD_REQUEST;
            stateResponse.getMensajes().add(excepcion.getUserMessage());


        } catch (final Exception excepcion) {
            httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
            stateResponse.getMensajes().add(MessageHelper.getMessage("M005"));

        }

        return new ResponseEntity<>(stateResponse, httpStatusCode);
    }
}

package co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.rest.city.impl;

import co.edu.uco.ucobet.generales.application.primaryports.dto.RegisterNewCityDTO;
import co.edu.uco.ucobet.generales.application.primaryports.interactor.city.RegisterNewCityInteractor;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.UcoBetException;

import co.edu.uco.ucobet.generales.crosscutting.helpers.SanitizerHelper;
import co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.response.RegisterCityResponse;
import co.edu.uco.ucobet.generales.crosscutting.helpers.MessageHelper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/general/api/v1/cities")

public class RegisterNewCityController {

    private RegisterNewCityInteractor  registerNewCityInteractor;

    public RegisterNewCityController(RegisterNewCityInteractor registerNewCityInteractor) {
        super();
        this.registerNewCityInteractor = registerNewCityInteractor;
    }

    @PostMapping("/registerNewCity")
    public ResponseEntity<RegisterCityResponse> registrar(@RequestBody RegisterNewCityDTO registerNewCityDTO) {

        var httpStatusCode = HttpStatus.ACCEPTED;
        var cityResponse = new RegisterCityResponse();

        try {
            sanitizeRegisterNewCityDTO(registerNewCityDTO);
            registerNewCityInteractor.execute(registerNewCityDTO);
            var mensajeUsuario = MessageHelper.getMessage("M001");
            cityResponse.getMensajes().add(mensajeUsuario);

        } catch (final UcoBetException excepcion) {
            httpStatusCode = HttpStatus.BAD_REQUEST;
            cityResponse.getMensajes().add(excepcion.getUserMessage());

        } catch (final Exception excepcion) {
            httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
            var mensajeUsuario = MessageHelper.getMessage("M002");
            cityResponse.getMensajes().add(mensajeUsuario);

        }

        return new ResponseEntity<>(cityResponse, httpStatusCode);

    }

    private void sanitizeRegisterNewCityDTO(RegisterNewCityDTO dto) {
        if (dto != null) {
            dto.setCityName(SanitizerHelper.sanitizeInput(dto.getCity()));
        }
    }
}

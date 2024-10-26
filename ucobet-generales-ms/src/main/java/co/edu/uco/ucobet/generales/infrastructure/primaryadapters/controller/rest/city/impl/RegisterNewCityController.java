package co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.rest.city.impl;

import co.edu.uco.ucobet.generales.application.primaryports.dto.CityDTO;
import co.edu.uco.ucobet.generales.application.primaryports.dto.RegisterNewCityDTO;
import co.edu.uco.ucobet.generales.application.primaryports.interactor.city.RegisterNewCityInteractor;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.UcoBetException;
import co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.response.CityResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/general/api/v1/cities")
public class RegisterNewCityController {
    private RegisterNewCityInteractor  registerNewCityInteractor;

    public RegisterNewCityController(RegisterNewCityInteractor registerNewCityInteractor) {
        super();
        this.registerNewCityInteractor = registerNewCityInteractor;
    }

    @PostMapping("/crearperfil")
    public ResponseEntity<CityResponse> registrar(@RequestBody RegisterNewCityDTO registerNewCityDTO) {

        var httpStatusCode = HttpStatus.ACCEPTED;
        var cityResponse = new CityResponse();

        try {
            registerNewCityInteractor.execute(registerNewCityDTO);
            var mensajeUsuario = "La ciudad se encuentra registrado correctamente";
            cityResponse.getMensajes().add(mensajeUsuario);

        } catch (final UcoBetException excepcion) {
            httpStatusCode = HttpStatus.BAD_REQUEST;
            cityResponse.getMensajes().add(excepcion.getUserMessage());
            excepcion.printStackTrace();

        } catch (final Exception excepcion) {
            httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
            var mensajeUsuario = "La ciudad no se pudo registrar";
            cityResponse.getMensajes().add(mensajeUsuario);
            excepcion.printStackTrace();
        }

        return new ResponseEntity<>(cityResponse, httpStatusCode);

    }
}

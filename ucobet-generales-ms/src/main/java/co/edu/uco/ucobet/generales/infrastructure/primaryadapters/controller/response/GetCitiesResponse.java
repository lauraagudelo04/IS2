package co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.response;

import co.edu.uco.ucobet.generales.application.primaryports.dto.GetCitiesDTO;

import java.util.ArrayList;

public class GetCitiesResponse extends Response <GetCitiesDTO> {
    public GetCitiesResponse(){
        setMensajes(new ArrayList<String>());
        setDatos(new ArrayList<>());
    }
}

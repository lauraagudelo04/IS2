package co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.response;

import co.edu.uco.ucobet.generales.application.primaryports.dto.StateDTO;

import java.util.ArrayList;

public class GetStatesResponse extends Response <StateDTO>{
    public GetStatesResponse(){
        setMensajes(new ArrayList<String>());
        setDatos(new ArrayList<>());
    }
}

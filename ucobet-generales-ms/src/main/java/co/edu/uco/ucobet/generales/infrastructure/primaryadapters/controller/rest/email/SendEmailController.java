package co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.rest.email;

import co.edu.uco.ucobet.generales.application.primaryports.dto.EmailDataDTO;
import co.edu.uco.ucobet.generales.application.primaryports.interactor.email.sendEmail.SendEmailInteractor;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.UcoBetException;
import co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.response.SendEmailResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/email")
public class SendEmailController {
    private final SendEmailInteractor sendEmailInteractor;
    public SendEmailController(SendEmailInteractor sendEmailInteractor) {
        this.sendEmailInteractor = sendEmailInteractor;
    }
    @PostMapping("/send")
    public ResponseEntity<SendEmailResponse> sendEmail(@RequestBody EmailDataDTO emailDataDTO) {
        var httpStatusCode = HttpStatus.OK;
        var emailResponse = new SendEmailResponse();
        try {
            // Ejecuta el interactor para enviar el email
            sendEmailInteractor.execute(emailDataDTO);
            emailResponse.getMensajes().add("Correo enviado exitosamente.");
        } catch (UcoBetException excepcion) {
            httpStatusCode = HttpStatus.BAD_REQUEST;
            emailResponse.getMensajes().add(excepcion.getUserMessage());
            excepcion.printStackTrace();
        } catch (Exception excepcion) {
            httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
            emailResponse.getMensajes().add("Se ha presentado un problema tratando de enviar el correo electrónico.");
            excepcion.printStackTrace();
        }
        return new ResponseEntity<>(emailResponse, httpStatusCode);
    }
}

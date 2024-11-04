package co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.notificationservice;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.SendGridUcoBetException;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class EmailSender {
    private final String apiKey;

    public EmailSender(@Value("${keySendgrid}") String apiKey) {
        this.apiKey = apiKey;
    }

    public void sendEmail(String to, String subject, String content) throws SendGridUcoBetException {
        Email from = new Email("zbankproject@gmail.com");
        Email toEmail = new Email(to);
        Content emailContent = new Content("text/plain", content);
        Mail mail = new Mail(from, subject, toEmail, emailContent);

        SendGrid sg = new SendGrid(apiKey);
        Request request = new Request();

        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);

        } catch (IOException exception) {
            throw  SendGridUcoBetException.create("Error al enviar el correo");
        }
    }
}

package co.edu.uco.ucobet.generales.application.usecase.email.impl;

import co.edu.uco.ucobet.generales.application.usecase.email.SendEmail;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.SendGridUcoBetException;
import co.edu.uco.ucobet.generales.domain.EmailData;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.notificationservice.EmailSender;
import org.springframework.stereotype.Service;

@Service
public class SendEmailImpl implements SendEmail {
    private final EmailSender emailSender;
    public SendEmailImpl(EmailSender emailSender) {
        this.emailSender = emailSender;
    }
    @Override
    public void execute(EmailData emailData) {
        try {
            emailSender.sendEmail(emailData.getTo(), emailData.getSubject(), emailData.getContent());
        } catch (SendGridUcoBetException exception) {
            System.err.println("Error enviando email ");
            throw exception;
        }
    }
}

package br.com.zitta.springemailsender.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zitta.springemailsender.models.EmailRequest;
import br.com.zitta.springemailsender.services.EmailSenderService;

@RestController
public class EmailSenderController {
    
    private EmailSenderService emailSenderService;

    public EmailSenderController(EmailSenderService emailSenderService) {
        this.emailSenderService = emailSenderService;
    }

    @PostMapping("/send-email")
    public String sendEmail(@RequestBody EmailRequest emailRequest) {
        try {
            emailSenderService.sendEmail(emailRequest.getTo(), emailRequest.getSubject(), emailRequest.getText());
            return "E-mail sent successfully";
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

}

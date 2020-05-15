package it.begear.SpringBoot1.controllers;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.begear.SpringBoot1.mail.MailSender;
import it.begear.SpringBoot1.mail.MockMailSender;

@RestController
public class MailController {
	
	private MailSender mailSender;
	

	public MailController(MailSender smtp) {
	this.mailSender = smtp;
	}


	@RequestMapping("/mail")
	public String mail () throws MessagingException {
			
		mailSender.send("mauroq21@gmail.com", "mail di prova Spring Boot", "ti consegno il mio primo test di SpringBoot!");
			
		return "Mail sent";
	}
}
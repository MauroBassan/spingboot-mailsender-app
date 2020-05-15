package it.begear.SpringBoot1.mail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;


public class SmtpMailSender implements MailSender {

	private static Log log = LogFactory.getLog(SmtpMailSender.class);
	
	private JavaMailSender javaMailSender;
	
	
	public SmtpMailSender(JavaMailSender javaMailSender) {
		
		this.javaMailSender = javaMailSender;
	}

	
	@Override
	public void send(String to, String subject, String body) throws MessagingException {

		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper;
		
		helper = new MimeMessageHelper(message, true); // true indicates multipart message
		
		helper.setSubject(subject);
		helper.setTo(to);
		helper.setText(body, true); // true indicates html
		
		// add other helper for more functionalities, such as attachments
		
		javaMailSender.send(message);
		
		log.info("Sending Smtp mail to: " + to);
		log.info("with subject: " + subject);
		log.info("and body: " + body);
	}

}

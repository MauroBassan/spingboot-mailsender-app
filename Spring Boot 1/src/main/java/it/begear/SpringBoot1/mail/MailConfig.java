package it.begear.SpringBoot1.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.mail.javamail.JavaMailSender;

@Configuration
public class MailConfig {
	
	// ALL METHODS in the configuration class are being cached!!!
	/** @return 
	 * @Autowired
	private JavaMailSender javaMailSender; 
	IN QUESTO MODO PRIMA DEFINIAMO UNA VARIABILE DI TIPO JavaMailSender,ma se lo passiamo nel metodo del bean smtpMailSender, l'oggetto viene injected diretttamente da spring
	**/
	
	@Bean
	public DemoBean demoBean() {
		
		return new DemoBean();
	}
	
	@Bean
	@ConditionalOnProperty(name="spring.mail.host", havingValue="foo", matchIfMissing=true)
	public MailSender mockMailSender() {
		
		return new MockMailSender();
	}
	@Bean
	@ConditionalOnProperty("spring.mail.host")
	public MailSender smtpMailSender(JavaMailSender javaMailSender, DemoBean demoBean) {
		
		return new SmtpMailSender(javaMailSender);
	}
}


//CLASSE PROVA X CONFIGURARE I BEAN CON UNA CLASSE DI CONFIGURAZIONE!!! 

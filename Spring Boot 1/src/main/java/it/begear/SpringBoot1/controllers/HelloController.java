package it.begear.SpringBoot1.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	/** @Value("${app.name}")
	private String appName;
	// quando HelloController verrà istanziato, spring injecterà in appName il valore della property app.name che si trova nel file application.properties
	**/
	
	@RequestMapping("/hello")
	public String Hello () {
		
		return "Hello World"; // + appName nel caso voglia usare il file application.prop
	}

}

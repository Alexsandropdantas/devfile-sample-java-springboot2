package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication
public class DemoApplication implements ErrorController{

    @RequestMapping("/")
    String home() {
        return "<h1>Boa tarde GSDS! </h1><br /><p>Click <a href=\"/private\">aqui</a> para ir para página segura</p>  ";
    }
    
    @RequestMapping("/private")
	public String secure() {
		return "Esta he uma página apos validacao SSO.";
	}
	
    @Override
    public String getErrorPath() {
        return "Página de erro do Controlador";
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}

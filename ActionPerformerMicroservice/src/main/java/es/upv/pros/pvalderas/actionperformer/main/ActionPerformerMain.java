package es.upv.pros.pvalderas.actionperformer.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import es.upv.pros.pvalderas.actionperformer.server.ActionPerformer;

@ActionPerformer
@SpringBootApplication(scanBasePackages = {"es.upv.pros.pvalderas.actionperformer.server"})
public class ActionPerformerMain {
	
	public static void main(String[] args) {
		SpringApplication.run(ActionPerformerMain.class, args);
	}
	
		
}
package es.upv.pros.pvalderas.bpcontroller.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import es.upv.pros.pvalderas.bpcontroller.server.BPController;

@BPController
@SpringBootApplication(scanBasePackages = {"es.upv.pros.pvalderas.bpcontroller.server"})
public class BPControllerMain {
	
	public static void main(String[] args) {
		SpringApplication.run(BPControllerMain.class, args);
	}
	
		
}
package es.upv.pros.pvalderas.contextmonitor.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import es.upv.pros.pvalderas.contextmonitor.server.ContextMonitor;

@ContextMonitor(contextOntology=PurchaseContextOntology.class)
@SpringBootApplication(scanBasePackages = {"es.upv.pros.pvalderas.contextmonitor.server","es.upv.pros.pvalderas.contextmonitor.ontology"})
public class ContextMonitorMain {
	
	public static void main(String[] args) {
		SpringApplication.run(ContextMonitorMain.class, args);
	}
		
}
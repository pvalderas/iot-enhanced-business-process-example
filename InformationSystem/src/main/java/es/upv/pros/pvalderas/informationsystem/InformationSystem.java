package es.upv.pros.pvalderas.informationsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import es.upv.pros.pvalderas.microservice.syncronous.SyncronousMicroservice;

@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {"es.upv.pros.pvalderas.informationsystem","es.upv.pros.pvalderas.microservice.syncronous"})
@SyncronousMicroservice(serviceAPIClass=InformationSystemHTTPController.class)
public class InformationSystem {
	
	public static void main(String[] args) {
		SpringApplication.run(InformationSystem.class, args);
	}
	
		
}
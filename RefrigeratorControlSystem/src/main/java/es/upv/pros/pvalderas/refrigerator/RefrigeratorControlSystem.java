package es.upv.pros.pvalderas.refrigerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import es.upv.pros.pvalderas.microservice.asynchronous.AsynchronousMicroservice;

@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {"es.upv.pros.pvalderas.refrigerator","es.upv.pros.pvalderas.microservice.asynchronous"})
@AsynchronousMicroservice(serviceAPIClass=RefrigeratorControlSystemAPI.class)
public class RefrigeratorControlSystem {
	
	public static void main(String[] args) {
		SpringApplication.run(RefrigeratorControlSystem.class, args);
	}
}

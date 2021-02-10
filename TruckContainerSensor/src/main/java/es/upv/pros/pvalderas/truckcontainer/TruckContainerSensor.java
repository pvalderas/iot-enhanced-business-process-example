package es.upv.pros.pvalderas.truckcontainer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import es.upv.pros.pvalderas.microservice.syncronous.SyncronousMicroservice;

@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {"es.upv.pros.pvalderas.truckcontainer","es.upv.pros.pvalderas.microservice.syncronous"})
@SyncronousMicroservice(serviceAPIClass=TruckContainerSensorHTTPController.class)
public class TruckContainerSensor {
	
	public static void main(String[] args) {
		SpringApplication.run(TruckContainerSensor.class, args);
	}
	
		
}
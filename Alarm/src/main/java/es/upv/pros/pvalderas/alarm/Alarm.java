package es.upv.pros.pvalderas.alarm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import es.upv.pros.pvalderas.microservice.asynchronous.AsynchronousMicroservice;

@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {"es.upv.pros.pvalderas.refrigerator","es.upv.pros.pvalderas.microservice.asynchronous"})
@AsynchronousMicroservice(serviceAPIClass=AlarmAPI.class)
public class Alarm {
	
	public static void main(String[] args) {
		SpringApplication.run(Alarm.class, args);
	}
}

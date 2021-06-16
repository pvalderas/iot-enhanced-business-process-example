package es.upv.pros.pvalderas.robot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import es.upv.pros.pvalderas.microservice.iotdevice.IoTDevice;

@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {"es.upv.pros.pvalderas.robot","es.upv.pros.pvalderas.microservice.iotdevice"})
@IoTDevice(serviceAPIClass=RobotHTTPController.class)
public class Robot {
	
	public static void main(String[] args) {
		SpringApplication.run(Robot.class, args);
	}
	
		
}
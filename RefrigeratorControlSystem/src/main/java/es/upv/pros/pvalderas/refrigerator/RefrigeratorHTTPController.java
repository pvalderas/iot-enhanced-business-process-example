package es.upv.pros.pvalderas.refrigerator;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.upv.pros.pvalderas.microservice.iotdevice.BPMNOperation;

public class RefrigeratorHTTPController {
	
	@RequestMapping(
			  value = "/camera/temperature/adjust/", 
			  method = RequestMethod.GET)
	@BPMNOperation(name = "Adjust Camera Temperatura", id = "adjustCameraTemp")
	 public String adjustCameraTemp() {
		return "{\"message\":\"Adjust Camera Temperatura Executed\"}";
	}
	
	@RequestMapping(
			  value = "/camera/temperature/increase/", 
			  method = RequestMethod.GET)
	@BPMNOperation(name = "Increase Camera Temperatura", id = "increaseCameraTemp")
	 public String increaseCameraTemp() {
		return "{\"message\":\"Increase Camera Temperatura Executed\"}";
	}
	
	@RequestMapping(
			  value = "/camera/temperature/decrease/", 
			  method = RequestMethod.GET)
	@BPMNOperation(name = "Decrease Camera Temperatura", id = "decreaseCameraTemp")
	 public String decreaseCameraTemp() {
		return "{\"message\":\"Decrease Camera Temperatura Executed\"}";
	}

}

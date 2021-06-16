package es.upv.pros.pvalderas.truckcontainer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.upv.pros.pvalderas.microservice.iotdevice.BPMNOperation;
 
@RestController
public class TruckContainerSensorHTTPController {
	
	
	@RequestMapping(
			  value = "/conditions", 
			  method = RequestMethod.GET)
	@BPMNOperation(name="Read Temerature and Humidity Values", id="readConditions")
	 public String readConditions() {
		 return "{\"message\":\"Read Conditions OK\"}";
	 }
	
}

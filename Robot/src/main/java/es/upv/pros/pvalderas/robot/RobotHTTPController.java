package es.upv.pros.pvalderas.robot;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.upv.pros.pvalderas.microservice.syncronous.BPMNOperation;
 
@RestController
public class RobotHTTPController {
	
	
	@RequestMapping(
			  value = "/storage/pallet/refrigerator/", 
			  method = RequestMethod.GET)
	@BPMNOperation(name="Store pallet in refrigerator camera", id="storePalletCamera")
	 public String storePalletCamera() {
		 return "{\"message\":\"Store Pallet in Refrigerator Camera Executed\"}";
	 }
	
	
	@RequestMapping(
			  value = "/placement/pallet/priority/area", 
			  method = RequestMethod.GET)
	@BPMNOperation(name="Move pallet to priority shipment area", id="movePalletToPriority")
	 public String movePalletToPriority() {
		 return "{\"message\":\"Move pallet to priority shipment area Executed\"}";
	 }
	
	
	@RequestMapping(
			  value = "/placement/pallet/nonpriority/area", 
			  method = RequestMethod.GET)
	@BPMNOperation(name="Move pallet to non-priority shipment area", id="movePalletToNonPriority")
	 public String movePalletToNonPriority() {
		 return "{\"message\":\"Move pallet to non-priority shipment area Executed\"}";
	 }
	
	@RequestMapping(
			  value = "/discard/pallet/", 
			  method = RequestMethod.GET)
	@BPMNOperation(name="Discard pallet", id="discardPallet")
	 public String discarPallet() {
		 return "{\"message\":\"Discard pallet\"}";
	 }
}

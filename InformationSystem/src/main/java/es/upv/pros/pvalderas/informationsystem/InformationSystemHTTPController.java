package es.upv.pros.pvalderas.informationsystem;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.upv.pros.pvalderas.microservice.syncronous.BPMNOperation;
 
@RestController
public class InformationSystemHTTPController {
	
	
	@RequestMapping(
			  value = "/pallet/storage", 
			  method = RequestMethod.GET)
	@BPMNOperation(name="Register pallet storage", id="registerPalletStorage")
	 public String registerPalletStorage() {
		 return "{\"message\":\"Register Pallet Storage Executed\"}";
	 }
	
	@RequestMapping(
			  value = "/price/reduction", 
			  method = RequestMethod.GET)
	@BPMNOperation(name="Reduce price", id="reducePrice")
	 public String reducePrice() {
		 return "{\"message\":\"Reduce Price Executed\"}";
	 }
	
	@RequestMapping(
			  value = "/shipement/management", 
			  method = RequestMethod.GET)
	@BPMNOperation(name="Manage shipment", id="manageShipment")
	 public String manageShipment() {
		 return "{\"message\":\"Manage Shipment Executed\"}";
	 }
	
	@RequestMapping(
			  value = "/pallet/rejection", 
			  method = RequestMethod.GET)
	@BPMNOperation(name="Register pallet rejection", id="registerPalletRejection")
	 public String registerPalletRejection() {
		 return "{\"message\":\"Register Pallet Rejection Executed\"}";
	 }
	
	@RequestMapping(
			  value = "/pallet/shipment", 
			  method = RequestMethod.GET)
	@BPMNOperation(name="Register pallet shipment", id="registerPalletShipment")
	 public String registerPalletShipment() {
		 return "{\"message\":\"Register Pallet Shipment Executed\"}";
	 }
	
}

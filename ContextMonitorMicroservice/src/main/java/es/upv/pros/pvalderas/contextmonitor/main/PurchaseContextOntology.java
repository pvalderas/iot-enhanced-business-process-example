package es.upv.pros.pvalderas.contextmonitor.main;

import java.util.Hashtable;
import java.util.Map;

import es.upv.pros.pvalderas.contextmonitor.ontology.ContextOntology;

public class PurchaseContextOntology extends ContextOntology {

	@Override
	public Map<String, String> SWRLRules() {
		Map<String, String> rules=new Hashtable<String,String>();

		rules.put("ContainerArrival","Container(?container) ^ locatedIn(?container, ContainerReception) -> status(?container,\"arrivalInWarehouse\")");
		rules.put("CameraRegrigeratorTooWarm","TemperatureObservation(?o) ^ hasResult(?o, ?result) ^ value(?result, ?v) ^ Product (?p) ^ maximumTemperature (?p, ?t) ^ swrlb:greaterThan (?v, ?t) -> temperatureCondition (?p, \"TooWarm\")");
		rules.put("TruckArrival","Truck(?truck) ^ locatedIn (?truck, TruckReception) -> status(?truck,\"arrivalInWarehouse\")");

		return rules;
	}

	@Override
	public Map<String, String> highLevelEvents() {
		Map<String, String> events=new Hashtable<String,String>();

		events.put("Container Arrival","ASK WHERE { Container(?container) status \"arrivalInWarehouse\" }");
		events.put("Camera Regrigerator Too Warm","ASK WHERE { TemperatureObservation(?o) temperatureCondition \"TooWarm\" }");
		events.put("Truck Arrival","ASK WHERE { Truck(?truck) status \"arrivalInWarehouse\" }");

		return events;
	}

}

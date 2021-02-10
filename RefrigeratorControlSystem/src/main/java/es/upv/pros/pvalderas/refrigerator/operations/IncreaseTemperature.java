package es.upv.pros.pvalderas.refrigerator.operations;

import es.upv.pros.pvalderas.microservice.asynchronous.AsynchronousOperation;

public class IncreaseTemperature extends AsynchronousOperation {

	@Override
	public String execute(String data) {
		
		return "Increase Temperature Executed";
		
	}

}

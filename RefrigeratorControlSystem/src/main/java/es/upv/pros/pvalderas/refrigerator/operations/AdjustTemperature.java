package es.upv.pros.pvalderas.refrigerator.operations;

import es.upv.pros.pvalderas.microservice.asynchronous.AsynchronousOperation;

public class AdjustTemperature extends AsynchronousOperation {

	@Override
	public String execute(String data) {
		
		return "Adjust Temperature Executed";
		
	}

}

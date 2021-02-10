package es.upv.pros.pvalderas.refrigerator.operations;

import es.upv.pros.pvalderas.microservice.asynchronous.AsynchronousOperation;

public class DecreaseTemperature extends AsynchronousOperation {

	@Override
	public String execute(String data) {
		
		return "Decrease Temperature Executed";
		
	}

}

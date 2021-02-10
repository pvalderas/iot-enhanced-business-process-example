package es.upv.pros.pvalderas.alarm.operations;

import es.upv.pros.pvalderas.microservice.asynchronous.AsynchronousOperation;

public class Activate extends AsynchronousOperation {

	@Override
	public String execute(String data) {
		
		return "Activate Alarm Executed";
		
	}

}

package es.upv.pros.pvalderas.alarm;

import es.upv.pros.pvalderas.alarm.operations.Activate;
import es.upv.pros.pvalderas.microservice.asynchronous.BPMNOperation;

public class AlarmAPI {
	
	@BPMNOperation(
			  name = "Activate", 
			  id = "activate"
			  )
	 public Class activate() {
		return Activate.class;
	}

}

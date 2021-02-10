package es.upv.pros.pvalderas.refrigerator;

import es.upv.pros.pvalderas.microservice.asynchronous.BPMNOperation;
import es.upv.pros.pvalderas.refrigerator.operations.AdjustTemperature;
import es.upv.pros.pvalderas.refrigerator.operations.DecreaseTemperature;
import es.upv.pros.pvalderas.refrigerator.operations.IncreaseTemperature;

public class RefrigeratorControlSystemAPI {
	
	@BPMNOperation(
			  name = "Adjust Camera Temperatura", 
			  id = "adjustCameraTemp"
			  )
	 public Class adjustCameraTemp() {
		return AdjustTemperature.class;
	}
	
	@BPMNOperation(
			  name = "Increase Camera Temperatura", 
			  id = "increaseCameraTemp"
			  )
	 public Class increaseCameraTemp() {
		return IncreaseTemperature.class;
	}
	
	@BPMNOperation(
			  name = "Decrease Camera Temperatura", 
			  id = "decreaseCameraTemp"
			  )
	 public Class decreaseCameraTemp() {
		return DecreaseTemperature.class;
	}

}

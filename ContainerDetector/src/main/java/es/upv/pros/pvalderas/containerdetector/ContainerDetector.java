package es.upv.pros.pvalderas.containerdetector;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class ContainerDetector {
	
	private static final String queue="context";
	
	private static final String device = "ObjectDetector";
	private static final String id = "containerReceptionDetector";
	private static final String property = "Container Availability";
	private static final String feature = "Container";
	
	
	private static Scanner keyboard= new Scanner(System.in);
	
	
	public static void main(String[] args) throws JSONException, IOException, TimeoutException{	
		
		String status=getManualDetectorStatus(); // getStatusFromSensor() in a real environment
		
		JSONObject contextProperty=createContextProperty(status);
		
		if(askToPublishManually(contextProperty)) sendToEventBus(contextProperty); // Asking is not needed in a real environment
		
	}
	
	private static JSONObject createContextProperty(String status) throws JSONException{
		JSONObject contextProperty=new JSONObject();
		contextProperty.put("device", device);
		contextProperty.put("id", id);
		contextProperty.put("property", property);
		contextProperty.put("feature", feature);
			
		JSONArray properties=new JSONArray();
		
		JSONObject statusJSON=new JSONObject();
		statusJSON.put("name", "status");
		statusJSON.put("value", new Boolean(status));
		
		JSONObject timeJSON=new JSONObject();
		timeJSON.put("name", "timeStamp");
		timeJSON.put("value", new Timestamp(System.currentTimeMillis()));
		
		properties.put(statusJSON);
		properties.put(timeJSON);
				
		contextProperty.put("properties", properties);
		
		return contextProperty;
	}
	
	private static String getManualDetectorStatus(){
		System.out.println("***********************************");
		System.out.println("********CONTAINER DETECTOR*********");
		System.out.println("***********************************");
		System.out.print("Introduce detector status (True/False): ");

		String status=keyboard.nextLine().toLowerCase();
		while(!status.equals("true") && !status.equals("false") && !status.equals("t") && !status.equals("f")){
			System.out.print("Introduce detector status (True/False): ");
			status=keyboard.nextLine();
		}
		
		if(status.equals("t")) status="true";
		if(status.equals("f")) status="false";
		
		return status;
	}
	
	private static boolean askToPublishManually(JSONObject contextProperty){
		System.out.println("**************************************");
		System.out.println(contextProperty.toString());
		System.out.println("**************************************");
		System.out.print("Publish (Y/N)?");
		char key=keyboard.next().charAt(0);
		keyboard.close();
		if(key=='Y' || key=='y'){
			return true;
		}
		return false;
	}
	
	private static String getStatusFromSensor(){
		String status=null;
		// TODO Code to obtain data from the physcial device 
		return status;
    }

	private static void sendToEventBus(JSONObject contextProperty) throws IOException, TimeoutException{
	
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();

		channel.queueDeclare(queue, false, false, false, null);

		channel.basicPublish("", queue, null, contextProperty.toString().getBytes());
		
		channel.close();
		connection.close();
		

	}
	
	
}

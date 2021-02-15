package es.upv.pros.pvalderas.testing.context;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class ContextDataTestingApp {
	
	private static final String queue="context";
	
	
	public static void main(String[] args) throws JSONException, IOException, TimeoutException{
	
		JSONObject contextProperty=new JSONObject();

		Scanner keyboard= new Scanner(System.in);
		
		System.out.print("Introduce device type: ");
		String device=keyboard.nextLine();
		contextProperty.put("device", device);
		
		System.out.print("Introduce device ID: ");
		String id=keyboard.nextLine();
		contextProperty.put("id", id);
		
		JSONArray properties=new JSONArray();
		
		System.out.println("Introduce list of proporties (Type 'exit' to finish) ");
		System.out.print("Property as name=value:"); 
		String property=keyboard.nextLine();
		
		while(!property.equals("finish")){
			
			String prop[]=property.split("=");
			
			try{
				JSONObject propJSON=new JSONObject();
				propJSON.put("name", prop[0]);
				propJSON.put("value", prop[1]);
				properties.put(propJSON);
				
			}catch(ArrayIndexOutOfBoundsException e){
				System.out.print("Incorrect property format! "); 
			}
			
			System.out.print("Property as name=value:"); 
			property=keyboard.nextLine();
			
		}
		
		contextProperty.put("properties", properties);
		

		
		System.out.println("**************************************");
		System.out.println(contextProperty.toString());
		System.out.println("**************************************");
		System.out.print("Publish (Y/N)?");
		char key=keyboard.next().charAt(0);
		if(key=='Y' || key=='y'){
			
			ConnectionFactory factory = new ConnectionFactory();
			factory.setHost("localhost");
			Connection connection = factory.newConnection();
			Channel channel = connection.createChannel();

			channel.queueDeclare(queue, false, false, false, null);

			channel.basicPublish("", queue, null, contextProperty.toString().getBytes());
			
			channel.close();
			connection.close();
			
			System.out.print("Published to the event bus");
		}
		
		keyboard.close();
		
	}
	

}

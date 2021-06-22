using System;
using System.Collections.Generic;
using System.Text.Json;
using RabbitMQ.Client;

namespace TemperatureSensor
{
    class Program
    {

        private static String queue="context";
	
	    private static String deviceType = "TemperatureSensor";
	    private static String deviceId = "containerReceptionSensor";
		private static String property = "Temperature";
		private static String feature = "Container";


		static void Main(string[] args)
        {
			float temp = GetManualTemperature(); // getStatusFromSensor() in a real environment

			ContextProperty contextProperty = createContextProperty(temp);

			if (AskToPublishManually(contextProperty)) SendToEventBus(contextProperty); // Asking is not needed in a real environment

		}

		private static ContextProperty createContextProperty(float temp)
        {
			ContextProperty contextProperty = new ContextProperty
			{
				device = deviceType,
				id = deviceId,
				property = property,
				feature = feature,
				dataProps = new List<Property>{
					new Property{
						name="temperature",
						value= temp
					},
					new Property{
						name="timestamp",
						value=DateTime.Now
					}
				}
			};

			return contextProperty;
		}

		private static float GetManualTemperature()
		{
			Console.WriteLine("************************************");
			Console.WriteLine("***********TEMPERATURE SENSOR*******");
			Console.WriteLine("************************************");
			Console.WriteLine("Introduce temperature: ");

			String temp = Console.ReadLine();

			return float.Parse(temp);
		}

		private static Boolean AskToPublishManually(ContextProperty contextProperty)
        {
			Console.WriteLine("**************************************");
			Console.WriteLine(JsonSerializer.Serialize(contextProperty));
			Console.WriteLine("**************************************");
			Console.WriteLine("Publish (Y/N)?");
			ConsoleKeyInfo key = Console.ReadKey();
			if (key.Key == ConsoleKey.Y)
			{
				return true;
            }
            else
            {
				return false;
            }
		}

		private static float getTempFromSensor()
        {
			float value=0;

			// TODO Code to obtain data from the physcial device 

			return value;
        }

		private static void SendToEventBus(ContextProperty contextProperty)
        {

			ConnectionFactory factory = new ConnectionFactory();
			factory.HostName = "localhost";
			IConnection conn = factory.CreateConnection();

			IModel channel = conn.CreateModel();

			channel.QueueDeclare(queue, false, false, false, null);

			byte[] messageBodyBytes = System.Text.Encoding.UTF8.GetBytes(JsonSerializer.Serialize(contextProperty));
			channel.BasicPublish("", queue, null, messageBodyBytes);

			channel.Close();
			conn.Close();

		}
	}
}

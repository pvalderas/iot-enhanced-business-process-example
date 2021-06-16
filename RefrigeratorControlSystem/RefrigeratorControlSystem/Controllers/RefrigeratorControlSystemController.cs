using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.Json;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Logging;

namespace RefrigeratorControlSystem.Controllers
{
    [ApiController]
    [Route("[controller]")]
    public class RefrigeratorControlSystemController : ControllerBase
    {
        [HttpGet]
        [Route("temperature/adjust")]
        public string AdjustCameraTemperature()
        {
            string result = "Adjust Camera Temperature executed";
            Console.WriteLine(DateTime.Now + " " + result);
            return result;

        }

        [HttpGet]
        [Route("temperature/decrease")]
        public string DecreaseCameraTemperature()
        {
            string result = "Decrease Camera Temperature executed";
            Console.WriteLine(DateTime.Now + " " + result);
            return result;
        }

        [HttpGet]
        [Route("temperature/increase")]
        public string IncreaseCameraTemperature()
        {
            string result = "Increase Camera Temperature executed";
            Console.WriteLine(DateTime.Now + " " + result);
            return result;
        }

        [HttpGet]
        [Route("operations")]
        public string GetOperations()
        {

            List<Operation> operations = new List<Operation>();

            operations.Add(new Operation
            {
                id = "adjustcameratemperature",
                name = "Adjust Camera Temperature",
                path = "/temperature/adjust",
                method = "GET"
            }
            );

            operations.Add(new Operation
            {
                id = "decreasecameratemperature",
                name = "Decrease Camera Temperature",
                path = "/temperature/decrease",
                method = "GET"
            }
            );

            operations.Add(new Operation
            {
                id = "increasecameratemperature",
                name = "Increase Camera Temperature",
                path = "/temperature/increase",
                method = "GET"
            }
            );

            return JsonSerializer.Serialize(operations);
        }
    }
}

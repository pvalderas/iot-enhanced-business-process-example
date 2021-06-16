using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.Json.Serialization;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Logging;
using System.Text.Json;

namespace Alarm.Controllers
{
    [ApiController]
    [Route("[controller]")]
    public class AlarmController : ControllerBase
    {

    
        [HttpGet]
        [Route("activate")]
        public string Activate()
        {
            return "The alarms has been activated";

        }


        [HttpGet]
        [Route("operations")]
        public string GetOperations()
        {
            List<Operation> operations = new List<Operation>();
            Operation activate = new Operation()
            {
                id = "activate",
                name = "Activate",
                path = "/activate",
                method = "GET"
            };
            operations.Add(activate);
            return JsonSerializer.Serialize(operations);
        }
    }
}

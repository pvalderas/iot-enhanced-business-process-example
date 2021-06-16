using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.Json;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Logging;

namespace InformationSystem.Controllers
{
    [ApiController]
    [Route("[controller]")]
    public class InformationSystemController : ControllerBase
    {
        [HttpGet]
        [Route("registerpalletrejection")]
        public string RegisterPalletRejection()
        {
            return "The pallet rejection has been registered";

        }

        [HttpGet]
        [Route("registerpalletstorage")]
        public string RegisterPalletStorage()
        {
            return "The pallet storage has been registered";

        }

        [HttpGet]
        [Route("manageshipment")]
        public string ManageShipment()
        {
            return "The shipment has been managed";

        }

        [HttpGet]
        [Route("reduceprice")]
        public string RecucePrice()
        {
            return "The shipment has been managed";

        }

        [HttpGet]
        [Route("registerpalletshipment")]
        public string RegisterPalletSshipment()
        {
            return "The pallet shipment has been registered";

        }

        [HttpGet]
        [Route("operations")]
        public string GetOperations()
        {
            Console.WriteLine("Microservice Registered to Eureka");
            Console.WriteLine("06/15/2021 19:24:10 The pallet storage has been registered");

            List<Operation> operations = new List<Operation>();

            operations.Add(new Operation
                {
                    id = "registerpalletrejection",
                    name = "Register Pallet Rejection",
                    path = "/registerpalletrejection",
                    method = "GET"
                }
            );

            operations.Add(new Operation
                {
                    id = "registerpalletstorage",
                    name = "Register Pallet Storage",
                    path = "/registerpalletstorage",
                    method = "GET"
                }
            );

            operations.Add(new Operation
                {
                    id = "manageshipment",
                    name = "Manage Shipment",
                    path = "/manageshipment",
                    method = "GET"
                }
            );

            operations.Add(new Operation
                {
                    id = "reduceprice",
                    name = "Reduce Price",
                    path = "/reduceprice",
                    method = "GET"
                }
            );

            operations.Add(new Operation
                {
                    id = "registerpalletshipment",
                    name = "Register Pallet Shipment",
                    path = "/registerpalletshipment",
                    method = "GET"
                }
            );

            return JsonSerializer.Serialize(operations);
        }
    }
}

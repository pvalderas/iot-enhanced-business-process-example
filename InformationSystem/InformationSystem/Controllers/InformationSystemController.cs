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
            string result = "Register Pallet Rejection executed";
            Console.WriteLine(DateTime.Now + " " + result);
            return result;
        }

        [HttpGet]
        [Route("registerpalletstorage")]
        public string RegisterPalletStorage()
        {
            string result = "Register Pallet Storage executed";
            Console.WriteLine(DateTime.Now + " " + result);
            return result;
        }

        [HttpGet]
        [Route("manageshipment")]
        public string ManageShipment()
        {
            string result = "Manage Shipment executed";
            Console.WriteLine(DateTime.Now + " " + result);
            return result;
        }

        [HttpGet]
        [Route("reduceprice")]
        public string RecucePrice()
        {
            string result = "Reduce Price executed";
            Console.WriteLine(DateTime.Now + " " + result);
            return result;
        }

        [HttpGet]
        [Route("registerpalletshipment")]
        public string RegisterPalletShipment()
        {
            string result = "Register Pallet Shipment executed";
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

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Ejercicio11
{
    class Program
    {
        static async Task Main(string[] args)
        {

            Paella p = new Paella();


            // Preparar caldo
            Cocinero cocinero = new Cocinero();
            Task<Caldo> tareaCaldo = cocinero.PrepararCaldo();

            // Calentar paella y sofreir ingredientes
            await cocinero.CalentarPaella(p);
            await cocinero.SofreirIngredientes(p, new List<string>(){ "tomate", "pollo", "judías planas", "garrafó", "arroz"});

            // Echar el caldo
            Caldo c = await tareaCaldo;
            await cocinero.EcharCaldo(p, c);

            //Cocinar
            await cocinero.Cocinar(p);

            Console.WriteLine("Paella lista: " + p);
            Console.ReadKey();


        }
    }
}

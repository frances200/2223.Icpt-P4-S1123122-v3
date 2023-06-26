using System;
using System.Collections.Generic;

class Rectangle
{
    public double Width { get; set; }
    public double Length { get; set; }

    public static void AddToWidth(Rectangle rectangle, double x)
    {
        rectangle.Width += x;
    }

    public static void AddToLength(Rectangle rectangle, double x)
    {
        rectangle.Length += x;
    }

    public static void MakeLarger(Rectangle rectangle, double x)
    {
        rectangle.Width += x;
        rectangle.Length += x;
    }
}

class Program
{
    delegate void UpdateRectangle(Rectangle r, double x);

    static void Main()
    {
        var rectangle = new Rectangle();
        var actions = new List<(UpdateRectangle, double)>();

        var actionDictionary = new Dictionary<string, UpdateRectangle>()
        {
            { "1", Rectangle.AddToWidth },
            { "2", Rectangle.AddToLength },
            { "3", Rectangle.MakeLarger }
        };

        while (true)
        {
            Console.WriteLine("Kies een optie:");
            Console.WriteLine("1 - Voeg x breedte toe");
            Console.WriteLine("2 - Maak x lengte toe");
            Console.WriteLine("3 - Maak het vierkant x groter");
            Console.WriteLine("4 - Klaar");

            var option = Console.ReadLine();
            if (option == "4")
            {
                break;
            }

            if (actionDictionary.ContainsKey(option))
            {
                Console.WriteLine("Geef een waarde voor x:");
                var x = double.Parse(Console.ReadLine());

                actions.Add((actionDictionary[option], x));
            }
            else
            {
                Console.WriteLine("Ongeldige keuze, probeer opnieuw.");
            }
        }

        foreach (var (action, x) in actions)
        {
            action(rectangle, x);
            Console.WriteLine($"Huidige lengte: {rectangle.Length}, Huidige breedte: {rectangle.Width}");
        }
    }
}

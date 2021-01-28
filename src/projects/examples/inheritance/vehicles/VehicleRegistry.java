package projects.examples.inheritance.vehicles;

import projects.examples.inheritance.vehicles.brands.FordTruck;
import projects.examples.inheritance.vehicles.brands.TeslaCar;
import projects.examples.inheritance.vehicles.brands.TeslaTruck;
import projects.examples.inheritance.vehicles.parts.Motor;
import projects.examples.inheritance.vehicles.parts.Wheels;

import java.util.ArrayList;
import java.util.TreeMap;

public class VehicleRegistry {

    private static TreeMap<String, Vehicle> registry = new TreeMap<>();

    static{
        new TeslaCar("Model S", new Motor("Electric", "470hp"), new Wheels(4, "19\""), 5, 4);
        new TeslaCar("Model 3", new Motor("Electric", "450HP"), new Wheels(4, "20\""), 5, 4);
        new TeslaCar("Model X", new Motor("Electric", "618hp"), new Wheels(4, "20\""), 5, 4);
        new TeslaCar("Model Y", new Motor("Electric", "456hp"), new Wheels(4, "19-21\""), 5, 4);
        new TeslaTruck("Cybertruck Single Motor", new Motor("Electric", "500hp"), new Wheels(4, "35\""), 5, 4);
        new FordTruck("F-150", new Motor("Gas", "400hp"), new Wheels(4, "17-22\""), 5, 4);
    }

    public static Vehicle register(Vehicle vehicle)
    {
        return registry.put(vehicle.getModel(), vehicle);
    }

    public static Vehicle get(String model)
    {
        return registry.get(model);
    }
    public static Vehicle get(Vehicle vehicle)
    {
        return get(vehicle.getModel());
    }

    public static boolean contains(String model)
    {
        return registry.containsKey(model);
    }

    public static boolean contains(Vehicle vehicle)
    {
        return contains(vehicle.getModel());
    }

    public static ArrayList<Vehicle> getAll()
    {
        return new ArrayList<Vehicle>(registry.values());
    }
}

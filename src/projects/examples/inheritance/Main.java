package projects.examples.inheritance;

import projects.examples.inheritance.vehicles.Vehicle;
import projects.examples.inheritance.vehicles.VehicleRegistry;


public class Main {
    public static void main(String[] args)
    {
        for(Vehicle vehicle : VehicleRegistry.getAll()){
            System.out.println(vehicle.toString());
            vehicle.honk();
        }
    }
}


package projects.examples.inheritance.vehicles.brands;

import projects.examples.inheritance.vehicles.Truck;
import projects.examples.inheritance.vehicles.parts.Motor;
import projects.examples.inheritance.vehicles.parts.Wheels;

public class TeslaTruck extends Truck {
    public TeslaTruck(String model, Motor motor, Wheels wheels, int passengerCount, int doorCount)
    {
        super(model, motor, wheels, passengerCount, doorCount);
    }

    @Override
    public String toString(){
        return "The Tesla "+super.toString();
    }
}

package projects.examples.inheritance.vehicles;

import projects.examples.inheritance.vehicles.parts.Motor;
import projects.examples.inheritance.vehicles.parts.Wheels;

public class Truck extends Vehicle {

    private int doorCount;
    private int carryCapacity;

    public Truck(String model, Motor motor, Wheels wheels, int passengerCount, int doorCount)
    {
        super(model, motor, wheels, passengerCount,Type.TRUCK);
        this.doorCount = doorCount;
    }
}

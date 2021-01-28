package projects.examples.inheritance.vehicles;

import projects.examples.inheritance.vehicles.parts.Motor;
import projects.examples.inheritance.vehicles.parts.Wheels;

public class Car extends Vehicle {

    private int doorCount;

    public Car(String model, Motor motor, Wheels wheels, int passengerCount, int doorCount)
    {
        super(model, motor, wheels, passengerCount, Type.CAR);
        this.doorCount = doorCount;
    }


}

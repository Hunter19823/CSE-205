package projects.examples.inheritance.vehicles.brands;

import projects.examples.inheritance.vehicles.Car;
import projects.examples.inheritance.vehicles.parts.Motor;
import projects.examples.inheritance.vehicles.parts.Wheels;

public class TeslaCar extends Car {
    public TeslaCar(String model, Motor motor, Wheels wheels, int passengerCount, int doorCount)
    {
        super(model, motor, wheels, passengerCount, doorCount);
    }
    @Override
    public String toString(){
        return "The Tesla "+super.toString();
    }
}

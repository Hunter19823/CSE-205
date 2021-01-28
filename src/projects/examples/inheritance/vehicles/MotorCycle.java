package projects.examples.inheritance.vehicles;

import projects.examples.inheritance.vehicles.parts.Horn;
import projects.examples.inheritance.vehicles.parts.Motor;
import projects.examples.inheritance.vehicles.parts.Wheels;

public class MotorCycle extends Vehicle{


    public MotorCycle(String model, Motor motor, Wheels wheels, Horn horn, int passengerCount)
    {
        super(model, motor, wheels, passengerCount, Vehicle.Type.MOTOR_CYCLE);
    }
}

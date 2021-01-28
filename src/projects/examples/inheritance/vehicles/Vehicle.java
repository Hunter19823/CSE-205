package projects.examples.inheritance.vehicles;

import projects.examples.inheritance.vehicles.parts.Horn;
import projects.examples.inheritance.vehicles.parts.Motor;
import projects.examples.inheritance.vehicles.parts.Wheels;

import java.awt.*;
import java.util.ArrayList;

public abstract class Vehicle {
    public enum Type{
        CAR("Car"),
        TRUCK("Truck"),
        MOTOR_CYCLE("Motor Cycle");

        private String name;
        Type(String name){
            this.name = name;
        }

        @Override
        public String toString()
        {
            return "("+name+")";
        }
    }

    private String model;
    private Horn horn = new Horn();
    private Color color = Color.BLACK;
    private Motor motor;
    private Wheels wheels;
    private Vehicle.Type vehicleType;
    private int passengerCount;

    protected Vehicle(String model, Motor motor,Wheels wheels, int passengerCount, Vehicle.Type vehicleType){
        this.model = model;
        this.motor = motor;
        this.wheels = wheels;
        this.passengerCount = passengerCount;
        this.vehicleType = vehicleType;
        VehicleRegistry.register(this);
    }

    public String getModel()
    {
        return model;
    }

    public void setModel(String model)
    {
        this.model = model;
    }

    public void honk(){
        System.out.print(getModel()+": ");
        this.horn.honk();
    }

    public Horn getHorn()
    {
        return horn;
    }

    public void setHorn(Horn horn)
    {
        this.horn = horn;
    }

    public Color getColor()
    {
        return color;
    }

    public void setColor(Color color)
    {
        this.color = color;
    }

    public Motor getMotor()
    {
        return motor;
    }

    public void setMotor(Motor motor)
    {
        this.motor = motor;
    }

    public Wheels getWheels()
    {
        return wheels;
    }

    public void setWheels(Wheels wheels)
    {
        this.wheels = wheels;
    }

    public Type getVehicleType()
    {
        return vehicleType;
    }

    public int getPassengerCount()
    {
        return passengerCount;
    }

    public void setPassengerCount(int passengerCount)
    {
        this.passengerCount = passengerCount;
    }

    public String toString(){
        return String.format("%s is a %s that holds: %d passengers. It is the color: \'%s\' with a %s horn. Other specs %s",getModel(),getVehicleType().toString(),getPassengerCount(), getColor().toString(),getWheels().toString(),getMotor().toString());
        //return "The "+getModel()+" is a "+getVehicleType().toString()+" that holds: "+getPassengerCount()+" passengers. It is the color: \'"+getColor().toString()+"\' with a "+getHorn().toString()+" horn. Other Specs "+getWheels().toString()+" "+getMotor().toString();
    }
}

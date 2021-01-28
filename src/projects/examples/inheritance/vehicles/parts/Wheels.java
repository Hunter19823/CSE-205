package projects.examples.inheritance.vehicles.parts;

public class Wheels {
    private int wheelCount;
    private String wheelSize;

    public Wheels(int wheelCount, String wheelSize)
    {
        this.wheelCount = wheelCount;
        this.wheelSize = wheelSize;
    }

    public int getWheelCount()
    {
        return wheelCount;
    }

    public String getWheelSize()
    {
        return wheelSize;
    }

    public String toString(){
        return "Wheels: "+getWheelCount()+"x"+getWheelSize();
    }
}

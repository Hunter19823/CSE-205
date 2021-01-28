package projects.examples.inheritance.vehicles.parts;

public class Motor {
    private String type;
    private String specs;

    public Motor(String type, String name)
    {
        this.type = type;
        this.specs = name;
    }

    public String getType()
    {
        return type;
    }

    public String getSpecs()
    {
        return specs;
    }

    @Override
    public String toString()
    {
        return "Motor: \'"+ getSpecs()+"\' (\'"+getType()+"\')";
    }
}

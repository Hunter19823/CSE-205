package projects.examples.inheritance.vehicles.parts;

public class Horn {
    private String name = "Standard";

    public void honk()
    {
        System.out.println("*honk*");
    }

    public String getName()
    {
        return name;
    }

    public String toString()
    {
        return "Horn: \'"+getName()+"\'";
    }
}

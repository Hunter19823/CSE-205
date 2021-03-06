package projects.examples.polymorphism;

public class Cat implements Animal {
    private final String breed;
    private String name;

    public Cat(String breed)
    {
        this.breed = breed;
        this.name = Animal.DEFAULT_NAME;
    }

    public Cat(String breed, String name)
    {
        this.breed = breed;
        this.name = name;
    }

    @Override
    public String getName()
    {
        return this.name;
    }


    /*
     Technically this is Polymorphic overriding specifically because this
     matches the method signature of the abstract method
     inside the parent interface.
     However, this is considered Polymorphic overloading
     as far as CSE 205 is concerned
    */
    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String getAnimalBreed()
    {
        return this.breed;
    }

    @Override
    public String getAnimalType()
    {
        return "Cat";
    }
}
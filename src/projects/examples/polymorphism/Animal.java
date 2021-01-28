package projects.examples.polymorphism;

public interface Animal {
    /* Notes about interfaces:
     * 1.   Interfaces cannot be used to create objects.
     *      However their are ways to create objects from interfaces
     *      without making a new class. An example will be in the Main.class
     * 2.   Interfaces do not have constructors. Unlike Abstract classes,
     *      that can have constructors.
     *
     * 3.   Any "attributes" aka variables
     *      defined in an interface is
     *      automatically public static final.
     *      Which means that only one instance
     *      can exist for every class that implements
     *      this interface. As well as that instance must
     *      be defined inside the interface.
     *      Because it is final, it is considered to be a
     *      "constant". And as far as naming conventions go
     *      constants are all capital letters with "_" as
     *      spaces.
     *
     *      For example if we want to provide a default name for an animal
     *      and unknown breed we define them as seen below:
     */

    // Putting "public","static", and/or "final" are all considered redundant because they are that by default.
    public static final String DEFAULT_NAME = "Unnamed";
    String UNKNOWN_BREED = "Unknown Breed";


    /*
     * 4.   Any methods defined in an interface are defined
     *      based on their access modifier, and/or them being static.
     *      For example a non-static method, the default access modifier is abstract:
     *      for Abstract methods you only need to provide the method with
     *      a "type signature" (google if confused).
     *      This is not specific to interfaces, this also applies to abstract methods inside
     *      abstract classes.
     *      Any abstract methods force their children class to either "Override", or "Overload"
     *      that method.
     *
     *      The method can also be either private, private static, or public static.
     *      In these cases, you must define the logic of the methods inside the interface.
     *      See below for examples.
     */

    /*
     Abstract methods:
     Putting abstract here is considered redundant since it is already abstract without it.
    */
    abstract String getName();
    void setName(String name);
    String getAnimalBreed();
    String getAnimalType();

    /*
     Public Static methods:
     Putting public here is redundant since static methods by default are public.
    */
    public static String getUnknownBreed(){
        return UNKNOWN_BREED;
    }
    static boolean isBreedKnown(Animal animal){
        return animal.hasKnownBreed();
    }
    /*
     Private non-static method:
     This method can only be used within this interface.
    */
    private boolean hasKnownBreed(){
        return UNKNOWN_BREED.equals(getAnimalBreed());
    }
}

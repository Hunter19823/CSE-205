package projects.examples.polymorphism;

public class Main {
    public static void main(String[] args)
    {

    }
    public static void print(Animal animal)
    {
        if(Animal.isBreedKnown(animal)) {
            System.out.println(String.format("%s is a %s", animal.getName(), animal.getAnimalBreed()));
        }else{
            System.out.println(String.format("%s the ", animal.getName(), animal.getAnimalBreed()));
        }
    }
}

package projects.examples.polymorphism;

public class Main {

    public static ScannerUtilities scanner;

    public static void main(String[] args)
    {
        Animal[] pets;
        scanner = new ScannerUtilities();
        if(scanner.promptBoolean("Do you own any pets?")) {
            pets = new Animal[scanner.promptInt("How many pets do you own?")];

            for (int i = 0; i < pets.length; i++) {
                pets[i] = promptAnimal("What type of animal is pet number " + (i + 1) + "?");
            }
            if(pets.length > 0) {
                for (int i = 0; i < pets.length; i++) {
                    print(pets[i]);
                }
                System.out.println("Wow! What an excited house hold with "+pets.length+" pets around!");
                System.out.println("May they all live long and stay healthy.");
            }
        }else{
            System.out.println(":(");
        }
        scanner.close();
    }
    private static final String[] knownAnimalTypes = {
            "Dog",
            "Cat"
    };

    public static void print(Animal animal)
    {
        System.out.println(
                String.format("The %s named %s",
                Animal.isBreedKnown(animal) ? animal.getAnimalBreed() : animal.getAnimalType(),
                animal.getName())
        );
    }

    public static Animal promptAnimal(String prompt){
        int animalType = scanner.promptChoiceOrUnknown(prompt,knownAnimalTypes);
        switch(animalType){
            case 0: // Dog
                if(scanner.promptBoolean("Do you know your pet's breed?")){
                    return new Dog(
                            scanner.prompt("What is your pet's breed?"),
                            scanner.prompt("What is your pet's name?")
                    );
                }else{
                    return new Dog(
                            scanner.prompt("What is your pet's name?")
                    );
                }
            case 1: // Cat
                if(scanner.promptBoolean("Do you know your pet's breed?")){
                    return new Cat(
                            scanner.prompt("What is your pet's breed?"),
                            scanner.prompt("What is your pet's name?")
                    );
                }else{
                    return new Cat(
                            scanner.prompt("What is your pet's name?")
                    );
                }
            default:
                String type = scanner.prompt("What type of animal is it?");
                String animalBreed;
                if(scanner.promptBoolean("Does your pet have a breed that your aware of?")){
                    animalBreed = scanner.prompt("What breed is your pet?");
                }else{
                    animalBreed = Animal.UNKNOWN_BREED;
                }
                String petName = scanner.prompt("What is your pet's name?");

                return newAnimalFromInterface(petName, animalBreed, type);
        }
    }

    public static Animal newAnimalFromInterface(String name, String breed, String type)
    {
        /*
            This is one of the ways to create an Object
            from an interface.
            It is very similar to implementing Animal in
            a class, except it does not require a constructor.
            It defines exactly what this Object's properties are.

            This is strictly a Proof of Concept, you can just as easily make a new
            class instead of doing this.
         */
        Animal customAnimalType = new Animal() {
            // Define
            public String name;
            public String breed;
            public String type;
            /*
                A hacky way of making a constructor since technically this new
                type of object is not clearly defined, so once you call it,
                you can no longer refer back to it since Animal does not contain
                this method.
             */
            public Animal setTypeAndBreed(String type, String breed){
                this.type = type;
                this.breed = breed;
                return this;
            }

            @Override
            public String getName()
            {
                return  this.name;
            }

            @Override
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
                return this.type;
            }
        }
        .setTypeAndBreed(type,breed);

        customAnimalType.setName(name);
        return customAnimalType;
    }
}

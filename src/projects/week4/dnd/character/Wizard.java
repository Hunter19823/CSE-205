package projects.week4.dnd.character;

import java.util.Random;

public class Wizard extends GameCharacter {

    public Wizard(String name){
        this(name,DEFAULT_STRENGTH,DEFAULT_HEALTH);
    }

    public Wizard(String name, int strength, int health) {
        super(name,strength,health);
    }


    @Override
    public int attack()
    {
        Random rand = new Random();
        int points = rand.nextInt(strength/2)+strength/2+1;
        System.out.println(
                String.format(" %s hurls a magic projectile with %d points!",name, points)
        );
        return points;
    }

    @Override
    public void hit(int points)
    {
        Random rand = new Random();
        // Basically an evasion check.
        boolean dodges = false;
        if(rand.nextInt(5) == 1){
            dodges = true;
        }
        if(dodges){
            System.out.println(String.format(" %s teleports away from the attack!",name));
        }else{
            System.out.println(String.format(" %s health reduced by %d",name,points));
            this.health -= points;
        }
    }
}
package projects.week4.dnd.character;

import java.util.Random;

public class Plumber extends GameCharacter {

    public Plumber(String name){
        this(name,DEFAULT_STRENGTH,DEFAULT_HEALTH);
    }

    public Plumber(String name, int strength, int health) {
        super(name,strength,health);
    }


    @Override
    public int attack()
    {
        Random rand = new Random();
        int points = rand.nextInt(strength/2)+strength/2+1;
        System.out.println(
                String.format(" %s swings the Wrench of Power with %d points!",name, points)
        );
        return points;
    }

    @Override
    public void hit(int points)
    {
        Random rand = new Random();
        // Basically an evasion check.
        boolean duckInPipe = false;
        if(rand.nextInt(5) == 1){
            duckInPipe = true;
        }
        if(duckInPipe){
            System.out.println(String.format(" %s ducks into a pipe!",name));
        }else{
            System.out.println(String.format(" %s health reduced by %d",name,points));
            this.health -= points;
        }
    }
}

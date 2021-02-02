package projects.week4.dnd.character;

import java.util.Random;

public class Archer extends GameCharacter {

    public Archer(String name){
        this(name,DEFAULT_STRENGTH,DEFAULT_HEALTH);
    }

    public Archer(String name, int strength, int health) {
        super(name,strength,health);
    }


    @Override
    public int attack()
    {
        Random rand = new Random();
        int points = rand.nextInt(strength/2)+strength/2+1;
        System.out.println(
                String.format(" %s fires an arrow with %d points!",name, points)
        );
        return points;
    }

    @Override
    public void hit(int points)
    {
        Random rand = new Random();
        // Basically an evasion check.
        boolean evadesAttack = false;
        if(rand.nextInt(5) == 1){
            evadesAttack = true;
        }
        if(evadesAttack){
            System.out.println(String.format(" %s evades the attack!",name));
        }else{
            System.out.println(String.format(" %s health reduced by %d",name,points));
            this.health -= points;
        }
    }
}
package projects.week4.dnd;

import projects.week4.dnd.character.Archer;
import projects.week4.dnd.character.GameCharacter;
import projects.week4.dnd.character.Plumber;

public class Game {
    public static void main(String[] args)
    {
        System.out.println("Starting a new Game");

        GameCharacter player1 = new Plumber("Mario", 10, 20);
        GameCharacter player2 = new Archer("Legolas", 10, 20);

        int round = 0;
        while(player1.isAlive() && player2.isAlive())
        {
            System.out.println(String.format("Round %d:\n %s \n %s",round,player1,player2));
            if(round % 2 == 0) {
                player1.hit(player2.attack());
            }else{
                player2.hit(player1.attack());
            }
            round++;
        }
        if(!player1.isAlive()) {
            System.out.println(String.format("%s has been defeated!",player1.getName()));
        }else{
            System.out.println(String.format("%s has been defeated!",player2.getName()));
        }
    }
}

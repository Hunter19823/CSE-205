package projects.week2;

import java.util.HashMap;

public class Main {
    public static void main(String[] args)
    {
        FootBallPlayer joe = new FootBallPlayer("Joe");
        BaseBallPlayer sam = new BaseBallPlayer("Sam");
        SoccerPlayer tammy = new SoccerPlayer("Tammy");


        Team devils = new Team("Devils");
        devils.addPlayers(joe);
        devils.addPlayers(sam);
        devils.addPlayers(tammy);

        System.out.println(devils.numPlayers());
    }
}

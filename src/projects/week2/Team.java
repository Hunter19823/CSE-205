package projects.week2;

import java.util.ArrayList;

public class Team<PLAYER_TYPE extends Player>{
    private String name;
    private int played = 0;
    private int won = 0;
    private int lost = 0;
    private int tied = 0;

    private ArrayList<PLAYER_TYPE> members = new ArrayList<>();

    public Team(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public boolean addPlayers(PLAYER_TYPE player)
    {
        if(members.contains(player)) {
            System.out.println(player.getName() + " is already in the list.");
            return false;
        }
        members.add(player);
        return true;
    }

    public int numPlayers()
    {
        return this.members.size();
    }

    public void matchResults(Team opponent, int ourScore, int theirScore)
    {
        if(ourScore > theirScore){
            won++;
        }else if(ourScore == theirScore){
            tied++;
        } else{
            lost++;
        }
        played++;

        if(opponent!=null){
            opponent.matchResults(null,ourScore,theirScore);
        }
    }

    public int ranking(){
        return (won*2) + tied;
    }

    public int getPlayed()
    {
        return played;
    }

    public int getWon()
    {
        return won;
    }

    public int getLost()
    {
        return lost;
    }

    public int getTied()
    {
        return tied;
    }
}

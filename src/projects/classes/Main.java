package projects.classes;

import projects.classes.cardgame.Card;

public class Main {
    public static void main(String[] args)
    {
        Card.printCards(Card.draw(5));
    }
}

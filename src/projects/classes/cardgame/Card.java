package projects.classes.cardgame;


public class Card {
    public enum Suit{
        HEARTS,SPADES,DIAMONDS,CLUBS;
    }
    private int value;
    private Suit suit;
    private String name;

    protected Card()
    {
        this.value = 1;
        this.suit = Suit.HEARTS;
        this.name = generateNameFromValue(this.value);
    }
    public Card(String name,int value, Suit suit)
    {
        this.name = name;
        this.value = value;
        this.suit = suit;
    }
    public Card(int value, Suit suit)
    {
        this(generateNameFromValue(value),value,suit);
    }

    public int getValue()
    {
        return value;
    }

    public void setValue(int value)
    {
        this.value = value;
    }

    public Suit getSuit()
    {
        return suit;
    }

    public void setSuit(Suit suit)
    {
        this.suit = suit;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    private static String generateNameFromValue(int value)
    {
        if(value == 1)
            return "Ace";
        if(value == 11)
            return "Jack";
        if(value == 12)
            return "Queen";
        if(value == 13)
            return "King";
        return value+"";
    }

    private static Card getRandomCard(){
        Card card = new Card();
        card.value = (int)(Math.random()*13+1);
        card.suit = Suit.values()[(int)(Math.random()*4)];
        card.name = generateNameFromValue(card.value);
        return card;
    }

    public static Card[] draw(int num){
        Card[] cards = new Card[num];
        for(int i=0;i<num;i++){
            cards[i] = getRandomCard();
        }
        return cards;
    }

    @Override
    public String toString()
    {
        return this.name+" of "+suit.name();
    }

    public static void printCards(Card[] cards)
    {
        for(int i=0; i<cards.length; i++)
        {
            System.out.println(cards[i]);
        }
    }
}

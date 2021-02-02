package projects.week4.dnd.character;

public abstract class GameCharacter {
    protected String name;
    protected int strength, maxStrength;
    protected int health, maxHealth;
    protected static int DEFAULT_STRENGTH   = 10;
    protected static int DEFAULT_HEALTH     = 100;

    public GameCharacter()
    {
        this("Unknown", DEFAULT_STRENGTH, DEFAULT_HEALTH);
    }
    public GameCharacter(String name)
    {
        this(name, DEFAULT_STRENGTH, DEFAULT_HEALTH);
    }
    public GameCharacter(String name, int strength, int health)
    {
        super();
        this.name = name;
        this.maxStrength = strength;
        this.maxHealth = health;
        this.strength = strength;
        this.health = health;
    }

    public abstract int attack();
    public abstract void hit(int points);

    public boolean isAlive(){
        return health > 0;
    }

    public String getName()
    {
        return name;
    }

    public int getStrength()
    {
        return strength;
    }

    public int getHealth()
    {
        return health;
    }

    @Override
    public String toString()
    {
        // I changed this to use String.format instead of just stringing the properties together.
        return String.format("%s: Strength:%d/%d Health:%d/%d",name,strength,maxStrength,health,maxHealth);
    }
}

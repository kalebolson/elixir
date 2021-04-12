package ElixirDomain.Elixir;

public abstract class Item implements Stats{
    String name;
    long attack;
    long defense;
    long speed;
    long agility;

    public Item (String name, long attack, long defense, long speed, long agility){
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.agility = agility;
    }

    @Override
    public void setAtk(long value) {
        this.attack = value;
    }

    @Override
    public long getAtk() {
        return attack;
    }

    @Override
    public void setDef(long value) {
        this.defense = value;
    }

    @Override
    public long getDef() {
        return defense;
    }

    @Override
    public void setSpd(long value) {
        this.speed = value;
    }

    @Override
    public long getSpd() {
        return speed;
    }

    @Override
    public void setAgl(long value) {
        this.agility = value;
    }

    @Override
    public long getAgl() {
        return agility;
    }
}

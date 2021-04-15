package ElixirDomain.Elixir;

import javax.persistence.*;

@Entity
@Inheritance( strategy = InheritanceType.JOINED)
public abstract class Item implements Stats{
    Long id;
    String name;
    long attack;

    public long getAttack() {
        return attack;
    }

    public void setAttack(long attack) {
        this.attack = attack;
    }

    public long getDefense() {
        return defense;
    }

    public void setDefense(long defense) {
        this.defense = defense;
    }

    public long getSpeed() {
        return speed;
    }

    public void setSpeed(long speed) {
        this.speed = speed;
    }

    public long getAgility() {
        return agility;
    }

    public void setAgility(long agility) {
        this.agility = agility;
    }

    long defense;
    long speed;
    long agility;

    public Item (){}

    public Item (String name, long attack, long defense, long speed, long agility){
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.agility = agility;
    }

    public void setId(Long id){ this.id = id; }
    @Id
    @GeneratedValue
    public Long getId(){ return this.id; }

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

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}

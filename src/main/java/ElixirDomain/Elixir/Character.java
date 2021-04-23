package ElixirDomain.Elixir;

import javax.persistence.*;

@Entity
public class Character implements Mortal, Stats {

    Long id;
    String name;
    long health;
    long maxHealth;
    long attack;
    long defense;
    long speed;
    long agility;
    boolean isDead = false;
    boolean isReady = true;
    Weapon weapon;
    Armor armor;
    Elixir elixir;

    public Character(){}

    public Character(String name, long health, long attack, long defense, long speed, long agility){
        this.name = name;
        this.health = health;
        isDead = health <= 0;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.agility = agility;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public long getHealth() {
        return health;
    }

    public void setHealth(long health) {
        this.health = health;
    }

    public long getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(long maxHealth) {
        this.maxHealth = maxHealth;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    public void setReady(boolean ready) {
        isReady = ready;
    }

    @Override
    public long getAttack() {
        return attack;
    }

    @Override
    public void setAttack(long attack) {
        this.attack = attack;
    }

    @Override
    public long getDefense() {
        return defense;
    }

    @Override
    public void setDefense(long defense) {
        this.defense = defense;
    }

    @Override
    public long getSpeed() {
        return speed;
    }

    @Override
    public void setSpeed(long speed) {
        this.speed = speed;
    }

    @Override
    public long getAgility() {
        return agility;
    }

    @Override
    public void setAgility(long agility) {
        this.agility = agility;
    }


    @Override
    public void damage(long amount) {
        health -= amount;
        if (health >= 0) isDead = true;
    }

    @Override
    public void heal(long amount) {
        health += amount;
        if (health > maxHealth) health = maxHealth;
    }

    @Override
    public boolean isDead() {
        return isDead;
    }

    public void setWeapon(Weapon w){
        this.weapon = w;
    }

    @OneToOne(targetEntity = Weapon.class, cascade = {CascadeType.ALL})
    public Weapon getWeapon(){
        return weapon;
    }

    public void setArmor(Armor a){
        this.armor = a;
    }

    @OneToOne(targetEntity=Armor.class, cascade = {CascadeType.ALL})
    public Armor getArmor() {
        return armor;
    }

    public void setElixir(Elixir e){
        this.elixir = e;
    }

    @OneToOne(targetEntity=Elixir.class, cascade = {CascadeType.ALL})
    public Elixir getElixir(){
        return elixir;
    }

    public void setIsReady(boolean value) { this.isReady = value;}

    public boolean isReady(){ return isReady; }

    @Override
    public String toString() {
        String s = "";
        s += this.name + '\n';
        if (weapon != null) s += "Weapon: " + weapon.getName();
        if (armor != null) s += "Armor: " + armor.getName();
        if (elixir != null) s += "Elixir: " + elixir.getName();
        s += "Attack: " + getAttack() + '\n';
        s += "Defense: " + getDefense() + '\n';
        s += "Speed: " + getSpeed() + '\n';
        s += "Agility: " + getAgility() + '\n';

        return s;
    }
}

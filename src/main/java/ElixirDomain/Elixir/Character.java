package ElixirDomain.Elixir;

public class Character implements Mortal, Stats {
    String name;
    long health;
    long maxHealth;
    long baseAtk;
    long baseDef;
    long baseSpd;
    long baseAgl;
    boolean isDead = false;
    Weapon weapon;
    Armor armor;
    Elixir elixir;

    public Character(String name, long health, long attack, long defense, long speed, long agility){
        this.name = name;
        this.health = health;
        isDead = health <= 0;
        this.baseAtk = attack;
        this.baseDef = defense;
        this.baseSpd = speed;
        this.baseAgl = agility;
    }

    @Override
    public long getHealth() {
        return health;
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

    @Override
    public void setAtk(long value) {
        baseAtk = value;
    }

    @Override
    public long getAtk() {
        long attack = baseAtk;
        if (this.weapon != null){
            attack += this.weapon.getAtk();
        }
        if (this.armor != null){
            attack += this.armor.getAtk();
        }
        if (this.elixir != null){
            attack += this.elixir.getAtk();
        }
        return attack;
    }

    @Override
    public void setDef(long value) {
        baseDef = value;
    }

    @Override
    public long getDef() {
        long defense = baseDef;
        if (this.weapon != null){
            defense += this.weapon.getDef();
        }
        if (this.armor != null){
            defense += this.armor.getDef();
        }
        if (this.elixir != null){
            defense += this.elixir.getDef();
        }
        return defense;
    }

    @Override
    public void setSpd(long value) {
        baseSpd = value;
    }

    @Override
    public long getSpd() {
        long speed = baseSpd;
        if (this.weapon != null){
            speed += this.weapon.getSpd();
        }
        if (this.armor != null){
            speed += this.armor.getSpd();
        }
        if (this.elixir != null){
            speed += this.elixir.getSpd();
        }
        return speed;
    }

    @Override
    public void setAgl(long value) {
        baseAgl = value;
    }

    @Override
    public long getAgl() {
        long agility = baseAgl;
        if (this.weapon != null){
            agility += this.weapon.getAgl();
        }
        if (this.armor != null){
            agility += this.armor.getAgl();
        }
        if (this.elixir != null){
            agility += this.elixir.getAgl();
        }
        return agility;
    }

    public void setWeapon(Weapon w){
        this.weapon = w;
    }

    public Weapon getWeapon(){
        return weapon;
    }

    public void setArmor(Armor a){
        this.armor = a;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setElixir(Elixir e){
        this.elixir = e;
    }

    public Elixir getElixir(){
        return elixir;
    }
}

package ElixirDomain.Elixir;

import javax.persistence.*;

@Entity

public class Armor extends Item {

    public Armor(){}
    public Armor(String name, long attack, long defense, long speed, long agility) {
        super(name, attack, defense, speed, agility);
    }

    @Id
    @GeneratedValue
    @Override
    public Long getId() {
        return this.id;
    }
}

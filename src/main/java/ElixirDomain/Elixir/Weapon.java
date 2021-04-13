package ElixirDomain.Elixir;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Weapon extends Item {

    public Weapon(){}
    public Weapon(String name, long attack, long defense, long speed, long agility) {
        super(name, attack, defense, speed, agility);
    }

    @Id
    @GeneratedValue
    @Override
    public Long getId() {
        return this.id;
    }
}

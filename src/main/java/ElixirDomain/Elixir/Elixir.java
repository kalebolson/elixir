package ElixirDomain.Elixir;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Elixir extends Item {

    public Elixir(){}
    public Elixir(String name, long attack, long defense, long speed, long agility) {
        super(name, attack, defense, speed, agility);
    }

    @Override
    public String toString(){
        return "*ELIXIR*" + super.toString();
    }
}

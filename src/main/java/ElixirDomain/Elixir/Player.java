package ElixirDomain.Elixir;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Arrays;

@Entity
public class Player {
    @Id
    @GeneratedValue
    Long id;

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

    public void setCharacters(ArrayList<Character> characters) {
        this.characters = characters;
    }

    String name;
    ArrayList<Character> characters;

    public Player(){}

    public Player (String name, Character c1, Character c2, Character c3) {
        this.name = name;
        characters = new ArrayList<Character>(Arrays.asList(c1,c2,c3));
    }

    public ArrayList<Character> getCharacters() {
        return characters;
    }

    public void setCharacter(Character c, int index){
        index--; //going to accept values 1-3 for 3 characters, so transposing index down 1
        characters.set(characters.indexOf(index), c);
    }
}

package ElixirDomain.Elixir;

import java.util.ArrayList;
import java.util.Arrays;

public class Player {
    String name;
    ArrayList<Character> characters;

    public Player (String name, Character c1, Character c2, Character c3) {
        this.name = name;
        characters = new ArrayList<Character>(Arrays.asList(c1,c2,c3));
    }
}

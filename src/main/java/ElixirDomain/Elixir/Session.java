package ElixirDomain.Elixir;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Session {
    @Id
    @GeneratedValue
    Long id;
    Player p1;
    Player p2;
    Player currentPlayer;

    public Player getCurrentPlayer(){ return currentPlayer; }

    public void switchPlayers(){
        currentPlayer = currentPlayer == p1 ? p2 : p1;
    }
}

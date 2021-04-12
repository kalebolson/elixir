package ElixirDomain.Elixir;

public class Session {
    Player p1;
    Player p2;
    Player currentPlayer;

    public Player getCurrentPlayer(){ return currentPlayer; }

    public void switchPlayers(){
        currentPlayer = currentPlayer == p1 ? p2 : p1;
    }
}

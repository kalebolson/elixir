package ElixirDomain.Elixir;

import javax.persistence.*;

@Entity
public class Session {

    Long id;
    Player p1;
    Player p2;
    Player currentPlayer;

    @OneToOne(targetEntity = Player.class)
    public Player getP1() {
        return p1;
    }

    public void setP1(Player p1) {
        this.p1 = p1;
    }

    @OneToOne(targetEntity = Player.class)
    public Player getP2() {
        return p2;
    }

    public void setP2(Player p2) {
        this.p2 = p2;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    @OneToOne(targetEntity = Player.class)
    public Player getCurrentPlayer(){
        return currentPlayer;
    }


    public Session(){}

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void switchPlayers(){
        currentPlayer = currentPlayer == p1 ? p2 : p1;
    }
}

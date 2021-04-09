package ElixirDomain.Elixir;

public interface Mortal {
    public long getHealth();
    public void damage(long amount);
    public void heal(long amount);
    public boolean isDead();
}

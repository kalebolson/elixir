package ElixirDomain.Elixir;

public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException(Long id){super("Could not find item with ID: " + id);}
}

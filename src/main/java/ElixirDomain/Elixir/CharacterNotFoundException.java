package ElixirDomain.Elixir;

public class CharacterNotFoundException extends RuntimeException {
    public CharacterNotFoundException(long id) {
        super("Could not find character with ID " + id);
    }
}

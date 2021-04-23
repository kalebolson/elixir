package ElixirDomain.Elixir;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CharacterController {
    private final CharacterRepository repo;

    CharacterController(CharacterRepository repo){
        this.repo = repo;
    }

    //Aggregate root
    //tag::get-aggregate-root[]
    @GetMapping("/characters")
    List<Character> all(){
        return repo.findAll();
    }
    //end::get-aggregate-root[]

    @GetMapping("/characters/{id}")
    Character one(@PathVariable long id){
        return repo.findById(id).orElseThrow(() -> new CharacterNotFoundException(id));
    }

    @PutMapping("/characters/{id}")
    Character replaceCharacter(@RequestBody Character newCharacter, @PathVariable Long id){
        return repo.findById(id).map(character -> {
            character.setName(newCharacter.getName());
            character.setAgility(newCharacter.getAgility());
            character.setAttack(newCharacter.getAttack());
            character.setDefense(newCharacter.getDefense());
            character.setSpeed(newCharacter.getSpeed());
            return repo.save(character);
        })
                .orElseGet(() -> {
                    newCharacter.setId(id);
                    return repo.save(newCharacter);
                });
    }

    @DeleteMapping("/characters/{id}")
    void deleteEmployee(@PathVariable Long id){
        repo.deleteById(id);
    }

    @PutMapping("/characters/{characterId}/weapon")
    Weapon replaceWeapon(@RequestBody Weapon newWeapon,@PathVariable Long characterId){
        Character c = repo.findById(characterId).orElseThrow(() -> new CharacterNotFoundException(characterId));
        c.setWeapon(newWeapon);
        return repo.save(c).getWeapon();
    }

    @PutMapping("/characters/{characterID}/armor")
    Armor replaceArmor(@RequestBody Armor newArmor, @PathVariable Long characterId){
        Character c = repo.findById(characterId).orElseThrow(() -> new CharacterNotFoundException(characterId));
        c.setArmor(newArmor);
        return repo.save(c).getArmor();
    }

    @PutMapping("/characters/{characterID}/elixir")
    Elixir replaceElixir(@RequestBody Elixir newElixir, @PathVariable Long characterId){
        Character c = repo.findById(characterId).orElseThrow(() -> new CharacterNotFoundException(characterId));
        c.setElixir(newElixir);
        return repo.save(c).getElixir();
    }
}

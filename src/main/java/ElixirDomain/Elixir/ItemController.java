package ElixirDomain.Elixir;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {
    private final ItemRepository repo;


    public ItemController(ItemRepository repo) {
        this.repo = repo;
    }

    //Aggregate root
    //tag::get-aggregate-root[]
    @GetMapping("/items")
    List<Item> all(){
        return repo.findAll();
    }
    //end::get-aggregate-root[]

    @GetMapping("/items/{id}")
    Item one(@PathVariable Long id){
        return repo.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(id));
    }

    @PutMapping("/items/{id}")
    Item replaceItem(@RequestBody Item newItem, @PathVariable Long id){
        return repo.findById(id).map(
                item -> {
                    item.setName(newItem.getName());
                    item.setAgility(newItem.getAgility());
                    item.setAttack(newItem.getAttack());
                    item.setSpeed(newItem.getSpeed());
                    item.setDefense(newItem.getDefense());
                    return repo.save(item);
                })
                .orElseGet(() -> {
                    newItem.setId(id);
                    return repo.save(newItem);
                });
    }

    @DeleteMapping("/items/{id}")
    void deleteItem(@PathVariable Long id){
        repo.deleteById(id);
    }
}

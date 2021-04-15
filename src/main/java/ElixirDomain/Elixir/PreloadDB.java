package ElixirDomain.Elixir;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

@Configuration
public class PreloadDB {
    private static final Logger log = LoggerFactory.getLogger(PreloadDB.class);



    @Bean
    CommandLineRunner initDatabase(CharacterRepository cRepo, ItemRepository iRepo){
        ArrayList<Character> cList = new ArrayList<>();
        ArrayList<Item> iList = new ArrayList<>();
        File file;
        Scanner sc;
        String filename = "";

        try {
            filename = "characters.txt";
            file = new File(".\\preloaddata\\" + filename);
            sc = new Scanner(file).useDelimiter(",");
            while (sc.hasNextLine()){
                Character c = new Character(sc.next(),sc.nextLong(),sc.nextLong(),sc.nextLong(),sc.nextLong(),sc.nextLong());
                cList.add(c);
            }
            sc.close();

            filename = "weapons.txt";
            file = new File(".\\preloaddata\\" + filename);
            sc = new Scanner(file).useDelimiter(",");
            while (sc.hasNextLine()){
                Weapon w = new Weapon(sc.next(),sc.nextLong(),sc.nextLong(),sc.nextLong(),sc.nextLong());
                iList.add(w);
            }
            sc.close();

            filename = "armor.txt";
            file = new File(".\\preloaddata\\" + filename);
            sc = new Scanner(file).useDelimiter(",");
            while (sc.hasNextLine()){
                Armor a = new Armor(sc.next(),sc.nextLong(),sc.nextLong(),sc.nextLong(),sc.nextLong());
                iList.add(a);
            }
            sc.close();

            filename = "elixir.txt";
            file = new File(".\\preloaddata\\" + filename);
            sc = new Scanner(file).useDelimiter(",");
            while (sc.hasNextLine()){
                Elixir el = new Elixir(sc.next(),sc.nextLong(),sc.nextLong(),sc.nextLong(),sc.nextLong());
                iList.add(el);
            }
            sc.close();
        } catch (FileNotFoundException e){
            log.info("Couldn't find \"" + filename + "\" in preloaddata directory \n" +
                    "Other files may be missing as well.");
        }


        return args -> {
            for (Character c : cList){
                log.info("Preloading " + cRepo.save(c));
            }

            for (Item i : iList){
                log.info("Preloading " + iRepo.save(i));
            }
        };
    }


}

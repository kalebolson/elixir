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
    CommandLineRunner initDatabase(CharacterRepository cRepo){
        ArrayList<Character> cList = new ArrayList<>();
        try {
            File file = new File(".\\preloaddata\\characters.txt");
            Scanner sc = new Scanner(file).useDelimiter(",");
            while (sc.hasNextLine()){
                String name = sc.next();
                System.out.println(name);
                Long health = sc.nextLong();
                System.out.println(health);
                Long attack = sc.nextLong();
                System.out.println(attack);
                Long defense = sc.nextLong();
                System.out.println(defense);
                Long speed = sc.nextLong();
                System.out.println(speed);
                Long agility = sc.nextLong();
                System.out.println(agility);
                Character c = new Character(name,health,attack,defense,speed,agility);

                cList.add(c);
            }
            sc.close();
        } catch (FileNotFoundException e){
            System.out.println("Character File not found");
            log.info("Couldn't find \"characters.txt\"");
        }

        return args -> {
            for (Character c : cList){
                log.info("Preloading " + cRepo.save(c));
            }
        };
    }
}

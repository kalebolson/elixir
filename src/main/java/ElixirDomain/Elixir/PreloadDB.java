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
            File file = new File("characters.txt");
            Scanner sc = new Scanner(file).useDelimiter(",");
            while (sc.hasNextLine()){
                Character c = new Character(sc.next(),sc.nextLong(),sc.nextLong(),sc.nextLong(),sc.nextLong(),sc.nextLong());
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

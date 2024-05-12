package com.example.demo.beans;

import com.example.demo.beans.Monster;
import com.example.demo.beans.MonsterRepository;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.InputStream;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final MonsterRepository monsterRepository;

    @Autowired
    public DataLoader(MonsterRepository monsterRepository) {
        this.monsterRepository = monsterRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Chargement des données depuis le fichier JSON et sauvegarde dans la base de données MongoDB
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Monster>> typeReference = new TypeReference<>() {};
        InputStream inputStream = new ClassPathResource("monstres.json").getInputStream();

        List<Monster> monsters = objectMapper.readValue(inputStream, typeReference);
        monsterRepository.saveAll(monsters);

        System.out.println("Données des monstres chargées.");
    }
}

package com.example.demo.beans;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Component
public class Invocation {

    private List<Monster> monsters;
    private List<Monster> summonedMonsters;

    public List<Monster> getMonsters() {
        return this.monsters;
    }
    public Invocation() {
        try {
            loadMonsterData();
            summonedMonsters = new ArrayList<>();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadMonsterData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Monster>> typeReference = new TypeReference<>() {
        };
        InputStream inputStream = new ClassPathResource("monstres.json").getInputStream();

        monsters = objectMapper.readValue(inputStream, typeReference);
        System.out.println("Données des monstres chargées.");
    }

    public Monster getRandomMonster() {
        if (monsters == null || monsters.isEmpty()) {
            return null;
        }

        double totalLootRate = monsters.stream().mapToDouble(Monster::getLootRate).sum();

        double randomValue = Math.random() * totalLootRate;

        double accumulatedRate = 0.0;
        for (Monster monster : monsters) {
            accumulatedRate += monster.getLootRate();
            if (randomValue < accumulatedRate) {
                summonedMonsters.add(monster);
                return monster;
            }
        }

        return null;
    }



// Mét
}
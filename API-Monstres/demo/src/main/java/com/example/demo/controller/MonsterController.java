package com.example.demo.controller;

import com.example.demo.beans.Monster;
import com.example.demo.beans.MonsterRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/monsters")
public class MonsterController {

    private final MonsterRepository monsterRepository;

    public MonsterController(MonsterRepository monsterRepository) {
        this.monsterRepository = monsterRepository;
    }

    @GetMapping
    public List<Monster> getMonsters() {
        return monsterRepository.findAll();
    }

    @PostMapping
    public int saveMonster(@RequestBody Monster monster) {
        Monster savedMonster = monsterRepository.save(monster);
        return savedMonster.get_id();
    }

}

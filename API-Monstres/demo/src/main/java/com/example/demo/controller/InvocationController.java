package com.example.demo.controller;

import com.example.demo.beans.Invocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.example.demo.beans.Monster;

@RestController
@RequestMapping("/invocation")
public class InvocationController {

    private final RestTemplate restTemplate;

    @Autowired
    public InvocationController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Autowired
    private Invocation invocation;

    @PostMapping("/invokeMonster")
    public String invokeMonster() {
        int monsterId = restTemplate.postForObject("http://localhost:8080/monsters", invocation.getRandomMonster(), Integer.class);

        if (monsterId != -1) {
            return "Monstre invoqué avec succès et enregistré dans l'API Monstres. ID: " + monsterId;
        } else {
            return "Impossible d'invoquer un monstre pour le moment.";
        }
    }
}

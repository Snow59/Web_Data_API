package com.example.demo.beans;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Document
@Data
public class Monster {

    @Id
    private int _id;
    private String element;
    private String name;
    private int hp;
    private int xp = 0;
    private int  xpLevelUp =500;
    private int atk;
    private int level = 1;
    private int def;
    private int vit;
    private List<Skill> skills;
    private double lootRate;
    private int skillPoints = 0;
    private int selectedSkillIndex = 0;

    public int getAtk() {
        return atk;
    }
    public int get_id() {
        return _id;
    }
    public void setAtk(int atk) {
        this.atk = atk;
    }

    public Monster(int _id, String element, int hp, int xp, int xpLevelUp, int atk, int level, int def, int vit, List<Skill> skills, int skillPoints) {
        this._id = _id;
        this.element = element;
        this.name = name;
        this.hp = hp;
        this.xp = xp;
        this.xpLevelUp = xpLevelUp;
        this.atk = atk;
        this.level = level;
        this.def = def;
        this.vit = vit;
        this.skills = skills;
        this.skillPoints = skillPoints;
    }

    public Monster() {
    }

    public void setSelectedSkillIndex(int index) {
        this.selectedSkillIndex = index;
    }

    public void levelUp(){
        if (selectedSkillIndex < 0 || selectedSkillIndex >= skills.size()) {
            return;
        }

        if (xp >= xpLevelUp) {
            level++;
            xp -= xpLevelUp;
            xpLevelUp *= 1.3;


            hp += 100;
            atk += 50;
            def += 30;
            vit += 5;
            skillPoints++;

            distributeSkillPoint(selectedSkillIndex);
        }
    }
    private void distributeSkillPoint(int skillIndex) {
        if (skillPoints > 0 && skillIndex >= 0 && skillIndex < skills.size()) {
            skills.get(skillIndex).upgrade();
            skillPoints--;
        }
    }

    public  void gainXp(int xp){
        this.xp += xp;
        levelUp();
    }
    public int attack(int skillIndex) {
        return skills.get(skillIndex).attack(this, skills, skillIndex);
    }

}

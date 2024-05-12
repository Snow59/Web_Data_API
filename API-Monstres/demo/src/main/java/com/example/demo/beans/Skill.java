package com.example.demo.beans;

import lombok.Data;
import java.util.List;


@Data
public class Skill {
    private int num;
    private int lvlSkill = 1;
    private int dmg;
    private StatRatio ratio;
    private int cooldown;
    private int lvlMax;

    public Skill(){

    }

    public Skill(int num, int lvlSkill, int dmg, StatRatio ratio, int cooldown, int lvlMax) {
        this.num = num;
        this.lvlSkill = lvlSkill;
        this.dmg = dmg;
        this.ratio = ratio;
        this.cooldown = cooldown;
        this.lvlMax = lvlMax;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getLvlSkill() {
        return lvlSkill;
    }

    public void setLvlSkill(int lvlSkill) {
        this.lvlSkill = lvlSkill;
    }

    public int getDmg() {
        return dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public StatRatio getRatio() {
        return ratio;
    }

    public void setRatio(StatRatio ratio) {
        this.ratio = ratio;
    }

    public int getCooldown() {
        return cooldown;
    }

    public void setCooldown(int cooldown) {
        this.cooldown = cooldown;
    }

    public int getLvlMax() {
        return lvlMax;
    }

    public void setLvlMax(int lvlMax) {
        this.lvlMax = lvlMax;
    }

    public void upgrade() {
        if (lvlSkill < lvlMax) {
            lvlSkill++;
            statsGrowth();
        }
    }

    private void statsGrowth() {
        dmg += 50;
        cooldown--;
    }

    public int attack(Monster monster, List<Skill> allSkills, int skillIndex) {
        if (skillIndex < 0 || skillIndex >= allSkills.size()) {
            return 0;
        }

        Skill skill = allSkills.get(skillIndex);

        if (skill.getCooldown() > 0) {
            return 0;
        }

        int damage = skill.getDmg() + (int) (skill.getRatio().getPercent() * monster.getAtk());

        skill.setCooldown(skill.getCooldown());

        return damage;
    }
}

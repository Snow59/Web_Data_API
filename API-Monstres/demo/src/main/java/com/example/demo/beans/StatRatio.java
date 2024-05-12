package com.example.demo.beans;

import lombok.Data;

@Data
public class StatRatio {
    private String stat;
    private double percent;

    public StatRatio(){

    }

    public StatRatio(String stat, double percent) {
        this.stat = stat;
        this.percent = percent;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }
}

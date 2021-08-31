package org.example;

public class Animal {
    private String kind;
    private String name;
    private int ageYears;
    private int ageMonths;
    private String host_name;

    public Animal(String kind, String name, int ageYears, int ageMonths, String host_name){
        this.kind = kind;
        this.name = name;
        this.ageYears = ageYears;
        this.ageMonths = ageMonths;
        this.host_name = host_name;
    }

    public String getKind() {
        return kind;
    }
    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getAgeYears() {
        return ageYears;
    }
    public void setAgeYears(int ageYears) {
        this.ageYears = ageYears;
    }

    public int getAgeMonths() {
        return ageMonths;
    }
    public void setAgeMonths(int ageMonths) {
        this.ageMonths = ageMonths;
    }

    public String getHost_name() {
        return host_name;
    }
    public void setHost(String host_name) {
        this.host_name = host_name;
    }

    public boolean isTheSameKind(Animal animal) {
        return kind.equals(animal.kind);
    }

    @Override
    public  String toString() {
        return kind + "; " + name + "; " + ageYears + "." + ageMonths + "; " + host_name;
    }
}


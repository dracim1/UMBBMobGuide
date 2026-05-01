package com.example.umbbmobguide;

import java.util.ArrayList;

public class Department {
    private String name;
    private String description;
    private ArrayList<String> specialties;
    
    // Constructeur original (pour compatibilité)
    public Department(String name, String description){
        this.name = name;
        this.description = description;
        this.specialties = new ArrayList<>();
    }
    
    // Nouveau constructeur avec spécialités
    public Department(String name, String description, ArrayList<String> specialties){
        this.name = name;
        this.description = description;
        this.specialties = specialties;
    }
    
    public String getName() { return name; }
    public String getDescription() { return description; }
    public ArrayList<String> getSpecialties() { return specialties; }
    public void setSpecialties(ArrayList<String> specialties) { this.specialties = specialties; }
}

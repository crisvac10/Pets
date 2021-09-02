package edu.unbosque.model;

import edu.unbosque.model.persistence.ManagerDAO;

import java.util.ArrayList;

public class Pets {

    public ArrayList<PetsList> list;
    public String id, species, sex , size, neighborhood, microchip;
    public boolean potentDangerous;

    public Pets(String id, String microchip, String species, String sex, String size, boolean potentDangerous, String neighborhood){

        this.microchip=microchip;
        this.neighborhood=neighborhood;
        this.potentDangerous=potentDangerous;
        this.sex=sex;
        this.size=size;
        this.species=species;

    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isPotentDangerous() {
        return potentDangerous;
    }

    public void setPotentDangerous(boolean potentDangerous) {
        this.potentDangerous = potentDangerous;
    }

    public String getMicrochip() {
        return microchip;
    }

    public void setMicrochip(String microchip) {
        this.microchip = microchip;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }
}






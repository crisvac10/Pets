package edu.unbosque.model;

public class Pets {
    public String id, species, sex , size, neighborhood;
    public long microchip;
    public boolean potentDangerous;

    public Pets (String id, String species, String sex, String size, String neighborhood, long microchip, boolean potentDangerous){
        super();
        this.id=id;
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

    public long getMicrochip() {
        return microchip;
    }

    public void setMicrochip(long microchip) {
        this.microchip = microchip;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public boolean isPotentDangerous() {
        return potentDangerous;
    }

    public void setPotentDangerous(boolean potentDangerous) {
        this.potentDangerous = potentDangerous;
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



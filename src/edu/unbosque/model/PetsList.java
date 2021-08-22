package edu.unbosque.model;

public class PetsList {
    public String species, sex , size, neighborhood,microchip, potentDangerous;


    public PetsList ( String species, String sex, String size, String neighborhood, String microchip, String potentDangerous){
        super();

        this.microchip=microchip;
        this.neighborhood=neighborhood;
        this.potentDangerous=potentDangerous;
        this.sex=sex;
        this.size=size;
        this.species=species;

    }

    public String getPotentDangerous() {
        return potentDangerous;
    }

    public void setPotentDangerous(String potentDangerous) {
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

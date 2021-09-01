package edu.unbosque.model.persistence;

import edu.unbosque.model.Pets;

import java.util.ArrayList;

public class PetsDao {
    private ArrayList<Pets> pets = new ArrayList<Pets>();
    private File1 arch;
    public PetsDao(){
        arch = new File1();
    }
    public void addPetPersistence(Pets p){
        if(arch.get()!= null){
            pets = arch.get();
        }
        pets.add(p);
        arch.write(pets);
    }

    public File1 getArch() {
        return arch;
    }

    public void setArch(File1 arch) {
        this.arch = arch;
    }

    public ArrayList<Pets> getPets() {
        return pets;
    }

    public void setPets(ArrayList<Pets> pets) {
        this.pets = pets;
    }
}

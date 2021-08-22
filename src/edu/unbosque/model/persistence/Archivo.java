package edu.unbosque.model.persistence;

import edu.unbosque.model.Pets;
import edu.unbosque.model.PetsDTO;

import java.io.*;
import java.util.ArrayList;

public class Archivo {

private ObjectOutputStream exit;
private ObjectInputStream entry;

public Archivo(){

}
public ArrayList<Pets> get(){
    try {
        entry = new ObjectInputStream(new FileInputStream("/c/Users/Cristian Vaca/Pets/src/Pets.dat"));
        ArrayList<Pets> arrayAux=(ArrayList<Pets>) entry.readObject();
        entry.close();
        return arrayAux;
    }catch (Exception e){
        return null;
    }
}
public void write(ArrayList<Pets> p){
    try {
        exit = new ObjectOutputStream(new FileOutputStream("/c/Users/Cristian Vaca/Pets/src/Pets.dat"));
        exit.writeObject(p);
        exit.close();
    }catch (Exception e){
        e.printStackTrace();
        System.out.println("have a exception");
    }
}
}

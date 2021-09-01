package edu.unbosque.model.persistence;

import edu.unbosque.model.Pets;

import java.io.*;
import java.util.ArrayList;

public class File1 {

private ObjectOutputStream exit;
private ObjectInputStream entry;

public File1(){

}
public ArrayList<Pets> get(){
    try {
        entry = new ObjectInputStream(new FileInputStream("C:/Users/Personal/Pets/Data/Pets.dat"));
        ArrayList<Pets> arrayAux=(ArrayList<Pets>) entry.readObject();
        entry.close();
        return arrayAux;
    }catch (Exception e){
        return null;
    }
}
public void write(ArrayList<Pets> p){
    try {
        exit = new ObjectOutputStream(new FileOutputStream("C:/Users/Personal/Pets/Data/Pets.dat"));
        exit.writeObject(p);
        exit.close();
    }catch (Exception e){
        e.printStackTrace();
        System.out.println("have a exception");
    }
}
}

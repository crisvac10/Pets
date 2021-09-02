package edu.unbosque.model;

import edu.unbosque.model.persistence.ManagerDAO;

import java.util.ArrayList;

public class Pets {

    ArrayList<PetsList> list;
    ManagerDAO file;

        public Pets(){
            file = new ManagerDAO();
            list = file.readFile();
    }

}





package edu.unbosque.model;

import edu.unbosque.model.persistence.FileCsv;

import java.util.ArrayList;

public class Pets {

    ArrayList<PetsList> list;
    FileCsv file;

        public Pets(){
            file = new FileCsv();
            list = file.readFile();
    }

}





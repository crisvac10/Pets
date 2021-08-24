package edu.unbosque.model.persistence;

import edu.unbosque.model.PetsList;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileCsv {
    private String ruta = "./C/Users/Cristian Vaca/Pets/src/pets-citizens.csv";

    public FileCsv() {

    }

    public ArrayList<PetsList> readFile() {
        String line = "";
        ArrayList<PetsList> list = new ArrayList<PetsList>() ;
        File f = new File(ruta);
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            line = br.readLine();
            String[] temp;
            while (line != null) {
                temp = line.split(";");

                list.add(new PetsList(temp[0], temp[1], temp[2], temp[3], temp[4],temp[5]));
                line = br.readLine();
            }
                fr.close();
                return list;

            }catch(IOException e){
                e.printStackTrace();
                System.out.println("No se ha podido leer el archivo");
            }
        return null;
        }
    }


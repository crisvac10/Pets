package edu.unbosque.model.persistence;

import edu.unbosque.model.Pets;
import edu.unbosque.model.PetsList;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class FileCsv {
    private String ruta = "C:/Users/Personal/Pets/Data/pets-citizens.csv";
    private String Separator = ";";

    public FileCsv() {

    }

    public ArrayList<PetsList> readFile() {
        ArrayList<PetsList> list = new ArrayList<PetsList>();
        File f = new File(ruta);
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(Separator);
                System.out.println(Arrays.toString(fields));

                list.add(new PetsList(fields[0], fields[1], fields[2], fields[3], fields[4], fields[5]));

                line = br.readLine();
            }

            fr.close();
            return list;

            }catch(FileNotFoundException e){
                System.out.println("No ha encontrado el archivo");

            }catch(IOException e){
                    e.printStackTrace();
                System.out.println("No se ha podido leer el archivo");
            }
        return null;
        }


    }


package edu.unbosque.model.persistence;

import edu.unbosque.model.Pets;
import edu.unbosque.model.PetsList;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class FileCsv {
    private String ruta = "C:/Users/Personal/Pets/Data/pets-citizens.csv";
    private String Separator = ";";
    private ArrayList<PetsList> list;
    ArrayList<PetsList>dangerous;
    private int a;
    private String id = "No-ID";
    public FileCsv() {
list = new ArrayList<PetsList>();
dangerous = new ArrayList<PetsList>();
a = 2;
    }

    public ArrayList<PetsList> readFile() {

        File f = new File(ruta);
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(Separator);
                System.out.println(Arrays.toString(fields));

                list.add(new PetsList(fields [0],Long.parseLong (fields[1]), fields[2], fields[3], fields[4], Boolean.parseBoolean(fields[5]), fields[6]));

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
    public String assignID () {
        String mc = "";
        String species = "";
        String sex = "";
        String size = "";
        String PD = "";
        String id = "";
        for (int i = 0; i < list.size(); i++) {
            mc = String.valueOf(list.get(i).getMicrochip());
            mc = mc.substring(mc.length()-3,mc.length());
            if (list.get(i).getSpecies().equals("canino".toUpperCase())) {
                species = "C";
            }else if (list.get(i).getSpecies().equals("felino".toUpperCase())) {
                species = "F";
            }

            if (list.get(i).getSex().equals("macho".toUpperCase())) {
                sex = "M";
            }else if (list.get(i).getSex().equals("hembra".toUpperCase())) {
                sex = "H";
            }

            if (list.get(i).getSize().equals("miniatura".toUpperCase())) {
                size = "MI";
            }else if (list.get(i).getSize().equals("pequeño".toUpperCase())) {
                size = "P";
            }else if (list.get(i).getSize().equals("mediano".toUpperCase())) {
                size = "M";
            }else if (list.get(i).getSize().equals("grande".toUpperCase())) {
                size = "G";
            }

            if (list.get(i).isPotentDangerous()) {
                PD = "T";
            }else {
                PD = "F";
            }
            id = mc + "-" + species+sex+size+PD+ "-" + list.get(i).getNeighborhood();
            list.get(i).setId(id);
            for (int j = 0; j < i; j++) {
                try {
                    if (list.get(j).getId().equals(id)) {
                        mc = mc +1;
                        throw new Exception("IdentifierExistsException");
                    }

                } catch (Exception IdentifierExistsException) {

                    id = mc + " - " + species+sex+size+PD+ " - " + list.get(i).getNeighborhood();
                    list.get(i).setId(id);
                }

            }
        }

        return "El proceso de asignación de ids ha finalizado";
    }
    public PetsList findMicrochip(long microchip) {
        PetsList encontrado = null;

        for (int i = 0; i < list.size(); i++) {

            if (list.get(i).getMicrochip() == microchip) {

                return list.get(i);

            }
        }

        return encontrado;
    }
    public String countSpecies (String species) {
        int contador = 0;
        String result = "";

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getSpecies().equals(species.toUpperCase())) {
                contador++;
            }

            result = "El número de animales de la especie"+ " " + species.toUpperCase() + " "+ "es"+ " " + contador;
        }


        return result;
    }
    public PetsList findByMultipleFields (String sex, String species,String size, String potentDangerous) {


        PetsList pd = new ArrayList<PetsList>();
        String pc = "";
        boolean dangerous = false;

        if (potentDangerous.equals("si".toUpperCase())) {
            dangerous = true;
        }else if (potentDangerous.equals("no".toUpperCase())) {
            dangerous = false;
        }

        for (int i = 0; i < list.size(); i++) {


            if (list.get(i).getSex().equals(sex.toUpperCase()) && list.get(i).getSpecies().equals(species.toUpperCase()) && list.get(i).getSize().equals(size.toUpperCase()) && list.get(i).isPotentDangerous() == dangerous){

                pd.add(list.get(i).getId());
            }
        }
        return pd;
    }

}


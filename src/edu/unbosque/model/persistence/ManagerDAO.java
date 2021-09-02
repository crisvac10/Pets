package edu.unbosque.model.persistence;

import edu.unbosque.model.PetsList;
import edu.unbosque.model.Pets;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Clase ManagerDAO que contiene la lectura del archivo csv, y los diferentes metodosde la aplicacion
 */
public class ManagerDAO {
    private String ruta = "C:/Users/Personal/Pets/Data/pets-citizens.csv";// Atributo de tipo String que contiene la ruta del archivo csv
    private String Separator = ";";//Atributo que contiene el separador del archivo csv
    private ArrayList<PetsList> list;//Atributo de tipo ArrayList que contiene el arreglo de la clase PetsList
    private ArrayList<Pets>list2;
    ArrayList<PetsList>dangerous; //Atributo de tipo ArrayList que contiene otro arreglo de la clase PetsList

    /**
     * Constructor de la clase ManagerDAO que inicializa los arreglos
     */
    public ManagerDAO() {
list = new ArrayList<PetsList>();
dangerous = new ArrayList<PetsList>();

    }

    /**
     * Metodo que raliza la lectura del archivo csv
     * @return
     */
    public ArrayList<PetsList> readFile() {

        File f = new File(ruta);
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(Separator);
                System.out.println(Arrays.toString(fields));

                list.add(new PetsList(fields[0], fields[1], fields[2], fields[3], Boolean.parseBoolean(fields[4]), fields[5]));
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



    /**
     * Metodo que realiza la asignacion de los id de los animales
     * @return
     */


    /**
     * Metodo que cuenta por localidad la cantidad de ciudadanos de 4 patas
     * @param neighborhood
     * @return
     */
    public String countNeighborhood(String neighborhood){

    int count = 0;
    String resul = "";
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getNeighborhood().equals(neighborhood.toUpperCase())){
                count++;
            } resul = "El numero de animales en "+ neighborhood.toUpperCase()+" son:"+count;
        }return resul;

    }

    /**
     * metodo que encuentra al ciudadano de 4 patas por su respectivo microchip
     * @param microchip
     * @return
     */
    public String findMicrochip(String microchip) {

        String find = "";
        if(!list.isEmpty()) {

            for (int i = 0; i < list.size(); i++) {

                if (list.get(i).getMicrochip() == microchip.toUpperCase()) {

                    find =find+""+ list.get(1)+ "";

                }
                return find;
            }
        }
        return find;
    }

    /**
     * Metodo que permite contar la cantidad de ciudadanos de 4 patas por especie
     * @param species
     * @return
     */
    public String countSpecies (String species) {
        int count = 0;
        String result = "";

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getSpecies().equals(species.toUpperCase())) {
                count++;
            }

            result = "El número de animales de la especie"+ " " + species.toUpperCase() + " "+ "es"+ " " + count;
        }


        return result;
    }

    /**
     * Metodo que encuentra los ciudadanos de 4 patas por diferentes filtros
     * @param sex
     * @param species
     * @param size
     * @param potentDangerous
     * @return
     */
    public ArrayList<PetsList> findMultipleFields (String sex, String species, String size, String potentDangerous) {


        ArrayList<PetsList> pd = new ArrayList<PetsList>();
        String pc = "";
        boolean dangerous = false;

        if (potentDangerous.equals("si".toUpperCase())) {
            dangerous = true;
        }else if (potentDangerous.equals("no".toUpperCase())) {
            dangerous = false;
        }

        for (int i = 0; i < list.size(); i++) {


            if (list.get(i).getSex().equals(sex.toUpperCase()) && list.get(i).getSpecies().equals(species.toUpperCase()) && list.get(i).getSize().equals(size.toUpperCase()) && list.get(i).isPotentDangerous() == dangerous){

                pd.add(list.get(i));
            }
        }
        return pd;
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
            list2.get(i).setId(id);
            for (int j = 0; j < i; j++) {
                try {
                    if (list2.get(j).getId().equals(id)) {
                        mc = mc +1;
                        throw new Exception("IdentifierExistsException");
                    }

                } catch (Exception IdentifierExistsException) {

                    id = mc + " - " + species+sex+size+PD+ " - " + list2.get(i).getNeighborhood();
                    list2.get(i).setId(id);
                }

            }
            return id;
        }

        return id;
    }

}


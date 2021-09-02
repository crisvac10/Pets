package edu.unbosque.main;

import edu.unbosque.model.PetsList;
import edu.unbosque.model.persistence.File1;
import edu.unbosque.model.persistence.ManagerDAO;
import edu.unbosque.view.ViewConsole;

import java.util.ArrayList;

public class Controller {

    private ViewConsole view;
    private ManagerDAO csv;
    private File1 file;
    private ArrayList<PetsList> list;

    public Controller(){
        view = new ViewConsole();
        csv = new ManagerDAO();
        file = new File1();
        list = new ArrayList<PetsList>();
        StartApp();

    }

    public void StartApp(){
        view.showMessage("      Pets App");
        view.showMessage("---------------------");
        view.showMessage("Desea acceder al sistema?");
        String aux = view.readData("1. Si  2. No");
        int aux2 = Integer.parseInt(aux);
        if(aux2 == 1){
            view.showMessage("Cargando archivo");
            try {


               System.out.println(csv.readFile());

            }catch(ArrayIndexOutOfBoundsException e){

            }
            try{
                view.showMessage(csv.assignID());

            }catch (NullPointerException e){

            }

            view.showMessage("El archivo se ha cargado");
            String opc = view.readData("1. Busqueda por microchip.  2. Cantidad de animales por especie. 3. Cantidad de animales por localidad. 4. Encontrar por varios aspectos");
                    int opc2 = Integer.parseInt(opc);
            if(opc2 == 1){
                String microchip = view.readData("Ingrese el microchip:");
               System.out.println(csv.findMicrochip(microchip));

            }else if(opc2 == 2){
                    String specie =view.readData("Digite la especie:");

                   System.out.println(csv.countSpecies(specie));

            }else if(opc2 == 3){
                    String localidad = view.readData("Digite la localidad:");

                    System.out.println(csv.countNeighborhood(localidad));
            }else if(opc2 == 4){

                String sexo = view.readData("Digite el sexo:");
                String especie = view.readData("Digite el especie:");
                String localidad = view.readData("Digite el localidad:");
                String peligroso = view.readData("Es peligroso? Si. No.");
                System.out.println(csv.findMultipleFields(sexo,especie,localidad,peligroso));

            }

        }else{
            view.showMessage("Ha salido del sistema");
        }
    }

}

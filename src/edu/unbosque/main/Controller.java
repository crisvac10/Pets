package edu.unbosque.main;

import edu.unbosque.model.persistence.File1;
import edu.unbosque.model.persistence.FileCsv;
import edu.unbosque.view.ViewConsole;

public class Controller {

    private ViewConsole view;
    private FileCsv csv;
    private File1 file;

    public Controller(){
        view = new ViewConsole();
        csv = new FileCsv();
        file = new File1();
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
            csv.readFile();
            view.showMessage("El archivo se ha cargado");
        }else{
            view.showMessage("Ha salido del sistema");
        }
    }

}

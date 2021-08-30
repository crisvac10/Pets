package edu.unbosque.view;

import java.util.Scanner;

public class ViewConsole {

    public Scanner read;

    public ViewConsole(){
    read = new Scanner(System.in);
}

    public void showMessage(String message){
    System.out.println(message);
}
    public String readData(String message){
        showMessage(message);
    String data = "";
    data = read.next();
    return data;
}
}

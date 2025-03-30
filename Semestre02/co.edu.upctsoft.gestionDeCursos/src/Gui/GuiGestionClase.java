package Gui;

import Control.ControlClase;
import Logic.Curso;
import java.util.Scanner;
public class GuiGestionClase {
    Scanner sc = new Scanner(System.in);
    public void menu (){
       int opcion = 0;
     do {

         System.out.println("----BIENVENIDO A CURSOS EN LINEA----");
         System.out.println("-----------------MENU---------------- ");
         System.out.println("1.Ingresar como estudiante");
         System.out.println("2.ingresar como intructor");
         System.out.println("3.ingresar como director");
         System.out.println("4.salir");

         try {
             opcion = sc.nextInt();
             sc.nextLine();

         }catch (Exception e){

             System.out.println("ERROR .... digito una opcion o caracter no valido");
             sc.next();
         }
     }while(opcion!=4);

    }

    public void gestioEstudiantes(){
        System.out.println("1.Ingresar como estudiante");
        System.out.println("2.ingresar como intructor");

    }
    public void gestionInstructor(){

    }
}

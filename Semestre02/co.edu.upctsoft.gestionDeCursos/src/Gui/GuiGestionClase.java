package Gui;

import Logic.Curso;
import java.util.Scanner;
public class GuiGestionClase {
    public void Rol (){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Define tu rol");
            System.out.println("1. Estudiante");
            System.out.println("2. Instructor");
            System.out.println("3. Salir");
            System.out.println("Opcion: ");
            byte opcion = sc.nextByte();
            if (opcion == 3){
                System.out.println("Saliendo del programa");
                break;
            }
            switch (opcion){
                case 1:
                    System.out.println("Ingreso exitosos");
                    System.out.println(control.interfazCirculo(radio));
                    break;
                case 2:
                    System.out.println("Instructor");
                    System.out.println(control.interfazRectangulo(largo, ancho));
                    break;
                default:
                    System.out.println("Opcion no valida. Intente de nuevo");
                    continue;
            }
        }

    }
}

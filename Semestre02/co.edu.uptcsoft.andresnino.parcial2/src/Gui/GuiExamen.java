package Gui;
import Control.ControlParcial;
import Logic.Pregunta;

import java.util.Scanner;
public class GuiExamen {
    public void vista() {
        ControlParcial co = new ControlParcial();
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Cuantas preguntas deseas?");
        String[] preguntas = new String[sc.nextByte()];

        for(int i = 0; i < preguntas.length; i++){

            System.out.println("Pregunta");
            String pre = sc.nextLine();

            System.out.println("Respuesta");
            String res = sc.nextLine();

            System.out.println("r1");
            String r1 = sc.nextLine();

            System.out.println("r2");
            String r2 = sc.nextLine();

            System.out.println("r3");
            String r3 = sc.nextLine();

            System.out.println("r4");
            String r4 = sc.nextLine();

            preguntas[i] = co.interfazPregunta(pre, res, r1, r2, r3, r4);

        }
        for (int i = 0; i < preguntas.length;i++){
            System.out.println(preguntas[i]);
        }
    }
}

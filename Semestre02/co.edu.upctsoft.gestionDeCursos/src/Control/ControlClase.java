package Control;

import Logic.Estudiante;

public class ControlClase {
    public String interfazEstudiante(String nombre, String correo, String id){
        Estudiante estudiante = new Estudiante(nombre, correo, id);
        return String.valueOf(estudiante);
    }
}

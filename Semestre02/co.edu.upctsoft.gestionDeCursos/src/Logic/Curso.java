package Logic;
import java.util.ArrayList;
import java.util.List;
public class Curso {
    private String nombre, descripcion;
    private boolean estado;
    private List<Leccion> lecciones;
    private List<Estudiante> estudiantesInscritos;

    public Curso(String nombre, String descripcion, boolean estado) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
        this.lecciones = new ArrayList<>();
        this.estudiantesInscritos = new ArrayList<>();
    }

    public void agregarLeccion(Leccion leccion){
        lecciones.add(leccion);
    }
    public void eliminarLeccion(Leccion leccion){
        lecciones.remove(leccion);
    }
    public List<Leccion> getLecciones(){
        return lecciones;
    }

    public void inscribirEstudiante(Estudiante estudiante){
        estudiantesInscritos.add(estudiante);
    }
    public void eliminarEstudiante(Estudiante estudiante){
        estudiantesInscritos.remove(estudiante);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", estado=" + estado +
                ", lecciones=" + lecciones.size() +
                ", estudiantesInscritos=" + estudiantesInscritos.size() +
                '}';
    }
}

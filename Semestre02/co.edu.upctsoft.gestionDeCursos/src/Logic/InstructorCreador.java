package Logic;

public class InstructorCreador extends Instructor{
    public InstructorCreador(String nombre, String email, String id) {
        super(nombre, email, id);
    }
    public Curso crearCurso(String nombre,String descripcion, boolean estado){
        return new Curso(nombre,descripcion,estado);
    }
}

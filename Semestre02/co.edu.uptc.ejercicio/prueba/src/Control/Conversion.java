package Control;

import Logic.*;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class Conversion {
    private List<Estudiante> estudiantes = new ArrayList<>();
    private List<Instructor> instructores = new ArrayList<>();

    // Métodos para estudiantes
    public String registrarEstudiante(String nombre, String email, String id) {
        if(usuarioYaExiste(nombre, id)) {
            return "Ya existe un usuario con ese nombre o ID";
        }
        estudiantes.add(new Estudiante(nombre, email, id));
        return "Estudiante registrado exitosamente";
    }

    public Estudiante buscarEstudiante(String id) {
        for (Estudiante e : estudiantes) {
            if (e.getId().equals(id))
                return e;
        }
        return null;
    }

    // Métodos para instructores
    public String registrarInstructor(String nombre, String email, String id, String tipo) {
        Instructor instructor;

        for (Instructor i : instructores){

            if (i.getNombre().equalsIgnoreCase(nombre) || i.getId().equals(id)){
                return "el instructor ya existe (con nombre o id )";
            }
        }

        for (Estudiante e : estudiantes) {
            if (e.getId().equals(id)) {
                return "Error: El ID ya está registrado para un estudiante";
            }
            if (tipo.equalsIgnoreCase("creador")) {
                instructor = new InstructorCreador(nombre, email, id);
            } else {
                instructor = new InstructorDirector(nombre, email, id);
            }

            instructores.add(instructor);
            return "Instructor registrado exitosamente";
        }

        public Instructor buscarInstructor(String id) {
            for (Instructor i : instructores) {
                if (i.getId().equals(id)) return i;
            }
            return null;
        }
        public String modificarDescripcionCurso(String nombreCurso, String idInstructor, String nuevaDescripcion){
            Instructor instructor = buscarInstructor(idInstructor);
            if (instructor == null || !(Instructor instanceof InstructorDirector)) {
                return "Solo los instructores directores pueden modificar la descripcion";
            }
            Curso curso = buscarCurso(nombreCurso);
            if(curso = null){
                return "El curso no se encontro";
            }
            return ((InstructorDirector)instructor).modificarDescripcionCurso(curso,nuevaDescripcion);
        }



        // Métodos para cursos
        public String crearNuevoCurso(String nombre, String descripcion, String idInstructor) {
            // Buscamos al instructor
            Instructor instructor = buscarInstructor(idInstructor);

            // Verificamos si el instructor existe
            if (instructor == null) {
                return "Instructor no encontrado";
            }

            // Verificamos el tipo de instructor usando el método getTipoInstructor()
            if ("DIRECTOR".equals(instructor.getTipoInstructor())) {
                // Crear el nuevo curso
                Curso nuevoCurso = new Curso(nombre, descripcion, false);

                // Agregar al gestor de cursos
                GestorCursos.agregarCurso(nuevoCurso);

                return "Curso creado exitosamente: " + nombre;
            } else {
                return "Solo instructores directores pueden crear cursos";
            }
        }

        public String eliminarCurso(String nombreCurso, String idInstructor) {
            // 1. Buscar al instructor
            Instructor instructor = buscarInstructor(idInstructor);

            // 2. Verificar si el instructor existe y es director
            if (instructor == null) {
                return "Instructor no encontrado";
            }

            if (!"DIRECTOR".equals(instructor.getTipoInstructor())) {
                return "Solo instructores directores pueden eliminar cursos";
            }

            // 3. Intentar eliminar el curso
            boolean cursoFueEliminado = GestorCursos.eliminarCurso(nombreCurso);

            // 4. Retornar el resultado apropiado
            if (cursoFueEliminado) {
                return "Curso eliminado exitosamente";
            } else {
                return "Curso no encontrado";
            }
        }

        public String inscribirEstudianteCurso(String idEstudiante, String nombreCurso) {
            Estudiante e = buscarEstudiante(idEstudiante);
            Curso c = buscarCurso(nombreCurso);

            if (e != null && c != null) {
                e.inscribirseCurso(c);
                c.inscribirEstudiante(e);
                return "Inscripción exitosa al curso: " + c.getNombre();
            }
            return "Error en la inscripción";
        }

        public String listarCursosEstudiante(String idEstudiante) {
            Estudiante e = buscarEstudiante(idEstudiante);
            if (e == null) return "Estudiante no encontrado";

            if (e.getCursosInscritos().isEmpty()) return "No tienes cursos inscritos";

            StringBuilder sb = new StringBuilder();
            for (Curso c : e.getCursosInscritos()) {
                sb.append("- ").append(c.getNombre())
                        .append(" (").append(c.getEstado() ? "Completado" : "En progreso")
                        .append(")\n");
            }
            return sb.toString();
        }

        public String listarCursosDisponibles() {
            if (GestorCursos.getCursosDisponibles().isEmpty()) {
                return "No hay cursos disponibles";
            }

            StringBuilder sb = new StringBuilder();
            for (Curso c : GestorCursos.getCursosDisponibles()) {
                sb.append("- ").append(c.getNombre())
                        .append(": ").append(c.getDescripcion())
                        .append("\n");
            }
            return sb.toString();
        }

        private Curso buscarCurso(String nombre) {
            for (Curso c : GestorCursos.getCursosDisponibles()) {
                if (c.getNombre().equalsIgnoreCase(nombre)) return c;
            }
            return null;
        }
        // En la clase Conversion

        // Método para crear curso (para instructores creadores)
        public String crearCurso(String nombre, String descripcion, String idInstructor) {
            Instructor instructor = buscarInstructor(idInstructor);
            if (instructor instanceof InstructorCreador) {
                Curso nuevoCurso = ((InstructorCreador)instructor).crearCurso(nombre, descripcion);
                GestorCursos.agregarCurso(nuevoCurso);
                return "Curso creado exitosamente: " + nombre;
            }
            return "Solo instructores creadores pueden crear cursos";
        }
        public boolean usuarioYaExiste (String nombre ,String id) {

            for (Estudiante estudiante : estudiantes) {

                if (estudiante.getNombre().equalsIgnoreCase(nombre) || estudiante.getId().equals(id))
                    return true;

            }

            for (Instructor instructor : instructores) {
                if (instructor.getNombre().equalsIgnoreCase(nombre) || instructor.getId().equals(id)) {
                    return true;
                }
            }

            return false;
        }
    }
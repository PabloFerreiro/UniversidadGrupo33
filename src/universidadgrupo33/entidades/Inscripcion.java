
package universidadgrupo33.entidades;

public class Inscripcion {
    
    //Atributos
    private int idInscripcion;
    private Alumno alumno;
    private Materia materia;
    private double nota;
    
    //constructor vacio
    public Inscripcion() {
    }
    
    //constructor con todos los atributos
    public Inscripcion(int idInscripcion, Alumno alumno, Materia materia, double nota) {
        this.idInscripcion = idInscripcion;
        this.alumno = alumno;
        this.materia = materia;
        this.nota = nota;
    }
    
    //constructor con todos los atributos menos el idInscripcion
    public Inscripcion(Alumno alumno, Materia materia, double nota) {
        this.alumno = alumno;
        this.materia = materia;
        this.nota = nota;
    }
    
    //getters y setters

    public int getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(int idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
    
    
    //to string

    @Override
    public String toString() {
        String insc= idInscripcion + " " + alumno.getApellido() + ", " + alumno.getNombre() + " " + materia.getNombre();
        return insc;
    }
    
    
    
    
    
}

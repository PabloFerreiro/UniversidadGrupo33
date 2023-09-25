
package universidadgrupo33.entidades;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class Alumno implements Comparable<Alumno>
{
    
    //atributos
    private int idAlumno;
    private int dni;
    private String apellido;
    private String nombre;
    private LocalDate fechaNac;
    private boolean activo;

    //constructor vacio
    public Alumno() {
    }

    //constructor con todos los atributos
    public Alumno(int idAlumno, int dni, String apellido, String nombre, LocalDate fechaNac, boolean activo) {
        this.idAlumno = idAlumno;
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.activo = activo;
    }
    
    //constructor con con todos los atributos menos el idAlumno
    public Alumno(int dni, String apellido, String nombre, LocalDate fechaNac, boolean activo) {
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.activo = activo;
    }
    
    //constructor solo con idAlumno
    public Alumno(int idAlumno) {
         this.idAlumno = idAlumno;
    }

    
    // getters y setters
    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    //to string
    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("000");
        return "id: "+df.format(idAlumno)+", "+apellido +" "+nombre+ ", dni: " + dni;
        
    }

    @Override
    public int compareTo(Alumno otroApellido) {
        return this.apellido.compareTo(otroApellido.apellido);        
    }
    
    
    
    
}

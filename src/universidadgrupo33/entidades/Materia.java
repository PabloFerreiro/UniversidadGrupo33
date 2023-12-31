package universidadgrupo33.entidades;

import java.text.DecimalFormat;

public class Materia implements Comparable<Materia> 
{

    //atributos
    private int idMateria;
    private String nombre;
    private int año;
    private boolean estado;
    
    //constructor vacio
    public Materia() {
    }
    
    //constructor con todos los atributos
    public Materia(int idMateria, String nombre, int año, boolean estado) {
        this.idMateria = idMateria;
        this.nombre = nombre;
        this.año = año;
        this.estado = estado;
    }
        
    //constructor con con todos los atributos menos el idAlumno
    public Materia(String nombre, int año, boolean estado) {
        this.nombre = nombre;
        this.año = año;
        this.estado = estado;
    }
    
    //constructor solo con el idMateria
    public Materia(int idMateria) {
        this.idMateria = idMateria;
    }
    
    // getters y setters

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("00");        
        return "id: " +df.format(idMateria)+ ", "+ nombre + ", Año: " + año + ", " + estado;
    }

    @Override
    public int compareTo(Materia otroNombre) {
        return this.nombre.compareTo(otroNombre.nombre);
    }    
    
}

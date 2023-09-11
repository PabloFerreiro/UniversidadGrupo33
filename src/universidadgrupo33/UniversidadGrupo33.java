
package universidadgrupo33;

import java.time.LocalDate;
import java.time.Month;
import universidadgrupo33.accesoADatos.AlumnoData;
import universidadgrupo33.accesoADatos.Conexion;
import universidadgrupo33.entidades.Alumno;

public class UniversidadGrupo33 {

    public static void main(String[] args) {
        
        Conexion.getConexion();
        
        //Alumno juan= new Alumno (3,24345676, "Rodriguez", "Juan Pedro", LocalDate.of(1980, 4, 25), true);
        AlumnoData alu=new AlumnoData();
        //alu.guardarAlumno(juan);
        //alu.modificarAlumno(juan);
        alu.eliminarAlumno(3);
        
        
         
    }
    
}

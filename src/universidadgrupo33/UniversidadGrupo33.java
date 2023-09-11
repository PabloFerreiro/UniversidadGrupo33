
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
        //alu.eliminarAlumno(3);
        
//        Alumno alumnoEncontrado=alu.buscarAlumno(2);
//        System.out.println("dni " + alumnoEncontrado.getDni());
//        System.out.println("apellido " + alumnoEncontrado.getApellido());
//

//        Alumno alumnoEncontrado=alu.buscarAlumnoPorDni(23345678);
//        if (alumnoEncontrado!=null){
//        System.out.println("idAlumno " + alumnoEncontrado.getIdAlumno());
//        System.out.println("apellido " + alumnoEncontrado.getApellido());
//        }
        
        for(Alumno alumno:alu.listarAlumnos()){
            System.out.println(alumno.getDni());
            System.out.println(alumno.getApellido());
            System.out.println(alumno.getNombre());
            System.out.println(alumno.getFechaNac());
            System.out.println("");
   
            
        }
        
         
    }
    
}

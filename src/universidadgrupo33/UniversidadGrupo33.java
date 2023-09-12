
package universidadgrupo33;

import java.time.LocalDate;
import java.time.Month;
import universidadgrupo33.accesoADatos.AlumnoData;
import universidadgrupo33.accesoADatos.Conexion;
import universidadgrupo33.accesoADatos.MateriaData;
import universidadgrupo33.entidades.Alumno;
import universidadgrupo33.entidades.Materia;

public class UniversidadGrupo33 {

    public static void main(String[] args) {
        
        
        //Llamamos a la conexion
        Conexion.getConexion();
        
        
//#########################################################################
// CONEXIONES A ALUMNODATA
//#########################################################################

 
    //Método guardar Alumno
        //Alumno juan= new Alumno (24345676, "Rodriguez", "Juan Pedro", LocalDate.of(1980, 4, 25), true);
        //AlumnoData alu=new AlumnoData();
        //alu.guardarAlumno(juan);

    //Método modificar Alumno
        //Alumno juan= new Alumno (3,24345676, "Rodriguez", "Juan Pedro", LocalDate.of(1980, 4, 25), true);
        //alu.modificarAlumno(juan);

    //Método eliminar Alumno
        //AlumnoData alu=new AlumnoData();
        //alu.eliminarAlumno(3);
        

    //Método buscar Alumno por Id 
        //AlumnoData alu=new AlumnoData();
        //Alumno alumnoEncontrado=alu.buscarAlumno(2);
        //System.out.println("dni " + alumnoEncontrado.getDni());
        //System.out.println("apellido " + alumnoEncontrado.getApellido());

    //Método buscar Alumno por Dni 
        //AlumnoData alu=new AlumnoData();
        //Alumno alumnoEncontrado=alu.buscarAlumnoPorDni(23345678);
        //if (alumnoEncontrado!=null){
        //System.out.println("idAlumno " + alumnoEncontrado.getIdAlumno());
        //System.out.println("apellido " + alumnoEncontrado.getApellido());
        //}
        
    //Método listar alumno
//        AlumnoData alu=new AlumnoData();
//        for(Alumno alumno:alu.listarAlumnos()){
//            System.out.println(alumno.getDni());
//            System.out.println(alumno.getApellido());
//            System.out.println(alumno.getNombre());
//            System.out.println(alumno.getFechaNac());
//            System.out.println("");  
//            }

            
//#########################################################################
// CONEXIONES A MATERIADATA
//#########################################################################   
    //Metodo guardar materia
//        Materia materia1= new Materia ("Biología", 2023, true);
//        MateriaData mat=new MateriaData();
//        mat.guardarMateria(materia1);
          

    //Método buscar Materia
//        MateriaData mat=new MateriaData();
//        Materia materiaEncontrada=mat.buscarMateria(2);
//        System.out.println("Nombre " + materiaEncontrada.getNombre());
//        System.out.println("Año " + materiaEncontrada.getAño());
        
    //Método modificar Materia
//          Materia materia1= new Materia (2,"Matemática", 2022, true);
//          MateriaData mat=new MateriaData();
//          mat.modificarMateria(materia1);

    //Método eliminar Materia
//        MateriaData mat=new MateriaData();
//        mat.eliminarMateria(2);

    //Método listar materia
        MateriaData mat=new MateriaData();
        for(Materia materia:mat.listarMaterias()){
            System.out.println(materia.getNombre());
            System.out.println(materia.getAño());
            System.out.println("");  
            }

//#########################################################################
// CONEXIONES A INSCRIPCIONDATA
//#########################################################################  
       







    }
    
}

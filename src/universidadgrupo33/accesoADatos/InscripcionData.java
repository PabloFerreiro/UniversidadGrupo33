// dia: 22/09/23 hs: 4:00am
package universidadgrupo33.accesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import universidadgrupo33.entidades.Alumno;
import universidadgrupo33.entidades.Inscripcion;
import universidadgrupo33.entidades.Materia;

public class InscripcionData {
    
    private Connection con = null;    
    
        public InscripcionData() {
        con = Conexion.getConexion();
    }
         
         //METODOS
         
         //método guardar Inscripcion
    public void guardarInscripcion(Inscripcion insc) {
        String sql = "INSERT INTO inscripcion (nota, idAlumno, idMateria) VALUES (?, ?, ?)";
        try {
            //preguntar al mentor el RETURN_GENERATED_KEYS
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, insc.getNota());
            ps.setInt(2, insc.getAlumno().getIdAlumno());
            ps.setInt(3, insc.getMateria().getIdMateria());
            ps.executeUpdate();
            ps.getGeneratedKeys();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                insc.setIdInscripcion(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Inscripcion guardada");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo realizar el guardado de la inscripcion");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion (insert)");
        }
    }
    
         //método obtener Inscripciones
    public List<String> obtenerInscripciones() {
        // Se piden los datos no solo de la tabla inscripcion, sino tambien las de alumno y materia
        // Se piden todas las inscripciones, incluso a las que incluyan alumnos y/o materias dadas de baja (baja lógica)
        String sql = "SELECT A.idInscripto, A.idAlumno, B.apellido, B.nombre, B.estado, A.idMateria, C.nombre,"
                + "C.anio, A.nota  "
                + "FROM inscripcion A, alumno B, materia C "
                + "WHERE A.idAlumno=B.idAlumno AND A.idMateria=C.idMateria "
                + "ORDER BY A.idInscripto";

        //Se define un arraylist
        ArrayList<String> resumen = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            //hacemos un contador can
            int can = 0;

            //hacemos un string informe para hacer las concatenaciones
            String informe = "";

            // linea de los titulos de columnas a mostrar
            informe = "idInscripto ";
            informe = informe + "idAlumno ";
            informe = informe + "apellido ";
            informe = informe + "nombre ";
            informe = informe + "idMateria ";
            informe = informe + "nombre ";
            informe = informe + "anio ";
            informe = informe + "nota";

            //guardamos en el array
            resumen.add(informe);

            //bucle while recorre la tabla de resultados
            while (rs.next()) {

                //vamos incrementando el contador
                can++;

                //hacemos los system out para control
                System.out.println("Registro: " + can);
                System.out.println(rs.getInt("A.idInscripto"));
                System.out.println(rs.getInt("A.idAlumno"));
                System.out.println(rs.getString("B.apellido"));
                System.out.println(rs.getString("B.nombre"));
                System.out.println(rs.getInt("A.idMateria"));
                System.out.println(rs.getString("C.nombre"));
                System.out.println(rs.getInt("C.anio"));
                System.out.println(String.valueOf(rs.getDouble("A.nota")));

                //armado de la linea de datos obtenidos
                informe = "Inscripcion Nº: ";
                informe = informe + rs.getInt("A.idInscripto") + " ";
                informe = informe + rs.getInt("A.idAlumno") + ":";
                informe = informe + rs.getString("B.apellido") + " ";

                //control de estado de alumno
                if (rs.getBoolean("B.estado") == true) {
                    informe = informe + rs.getString("B.nombre") + "(    ) ";
                } else {
                    informe = informe + rs.getString("B.nombre") + "(Baja) ";
                }
                informe = informe + rs.getInt("A.idMateria") + ":";
                informe = informe + rs.getString("C.nombre") + " ";
                informe = informe + rs.getInt("C.anio") + " ";
                informe = informe + String.valueOf(rs.getDouble("A.nota"));

                resumen.add(informe);

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a las Bases de Datos. No se pudo realizar el informe de Inscripciones: " + ex);
        }
        //return inscripcion;         
        return resumen;
    }

        //método obtener Inscripciones por alumno VERSION NUEVA
    public List<String> ANTESobtenerInscripcionesPorAlumno(int idAlumno) {
        //Se define un arraylist
        ArrayList<String> resumen = new ArrayList<>();
//        // Se piden los datos no solo de la tabla inscripcion, sino tambien las de alumno y materia
//        // Se piden todas las inscripciones, incluso a las que incluyan alumnos y/o materias dadas de baja (baja lógica)
//        String sql = "SELECT A.idInscripto, A.idAlumno, B.apellido, B.nombre, B.estado, A.idMateria, C.nombre,"
//                + "C.anio, A.nota  "
//                + "FROM inscripcion A, alumno B, materia C "
//                + "WHERE A.idAlumno=? AND A.idAlumno=B.idAlumno AND A.idMateria=C.idMateria "
//                + "ORDER BY A.idInscripto";/
//
//        try {
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setInt(1, idAlumno);
//            ResultSet rs = ps.executeQuery();
//
//            //hacemos un contador can
//            int can = 0;
//
//            //hacemos un string informe para hacer las concatenaciones
//            String informe = "";
//
//            // linea de los titulos de columnas a mostrar
//            informe = "idInscripto ";
//            informe = informe + "idAlumno ";
//            informe = informe + "apellido ";
//            informe = informe + "nombre ";
//            informe = informe + "idMateria ";
//            informe = informe + "nombre ";
//            informe = informe + "anio ";
//            informe = informe + "nota";
//
//            //guardamos en el array
//            resumen.add(informe);
//
//            //bucle while recorre la tabla de resultados
//            while (rs.next()) {
//
//                //vamos incrementando el contador
//                can++;
//
//                //hacemos los system out para control
//                System.out.println("Registro: " + can);
//                System.out.println(rs.getInt("A.idInscripto"));
//                System.out.println(rs.getInt("A.idAlumno"));
//                System.out.println(rs.getString("B.apellido"));
//                System.out.println(rs.getString("B.nombre"));
//                System.out.println(rs.getInt("A.idMateria"));
//                System.out.println(rs.getString("C.nombre"));
//                System.out.println(rs.getInt("C.anio"));
//                System.out.println(String.valueOf(rs.getDouble("A.nota")));
//
//                //armado de la linea de datos obtenidos
//                informe = "Inscripcion Nº: ";
//                informe = informe + rs.getInt("A.idInscripto") + " ";
//                informe = informe + rs.getInt("A.idAlumno") + ":";
//                informe = informe + rs.getString("B.apellido") + " ";
//
//                //control de estado de alumno
//                if (rs.getBoolean("B.estado") == true) {
//                    informe = informe + rs.getString("B.nombre") + "(    ) ";
//                } else {
//                    informe = informe + rs.getString("B.nombre") + "(Baja) ";
//                }
//                informe = informe + rs.getInt("A.idMateria") + ":";
//                informe = informe + rs.getString("C.nombre") + " ";
//                informe = informe + rs.getInt("C.anio") + " ";
//                informe = informe + String.valueOf(rs.getDouble("A.nota"));
//
//                resumen.add(informe);
//
//            }
//            ps.close();
//
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error al acceder a las Bases de Datos. No se pudo realizr el informe de Inscripciones: " + ex);
//        }
//        //return inscripcion;         
//        return resumen;
        return resumen;
    }
    
       //método obtener Inscripciones segun video
    public List<Inscripcion> obtenerInscripcionesPorAlumno(int idAlumno) {      
     ArrayList<Inscripcion> inscripcion = new ArrayList<>();
        
        String sql = "SELECT A.idinscripto, A.idAlumno, A.idMateria, B.nombre, A.nota, B.anio "                
                + "FROM inscripcion A, materia B "
                + "WHERE A.idAlumno = ? AND A.idMateria = B.idMateria";
        try {        
            PreparedStatement ps = con.prepareStatement(sql);
            //seteamos el id de materia que viene por parametro
            ps.setInt(1, idAlumno);        
            ResultSet rs = ps.executeQuery();         
            // las dos lineas siguientes toman la cantidad de registros traidos desde SQL
            //rs.last();
            //int cantidadRegistrosSql = rs.getRow();        
            // las dos lineas siguientes toman la primera posicion de registros traidos desde SQL
            //rs.beforeFirst();
            //int posicionInicialPunteroSql=rs.getRow();
            while (rs.next())            
            {                
                Alumno alum = new Alumno();
                Materia mater = new Materia();
                Inscripcion inscrip=new Inscripcion();
                //posicionInicialPunteroSql=rs.getRow();
                //Inscripcion inscrip=new Inscripcion();
             inscrip.setIdInscripcion(rs.getInt("A.idInscripto"));             
             //inscrip.setNota(rs.getDouble("A.nota"));                             
             //inscrip.setNota(rs.getDouble("A.nota"));                             
             inscrip.setNota(rs.getDouble(5));                             
                //alum.setIdAlumno(rs.getInt("A.idAlumno"));                
                alum.setIdAlumno(rs.getInt(2));                
                //mater.setIdMateria(rs.getInt("A.idMateria"));                                
                mater.setIdMateria(rs.getInt(3));                                
                //mater.setNombre(rs.getString("B.nombre"));                
                mater.setNombre(rs.getString(4));                
                //mater.setAño(rs.getInt("B.anio"));                
                mater.setAño(rs.getInt(6));                
             inscrip.setAlumno(alum);                
             inscrip.setMateria(mater);                
                inscripcion.add(inscrip);  
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a las Bases de Datos de Inscripcion: " + ex);
        }
        //return inscripcion;         
        /*
        for(Inscripcion inscrip2:inscripcion){      
           System.out.println("recorro al Array a pasar a la tabla antes de ir armarla");
           System.out.println("idMAteria: "+inscrip2.getMateria().getIdMateria());
           System.out.println("Nombre: "+inscrip2.getMateria().getNombre());
           System.out.println("Nota: "+inscrip2.getNota());                      
        }
        */
       // System.out.println("IMPRIMIENDO LISTA DE INSCRIPCIONES: "+inscripcion);
        return inscripcion;
    };
          
        //método obtener materias cursadas
    public List<Materia> obtenerMateriasCursadas(int id) {
        List<Materia> materias = new ArrayList<Materia>();

        String sql = "SELECT inscripcion.idMateria, nombre, anio, inscripcion.nota FROM inscripcion,"
                + " materia WHERE inscripcion.idMateria = materia.idMateria\n"
                + "AND inscripcion.idAlumno = ?;";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Materia materia;
            while (rs.next()) {
                materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAño(rs.getInt("anio"));
                materias.add(materia);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener Inscripciones" + ex.getMessage());
        }
        return materias;
    }
      
        //método obtener materias no cursadas
    public List<Materia> obtenerMateriasNoCursadas(int id) {
        List<Materia> materias = new ArrayList<Materia>();

        String sql = "SELECT * FROM materia WHERE estado=1 AND idMateria not in "
                + "(SELECT idMateria FROM inscripcion WHERE idAlumno = ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Materia materia;
            while (rs.next()) {
                materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAño(rs.getInt("anio"));
                materias.add(materia);

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener Inscripciones" + ex.getMessage());
        }
        return materias;
    }
    
        //método borrar inscripcion materia alumno
    public int borrarInscripcionMateriaAlumno(int idAlumno, int idMateria) {
        String sql = "DELETE FROM inscripcion WHERE idAlumno=? AND idMateria=?";
        int exito = 0;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ps.setInt(2, idMateria);
            exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Alumno y su Materia Borrado");
            } else {
                JOptionPane.showMessageDialog(null, "Alumno y/o su Materia inexistente");
            };
            ps.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Inscripcion. No se pudo Borrar el alumno y/o su Materia" + ex.getMessage());
        }
        return exito;
    }
          
        //método actualizar nota
    public void actualizarNota(int idAlumno, int idMateria, double nota) {
        String sql = "UPDATE inscripcion SET nota = ? WHERE idAlumno = ? and idMateria =?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, nota);
            ps.setInt(2, idAlumno);
            ps.setInt(3, idMateria);

            int filas = ps.executeUpdate();
            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Nota Actualizada");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripción");
        }
    }

    //método obtener alumnos por materia SEGUN EL VIDEO
    public List<Alumno> obtenerAlumnosXMateria(int idMateria) {
        ArrayList<Alumno> alumnosMateria = new ArrayList<>();
        String sql = "SELECT a.idAlumno, dni, nombre, apellido, fechaNacimiento, estado "                
                + "FROM inscripcion i, alumno a "
                + "WHERE i.idAlumno = a.idAlumno AND idMateria = ? AND a.estado = 1 "
                + "ORDER BY apellido";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            //seteamos el id de materia que viene por parametro
            ps.setInt(1, idMateria);
            ResultSet rs = ps.executeQuery();            
            while (rs.next())
            {
                Alumno alumno=new Alumno();
                alumno.setIdAlumno(rs.getInt("a.idAlumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setFechaNac(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setActivo(rs.getBoolean("estado"));
                alumnosMateria.add(alumno);                
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a las Bases de Datos de Inscripcion: " + ex);
        }
        //return inscripcion;         
        return alumnosMateria;
    }
    
    // VERSION DISTINTA A LA QUE PROPONE EL VIDEO    
    public List<String> ANTESobtenerAlumnosXMateria(int idMateria) {
    //ArrayList<Inscripcion> inscripcion = new ArrayList<>();
    ArrayList<String> resumen = new ArrayList<>();
    /*    
        String sql = "SELECT C.nombre, A.idInscripto, A.idAlumno, B.apellido, B.nombre, B.estado "
                + "FROM inscripcion A, alumno B, materia C "
                + "WHERE A.idMateria=? AND A.idAlumno=B.idAlumno AND A.idMateria=C.idMateria "
                + "ORDER BY A.idInscripto";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);

            //seteamos el id de materia que viene por parametro
            ps.setInt(1, idMateria);
            ResultSet rs = ps.executeQuery();

            //contador
            int can = 0;

            //string para concatenar los resultados y los titulos
            String informe = "";

            // linea del titulo de columnas a mostrar
            informe = "Materia ";
            informe = informe + "idInscripto ";
            informe = informe + "idAlumno ";
            informe = informe + "apellido ";
            informe = informe + "nombre ";

            resumen.add(informe);
            while (rs.next()) {

                //incrementamos el contador
                can++;

                System.out.println("Materia: ");
                System.out.println(rs.getString("C.nombre"));
                System.out.println(rs.getInt("A.idInscripto"));
                System.out.println(rs.getInt("A.idAlumno"));
                System.out.println(rs.getString("B.apellido"));
                System.out.println(rs.getString("B.nombre"));

                informe = "Inscripcion Nº: ";
                informe = informe + rs.getInt("A.idInscripto") + " ";
                informe = informe + rs.getString("C.nombre") + " ";
                informe = informe + rs.getInt("A.idAlumno") + ":";
                informe = informe + rs.getString("B.apellido") + " ";
                if (rs.getBoolean("B.estado") == true) {
                    informe = informe + rs.getString("B.nombre") + "(    ) ";
                } else {
                    informe = informe + rs.getString("B.nombre") + "(Baja) ";
                }

                resumen.add(informe);

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a las Bases de Datos. No se pudo realizr el informe de Alumnos x Materia: " + ex);
        }
        //return inscripcion;             
    */
        return resumen;
    }
    
    /*
    public List<Inscripcion> obtenerInscripcionesPorAlumno(int idAlumno) {
        System.out.println("Antes de instanciar el arraylist");
        System.out.println("idAlumno a tomar: "+idAlumno);
     ArrayList<Inscripcion> inscripcion = new ArrayList<>();
        Alumno alum = new Alumno();
        Materia mater = new Materia();
        Inscripcion inscrip=new Inscripcion();
        String sql = "SELECT A.idinscripto, A.idAlumno, A.idMateria, B.nombre, A.nota, B.anio "                
                + "FROM inscripcion A, materia B "
                + "WHERE A.idAlumno = ? AND A.idMateria = B.idMateria";
        try {
            System.out.println("Antes del PreparedStatement");
            PreparedStatement ps = con.prepareStatement(sql);
            //seteamos el id de materia que viene por parametro
            ps.setInt(1, idAlumno);
            System.out.println("Antes del Resulset");
            ResultSet rs = ps.executeQuery(); 
            System.out.println("Despues del Resulset");            
            System.out.println("Entrando al while" + rs.next());           
            // las dos lineas siguientes toman la cantidad de registros traidos desde SQL
            rs.last();
            int cantidadRegistrosSql = rs.getRow();
            System.out.println("Cantidad de registros encontrados en Sql: " + cantidadRegistrosSql);                        
            // las dos lineas siguientes toman la primera posicion de registros traidos desde SQL
            rs.beforeFirst();
            int posicionInicialPunteroSql=rs.getRow();
            System.out.println("Primera posicion a leer desde Sql: " + posicionInicialPunteroSql);                                    
            while (rs.next())            
            {                
                posicionInicialPunteroSql=rs.getRow();
                System.out.println("Nro registro leido de sql: " + posicionInicialPunteroSql);                        
                System.out.println("Paso1");
                //Inscripcion inscrip=new Inscripcion();
                  System.out.println(rs.getInt("A.idInscripto"));
             inscrip.setIdInscripcion(rs.getInt("A.idInscripto"));             
                  System.out.println(rs.getDouble("A.nota"));                
             inscrip.setNota(rs.getDouble("A.nota"));             
                System.out.println("Paso2");
                //Alumno alum = new Alumno();
                System.out.println("Paso3");
                //Materia mater = new Materia();
                System.out.println("Paso4");        
                  System.out.println(rs.getInt("A.idAlumno"));                
                alum.setIdAlumno(rs.getInt("A.idAlumno"));
                System.out.println("Paso5");
                  System.out.println(rs.getInt("A.idMateria"));                
                mater.setIdMateria(rs.getInt("A.idMateria"));                
                System.out.println("Paso6");
                  System.out.println(rs.getString("B.nombre"));                
                mater.setNombre(rs.getString("B.nombre"));
                System.out.println("Paso7");
                  System.out.println(rs.getInt("B.anio"));                
                mater.setAño(rs.getInt("B.anio"));
                System.out.println("Paso8");                
             inscrip.setAlumno(alum);
                System.out.println("Paso9");
             inscrip.setMateria(mater);
                System.out.println("Paso10");             
                inscripcion.add(inscrip);  
                System.out.println(inscrip.getIdInscripcion()+"/"+inscrip.getAlumno().getIdAlumno()+"/"+inscrip.getMateria().getIdMateria()+"/"+inscrip.getNota());                             
                System.out.println(inscrip.toString());                             
                
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a las Bases de Datos de Inscripcion: " + ex);
        }
        //return inscripcion;         
        System.out.println("Paso11");
        System.out.println("datos a enviar a la tabla");                             
        for(Inscripcion inscrip2:inscripcion){      
           System.out.println("recorro al Array a pasar a la tabla antes de ir armarla");
           System.out.println("idMAteria: "+inscrip2.getMateria().getIdMateria());
           System.out.println("Nombre: "+inscrip2.getMateria().getNombre());
           System.out.println("Nota: "+inscrip2.getNota());                      
        }
        System.out.println("FINAL recorrido del Array ");
        return inscripcion;
    };
    */
}

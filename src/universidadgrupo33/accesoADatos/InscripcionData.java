
package universidadgrupo33.accesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.swing.JOptionPane;
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
            ps.setObject(2, insc.getAlumno());
            ps.setObject(3, insc.getMateria());
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
             
         
         
         };
         
         //método obtener Inscripciones
          public List<Inscripcion> obtenerInscripciones() {
          
          
          };
          
        //método obtener Inscripciones por alumno
          public List<Inscripcion> obtenerInscripcionesPorAlumno(int id) {
          
          
          };
          
        //método obtener materias cursadas
          public List<Materia> obtenerMateriasCursadas(int id) {
          
          
          };
          
        //método obtener materias no cursadas
          public List<Materia> obtenerMateriasNoCursadas(int id) {
          
          
          };
          
        //método borrar inscripcion materia alumno
          public void borrarInscripcionMateriaAlumno(int idAlumno, int idMateria){
          
          
          };
          
        //método actualizar nota
          public void actualizarNota(int idAlumno, int idMateria, double nota){
          
          
          };
          
        //método obtener alumnos por materia
          public List<Materia> obtenerAlumnosXMateria(int idMateria) {
          
          
          };
    
         
}

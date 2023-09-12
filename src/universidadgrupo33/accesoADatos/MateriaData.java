
package universidadgrupo33.accesoADatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import universidadgrupo33.entidades.Materia;

public class MateriaData {
     private Connection con = null;
     
     public MateriaData() {
        con = Conexion.getConexion();
    }
     
     //METODOS
     
     //Método guardarMateria
     public void guardarMateria(Materia materia) {
        String sql = "INSERT INTO materia (nombre, anio, estado) VALUES (?, ?, ?)";

        try {

            //preguntar al mentor el RETURN_GENERATED_KEYS
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAño());
            ps.setBoolean(3, materia.isEstado());
            ps.executeUpdate();
            ps.getGeneratedKeys();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                materia.setIdMateria(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Materia guardada");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo realizar el guardado de la materia");
            }
            ps.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia (insert)");
        }
         
         
         
     };
     
    
     //Método buscarMateria
      public Materia buscarMateria(int id) {
          
        String sql = "SELECT nombre, anio FROM materia WHERE idMateria=? AND estado=1";
        Materia materia = null;

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                materia = new Materia();
                materia.setIdMateria(id);
                materia.setNombre(rs.getString("nombre"));
                materia.setAño(rs.getInt("anio"));
             
                materia.setEstado(true);

            } else {
                JOptionPane.showMessageDialog(null, "No existe esa materia");
            };
            ps.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Materia. No se pudo buscar la materia");
        }

        return materia;
          
          
          
      
      };
      
     //Método modificarMateria
      public void modificarMateria(Materia materia) {
          
          String sql = "UPDATE materia SET nombre=?, anio=? WHERE idMateria=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAño());
            ps.setInt(3, materia.getIdMateria());
            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Materia modificada");
            } else {
                JOptionPane.showMessageDialog(null, "Materia inexistente");
            };

        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Materia. No se pudo modificar la materia");
        }
          
          
      
      };
      
     //Método eliminarMateria
      public void eliminarMateria(int id) {
          
          String sql = "UPDATE materia SET estado = 0 WHERE idMateria=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Materia eliminada");
            } else {
                JOptionPane.showMessageDialog(null, "Materia inexistente");
            };
            ps.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Materia. No se pudo eliminar la materia" + ex.getMessage());
        }
          
          
      
      };
      
     //Método listarMaterias
      public List<Materia> listarMaterias() {
          
        String sql = "SELECT idMateria, nombre, anio FROM materia WHERE estado = 1";
        ArrayList<Materia> materias = new ArrayList<>();
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();

            while (rs.next()) {
                Materia materia=new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAño(rs.getInt("anio"));
                materia.setEstado(true);
                
                materias.add(materia);
                
            }
            ps.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno. No se pudo buscar el alumno");
        }

        return materias;
          
          
      
      };
      
   
     
     
     
}

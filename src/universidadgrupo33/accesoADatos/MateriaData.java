// dia: 22/09/23 hs: 4:00am
package universidadgrupo33.accesoADatos;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.logging.Level;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import universidadgrupo33.entidades.Materia;

public class MateriaData {
     private Connection con = null;
     public static TreeSet<Materia> listaMaterias=new TreeSet<>();
     
     public MateriaData() {
        con = Conexion.getConexion();
    }
     
     //METODOS
     
     //Método guardarMateria
     public int guardarMateria(Materia materia) {
        String sql = "INSERT INTO materia (nombre, anio, estado) VALUES (?, ?, ?)";
        int exito=0; 
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
                exito = 1;
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo realizar el guardado de la materia");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia (insert)");
        }
        return exito;
     };
     
    
     //Método buscarMateria
      public Materia buscarMateria(int id, int bajaActivo) {
          
        //String sql = "SELECT nombre, anio, estado FROM materia WHERE idMateria=? AND estado=?";
        String sql = "SELECT nombre, anio, estado FROM materia WHERE idMateria=?";
        Materia materia = null;

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setInt(2, bajaActivo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                materia = new Materia();
                materia.setIdMateria(id);
                materia.setNombre(rs.getString("nombre"));
                materia.setAño(rs.getInt("anio"));                             
                materia.setEstado(rs.getBoolean("estado"));
                JOptionPane.showMessageDialog(null, "MATERIA ENCONTRADA");
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
      public int modificarMateria(Materia materia) {          
        String sql = "UPDATE materia SET nombre=?, anio=? WHERE idMateria=?";
        int exito=0; 
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAño());
            ps.setInt(3, materia.getIdMateria());
            exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Materia modificada");
            } else {
                JOptionPane.showMessageDialog(null, "Materia inexistente");
            };
        } catch (SQLException ex) {            
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Materia. No se pudo modificar la materia");
        }
        return exito;
      };
      
     //Método eliminarMateria
      public int eliminarMateria(int id) {          
        String sql = "UPDATE materia SET estado = 0 WHERE idMateria=?";
        int exito = 0;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Materia eliminada");
            } else {
                JOptionPane.showMessageDialog(null, "Materia inexistente");
            };
            ps.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Materia. No se pudo eliminar la materia" + ex.getMessage());
        }
        return exito;
      };
      
      //método Recuperar un alumno eliminado logicamente
    public int recuperarMateria(int id) {
        String sql = "UPDATE materia SET estado = 1 WHERE idMateria=?";        
        //System.out.println("id=" + id);
        int exito=0;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            exito = ps.executeUpdate();
            //System.out.println("variable exito=" + exito);
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Materia Recuperada");
            } else {
                JOptionPane.showMessageDialog(null, "Materia inexistente");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Materia. No se pudo Recuperar al alumno" + ex.getMessage());
        }
        return exito;
    }
    
    //Método listarMaterias ANTERIOR para buscar en un COMBOBOX
    public List<Materia> listarMaterias() {          
        String sql = "SELECT idMateria, nombre, anio, estado FROM materia WHERE estado = 1 ORDER BY nombre";        
        ArrayList<Materia> materias = new ArrayList<>();
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();

            while (rs.next()) {
                Materia materia=new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAño(rs.getInt("anio"));
                materia.setEstado(rs.getBoolean("estado"));                
                materias.add(materia);                
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Mateteria. No se pudo buscar el alumno");
        }
        return materias;         
      };
      
     //Método listarMaterias NUEVA para buscar en una JTABLE
      public TreeSet<Materia> listarMateriasJTable() {          
        String sql = "SELECT idMateria, nombre, anio, estado FROM materia WHERE estado = 1 ORDER BY nombre";            
        TreeSet<Materia> materias=new TreeSet<>();
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {
                Materia mater=new Materia();
                mater.setIdMateria(rs.getInt("idMateria"));
                mater.setNombre(rs.getString("nombre"));
                mater.setAño(rs.getInt("anio"));
                mater.setEstado(rs.getBoolean("estado"));                
                //System.out.println("1)"+mater.toString());
                //System.out.println("2)"+materias);
                materias.add(mater);                
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Mateteria. No se pudo buscar el alumno");
        }
        catch (Exception ex2) {
            JOptionPane.showMessageDialog(null, "Error 2:"+ex2);
        }
        return materias;         
      };
      
      
      //Método proximoIdMateria
      public Materia proximoIdMateria() {                  
        String sql = "SELECT idMateria, nombre, anio, estado FROM materia ORDER BY idMateria DESC";
        Materia materia = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);            
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAño(rs.getInt("anio"));                             
                materia.setEstado(rs.getBoolean("estado"));
                //JOptionPane.showMessageDialog(null, "MATERIA ENCONTRADA");             
            } 
            /*
            else {
                //JOptionPane.showMessageDialog(null, "No existe esa materia");
            };
            */
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Materia. No se pudo buscar la materia");
        }
        return materia;
      };
      
      
     
}

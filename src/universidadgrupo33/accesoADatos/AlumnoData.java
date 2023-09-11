
package universidadgrupo33.accesoADatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import universidadgrupo33.entidades.Alumno;

public class AlumnoData {
    
    private Connection con=null;
    
    public AlumnoData(){
    
        con=Conexion.getConexion();
        
    }
    
    
    //método guardar alumno
    public void guardarAlumno(Alumno alumno){
    
        String sql="INSERT INTO alumno (dni, apellido, nombre, fechaNacimiento, estado) VALUES (?, ?, ?, ?, ?)";
        
       try {
           
       //preguntar al mentor el RETURN_GENERATED_KEYS
       PreparedStatement ps=con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
       ps.setInt(1, alumno.getDni());
       ps.setString (2, alumno.getApellido());
       ps.setString(3, alumno.getNombre());
       ps.setDate (4, Date.valueOf(alumno.getFechaNac()));
       ps.setBoolean(5, alumno.isActivo());
       ps.executeUpdate();
       ps.getGeneratedKeys();
       
       ResultSet rs=ps.getGeneratedKeys();
       
       if (rs.next()){
           alumno.setIdAlumno(rs.getInt(1));
           JOptionPane.showMessageDialog(null, "Alumno guardado");
       }else{JOptionPane.showMessageDialog(null, "No se pudo realizar el guardado del alumno");}
       ps.close();
       
       
       }catch(SQLException ex){
          
           JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno (insert)");
           
       }
    
    }
    
    
    //método modificar alumno
    public void modificarAlumno(Alumno alumno){
        
        String sql="UPDATE alumno SET dni=?, apellido=?, nombre=?, fechaNacimiento=? WHERE idAlumno=?";
    
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNac()));
            ps.setInt(5, alumno.getIdAlumno());
            int exito=ps.executeUpdate();
            
            if (exito==1){
            JOptionPane.showMessageDialog(null, "Alumno modificado");
            }else{
            JOptionPane.showMessageDialog(null, "Alumno inexistente");
            };
            
            
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno. No se pudo modificar del alumno");
        }
    
    };
    
    //método eliminar alumno
    public void eliminarAlumno(int id){
        
        String sql= "UPDATE alumno SET estado = 0 WHERE idAlumno=?";
        
        
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt (1, id);
            int exito=ps.executeUpdate();
            if(exito==1){
            JOptionPane.showMessageDialog(null, "Alumno eliminado");
            }else{
            JOptionPane.showMessageDialog(null, "Alumno inexistente");
            };
            ps.close();
            
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno. No se pudo eliminar alumno" + ex.getMessage());
        }
    
    
    };
    
    
}

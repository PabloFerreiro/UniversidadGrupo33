
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
           
       
       };
       
       
       }catch(SQLException ex){
          
           JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno (insert)");
           
       }
    
    }
    public void modificarAlumno(Alumno alumno){
        String sql = "UPDATE alumno SET dni=?,apellido=?,nombre=?,fechaNacimiento=?"
                + "WHERE idAlumno=?";
        
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNac()));
            ps.setInt(5, alumno.getIdAlumno());
            int exito=ps.executeUpdate();
            if (exito == 1){
                JOptionPane.showMessageDialog(null, "Alumno modificado");
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno!");
        }
    }
    
    
}

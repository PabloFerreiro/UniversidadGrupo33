// dia: 18/09/23 hs: 12:20
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
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import universidadgrupo33.entidades.Alumno;

public class AlumnoData {

    private Connection con = null;

    public AlumnoData() {

        con = Conexion.getConexion();

    }

    //método guardar alumno
    public int guardarAlumno(Alumno alumno) {
        String sql = "INSERT INTO alumno (dni, apellido, nombre, fechaNacimiento, estado) VALUES (?, ?, ?, ?, ?)";
        int exito=0; 
        try {
            //preguntar al mentor el RETURN_GENERATED_KEYS
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNac()));
            ps.setBoolean(5, alumno.isActivo());
            ps.executeUpdate();            
            ps.getGeneratedKeys();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                alumno.setIdAlumno(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Alumno guardado");
                exito = 1;
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo realizar el guardado del alumno");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno (insert)");
        }
        return exito;
    }

    //método modificar alumno
    public int modificarAlumno(Alumno alumno) {        
        String sql = "UPDATE alumno SET dni=?, apellido=?, nombre=?, fechaNacimiento=?, estado=? WHERE idAlumno=?";
        int exito=0; 
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNac()));
            ps.setBoolean(5, alumno.isActivo());            
            ps.setInt(6, alumno.getIdAlumno());
            //System.out.println("idAlumno en modificar="+alumno.getIdAlumno());
            exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Alumno modificado");
            } else {
                JOptionPane.showMessageDialog(null, "Alumno inexistente");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno. No se pudo modificar del alumno");
        }
        return exito;
    }

    //método eliminar alumno
    public int eliminarAlumno(int id) {
        String sql = "UPDATE alumno SET estado = 0 WHERE idAlumno=?";        
        System.out.println("id=" + id);
        int exito=0;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            exito = ps.executeUpdate();
            //System.out.println("variable exito=" + exito);
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Alumno eliminado");
            } else {
                JOptionPane.showMessageDialog(null, "Alumno inexistente");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno. No se pudo eliminar alumno" + ex.getMessage());
        }
        return exito;
    }
    
    //método Recuperar un alumno eliminado logicamente
    public int recuperarAlumno(int id) {
        String sql = "UPDATE alumno SET estado = 1 WHERE idAlumno=?";        
        //System.out.println("id=" + id);
        int exito=0;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            exito = ps.executeUpdate();
            //System.out.println("variable exito=" + exito);
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Alumno Recuperado");
            } else {
                JOptionPane.showMessageDialog(null, "Alumno inexistente");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno. No se pudo Recuperar al alumno" + ex.getMessage());
        }
        return exito;
    }
    
    //método buscar alumno
    public Alumno buscarAlumno(int id, int bajaActivo) {
        String sql = "SELECT dni, apellido, nombre, fechaNacimiento, estado FROM alumno WHERE idAlumno=? AND estado=?";
        Alumno alumno = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setInt(2, bajaActivo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                alumno = new Alumno();
                alumno.setIdAlumno(id);
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNac(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setActivo(rs.getBoolean("estado"));
                // no se hace esta asignacion porque se entiende por defecto de que lo que 
                // esta trayendo del sql son registros activos-true-
                //alumno.setActivo(rs.getBoolean("estado"));
            } else {
                JOptionPane.showMessageDialog(null, "No existe ese alumno");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno. No se pudo buscar el alumno");
        }
        return alumno;
    }
        
    //método buscar alumno por dni
    public Alumno buscarAlumnoPorDni(int dni, int bajaActivo) {
        //String sql = "SELECT idAlumno, dni, apellido, nombre, fechaNacimiento, estado FROM alumno WHERE dni = ? AND estado = ?";
        String sql = "SELECT idAlumno, dni, apellido, nombre, fechaNacimiento, estado FROM alumno WHERE dni = ?";
        Alumno alumno = null;
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, dni);
            //ps.setInt(2, bajaActivo);
            ResultSet rs=ps.executeQuery();
            if (rs.next()) {
                alumno=new Alumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNac(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setActivo(rs.getBoolean("estado"));                
                // no se hace esta asignacion porque se entiende por defecto de que lo que 
                // esta trayendo del sql son registros activos-true-
                //alumno.setActivo(rs.getBoolean("estado"));
                JOptionPane.showMessageDialog(null, "ALUMNO ENCONTRADO");
            } else {
                JOptionPane.showMessageDialog(null, "No existe ese alumno");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno. No se pudo buscar el alumno");
        }
        return alumno;
    }
    
    //método listar alumnos
    public List<Alumno> listarAlumnos(int bajaActivo) {
        String sql = "SELECT idAlumno, dni, apellido, nombre, fechaNacimiento, estado FROM alumno WHERE estado = ?"
                + " ORDER BY apellido, nombre ";
        ArrayList<Alumno> alumnos = new ArrayList<>();
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, bajaActivo);
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {
                Alumno alumno=new Alumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNac(rs.getDate("fechaNacimiento").toLocalDate());                
                alumno.setActivo(rs.getBoolean("estado"));                
                // no se hace esta asignacion porque se entiende por defecto de que lo que 
                // esta trayendo del sql son registros activos-true-
                //alumno.setActivo(rs.getBoolean("estado"));
                alumnos.add(alumno);                
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno. No se pudo buscar el alumno");
        }
        return alumnos;
    }
    
    
    
    
    
    
}

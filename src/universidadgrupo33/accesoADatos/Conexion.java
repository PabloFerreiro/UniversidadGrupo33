// dia: 22/09/23 hs: 4:00am
package universidadgrupo33.accesoADatos;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexion {
    //atributos del tipo estatico y final (constantes)
    private static final String URL="jdbc:mariadb://localhost/";
    private static final String DB="universidadgrupo33";
    private static final String USUARIO="root";
    private static final String PASSWORD="";
    private static Connection connection;
    
    //constructor vacio
    private Conexion(){}
    
    //Método para conectarse
    public static Connection getConexion(){
        
        //condicional para ver si la conexion es nula
        if(connection==null){
            //try catch para las excepciones (del driver y de la conexion)
            try {
                
                //carga y registro del driver
                Class.forName("org.mariadb.jdbc.Driver");
                
                // conexion a la base de datos
                //connection = DriverManager.getConnection(URL+DB, USUARIO, PASSWORD);
                
                connection = DriverManager.getConnection(URL+DB + "?useLegacyDatetimeCode=false&serverTimezone=UTC"
                  + "&user=" + USUARIO+ "&password=" + PASSWORD);
                
                //borrar despues si se quiere este JOptionPane
                JOptionPane.showMessageDialog(null,"Se conecto a la base de datos");
                
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null,"Error al cargar los drivers");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"Error al conectarse a la base de datos");
            }
        
        }
    return connection;
    }
    
}

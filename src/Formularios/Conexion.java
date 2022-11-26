package Formularios;
import java.sql.*;
import javax.swing.JOptionPane;
public class Conexion{

    private final String URL = "jdbc:mysql://localhost:3306/tt_hugo";// Driver@MachineName:Port/SID
    private final String USERID = "root";// USER ID
    private final String PASSW = "";// PASSW

    public Conexion() {
    }
    
    public Connection realizarConexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection  conexion = DriverManager.getConnection(URL,USERID,PASSW);
            return conexion;
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse a la Base de Datos", "Error de Conexion", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}
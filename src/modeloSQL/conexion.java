/**
 * Esta clase implementa la conexion al SGBD de 
 * PostgreSQL
 */
package modeloSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.modeloSesionUsuario;
import vista.vistaSesionUsuario;

public class conexion{
    private final String baseDatos = "caeaconafe";
    private String usuario;
    private String password;
    private final String url = "jdbc:postgresql://localhost:5432/" + baseDatos;
    modeloSesionUsuario modeloSesionUsuario;
  
    public Connection getConexion(vistaSesionUsuario sesionVista){        
        usuario = sesionVista.fieldUsuario.getText();
        String contraseña = new String (sesionVista.contraseña.getPassword());
        password = contraseña;
        
        Connection con = null;
        System.out.println(" :::::: Clase conexion :::::: ");
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url, usuario, password);
            System.out.println("C o n e c t a d o !!!");
        }
        catch (ClassNotFoundException e) {
            System.err.print(e.getMessage());
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            JOptionPane.showMessageDialog(sesionVista, "Datos incorrectos");
        }
        return con;
    }
    public Connection getConexion(modeloSesionUsuario modeloSesionUsuario){ 
        usuario = modeloSesionUsuario.getUsuario();
        String contraseña = modeloSesionUsuario.getPassword();
        password = contraseña;
        
        Connection con = null;
        System.out.println(" :::::: Clase conexion :::::: ");
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url, usuario, password);
            System.out.println("C o n e c t a d o !!!");
        }
        catch (ClassNotFoundException e) {
            System.err.print(e.getMessage());
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Datos incorrectos");
        }
        return con;
    }
}
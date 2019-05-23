package modeloSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.modeloAlumno;
import modelo.modeloSesionUsuario;
/**
 *
 * @author Dizan
 */
public class sqlAlumno {
    Connection con;
    conexion conexion;
    sqlSesionUsuario modeloUsuario;

    public sqlAlumno(sqlSesionUsuario modeloUsuario) {
        this.modeloUsuario = modeloUsuario;
    }
    
    public void insertarAlta(modeloAlumno alumno){
        
    }
      
}

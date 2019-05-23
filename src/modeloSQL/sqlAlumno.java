package modeloSQL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import modelo.modeloAlumno;
import modelo.modeloSesionUsuario;
/**
 *
 * @author Dizan
 */
public class sqlAlumno {
    Connection con;
    conexion conexion;
    modeloSesionUsuario modeloUsuario;
    boolean correctoInsertar;

    public sqlAlumno(modeloSesionUsuario modeloUsuario) {
        this.modeloUsuario = modeloUsuario;
    }
    
    public void insertarAlta(modeloAlumno alumno) throws SQLException{
        
        CallableStatement sql;
        String insert = "SELECT alta_alumno( ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String consulta = "call alta_alumno(?, ?, ?, ?, ?, ?, ?, ?. ?)";
        conexion = new conexion();
        try{
            con = conexion.getConexion(modeloUsuario);
            sql = con.prepareCall(consulta);
            sql.setInt(1, alumno.getNumeroControl());
            sql.setInt(2, alumno.getIdRegion());
            sql.setString(3, alumno.getNombre());
            sql.setString(4, alumno.getApe_paterno());
            sql.setString(5, alumno.getApe_materno());
            sql.setString(6, alumno.getSexo());
            sql.setString(7, alumno.getFecha_nacimiento());
            sql.setString(8, alumno.getCicloEscolar());
            sql.setInt(9, alumno.getGrado());
            sql.execute();
        }
        catch (final SQLException e){
            correctoInsertar = false;
            System.err.print(e.getMessage());
            throw e;
        }
    }
}

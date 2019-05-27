package modeloSQL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.modeloSesionUsuario;
/**
 *
 * @author Dizan
 */
public class sqlReinscribir {
    Connection con;
    conexion conexion;
    modeloSesionUsuario modeloUsuario;

    public sqlReinscribir(modeloSesionUsuario modeloUsuario) {
        this.modeloUsuario = modeloUsuario;
    }
   
    public Date obtenerFechaActual() throws SQLException{
        Date fechaActual = null;
        ResultSet Resultados;
        PreparedStatement sql;
        conexion = new conexion();
        try {
            con = conexion.getConexion(modeloUsuario);
            sql = con.prepareStatement("SELECT current_date");
            Resultados = sql.executeQuery();
            while(Resultados.next()){
                fechaActual = Resultados.getDate(1);
            }
        } 
        catch (SQLException e){
            System.err.print(e.getMessage());
            throw e; 
        }
        finally {
            try{
                con.close();
            } 
            catch (SQLException e) {
                System.err.print(e.getMessage());
                throw e; 
            }
        }
        return fechaActual;
    }
    
    public void reinscribir(){
        
    }
    
    public int existe(int nocontrol, String nuevoCicloescolar) throws SQLException{
        int existe = 0;
        ResultSet Resultados;
        PreparedStatement sql;
        conexion = new conexion();
        try {
            con = conexion.getConexion(modeloUsuario);
            sql = con.prepareStatement("SELECT count(*) from grado_alumno where nocontrol = ? and idcicloescolar = ?");
            sql.setInt(1, nocontrol);
            sql.setString(2, nuevoCicloescolar);
            Resultados = sql.executeQuery();
            while(Resultados.next()){
                existe = Resultados.getInt(1);
            }
        } 
        catch (SQLException e){
            System.err.print(e.getMessage());
            throw e; 
        }
        finally {
            try{
                con.close();
            } 
            catch (SQLException e) {
                System.err.print(e.getMessage());
                throw e; 
            }
        }
        return existe;
        
    }
}

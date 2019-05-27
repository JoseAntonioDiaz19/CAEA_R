package modeloSQL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.modeloGrado_Alumno;
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
    
    public void reinscribir(modeloGrado_Alumno modeloGrado_Alumno) throws SQLException{
        CallableStatement sql;
        conexion = new conexion();
        PreparedStatement psql;
        
        try{
            con = conexion.getConexion(modeloUsuario);
            psql=con.prepareStatement("INSERT INTO grado_alumno(nocontrol,idgrado,idsituacion,idcicloescolar,idestado,idestado_actual_final) VALUES (?,?,?,?,?,?)");
            
            psql.setInt(1, modeloGrado_Alumno.getNocontrol());
            psql.setInt(2, modeloGrado_Alumno.getIdgrado());
            psql.setInt(3, modeloGrado_Alumno.getIdsituacion());
            psql.setString(4, modeloGrado_Alumno.getIdcicloescolar());
            psql.setInt(5, modeloGrado_Alumno.getIdestado());
            psql.setInt(6, modeloGrado_Alumno.getIdestado_actual_final());
            psql.execute();    
        }catch (final SQLException e){
            System.err.print(e.getMessage()); 
            throw e; 
        }
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

package modeloSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.modeloAvances;
import modelo.modeloSesionUsuario;
/**
 * @author Dizan
 */
public class sqlAvances {
    Connection con;
    conexion conexion;
    modeloSesionUsuario modeloUsuario;

    public sqlAvances(modeloSesionUsuario modeloUsuario) {
        this.modeloUsuario = modeloUsuario;
    }
    
    
        
    public modeloAvances datosAlumno(int nocontrol){
        modeloAvances modeloAvances = new modeloAvances();
        ResultSet Resultados;
        PreparedStatement sql;
        conexion = new conexion();
        try 
        {
            con = conexion.getConexion(modeloUsuario);
            sql = con.prepareStatement("SELECT * FROM vista_datos_alumno WHERE nocontrol = ?");
            sql.setInt(1, nocontrol);
            Resultados = sql.executeQuery();
            while(Resultados.next()){
                
//                modeloDatosAlumno.setNombre(Resultados.getString("nombre"));
//                modeloDatosAlumno.setApe_paterno(Resultados.getString("ape_paterno"));
//                modeloDatosAlumno.setApe_materno(Resultados.getString("ape_materno"));
//                modeloDatosAlumno.setSexo(Resultados.getString("sexo"));
//                modeloDatosAlumno.setFecha_nacimiento(Resultados.getString("fecha_nacimiento"));
//                modeloDatosAlumno.setNocontrol(Resultados.getInt("nocontrol"));
//                modeloDatosAlumno.setCicloescolar(Resultados.getString("cicloescolar"));
//                modeloDatosAlumno.setRegion(Resultados.getString("region"));
//                modeloDatosAlumno.setGrado(Resultados.getInt("grado"));
//                modeloDatosAlumno.setSituacion(Resultados.getString("situacion"));
//                modeloDatosAlumno.setSituacion_final(Resultados.getString("estado_actual_final"));
            }
        } 
        catch (SQLException e) 
        {
            System.err.print(e.getMessage());
        }
        finally
        {
            try 
            {
                con.close();
            } 
            catch (SQLException e) 
            {
                System.err.print(e.getMessage());
            }
        }
        return modeloAvances;
    }
    
    public int obtenerIdgrado_alumno(int nocontrol, int idgrado, String cicloescolar ){
        int idgrado_alumno = 0;
        ResultSet Resultados;
        PreparedStatement sql;
        conexion = new conexion();
        try {
            con = conexion.getConexion(modeloUsuario);
            sql = con.prepareStatement("SELECT idgrado_alumno FROM grado_alumno WHERE nocontrol = ? and idgrado = ? and idcicloescolar = ?");
            sql.setInt(1, nocontrol);
            sql.setInt(2, idgrado);
            sql.setString(3, cicloescolar);
            Resultados = sql.executeQuery();
           
            while(Resultados.next()){
                idgrado_alumno = Resultados.getInt(1);
            }
        } 
        catch (SQLException e){
            System.err.print(e.getMessage());
        }
        finally {
            try{
                con.close();
            } 
            catch (SQLException e) {
                System.err.print(e.getMessage());
            }
        }
        return idgrado_alumno;
    }
    
    public int obtenerEtapa(int idgrado_alumno, int trimestre ){
        int idetapa = 0;
        ResultSet Resultados;
        PreparedStatement sql;
        conexion = new conexion();
        try {
            con = conexion.getConexion(modeloUsuario);
            sql = con.prepareStatement("SELECT idetapa FROM avance WHERE idgrado_alumno = ? and trimestre = ?");
            sql.setInt(1, idgrado_alumno);
            sql.setInt(2, trimestre);
            
            Resultados = sql.executeQuery();
           
            while(Resultados.next()){
                idetapa = Resultados.getInt(1);
            }
        } 
        catch (SQLException e){
            System.err.print(e.getMessage());
        }
        finally {
            try{
                con.close();
            } 
            catch (SQLException e) {
                System.err.print(e.getMessage());
            }
        }
        return idetapa;
    }
}

package modeloSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.modeloDatosAlumno;
import modelo.modeloSesionUsuario;
/**
 *
 * @author Dizan
 */
public class sqlDatosAlumno {
    Connection con;
    conexion conexion;
    modeloSesionUsuario modeloUsuario;
    private boolean correctoActualizar;
    
    public sqlDatosAlumno(modeloSesionUsuario modeloUsuario) {
        this.modeloUsuario = modeloUsuario;
    }
    
    public modeloDatosAlumno datosAlumno(int nocontrol){
        modeloDatosAlumno modeloDatosAlumno = new modeloDatosAlumno();
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
                
                modeloDatosAlumno.setNombre(Resultados.getString("nombre"));
                modeloDatosAlumno.setApe_paterno(Resultados.getString("ape_paterno"));
                modeloDatosAlumno.setApe_materno(Resultados.getString("ape_materno"));
                modeloDatosAlumno.setSexo(Resultados.getString("sexo"));
                modeloDatosAlumno.setFecha_nacimiento(Resultados.getString("fecha_nacimiento"));
                modeloDatosAlumno.setNocontrol(Resultados.getInt("nocontrol"));
                modeloDatosAlumno.setCicloescolar(Resultados.getString("cicloescolar"));
                modeloDatosAlumno.setRegion(Resultados.getString("region"));
                modeloDatosAlumno.setGrado(Resultados.getInt("grado"));
                modeloDatosAlumno.setSituacion(Resultados.getString("situacion"));
                modeloDatosAlumno.setSituacion_final(Resultados.getString("estado_actual_final"));
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
        return modeloDatosAlumno;
    }
    
     public ArrayList <String> situacion()
    {
        ArrayList <String> lista = null;
        ResultSet Resultados;
        PreparedStatement sql;
        conexion = new conexion();
        try 
        {
            con = conexion.getConexion(modeloUsuario);
            sql = con.prepareStatement("SELECT descripcion FROM situacion ");
                    
            Resultados = sql.executeQuery();
            lista = new ArrayList();
            while(Resultados.next())
            {
                lista.add(Resultados.getString("descripcion")
                );
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
            } catch (SQLException e) 
            {
                System.err.print(e.getMessage());
            }
        }
        return lista;
    }
     
    public void actualizar(modeloDatosAlumno alumno, 
                            int idregion, 
                            int idsituacion, 
                            int idsituacionfinal) throws SQLException{

        PreparedStatement sql;
        conexion = new conexion();
       
        try{
            con = conexion.getConexion(modeloUsuario);
            sql = con.prepareStatement("SELECT actualizar_datos_alumno(?,?,?,?,?,?,?,?,?,?,?)");
            sql.setInt(1, alumno.getNocontrol());
            sql.setInt(2, idregion);
            sql.setString(3,alumno.getNombre());
            sql.setString(4, alumno.getApe_paterno());
            sql.setString(5, alumno.getApe_materno());
            sql.setString(6, alumno.getSexo());
            sql.setString(7, alumno.getFecha_nacimiento());
            sql.setString(8, alumno.getCicloescolar());
            sql.setInt(9, alumno.getGrado());
            sql.setInt(10, idsituacion);
            sql.setInt(11, idsituacionfinal);
           
            sql.execute();
        }
        catch (final SQLException e){
            setCorrectoActualizar(false);
            System.err.print(e.getMessage());
            throw e;
        }  
    }
    /**
     * @return the correctoActualizar
     */
    public boolean isCorrectoActualizar() {
        return correctoActualizar;
    }

    /**
     * @param correctoActualizar the correctoActualizar to set
     */
    public void setCorrectoActualizar(boolean correctoActualizar) {
        this.correctoActualizar = correctoActualizar;
    }
}

        
//            upnocontrol INT, 
//            upidregion INT, 
//            upnombre VARCHAR(30), 
//            upape_paterno VARCHAR(30), 
//            upape_materno VARCHAR (30),  
//            upsexo CHAR(1),
//            upfecha_nacimiento DATE,
//            upcicloescolar VARCHAR(9),  
//            upidgrado INT, 
//            upidsituacion INT, 
//            upsituacionfinal INT
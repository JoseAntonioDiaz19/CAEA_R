package modeloSQL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.modeloSesionUsuario;
/**
 *
 * @author Dizan
 */
public class sqlCiclosEscolares {
    Connection con;
    conexion conexion;
    modeloSesionUsuario modeloUsuario;

    public sqlCiclosEscolares(modeloSesionUsuario modeloUsuario) {
        this.modeloUsuario = modeloUsuario;
    }
    
    public void nuevoCicloEscolar(String cicloescolar, String fechaInsReinsInicio, String fechaInsReinsFin) throws SQLException{
        CallableStatement sql = null;
        conexion = new conexion();
        PreparedStatement psql;
        try{
            con = conexion.getConexion(modeloUsuario);
            psql=con.prepareStatement("INSERT INTO cicloescolar VALUES (?,"+"'"+fechaInsReinsInicio+"'"+","+"'"+fechaInsReinsFin+"'"+")");
            psql.setString(1, cicloescolar);         
            psql.execute();
        }catch (final SQLException e){
            System.err.print(e.getMessage()); 
            throw e; 
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
    }
    
    public void actualizarCicloEscolar(String cicloescolar, String fechaInsReinsInicio, String fechaInsReinsFin) throws SQLException{
        PreparedStatement sql;
        conexion = new conexion();
        try{
            con = conexion.getConexion(modeloUsuario);
            sql = con.prepareStatement("UPDATE cicloescolar SET idcicloescolar = ?, "
                                    + "inicio_inscripcion/reinscripcion = "+"'"+fechaInsReinsInicio+"'"+", "
                                    + "final_inscripcion/reinscripcion = "+"'"+fechaInsReinsFin+"'");
            sql.setString(1, cicloescolar);
            sql.execute();
        }
        catch (final SQLException e){
            System.err.print(e.getMessage());
            throw e;
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
    } 
    
    public String obtenerFechaActual() throws SQLException{
        String fechaActual = "";
        ResultSet Resultados;
        PreparedStatement sql;
        conexion = new conexion();
        try {
            con = conexion.getConexion(modeloUsuario);
            sql = con.prepareStatement("SELECT current_date");
            Resultados = sql.executeQuery();
            while(Resultados.next()){
                fechaActual = Resultados.getString(1);
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
    
    public void eliminar(String cicloescolar) throws SQLException{
        conexion = new conexion();
        Statement statement;
        try{
            con = conexion.getConexion(modeloUsuario);
            statement = con.createStatement();
            statement.execute("DELETE FROM cicloescolar WHERE idcicloescolar = "+"'"+cicloescolar+"'") ;
            
        }catch (final SQLException e){
            System.err.print(e.getMessage()); 
            throw e; 
        }
    }
    
    public String obtenerAñoActual() throws SQLException{
        String fechaActual = "";
        ResultSet Resultados;
        PreparedStatement sql;
        conexion = new conexion();
        try {
            con = conexion.getConexion(modeloUsuario);
            sql = con.prepareStatement("select extract(year from (select current_date))");
            Resultados = sql.executeQuery();
            while(Resultados.next()){
                fechaActual = Resultados.getString(1);
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
}
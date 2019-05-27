package modeloSQL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.modeloSesionUsuario;
/**
 * @author Dizan
 */
public class sqlAvances {
    Connection con;
    conexion conexion;
    modeloSesionUsuario modeloUsuario;
    private boolean correctoInsertar;

    public sqlAvances(modeloSesionUsuario modeloUsuario) {
        this.modeloUsuario = modeloUsuario;
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
    
    public int obtenerEtapa(int idgrado_alumno, int trimestre ) throws SQLException{
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
        return idetapa;
    }
    
    public void insertarAvance(int idgrado_alumno,int idetapa,int trimestre ) throws SQLException{
        CallableStatement sql;
        conexion = new conexion();
        PreparedStatement psql;
        try{
            con = conexion.getConexion(modeloUsuario);
            psql=con.prepareStatement("INSERT INTO avance(idgrado_alumno, idetapa, trimestre) VALUES(?,?,?)");
            psql.setInt(1, idgrado_alumno);
            psql.setInt(2, idetapa);
            psql.setInt(3, trimestre);
            psql.execute();
            setCorrectoInsertar(true);
                
        }catch (final SQLException e){
            setCorrectoInsertar(false);
            System.err.print(e.getMessage()); 
            throw e; 
        }
    }
    /**
     * @return the correctoInsertar
     */
    public boolean isCorrectoInsertar() {
        return correctoInsertar;
    }

    /**
     * @param correctoInsertar the correctoInsertar to set
     */
    public void setCorrectoInsertar(boolean correctoInsertar) {
        this.correctoInsertar = correctoInsertar;
    }
    
    public int existeAvanceTrimestre(int idgrado_alumno, int trimestre) throws SQLException{
        int existeTrimestre = 0;
        ResultSet Resultados;
        PreparedStatement sql;
        conexion = new conexion();
        try {
            con = conexion.getConexion(modeloUsuario);
            sql = con.prepareStatement("SELECT trimestre FROM avance WHERE idgrado_alumno = ? and trimestre = ?");
            sql.setInt(1, idgrado_alumno);
            sql.setInt(2, trimestre);
            Resultados = sql.executeQuery();
            while(Resultados.next()){
                existeTrimestre = Resultados.getInt(1);
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
        return existeTrimestre;
        
    }
    
    public void actualizar(int idetapa, int idgrado_alumno, int trimestre) throws SQLException{
        
        ResultSet Resultados;
        PreparedStatement sql;
        conexion = new conexion();
        try {
            con = conexion.getConexion(modeloUsuario);
            sql = con.prepareStatement("UPDATE avance SET idetapa = ? WHERE idgrado_alumno = ? and trimestre = ?");
            sql.setInt(1, idetapa);
            sql.setInt(2, idgrado_alumno);
            sql.setInt(3, trimestre);
            sql.execute();
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
        
    }
}

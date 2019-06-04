package modeloSQL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.modeloAlumno;
import modelo.modeloSesionUsuario;
/**
 * @author Dizan
 */
public class sqlAlumno {
    Connection con;
    conexion conexion;
    String insert;
    int resultado =0;
    modeloSesionUsuario modeloUsuario;
    private boolean correctoInsertar;

    public sqlAlumno(modeloSesionUsuario modeloUsuario) {
        this.modeloUsuario = modeloUsuario;
    }
    
    public void insertarAlta(modeloAlumno alumno) throws SQLException{
        
        CallableStatement sql;
        conexion = new conexion();
        PreparedStatement psql=null;
        try{
            con = conexion.getConexion(modeloUsuario);
            insert = "SELECT alta_alumno("+alumno.getNumeroControl()+","
                    +alumno.getIdRegion()+",'"
                    +alumno.getNombre()+"','"
                    +alumno.getApe_paterno()+"','"
                    +alumno.getApe_materno()+"','"
                    +alumno.getSexo()+"','"
                    +alumno.getFecha_nacimiento()+"','"
                    +alumno.getCicloEscolar()+"',"
                    +alumno.getGrado()+","+1+","+1+","+0+")";
              
            psql=con.prepareStatement(insert);
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
    
    
    public boolean existeNocontrolAlumno(int numerocontrol){
       int nocontrol;
        boolean Noexiste = true;//Si 
        ResultSet Resultados;
        PreparedStatement sql;
        conexion = new conexion();
        try 
        {
            con = conexion.getConexion(modeloUsuario);
            sql = con.prepareStatement("SELECT nocontrol FROM alumno WHERE nocontrol = ?");
            sql.setInt(1, numerocontrol);
            Resultados = sql.executeQuery();
            while(Resultados.next())
            {
                nocontrol = Resultados.getInt(1);
                Noexiste = false;
                System.out.println("nocontrol :::::= " + nocontrol);
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
        return Noexiste;
    }
    
    public void eliminarAlumno(int nocontrol) throws SQLException{
        conexion = new conexion();
        Statement statement;
        try{
            con = conexion.getConexion(modeloUsuario);
            statement = con.createStatement();
            statement.execute("DELETE FROM alumno WHERE nocontrol = " + nocontrol) ;
            
        }catch (final SQLException e){
            System.err.print(e.getMessage()); 
            throw e; 
        }
    }
    
    public void eliminarGradoAlumno(int nocontrol, int grado, String cicloescolar) throws SQLException{
        conexion = new conexion();
        Statement statement;
        try{
            con = conexion.getConexion(modeloUsuario);
            statement = con.createStatement();
            statement.execute("DELETE FROM grado_alumno WHERE nocontrol = "
                    +nocontrol+" and idcicloescolar = "
                    +"'"+cicloescolar+"'"+" and idgrado = "+grado) ;
            
        }catch (final SQLException e){
            System.err.print(e.getMessage()); 
            throw e; 
        }
    }
        
}


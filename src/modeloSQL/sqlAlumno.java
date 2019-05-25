package modeloSQL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
                    +alumno.getApe_paterno()+"','"
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
        
}


package modeloSQL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.modeloAlumno;
import modelo.modeloSesionUsuario;
/**
 * @author Dizan
 */
public class sqlAlumno {
    Connection con;
    conexion conexion;
    int resultado =0;
    modeloSesionUsuario modeloUsuario;
    boolean correctoInsertar;

    public sqlAlumno(modeloSesionUsuario modeloUsuario) {
        this.modeloUsuario = modeloUsuario;
    }
    
    public void insertarAlta(modeloAlumno alumno) throws SQLException{
        
        CallableStatement sql;
        String insert = "SELECT alta_alumno( ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        conexion = new conexion();
        try{
            con = conexion.getConexion(modeloUsuario);
            try (PreparedStatement psql = con.prepareStatement(insert)) {
                psql.setInt(1, alumno.getNumeroControl());
                psql.setInt(2, alumno.getIdRegion());
                psql.setString(3, alumno.getNombre());
                psql.setString(4, alumno.getApe_paterno());
                psql.setString(5, alumno.getApe_materno());
                psql.setString(6, alumno.getSexo());
                psql.setString(7, alumno.getFecha_nacimiento());
                psql.setString(8, alumno.getCicloEscolar());
                psql.setInt(9, alumno.getGrado());
                psql.execute();
            }
            correctoInsertar = true;
        }
        catch (final SQLException e){
            correctoInsertar = false;
            System.err.print(e.getMessage());
            throw e;
        }
    }
    
    public ArrayList <String> ciclosEscolares()
    {
        ArrayList <String> lista = null;
        ResultSet Resultados;
        PreparedStatement sql;
        conexion = new conexion();
        try 
        {
            con = conexion.getConexion(modeloUsuario);
            sql = con.prepareStatement("SELECT idcicloescolar FROM cicloescolar");
            Resultados = sql.executeQuery();
            lista = new ArrayList();
            while(Resultados.next())
            {
                lista.add(Resultados.getString("idcicloescolar")
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
    
    public ArrayList <String> grados()
    {
        ArrayList <String> lista = null;
        ResultSet Resultados;
        PreparedStatement sql;
        conexion = new conexion();
        try 
        {
            con = conexion.getConexion(modeloUsuario);
            sql = con.prepareStatement("SELECT idgrado FROM grado");
            Resultados = sql.executeQuery();
            lista = new ArrayList();
            while(Resultados.next())
            {
                lista.add(Resultados.getString("idgrado")
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
    
    public ArrayList <String> regiones()
    {
        ArrayList <String> lista = null;
        ResultSet Resultados;
        PreparedStatement sql;
        conexion = new conexion();
        try 
        {
            con = conexion.getConexion(modeloUsuario);
            sql = con.prepareStatement("SELECT idregion, nombre FROM region "
                    + "INNER JOIN municipio ON region.idmunicipio = municipio.idmunicipio");
            Resultados = sql.executeQuery();
            lista = new ArrayList();
            while(Resultados.next())
            {
                lista.add("0"+Resultados.getString("idregion") +" "+Resultados.getString("nombre")
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
}

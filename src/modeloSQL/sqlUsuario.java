package modeloSQL;
/**
 * @author Dizan
 */
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.modeloSesionUsuario;
import modelo.modeloTablaUsuarios;
import modelo.modeloUsuario;
public class sqlUsuario {
    
    Connection con;
    conexion conexion;
    modeloSesionUsuario modeloUsuario;
    
    public sqlUsuario(modeloSesionUsuario modeloUsuario) {
        this.modeloUsuario = modeloUsuario;
        
    }
    
    public void altaUsuario(modeloUsuario modeloAltaUsuario) throws SQLException{
        CallableStatement sql;
        conexion = new conexion();
        PreparedStatement psql;
        try{
            con = conexion.getConexion(modeloUsuario);
            psql=con.prepareStatement("SELECT alta_usuario (?,?,?,?,?,?,?,?)");
            psql.setInt(1, modeloAltaUsuario.getIdusuario());
            psql.setInt(2, modeloAltaUsuario.getFigura_educativa());
            psql.setString(3, modeloAltaUsuario.getNombre());
            psql.setString(4, modeloAltaUsuario.getApe_paterno());
            psql.setString(5, modeloAltaUsuario.getApe_materno());
            psql.setString(6, modeloAltaUsuario.getSexo());
            psql.setString(7, modeloAltaUsuario.getUsuario());
            psql.setString(8, modeloAltaUsuario.getContraseña());
            psql.execute();    
        }catch (final SQLException e){
            System.err.print(e.getMessage()); 
            throw e; 
        }
    }  
    
    public ArrayList <String> llenarFigurasEducativas(){
     ArrayList <String> lista = null;
        ResultSet Resultados;
        PreparedStatement sql;
        conexion = new conexion();
        try 
        {
            con = conexion.getConexion(modeloUsuario);
            sql = con.prepareStatement("SELECT figura_educativa FROM figura_educativa");
            Resultados = sql.executeQuery();
            lista = new ArrayList();
            int i = 1;
            while(Resultados.next())
            {
                
                lista.add(i+" "+Resultados.getString(1)
                 );
                i = i+1;
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
    
    public int idfiguraeducativa(String figura_educativa )
    {
        Integer idfigura_educativa = 0;
        
        ResultSet Resultados;
        PreparedStatement sql;
        conexion = new conexion();
        try 
        {
            con = conexion.getConexion(modeloUsuario);
            sql = con.prepareStatement("SELECT idfigura_educativa FROM figura_educativa WHERE figura_educativa = ?");
            sql.setString(1, figura_educativa);
            Resultados = sql.executeQuery();
            while(Resultados.next())
            {
                idfigura_educativa = Resultados.getInt(1);
                System.out.println("idfigura_educativa :::::= " + idfigura_educativa);
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
        return idfigura_educativa;
    }
    
    public void crearUser(String nombreUser, String rol, String contraseña, String vigencia) throws SQLException{
        conexion = new conexion();
        Statement statement = con.createStatement();
        try{
            con = conexion.getConexion(modeloUsuario);
            statement.execute("CREATE USER "+nombreUser+" IN ROLE "+rol+" PASSWORD "+"'"+contraseña+"'"+" VALID UNTIL " +"'"+vigencia+"'"); 
            
        }catch (final SQLException e){
            System.err.print(e.getMessage()); 
            throw e; 
        }
    }
    
    public void crearCapacitadorTutor(String nombreUser, String rol, String contraseña, String vigencia) throws SQLException{
        conexion = new conexion();
        Statement statement = con.createStatement();
        try{
            con = conexion.getConexion(modeloUsuario);
            statement.execute("CREATE USER "+nombreUser+" IN ROLE "+rol+" PASSWORD "+"'"+contraseña+"'"+" VALID UNTIL " +"'"+vigencia+"'"); 
            
        }catch (final SQLException e){
            System.err.print(e.getMessage()); 
            throw e; 
        }
    }
    
    public void crearAsistenteEducativo(String nombreUser, String rol, String contraseña, String vigencia) throws SQLException{
        conexion = new conexion();
        Statement statement = con.createStatement();
        try{
            con = conexion.getConexion(modeloUsuario);
            statement.execute("CREATE USER "+nombreUser+" LOGIN CREATEROLE IN ROLE "+rol+" PASSWORD "+"'"+contraseña+"'"+" VALID UNTIL " +"'"+vigencia+"'"); 
            
        }catch (final SQLException e){
            System.err.print(e.getMessage()); 
            throw e; 
        }
    }
    
    public void crearCoordinadorAcademicoDeSeguimiento(String nombreUser, String rol, String contraseña, String vigencia) throws SQLException{
        conexion = new conexion();
        Statement statement = con.createStatement();
        try{
            con = conexion.getConexion(modeloUsuario);
            statement.execute("CREATE USER "+nombreUser+" LOGIN CREATEROLE IN ROLE "+rol+" PASSWORD "+"'"+contraseña+"'"+" VALID UNTIL " +"'"+vigencia+"'"); 
            
        }catch (final SQLException e){
            System.err.print(e.getMessage()); 
            throw e; 
        }
    }
    
    public void crearCoordinadorAcademico(String nombreUser, String rol, String contraseña, String vigencia) throws SQLException{
        conexion = new conexion();
        Statement statement = con.createStatement();
        try{
            con = conexion.getConexion(modeloUsuario);
            statement.execute("CREATE USER "+nombreUser+" LOGIN CREATEROLE IN ROLE "+rol+" PASSWORD "+"'"+contraseña); 
            
        }catch (final SQLException e){
            System.err.print(e.getMessage()); 
            throw e; 
        }
    }
    
    
    
    public ArrayList<modeloTablaUsuarios> tablaAdministrador(){
        ArrayList <modeloTablaUsuarios> lista = null;
        ResultSet Resultados;
        PreparedStatement sql;
        conexion = new conexion();
        try 
        {
            con = conexion.getConexion(modeloUsuario);
            sql = con.prepareStatement("SELECT * FROM vista_usuarios");
            Resultados = sql.executeQuery();
            lista = new ArrayList<>();
            while(Resultados.next())
            {
                lista.add(new modeloTablaUsuarios(  Resultados.getInt(1),
                                                    Resultados.getString(2),
                                                    Resultados.getString(3),
                                                    Resultados.getString(4),
                                                    Resultados.getString(5),
                                                    Resultados.getString(6),
                                                    Resultados.getString(7),
                                                    Resultados.getString(8),
                                                    Resultados.getString(9)
                                               
                    )
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
            } 
            catch (SQLException e) 
            {
                System.err.print(e.getMessage());
            }
        }
        return lista;
    }
    
    public ArrayList<modeloTablaUsuarios> tablaCoordinadorAcademico(){
        ArrayList <modeloTablaUsuarios> lista = null;
        ResultSet Resultados;
        PreparedStatement sql;
        conexion = new conexion();
        try 
        {
            con = conexion.getConexion(modeloUsuario);
            sql = con.prepareStatement("SELECT * FROM vista_usuarios where figura_educativa <> 'administrador'");
            Resultados = sql.executeQuery();
            lista = new ArrayList<>();
            while(Resultados.next())
            {
                lista.add(new modeloTablaUsuarios(  Resultados.getInt(1),
                                                    Resultados.getString(2),
                                                    Resultados.getString(3),
                                                    Resultados.getString(4),
                                                    Resultados.getString(5),
                                                    Resultados.getString(6),
                                                    Resultados.getString(7),
                                                    Resultados.getString(8),
                                                    Resultados.getString(9)
                                               
                    )
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
            } 
            catch (SQLException e) 
            {
                System.err.print(e.getMessage());
            }
        }
        return lista;
    }
    
    public ArrayList<modeloTablaUsuarios> tablaCoordinadorAcademicoDeSeguimiento(){
        ArrayList <modeloTablaUsuarios> lista = null;
        ResultSet Resultados;
        PreparedStatement sql;
        conexion = new conexion();
        try 
        {
            con = conexion.getConexion(modeloUsuario);
            sql = con.prepareStatement("SELECT * FROM vista_usuarios where figura_educativa = 'capacitador_tutor' OR figura_educativa = 'asistente_educativo'");
            Resultados = sql.executeQuery();
            lista = new ArrayList<>();
            while(Resultados.next())
            {
                lista.add(new modeloTablaUsuarios(  Resultados.getInt(1),
                                                    Resultados.getString(2),
                                                    Resultados.getString(3),
                                                    Resultados.getString(4),
                                                    Resultados.getString(5),
                                                    Resultados.getString(6),
                                                    Resultados.getString(7),
                                                    Resultados.getString(8),
                                                    Resultados.getString(9)
                                               
                    )
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
            } 
            catch (SQLException e) 
            {
                System.err.print(e.getMessage());
            }
        }
        return lista;
    }
    
    public ArrayList<modeloTablaUsuarios> tablaAsistenteEducativo(){
        ArrayList <modeloTablaUsuarios> lista = null;
        ResultSet Resultados;
        PreparedStatement sql;
        conexion = new conexion();
        try 
        {
            con = conexion.getConexion(modeloUsuario);
            sql = con.prepareStatement("SELECT * FROM vista_usuarios where figura_educativa = 'capacitador_tutor'");
            Resultados = sql.executeQuery();
            lista = new ArrayList<>();
            while(Resultados.next())
            {
                lista.add(new modeloTablaUsuarios(  Resultados.getInt(1),
                                                    Resultados.getString(2),
                                                    Resultados.getString(3),
                                                    Resultados.getString(4),
                                                    Resultados.getString(5),
                                                    Resultados.getString(6),
                                                    Resultados.getString(7),
                                                    Resultados.getString(8),
                                                    Resultados.getString(9)
                                               
                    )
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
            } 
            catch (SQLException e) 
            {
                System.err.print(e.getMessage());
            }
        }
        return lista;
    }
    
    public ArrayList<modeloTablaUsuarios> tablaCapacitadorTutor(int nocontrol){
        ArrayList <modeloTablaUsuarios> lista = null;
        ResultSet Resultados;
        PreparedStatement sql;
        conexion = new conexion();
        try 
        {
            con = conexion.getConexion(modeloUsuario);
            sql = con.prepareStatement("SELECT * FROM vista_usuarios where idusuario = ?");
            sql.setInt(1, nocontrol);
            Resultados = sql.executeQuery();
            lista = new ArrayList<>();
            while(Resultados.next())
            {
                lista.add(new modeloTablaUsuarios(  Resultados.getInt(1),
                                                    Resultados.getString(2),
                                                    Resultados.getString(3),
                                                    Resultados.getString(4),
                                                    Resultados.getString(5),
                                                    Resultados.getString(6),
                                                    Resultados.getString(7),
                                                    Resultados.getString(8),
                                                    Resultados.getString(9)
                                               
                    )
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
            } 
            catch (SQLException e) 
            {
                System.err.print(e.getMessage());
            }
        }
        return lista;
    }
}

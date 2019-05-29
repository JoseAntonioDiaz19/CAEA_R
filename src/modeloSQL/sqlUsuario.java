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
            psql=con.prepareStatement("INSERT INTO usuario (idusuario, idfigura_educativa, nombre, "
                                    + "ape_paterno, ape_materno, sexo, usuario, password, vigencia) "
                                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, '"+modeloAltaUsuario.getVigencia()+"');");
            
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
            sql = con.prepareStatement("SELECT * FROM vista_usuarios ORDER BY idusuario");
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
            sql = con.prepareStatement("SELECT * FROM vista_usuarios where figura_educativa <> 'administrador' ORDER BY idusuario");
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
            sql = con.prepareStatement("SELECT * FROM vista_usuarios where figura_educativa = 'capacitador_tutor' OR figura_educativa = 'asistente_educativo' ORDER BY idusuario");
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
            sql = con.prepareStatement("SELECT * FROM vista_usuarios where figura_educativa = 'capacitador_tutor' ORDER BY idusuario");
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
            sql = con.prepareStatement("SELECT * FROM vista_usuarios where idusuario = ? ");
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
    
    
    public boolean existeNombreUsuario(String nameUser){
        String nombreUsuario;
        boolean Noexiste = true;
        ResultSet Resultados;
        PreparedStatement sql;
        conexion = new conexion();
        try 
        {
            con = conexion.getConexion(modeloUsuario);
            sql = con.prepareStatement("SELECT usuario FROM usuario WHERE usuario = ?");
            sql.setString(1, nameUser);
            Resultados = sql.executeQuery();
            while(Resultados.next())
            {
                nombreUsuario = Resultados.getString(1);
                Noexiste = false;
                System.out.println("Usuario :::::= " + nombreUsuario);
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
    
    public boolean existeIdUsuario(int idusuario){
       int idUsuario;
        boolean Noexiste = true;//Si 
        ResultSet Resultados;
        PreparedStatement sql;
        conexion = new conexion();
        try 
        {
            con = conexion.getConexion(modeloUsuario);
            sql = con.prepareStatement("SELECT idusuario FROM usuario WHERE idusuario = ?");
            sql.setInt(1, idusuario);
            Resultados = sql.executeQuery();
            while(Resultados.next())
            {
                idUsuario = Resultados.getInt(1);
                Noexiste = false;
                System.out.println("Usuario :::::= " + idUsuario);
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
    
    public void actualizarDatosUsuario(modeloUsuario modeloAltaUsuario, int idfiguraeducativa) throws SQLException{
        PreparedStatement sql;
        conexion = new conexion();
        int idusuario = modeloAltaUsuario.getIdusuario();
        System.out.println("SQLidUsuario: "+ modeloAltaUsuario.getIdusuario() );
        System.out.println(""+modeloAltaUsuario.getNombre());
         
        try{
            con = conexion.getConexion(modeloUsuario);
            
            sql = con.prepareStatement("UPDATE usuario SET idusuario = ?, idfigura_educativa = ?, "
                                        + "nombre = ?, ape_paterno = ?, ape_materno = ?, "
                                        + "sexo ='"+ modeloUsuario.getSexo()+"' Where idusuario = ?" );
           
            sql.setInt(1, idusuario);
            sql.setInt(2, idfiguraeducativa);
            sql.setString(3,modeloAltaUsuario.getNombre());
            sql.setString(4, modeloAltaUsuario.getApe_paterno());
            sql.setString(5, modeloAltaUsuario.getApe_materno());
            sql.setInt(6,idusuario);
            sql.executeUpdate();
        }
        catch (final SQLException e){
            System.err.print(e.getMessage());
            throw e;
        }  
    }
    
    public ArrayList<modeloTablaUsuarios> tablaBuscarNocontrol(int idusuario){
        ArrayList <modeloTablaUsuarios> lista = null;
        ResultSet Resultados;
        PreparedStatement sql;
        conexion = new conexion();
        try 
        {
            con = conexion.getConexion(modeloUsuario);
            sql = con.prepareStatement("SELECT * FROM vista_usuarios WHERE idusuario = ? ");
            sql.setInt(1,idusuario );
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
    
    public ArrayList<modeloTablaUsuarios> tablaBuscarNombreApellidos(String nombre, String ape_paterno, String ape_materno){
        ArrayList <modeloTablaUsuarios> lista = null;
        ResultSet Resultados;
        PreparedStatement sql;
        conexion = new conexion();
        try 
        {
            con = conexion.getConexion(modeloUsuario);
            sql = con.prepareStatement("SELECT * FROM vista_usuarios WHERE ape_paterno LIKE '%'||?||'%' and ape_materno LIKE '%'||?||'%' and nombre LIKE '%'||?||'%'");
            sql.setString(1,ape_paterno.toUpperCase() );            
            sql.setString(2,ape_materno.toUpperCase() );
            sql.setString(3,nombre.toUpperCase() );
            
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
    
    
    public void borrarUsuario(String nombreUsuario) throws SQLException{
        conexion = new conexion();
        
        System.out.println("nombreUsuario: "+ nombreUsuario);
        Statement statement;
        try{
            con = conexion.getConexion(modeloUsuario);
            statement = con.createStatement();
            statement.execute("DROP USER "+ nombreUsuario) ;
            
        }catch (final SQLException e){
            System.err.print(e.getMessage()); 
            throw e; 
        }
    }
    
    public void borrarUsuarioDeTabla(String nombreUsuario) throws SQLException{
        conexion = new conexion();
        Statement statement;
        try{
            con = conexion.getConexion(modeloUsuario);
            statement = con.createStatement();
            statement.execute("DELETE FROM usuario WHERE usuario = "+"'"+nombreUsuario+"'") ;
            
        }catch (final SQLException e){
            System.err.print(e.getMessage()); 
            throw e; 
        }
    }
}
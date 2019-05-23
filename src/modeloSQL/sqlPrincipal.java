package modeloSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.modeloSesionUsuario;
import modelo.modeloTablaPrincipal;
/**
 * @author Dizan
 */
public class sqlPrincipal {
    Connection con;
    conexion conexion;
    modeloSesionUsuario modeloUsuario;

    public sqlPrincipal(modeloSesionUsuario modeloUsuario) {
        this.modeloUsuario = modeloUsuario;
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
    
    public ArrayList<modeloTablaPrincipal> buscarPorNocontrol(String nocontrol){
        ArrayList <modeloTablaPrincipal> lista = null;
        ResultSet Resultados;
        PreparedStatement sql;
        conexion = new conexion();
        try 
        {
            con = conexion.getConexion(modeloUsuario);
            sql = con.prepareStatement("SELECT * FROM vista_principal WHERE nocontrol = ?");
            sql.setInt(1, Integer.parseInt(nocontrol));
            Resultados = sql.executeQuery();
            lista = new ArrayList<>();
            while(Resultados.next())
            {
                lista.add(new modeloTablaPrincipal( Resultados.getInt("nocontrol"),
                                                    Resultados.getString("ape_paterno"),
                                                    Resultados.getString("ape_materno"),
                                                    Resultados.getString("nombre"),
                                                    Resultados.getInt("grado"),
                                                    "0"+Resultados.getString("region"),
                                                    Resultados.getString("cicloescolar"),
                                                    Resultados.getString("situacion"),
                                                    Resultados.getString("estado"),
                                                    Resultados.getString("estado_actual_final")
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
    
    public ArrayList<modeloTablaPrincipal> buscarPorCicloEscolar(String cicloescolar){
        ArrayList <modeloTablaPrincipal> lista = null;
        ResultSet Resultados;
        PreparedStatement sql;
        conexion = new conexion();
        try 
        {
            con = conexion.getConexion(modeloUsuario);
            sql = con.prepareStatement("SELECT * FROM vista_principal WHERE cicloescolar = ?");
            sql.setString(1, cicloescolar);
            Resultados = sql.executeQuery();
            lista = new ArrayList<>();
            while(Resultados.next())
            {
                lista.add(new modeloTablaPrincipal( Resultados.getInt("nocontrol"),
                                                    Resultados.getString("ape_paterno"),
                                                    Resultados.getString("ape_materno"),
                                                    Resultados.getString("nombre"),
                                                    Resultados.getInt("grado"),
                                                    "0"+Resultados.getString("region"),
                                                    Resultados.getString("cicloescolar"),
                                                    Resultados.getString("situacion"),
                                                    Resultados.getString("estado"),
                                                    Resultados.getString("estado_actual_final")
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
    
    public ArrayList<modeloTablaPrincipal> buscarPorRegion(String region){
        ArrayList <modeloTablaPrincipal> lista = null;
        ResultSet Resultados;
        PreparedStatement sql;
        conexion = new conexion();
        try 
        {
            con = conexion.getConexion(modeloUsuario);
            sql = con.prepareStatement("SELECT * FROM vista_principal WHERE region = ?");
            sql.setString(1, region);
            Resultados = sql.executeQuery();
            lista = new ArrayList<>();
            while(Resultados.next())
            {
                lista.add(new modeloTablaPrincipal( Resultados.getInt("nocontrol"),
                                                    Resultados.getString("ape_paterno"),
                                                    Resultados.getString("ape_materno"),
                                                    Resultados.getString("nombre"),
                                                    Resultados.getInt("grado"),
                                                    "0"+Resultados.getString("region"),
                                                    Resultados.getString("cicloescolar"),
                                                    Resultados.getString("situacion"),
                                                    Resultados.getString("estado"),
                                                    Resultados.getString("estado_actual_final")
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
    
    public ArrayList<modeloTablaPrincipal> buscarPorGrado(int grado){
        ArrayList <modeloTablaPrincipal> lista = null;
        ResultSet Resultados;
        PreparedStatement sql;
        conexion = new conexion();
        try 
        {
            con = conexion.getConexion(modeloUsuario);
            sql = con.prepareStatement("SELECT * FROM vista_principal WHERE grado = ?");
            sql.setInt(1, grado);
            Resultados = sql.executeQuery();
            lista = new ArrayList<>();
            while(Resultados.next())
            {
                lista.add(new modeloTablaPrincipal( Resultados.getInt("nocontrol"),
                                                    Resultados.getString("ape_paterno"),
                                                    Resultados.getString("ape_materno"),
                                                    Resultados.getString("nombre"),
                                                    Resultados.getInt("grado"),
                                                    "0"+Resultados.getString("region"),
                                                    Resultados.getString("cicloescolar"),
                                                    Resultados.getString("situacion"),
                                                    Resultados.getString("estado"),
                                                    Resultados.getString("estado_actual_final")
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
    
    public ArrayList<modeloTablaPrincipal> buscarCicloRegion(String cicloescolar, String region){
        ArrayList <modeloTablaPrincipal> lista = null;
        ResultSet Resultados;
        PreparedStatement sql;
        conexion = new conexion();
        try 
        {
            con = conexion.getConexion(modeloUsuario);
            sql = con.prepareStatement("SELECT * FROM vista_principal WHERE region = ? and cicloescolar = ?");
            sql.setString(1, region);
            sql.setString(2, cicloescolar);
            Resultados = sql.executeQuery();
            lista = new ArrayList<>();
            while(Resultados.next())
            {
                lista.add(new modeloTablaPrincipal( Resultados.getInt("nocontrol"),
                                                    Resultados.getString("ape_paterno"),
                                                    Resultados.getString("ape_materno"),
                                                    Resultados.getString("nombre"),
                                                    Resultados.getInt("grado"),
                                                    "0"+Resultados.getString("region"),
                                                    Resultados.getString("cicloescolar"),
                                                    Resultados.getString("situacion"),
                                                    Resultados.getString("estado"),
                                                    Resultados.getString("estado_actual_final")
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
    
    public ArrayList<modeloTablaPrincipal> buscarCicloGrado(String cicloescolar, int grado){
        ArrayList <modeloTablaPrincipal> lista = null;
        ResultSet Resultados;
        PreparedStatement sql;
        conexion = new conexion();
        try 
        {
            con = conexion.getConexion(modeloUsuario);
            sql = con.prepareStatement("SELECT * FROM vista_principal WHERE grado = ? and cicloescolar = ?");
            sql.setInt(1, grado);
            sql.setString(2, cicloescolar);
            Resultados = sql.executeQuery();
            lista = new ArrayList<>();
            while(Resultados.next())
            {
                lista.add(new modeloTablaPrincipal( Resultados.getInt("nocontrol"),
                                                    Resultados.getString("ape_paterno"),
                                                    Resultados.getString("ape_materno"),
                                                    Resultados.getString("nombre"),
                                                    Resultados.getInt("grado"),
                                                    "0"+Resultados.getString("region"),
                                                    Resultados.getString("cicloescolar"),
                                                    Resultados.getString("situacion"),
                                                    Resultados.getString("estado"),
                                                    Resultados.getString("estado_actual_final")
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

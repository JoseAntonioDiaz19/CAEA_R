package modeloSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.modeloAvancesCapturas;
import modelo.modeloSesionUsuario;
/**
 *
 * @author Dizan
 */
public class sqlAvancesCapturas {
    Connection con;
    conexion conexion;
    modeloSesionUsuario modeloUsuario;

    public sqlAvancesCapturas(modeloSesionUsuario modeloUsuario) {
       
        this.modeloUsuario = modeloUsuario;
    }
    
    public ArrayList<modeloAvancesCapturas> buscarPorCicloEscolar(String cicloescolar){
        ArrayList <modeloAvancesCapturas> lista = null;
        ResultSet Resultados;
        PreparedStatement sql;
        conexion = new conexion();
        try 
        {
            con = conexion.getConexion(modeloUsuario);
            sql = con.prepareStatement("SELECT * FROM vista_avances_capturas WHERE idcicloescolar = ?");
            sql.setString(1, cicloescolar);
            Resultados = sql.executeQuery();
            lista = new ArrayList<>();
            while(Resultados.next())
            {
                lista.add(new modeloAvancesCapturas( Resultados.getString("idcicloescolar"),
                                                    Resultados.getString("region"),
                                                    Resultados.getInt("nocontrol"),
                                                    Resultados.getInt("idgrado"),
                                                    Resultados.getString("ape_paterno"),
                                                    Resultados.getString("ape_materno"),
                                                    Resultados.getString("nombre"),
                                                    Resultados.getInt("t1"),
                                                    Resultados.getInt("t2"),
                                                    Resultados.getInt("t3"),
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
    
    public ArrayList<modeloAvancesCapturas> buscarPorRegion(String region){
        ArrayList <modeloAvancesCapturas> lista = null;
        ResultSet Resultados;
        PreparedStatement sql;
        conexion = new conexion();
        try 
        {
            con = conexion.getConexion(modeloUsuario);
            sql = con.prepareStatement("SELECT * FROM vista_avances_capturas WHERE region = ?");
            sql.setString(1, region);
            Resultados = sql.executeQuery();
            lista = new ArrayList<>();
            while(Resultados.next())
            {
                lista.add(new modeloAvancesCapturas( Resultados.getString("idcicloescolar"),
                                                    Resultados.getString("region"),
                                                    Resultados.getInt("nocontrol"),
                                                    Resultados.getInt("idgrado"),
                                                    Resultados.getString("ape_paterno"),
                                                    Resultados.getString("ape_materno"),
                                                    Resultados.getString("nombre"),
                                                    Resultados.getInt("t1"),
                                                    Resultados.getInt("t2"),
                                                    Resultados.getInt("t3"),
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
    
    public ArrayList<modeloAvancesCapturas> buscarPorGrado(int grado){
        ArrayList <modeloAvancesCapturas> lista = null;
        ResultSet Resultados;
        PreparedStatement sql;
        conexion = new conexion();
        try 
        {
            con = conexion.getConexion(modeloUsuario);
            sql = con.prepareStatement("SELECT * FROM vista_avances_capturas WHERE idgrado = ?");
            sql.setInt(1, grado);
            Resultados = sql.executeQuery();
            lista = new ArrayList<>();
            while(Resultados.next())
            {
                lista.add(new modeloAvancesCapturas( Resultados.getString("idcicloescolar"),
                                                    Resultados.getString("region"),
                                                    Resultados.getInt("nocontrol"),
                                                    Resultados.getInt("idgrado"),
                                                    Resultados.getString("ape_paterno"),
                                                    Resultados.getString("ape_materno"),
                                                    Resultados.getString("nombre"),
                                                    Resultados.getInt("t1"),
                                                    Resultados.getInt("t2"),
                                                    Resultados.getInt("t3"),
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
    
    public ArrayList<modeloAvancesCapturas> buscarCicloRegion(String cicloescolar, String region){
        ArrayList <modeloAvancesCapturas> lista = null;
        ResultSet Resultados;
        PreparedStatement sql;
        conexion = new conexion();
        try 
        {
            con = conexion.getConexion(modeloUsuario);
            sql = con.prepareStatement("SELECT * FROM vista_avances_capturas WHERE region = ? and idcicloescolar = ?");
            sql.setString(1, region);
            sql.setString(2, cicloescolar);
            Resultados = sql.executeQuery();
            lista = new ArrayList<>();
            while(Resultados.next())
            {
                lista.add(new modeloAvancesCapturas( Resultados.getString("idcicloescolar"),
                                                    Resultados.getString("region"),
                                                    Resultados.getInt("nocontrol"),
                                                    Resultados.getInt("idgrado"),
                                                    Resultados.getString("ape_paterno"),
                                                    Resultados.getString("ape_materno"),
                                                    Resultados.getString("nombre"),
                                                    Resultados.getInt("t1"),
                                                    Resultados.getInt("t2"),
                                                    Resultados.getInt("t3"),
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
    
    public ArrayList<modeloAvancesCapturas> buscarCicloGrado(String cicloescolar, int grado){
        ArrayList <modeloAvancesCapturas> lista = null;
        ResultSet Resultados;
        PreparedStatement sql;
        conexion = new conexion();
        try 
        {
            con = conexion.getConexion(modeloUsuario);
            sql = con.prepareStatement("SELECT * FROM vista_avances_capturas WHERE idgrado = ? and idcicloescolar = ?");
            sql.setInt(1, grado);
            sql.setString(2, cicloescolar);
            Resultados = sql.executeQuery();
            lista = new ArrayList<>();
            while(Resultados.next())
            {
                lista.add(new modeloAvancesCapturas( Resultados.getString("idcicloescolar"),
                                                    Resultados.getString("region"),
                                                    Resultados.getInt("nocontrol"),
                                                    Resultados.getInt("idgrado"),
                                                    Resultados.getString("ape_paterno"),
                                                    Resultados.getString("ape_materno"),
                                                    Resultados.getString("nombre"),
                                                    Resultados.getInt("t1"),
                                                    Resultados.getInt("t2"),
                                                    Resultados.getInt("t3"),
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
    
    public ArrayList<modeloAvancesCapturas> buscarRegionGrado(String region, int grado){
        ArrayList <modeloAvancesCapturas> lista = null;
        ResultSet Resultados;
        PreparedStatement sql;
        conexion = new conexion();
        try 
        {
            con = conexion.getConexion(modeloUsuario);
            sql = con.prepareStatement("SELECT * FROM vista_avances_capturas WHERE idgrado = ? and region = ?");
            sql.setInt(1, grado);
            sql.setString(2, region);
            Resultados = sql.executeQuery();
            lista = new ArrayList<>();
            while(Resultados.next())
            {
                lista.add(new modeloAvancesCapturas( Resultados.getString("idcicloescolar"),
                                                    Resultados.getString("region"),
                                                    Resultados.getInt("nocontrol"),
                                                    Resultados.getInt("idgrado"),
                                                    Resultados.getString("ape_paterno"),
                                                    Resultados.getString("ape_materno"),
                                                    Resultados.getString("nombre"),
                                                    Resultados.getInt("t1"),
                                                    Resultados.getInt("t2"),
                                                    Resultados.getInt("t3"),
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
    
    public ArrayList<modeloAvancesCapturas> buscarCicloRegionGrado(String ciclo,String region ,int grado){
        ArrayList <modeloAvancesCapturas> lista = null;
        ResultSet Resultados;
        PreparedStatement sql;
        conexion = new conexion();
        try 
        {
            con = conexion.getConexion(modeloUsuario);
            sql = con.prepareStatement("SELECT * FROM vista_avances_capturas WHERE idcicloescolar = ? and region = ? and idgrado = ?");
            sql.setString(1, ciclo);
            sql.setString(2, region);
            sql.setInt(3, grado);
            Resultados = sql.executeQuery();
            lista = new ArrayList<>();
            while(Resultados.next())
            {
                lista.add(new modeloAvancesCapturas( Resultados.getString("idcicloescolar"),
                                                    Resultados.getString("region"),
                                                    Resultados.getInt("nocontrol"),
                                                    Resultados.getInt("idgrado"),
                                                    Resultados.getString("ape_paterno"),
                                                    Resultados.getString("ape_materno"),
                                                    Resultados.getString("nombre"),
                                                    Resultados.getInt("t1"),
                                                    Resultados.getInt("t2"),
                                                    Resultados.getInt("t3"),
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
    
    public ArrayList<modeloAvancesCapturas> buscarSituacion(String estado_actual_final){
        ArrayList <modeloAvancesCapturas> lista = null;
        ResultSet Resultados;
        PreparedStatement sql;
        conexion = new conexion();
        try 
        {
            con = conexion.getConexion(modeloUsuario);
            sql = con.prepareStatement("SELECT * FROM vista_avances_capturas WHERE estado_actual_final = ?");
            sql.setString(1, estado_actual_final);
            Resultados = sql.executeQuery();
            lista = new ArrayList<>();
            while(Resultados.next())
            {
                lista.add(new modeloAvancesCapturas( Resultados.getString("idcicloescolar"),
                                                    Resultados.getString("region"),
                                                    Resultados.getInt("nocontrol"),
                                                    Resultados.getInt("idgrado"),
                                                    Resultados.getString("ape_paterno"),
                                                    Resultados.getString("ape_materno"),
                                                    Resultados.getString("nombre"),
                                                    Resultados.getInt("t1"),
                                                    Resultados.getInt("t2"),
                                                    Resultados.getInt("t3"),
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
    
    public ArrayList<modeloAvancesCapturas> buscarGradoSituacion(String estado_actual_final, int grado){
        ArrayList <modeloAvancesCapturas> lista = null;
        ResultSet Resultados;
        PreparedStatement sql;
        conexion = new conexion();
        try 
        {
            con = conexion.getConexion(modeloUsuario);
            sql = con.prepareStatement("SELECT * FROM vista_avances_capturas WHERE estado_actual_final = ? and idgrado = ?");
            sql.setString(1, estado_actual_final);
            sql.setInt(2, grado);
            Resultados = sql.executeQuery();
            lista = new ArrayList<>();
            while(Resultados.next())
            {
                lista.add(new modeloAvancesCapturas( Resultados.getString("idcicloescolar"),
                                                    Resultados.getString("region"),
                                                    Resultados.getInt("nocontrol"),
                                                    Resultados.getInt("idgrado"),
                                                    Resultados.getString("ape_paterno"),
                                                    Resultados.getString("ape_materno"),
                                                    Resultados.getString("nombre"),
                                                    Resultados.getInt("t1"),
                                                    Resultados.getInt("t2"),
                                                    Resultados.getInt("t3"),
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
    
    public ArrayList<modeloAvancesCapturas> buscarRegionSituacion(String estado_actual_final, String region){
        ArrayList <modeloAvancesCapturas> lista = null;
        ResultSet Resultados;
        PreparedStatement sql;
        conexion = new conexion();
        try 
        {
            con = conexion.getConexion(modeloUsuario);
            sql = con.prepareStatement("SELECT * FROM vista_avances_capturas WHERE estado_actual_final = ? and region = ?");
            sql.setString(1, estado_actual_final);
            sql.setString(2, region);
            Resultados = sql.executeQuery();
            lista = new ArrayList<>();
            while(Resultados.next())
            {
                lista.add(new modeloAvancesCapturas( Resultados.getString("idcicloescolar"),
                                                    Resultados.getString("region"),
                                                    Resultados.getInt("nocontrol"),
                                                    Resultados.getInt("idgrado"),
                                                    Resultados.getString("ape_paterno"),
                                                    Resultados.getString("ape_materno"),
                                                    Resultados.getString("nombre"),
                                                    Resultados.getInt("t1"),
                                                    Resultados.getInt("t2"),
                                                    Resultados.getInt("t3"),
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
    
    public ArrayList<modeloAvancesCapturas> buscarRegionGradoSituacion(String estado_actual_final, int grado, String region){
        ArrayList <modeloAvancesCapturas> lista = null;
        ResultSet Resultados;
        PreparedStatement sql;
        conexion = new conexion();
        try 
        {
            con = conexion.getConexion(modeloUsuario);
            sql = con.prepareStatement("SELECT * FROM vista_avances_capturas WHERE estado_actual_final = ? and idgrado = ? and region = ?");
            sql.setString(1, estado_actual_final);
            sql.setInt(2, grado);
            sql.setString(3, region);
            Resultados = sql.executeQuery();
            lista = new ArrayList<>();
            while(Resultados.next())
            {
                lista.add(new modeloAvancesCapturas( Resultados.getString("idcicloescolar"),
                                                    Resultados.getString("region"),
                                                    Resultados.getInt("nocontrol"),
                                                    Resultados.getInt("idgrado"),
                                                    Resultados.getString("ape_paterno"),
                                                    Resultados.getString("ape_materno"),
                                                    Resultados.getString("nombre"),
                                                    Resultados.getInt("t1"),
                                                    Resultados.getInt("t2"),
                                                    Resultados.getInt("t3"),
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
    
    public ArrayList<modeloAvancesCapturas> buscarCicloescolarSituacion(String estado_actual_final, String cicloescolar){
        ArrayList <modeloAvancesCapturas> lista = null;
        ResultSet Resultados;
        PreparedStatement sql;
        conexion = new conexion();
        try 
        {
            con = conexion.getConexion(modeloUsuario);
            sql = con.prepareStatement("SELECT * FROM vista_avances_capturas WHERE estado_actual_final = ?  and idcicloescolar = ?");
            sql.setString(1, estado_actual_final);
            sql.setString(2, cicloescolar);
            Resultados = sql.executeQuery();
            lista = new ArrayList<>();
            while(Resultados.next())
            {
                lista.add(new modeloAvancesCapturas( Resultados.getString("idcicloescolar"),
                                                    Resultados.getString("region"),
                                                    Resultados.getInt("nocontrol"),
                                                    Resultados.getInt("idgrado"),
                                                    Resultados.getString("ape_paterno"),
                                                    Resultados.getString("ape_materno"),
                                                    Resultados.getString("nombre"),
                                                    Resultados.getInt("t1"),
                                                    Resultados.getInt("t2"),
                                                    Resultados.getInt("t3"),
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
    
    public ArrayList<modeloAvancesCapturas> buscarCicloescolarGradoSituacion(String estado_actual_final, String cicloescolar, int grado){
        ArrayList <modeloAvancesCapturas> lista = null;
        ResultSet Resultados;
        PreparedStatement sql;
        conexion = new conexion();
        try 
        {
            con = conexion.getConexion(modeloUsuario);
            sql = con.prepareStatement("SELECT * FROM vista_avances_capturas WHERE estado_actual_final = ?  and idcicloescolar = ? and idgrado = ?");
            sql.setString(1, estado_actual_final);
            sql.setString(2, cicloescolar);
            sql.setInt(3, grado);
            Resultados = sql.executeQuery();
            lista = new ArrayList<>();
            while(Resultados.next())
            {
                lista.add(new modeloAvancesCapturas( Resultados.getString("idcicloescolar"),
                                                    Resultados.getString("region"),
                                                    Resultados.getInt("nocontrol"),
                                                    Resultados.getInt("idgrado"),
                                                    Resultados.getString("ape_paterno"),
                                                    Resultados.getString("ape_materno"),
                                                    Resultados.getString("nombre"),
                                                    Resultados.getInt("t1"),
                                                    Resultados.getInt("t2"),
                                                    Resultados.getInt("t3"),
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
    
    public ArrayList<modeloAvancesCapturas> buscarCicloescolarRegionSituacion(String estado_actual_final, String cicloescolar, String region){
        ArrayList <modeloAvancesCapturas> lista = null;
        ResultSet Resultados;
        PreparedStatement sql;
        conexion = new conexion();
        try 
        {
            con = conexion.getConexion(modeloUsuario);
            sql = con.prepareStatement("SELECT * FROM vista_avances_capturas WHERE estado_actual_final = ?  and idcicloescolar = ? and region = ?");
            sql.setString(1, estado_actual_final);
            sql.setString(2, cicloescolar);
            sql.setString(3, region);
            Resultados = sql.executeQuery();
            lista = new ArrayList<>();
            while(Resultados.next())
            {
                lista.add(new modeloAvancesCapturas( Resultados.getString("idcicloescolar"),
                                                    Resultados.getString("region"),
                                                    Resultados.getInt("nocontrol"),
                                                    Resultados.getInt("idgrado"),
                                                    Resultados.getString("ape_paterno"),
                                                    Resultados.getString("ape_materno"),
                                                    Resultados.getString("nombre"),
                                                    Resultados.getInt("t1"),
                                                    Resultados.getInt("t2"),
                                                    Resultados.getInt("t3"),
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
    
    public ArrayList<modeloAvancesCapturas> buscarCicloescolarRegionGradoSituacion(String estado_actual_final, String cicloescolar, String region, int grado){
        ArrayList <modeloAvancesCapturas> lista = null;
        ResultSet Resultados;
        PreparedStatement sql;
        conexion = new conexion();
        try 
        {
            con = conexion.getConexion(modeloUsuario);
            sql = con.prepareStatement("SELECT * FROM vista_avances_capturas WHERE estado_actual_final = ?  and idcicloescolar = ? and region = ? and idgrado = ?");
            sql.setString(1, estado_actual_final);
            sql.setString(2, cicloescolar);
            sql.setString(3, region);
            sql.setInt(4, grado);
            Resultados = sql.executeQuery();
            lista = new ArrayList<>();
            while(Resultados.next())
            {
                lista.add(new modeloAvancesCapturas( Resultados.getString("idcicloescolar"),
                                                    Resultados.getString("region"),
                                                    Resultados.getInt("nocontrol"),
                                                    Resultados.getInt("idgrado"),
                                                    Resultados.getString("ape_paterno"),
                                                    Resultados.getString("ape_materno"),
                                                    Resultados.getString("nombre"),
                                                    Resultados.getInt("t1"),
                                                    Resultados.getInt("t2"),
                                                    Resultados.getInt("t3"),
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

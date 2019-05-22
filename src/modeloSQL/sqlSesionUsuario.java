
package modeloSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.modeloSesionUsuario;
import vista.vistaSesionUsuario;

public class sqlSesionUsuario {
    Connection connection;
    vistaSesionUsuario vistaSesionUsuario;
    conexion conexion;

    public sqlSesionUsuario(vistaSesionUsuario vistaSesionUsuario) {
        this.vistaSesionUsuario = vistaSesionUsuario;
    }
    
    public boolean buscar_usuario(modeloSesionUsuario modeloUsuario) throws SQLException{
        boolean iniciar_sesion = false;
        PreparedStatement sql;
        String existe = "SELECT * FROM usuario WHERE usuario=? AND password=?";
        ResultSet resultado;
        conexion = new conexion();
        try{
            connection = conexion.getConexion(vistaSesionUsuario);
            sql = connection.prepareStatement(existe);
            sql.setString(1, modeloUsuario.getUsuario());
            sql.setString(2, modeloUsuario.getPassword());
            resultado = sql.executeQuery();            
            
            if (resultado.next()) {
                iniciar_sesion = true;
                System.out.println("Conexión establecida !!!");
            }  
        }
        catch (final SQLException e){
            System.err.print(e.getMessage());            
            throw e;
        }
        finally{
            System.out.println("Cerrando conexion");
            try {
                connection.close();
                System.out.println("Conexion cerrada !!!");
            } catch (SQLException e) {
                System.err.print(e.getMessage());
            }
        }
        //Retorna t para true y f para false
        return iniciar_sesion;
    } 
    
    public modeloSesionUsuario datosUsuarioActual(modeloSesionUsuario datosSesion) throws SQLException{
        modeloSesionUsuario modeloUsuario = new modeloSesionUsuario();
    
        PreparedStatement sql;
        String datosUsuario = "SELECT * FROM usuario where usuario=? and password=?";
        ResultSet resultado;
        conexion = new conexion();
        try{
            connection = conexion.getConexion(vistaSesionUsuario);
            sql = connection.prepareStatement(datosUsuario);
            sql.setString(1, datosSesion.getUsuario());
            sql.setString(2, datosSesion.getPassword());
            resultado = sql.executeQuery();
            while (resultado.next()) {               
                modeloUsuario.setIdusuario(resultado.getInt("idusuario"));
                modeloUsuario.setIdfigura_educativa(resultado.getInt("idfigura_educativa"));
                modeloUsuario.setNombre(resultado.getString("nombre"));
                modeloUsuario.setApe_paterno(resultado.getString("ape_paterno"));
                modeloUsuario.setApe_materno(resultado.getString("ape_materno"));
                modeloUsuario.setSexo(resultado.getString("sexo").charAt(0));
                modeloUsuario.setUsuario(resultado.getString("usuario"));
                modeloUsuario.setPassword(resultado.getString("password"));
            }
            System.out.println(modeloUsuario.getNombre());
            System.out.println(modeloUsuario.getApe_paterno());
            System.out.println(modeloUsuario.getApe_materno()); 
        }
        catch (final SQLException e){
            System.err.print(e.getMessage());
            throw e;
        }
         return modeloUsuario; 
    } 

}
package controlador;
//import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.modeloAlumno;
import modelo.modeloSesionUsuario;
import modeloSQL.sqlAlumno;
import modeloSQL.sqlPrincipal;
import vista.vistaAltaAlumno;
import vista.vistaSesionUsuario;
/**
 *
 * @author Dizan
 */
public class controlVistaAltaAlumno {

    vistaAltaAlumno vistaAltaAlumno;
    vistaSesionUsuario vistaSesionUsuario;
    
    sqlAlumno sql;
    modeloAlumno modeloAlumno;
    modeloSesionUsuario modeloUsuario;
    
    String dia;
    String mes;
    String año;
    String Fecha;
    
    controlVistaAltaAlumno(vistaAltaAlumno vistaAltaAlumno, modeloSesionUsuario modeloUsuario) {
        this.vistaAltaAlumno = vistaAltaAlumno;
        this.modeloUsuario = modeloUsuario;
        vistaAltaAlumno.botonGuardar.addActionListener(this::botonGuardar);
        llenarCicloEscolar();
        llenarRegion();
        llenarGrado();
    }
    
    private void botonGuardar(ActionEvent e){
        modeloAlumno = new modeloAlumno();
        sqlAlumno sqlAlumno = new sqlAlumno(modeloUsuario);
        
        año= String.valueOf(vistaAltaAlumno.boxAño.getSelectedItem());
        mes= String.valueOf(vistaAltaAlumno.boxMes.getSelectedItem());
        dia= String.valueOf(vistaAltaAlumno.boxDia.getSelectedItem()); 
        Fecha= año+'-'+mes+'-'+dia;
        modeloAlumno.setNumeroControl(Integer.valueOf(vistaAltaAlumno.fieldNumeroControl.getText()));
        modeloAlumno.setIdRegion(Integer.parseInt((String) vistaAltaAlumno.boxRegion.getSelectedItem()));
        modeloAlumno.setNombre(vistaAltaAlumno.fieldNombre.getText());
        modeloAlumno.setApe_paterno(vistaAltaAlumno.fieldApe_paterno.getText());
        modeloAlumno.setApe_materno(vistaAltaAlumno.fieldApe_materno.getText());
        modeloAlumno.setSexo(String.valueOf(vistaAltaAlumno.boxSexo.getSelectedItem()));
        modeloAlumno.setFecha_nacimiento(Fecha);
        modeloAlumno.setCicloEscolar(String.valueOf(vistaAltaAlumno.boxCicloEscolar.getSelectedItem()));
        modeloAlumno.setGrado(Integer.parseInt(vistaAltaAlumno.boxGrado.getSelectedItem().toString()));
        
        try {
            sqlAlumno.insertarAlta(modeloAlumno);
        } catch (SQLException ex) {
            Logger.getLogger(controlVistaAltaAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void llenarCicloEscolar(){
        sqlPrincipal sqlPrincipal = new sqlPrincipal(modeloUsuario);
        ArrayList <String> ciclosEscolares;
        ciclosEscolares = sqlPrincipal.ciclosEscolares();
        int iteraciones = ciclosEscolares.size();
        for (int i = 0; i < iteraciones; i++) {
            vistaAltaAlumno.boxCicloEscolar.addItem(ciclosEscolares.get(i));
        } 
    }
    
    private void llenarRegion(){
       sqlPrincipal sqlPrincipal = new sqlPrincipal(modeloUsuario);
       ArrayList <String> regiones;
       regiones = sqlPrincipal.regiones();
       int iteraciones = regiones.size();
       for (int i = 0; i < iteraciones; i++) {
           vistaAltaAlumno.boxRegion.addItem(regiones.get(i));
       }
    }
    
    private void llenarGrado(){
        sqlPrincipal sqlPrincipal = new sqlPrincipal(modeloUsuario);
        ArrayList <String>  grados;
        grados = sqlPrincipal.grados();
        int iteraciones = grados.size();
        for (int i = 0; i < iteraciones; i++) {
           vistaAltaAlumno.boxGrado.addItem(grados.get(i));
       }
    }
}

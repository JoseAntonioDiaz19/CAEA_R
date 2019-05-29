package controlador;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static jdk.nashorn.internal.objects.NativeString.substring;
import modelo.modeloAlumno;
import modelo.modeloSesionUsuario;
import modeloSQL.sqlAlumno;
import modeloSQL.sqlPrincipal;
import vista.vistaAltaAlumno;
import vista.vistaSesionUsuario;
/**
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
        modeloAlumno.setIdRegion( Integer.parseInt(substring(vistaAltaAlumno.boxRegion.getSelectedItem().toString(), 0,3))
        );
        modeloAlumno.setNombre(vistaAltaAlumno.fieldNombre.getText());
        modeloAlumno.setApe_paterno(vistaAltaAlumno.fieldApe_paterno.getText());
        modeloAlumno.setApe_materno(vistaAltaAlumno.fieldApe_materno.getText());
        modeloAlumno.setSexo(String.valueOf(vistaAltaAlumno.boxSexo.getSelectedItem()));
        modeloAlumno.setFecha_nacimiento(Fecha);
        modeloAlumno.setCicloEscolar(String.valueOf(vistaAltaAlumno.boxCicloEscolar.getSelectedItem()));
        modeloAlumno.setGrado(Integer.parseInt(vistaAltaAlumno.boxGrado.getSelectedItem().toString()));
        
        boolean NoexisteNocontrol = sqlAlumno.existeNocontrolAlumno(modeloAlumno.getNumeroControl());
        if (NoexisteNocontrol) {
            try {
                sqlAlumno.insertarAlta(modeloAlumno);
                JOptionPane.showMessageDialog(vistaAltaAlumno, "La operación se realizó correctamente");
                vistaAltaAlumno.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(controlVistaAltaAlumno.class.getName()).log(Level.SEVERE, null, ex);
                vistaAltaAlumno.labelMensaje.setText("Revise si los datos capturados son correctos");
                vistaAltaAlumno.labelMensaje.setForeground(new Color(204,51,0));
            }
        }else{
            vistaAltaAlumno.labelMensaje.setText("El número control ya existe");
            vistaAltaAlumno.labelMensaje.setForeground(new Color(204,51,0));
        }
    }
    
    private void llenarCicloEscolar(){
        sqlPrincipal sqlPrincipal = new sqlPrincipal(modeloUsuario);
        ArrayList <String> ciclosEscolares;
        ciclosEscolares = sqlPrincipal.ciclosEscolares();
        int iteraciones = ciclosEscolares.size();
        vistaAltaAlumno.boxCicloEscolar.addItem(ciclosEscolares.get(iteraciones - 1));
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

package controlador;
//import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.modeloAlumno;
import modelo.modeloSesionUsuario;
import modeloSQL.sqlAlumno;
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
    }
    

//    @Override
//    public void actionPerformed(ActionEvent ae) {
//        if(ae.getSource() == vistaAltaAlumno.botonGuardar)
//        {   
//            
//            
//            
//            
//            
//            sql.insertarAlta(modeloUsuario, modelo);
//        }
//    }
    
    private void botonGuardar(ActionEvent e){
        modeloAlumno = new modeloAlumno();
        
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
//        modeloAlumno.setFecha_nacimiento(String.valueOf(vistaAltaAlumno.boxAño.getSelectedIndex()));
//        modeloAlumno.setFecha_nacimiento(String.valueOf(vistaAltaAlumno.boxMes.getSelectedIndex()));
//        modeloAlumno.setFecha_nacimiento(String.valueOf(vistaAltaAlumno.boxDia.getSelectedIndex()));
        modeloAlumno.setFecha_nacimiento(Fecha);
        modeloAlumno.setCicloEscolar(String.valueOf(vistaAltaAlumno.boxCicloEscolar.getSelectedItem()));
        modeloAlumno.setGrado(Integer.parseInt(vistaAltaAlumno.boxGrado.getSelectedItem().toString()));
        
    }
}

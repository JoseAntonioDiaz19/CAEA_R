package controlador;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.modeloDatosAlumno;
import modelo.modeloSesionUsuario;
import modeloSQL.sqlDatosAlumno;
import vista.vistaDatosAlumno;
import vista.vistaPrincipal;
/**
 * @author Dizan
 */
public class controlVistaDatosAlumno {
    
    vistaPrincipal ventanaPrincipal;
    modeloSesionUsuario modeloUsuario;
    vistaDatosAlumno vistaDatosAlumno;
    modeloDatosAlumno modeloDatosAlumnoAnterior;
    
    controlVistaDatosAlumno(vistaPrincipal ventanaPrincipal, 
            modeloSesionUsuario modeloUsuario, 
            vistaDatosAlumno vistaDatosAlumno, modeloDatosAlumno modeloDatosAlumno) {
        
        this.ventanaPrincipal = ventanaPrincipal;
        this.modeloUsuario = modeloUsuario;
        this.vistaDatosAlumno = vistaDatosAlumno;
        this.modeloDatosAlumnoAnterior = modeloDatosAlumno;
        
        vistaDatosAlumno.botonActualizar.addActionListener(this::botonActualizar);
    }

  
    private void botonActualizar(ActionEvent e){
        String fecha;
        String año;
        String mes;
        String dia;
        
        modeloDatosAlumno modeloDatosAlumnoNuevo = new modeloDatosAlumno();
        
        modeloDatosAlumnoNuevo.setNocontrol(Integer.parseInt(vistaDatosAlumno.fieldNumeroControl.getText()));
        modeloDatosAlumnoNuevo.setRegion((String) vistaDatosAlumno.boxRegion.getSelectedItem());
        modeloDatosAlumnoNuevo.setNombre(vistaDatosAlumno.fieldNombre.getText());
        modeloDatosAlumnoNuevo.setApe_paterno(vistaDatosAlumno.fieldApe_paterno.getText());
        modeloDatosAlumnoNuevo.setApe_materno(vistaDatosAlumno.fieldApe_materno.getText());
        modeloDatosAlumnoNuevo.setSexo((String) vistaDatosAlumno.boxSexo.getSelectedItem());
        
            año = (String) vistaDatosAlumno.boxAño.getSelectedItem();
            mes = (String) vistaDatosAlumno.boxMes.getSelectedItem();
            dia = (String) vistaDatosAlumno.boxDia.getSelectedItem();
            fecha = año+"-"+mes+"-"+dia;
       
        modeloDatosAlumnoNuevo.setFecha_nacimiento(fecha);
        modeloDatosAlumnoNuevo.setCicloescolar((String) vistaDatosAlumno.boxCicloEscolar.getSelectedItem());
        modeloDatosAlumnoNuevo.setGrado(Integer.parseInt(vistaDatosAlumno.boxGrado.getSelectedItem().toString()));
        System.out.println("Grado " + modeloDatosAlumnoNuevo.getGrado());
        modeloDatosAlumnoNuevo.setSituacion((String) vistaDatosAlumno.boxSituacion.getSelectedItem());
       
        int region = Integer.parseInt(modeloDatosAlumnoNuevo.getRegion().substring(1, 3));
        System.out.println("region = " + region);
        
        sqlDatosAlumno  sqlDatosAlumno = new sqlDatosAlumno(modeloUsuario);
        int idgrado_alumno = sqlDatosAlumno.idgrado_alumno( modeloDatosAlumnoAnterior.getNocontrol(), 
                                                            modeloDatosAlumnoAnterior.getGrado(), 
                                                            modeloDatosAlumnoAnterior.getCicloescolar());
        
        System.out.println("idgrado_alumno = " + idgrado_alumno);
       
        try {
            sqlDatosAlumno.actualizar(modeloDatosAlumnoNuevo, modeloDatosAlumnoAnterior,
                                      region, 
                                      vistaDatosAlumno.boxSituacion.getSelectedIndex()-1, 
                                      vistaDatosAlumno.boxSituacionFinal.getSelectedIndex()-1,idgrado_alumno);
            
        } catch (SQLException ex) {
            Logger.getLogger(controlVistaDatosAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        vistaDatosAlumno.dispose();
    }
}

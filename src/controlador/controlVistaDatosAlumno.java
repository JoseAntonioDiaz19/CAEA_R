/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import modelo.modeloDatosAlumno;
import modelo.modeloSesionUsuario;
import vista.vistaDatosAlumno;
import vista.vistaPrincipal;

/**
 *
 * @author Dizan
 */
public class controlVistaDatosAlumno {
    
    vistaPrincipal ventanaPrincipal;
    modeloSesionUsuario modeloUsuario;
    vistaDatosAlumno vistaDatosAlumno;
    
    controlVistaDatosAlumno(vistaPrincipal ventanaPrincipal, 
            modeloSesionUsuario modeloUsuario, 
            vistaDatosAlumno vistaDatosAlumno) {
        
        this.ventanaPrincipal = ventanaPrincipal;
        this.modeloUsuario = modeloUsuario;
        this.vistaDatosAlumno = vistaDatosAlumno;
        
        vistaDatosAlumno.botonActualizar.addActionListener(this::botonActualizar);
    }
    
    private void botonActualizar(ActionEvent e){
        
        String fecha;
        String año;
        String mes;
        String dia;
        
        modeloDatosAlumno modeloDatosAlumno = new modeloDatosAlumno();
        modeloDatosAlumno.setNocontrol(Integer.parseInt(vistaDatosAlumno.fieldNumeroControl.getText()));
        modeloDatosAlumno.setRegion((String) vistaDatosAlumno.boxRegion.getSelectedItem());
        modeloDatosAlumno.setNombre(vistaDatosAlumno.fieldNombre.getText());
        modeloDatosAlumno.setApe_paterno(vistaDatosAlumno.fieldApe_paterno.getText());
        modeloDatosAlumno.setApe_materno(vistaDatosAlumno.fieldApe_materno.getText());
        modeloDatosAlumno.setSexo((String) vistaDatosAlumno.boxSexo.getSelectedItem());
        
            año = (String) vistaDatosAlumno.boxAño.getSelectedItem();
            mes = (String) vistaDatosAlumno.boxMes.getSelectedItem();
            dia = (String) vistaDatosAlumno.boxDia.getSelectedItem();
            fecha = año+"-"+mes+"-"+dia;
       
            modeloDatosAlumno.setFecha_nacimiento(fecha);
        modeloDatosAlumno.setCicloescolar((String) vistaDatosAlumno.boxCicloEscolar.getSelectedItem());
        modeloDatosAlumno.setGrado((int) vistaDatosAlumno.boxGrado.getSelectedItem());
        modeloDatosAlumno.setSituacion((String) vistaDatosAlumno.boxSituacion.getSelectedItem());
        
        if (vistaDatosAlumno.checkSituacionFinal.isSelected()) {
            modeloDatosAlumno.setSituacion_final("ACREDITADO");
        }
        
        
    }
}

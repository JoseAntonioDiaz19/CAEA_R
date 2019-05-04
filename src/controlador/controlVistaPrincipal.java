/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import modelo.modeloSesionUsuario;
import vista.vistaPrincipal;
import vista.vistaSesionUsuario;

/**
 *
 * @author Dizan
 */
public class controlVistaPrincipal {

    vistaPrincipal ventanaPrincipal;
    vistaSesionUsuario vistaSesion;
    

    controlVistaPrincipal(vistaPrincipal ventanaPrincipal) {
       this.ventanaPrincipal = ventanaPrincipal;

       ventanaPrincipal.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                close(true);
            }
        });
       
       eventos();
        
       
    }
    
    private void eventos(){
        ventanaPrincipal.botonCerrarSesion.addActionListener(this::botonCerrarSesion);     
    }
    
    private void close(boolean mensaje){ 
        vistaSesion = new vistaSesionUsuario();
        modeloSesionUsuario modeloSesionUsuario = new modeloSesionUsuario();
        vistaSesion.setVisible(true);
        controlVistaSesionUsuario controlVistaSesionUsuario = new controlVistaSesionUsuario(vistaSesion, modeloSesionUsuario);
        System.out.println("Nueva ventana de inicio de sesion");
       
    } 
   
    public void botonCerrarSesion(ActionEvent e){
       System.out.println("Cerrar sesion boton");
       ventanaPrincipal.dispose();
       close(false);
       
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.modeloSesionUsuario;
import vista.vistaPrincipal;

/**
 *
 * @author Dizan
 */
public class controlVistaDatosAlumno {
    vistaPrincipal ventanaPrincipal;
    modeloSesionUsuario modeloUsuario;
    
    controlVistaDatosAlumno(vistaPrincipal ventanaPrincipal, modeloSesionUsuario modeloUsuario) {
        this.ventanaPrincipal = ventanaPrincipal;
        this.modeloUsuario = modeloUsuario;
    }
    
    
}

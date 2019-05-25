/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.modeloSesionUsuario;
import vista.vistaAvances;
import vista.vistaPrincipal;
/**
 *
 * @author Dizan
 */
public class controlVistaAvances {
    vistaAvances vistaAvances;
    modeloSesionUsuario modeloUsuario;
    vistaPrincipal ventanaPrincipal;

    controlVistaAvances(vistaAvances vistaAvances, modeloSesionUsuario modeloUsuario, vistaPrincipal ventanaPrincipal) {
       this.vistaAvances = vistaAvances;
       this.modeloUsuario = modeloUsuario;
       this.ventanaPrincipal = ventanaPrincipal;
    }
}


package controlador;

import modelo.modeloAvances;
import modelo.modeloSesionUsuario;
import vista.vistaPrincipal;
import vista.vistaReinscripcion;

/**
 *
 * @author Dizan
 */
public class controlVistaReinscripcion {
    
    vistaReinscripcion vistaReinscripcion;
    modeloSesionUsuario modeloUsuario;
    vistaPrincipal ventanaPrincipal;

    controlVistaReinscripcion(vistaReinscripcion vistaReinscripcion, 
                            modeloSesionUsuario modeloUsuario, 
                            vistaPrincipal ventanaPrincipal) {
        
        this.vistaReinscripcion = vistaReinscripcion;
        this.modeloUsuario = modeloUsuario;
        this.ventanaPrincipal = ventanaPrincipal;
        
    }
}

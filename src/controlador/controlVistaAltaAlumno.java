package controlador;

import modelo.modeloSesionUsuario;
import vista.vistaAltaAlumno;
import vista.vistaSesionUsuario;

/**
 *
 * @author Dizan
 */
public class controlVistaAltaAlumno {

    vistaAltaAlumno vistaAltaAlumno;
    vistaSesionUsuario vistaSesionUsuario;
    modeloSesionUsuario modeloUsuario;
    
    controlVistaAltaAlumno(vistaAltaAlumno vistaAltaAlumno, modeloSesionUsuario modeloUsuario) {
        this.vistaAltaAlumno = vistaAltaAlumno;
        this.modeloUsuario = modeloUsuario;
    }
}

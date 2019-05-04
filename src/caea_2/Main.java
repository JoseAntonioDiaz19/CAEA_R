package caea_2;
import controlador.controlVistaSesionUsuario;
import modelo.modeloSesionUsuario;
import vista.vistaSesionUsuario;
/**
 *
 * @author Dizan
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        vistaSesionUsuario vistaSesion = new vistaSesionUsuario();
        modeloSesionUsuario modeloSesionUsuario = new modeloSesionUsuario();
        controlVistaSesionUsuario controlVistaSesionUsuario = new controlVistaSesionUsuario(vistaSesion, modeloSesionUsuario);
    }
}

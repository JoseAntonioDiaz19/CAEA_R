package controlador;
import java.awt.event.ActionEvent;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.modeloGrado_Alumno;
import modelo.modeloSesionUsuario;
import modeloSQL.sqlReinscribir;
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
    modeloGrado_Alumno modeloGrado_Alumno;

    controlVistaReinscripcion(vistaReinscripcion vistaReinscripcion, 
                            modeloSesionUsuario modeloUsuario, 
                            vistaPrincipal ventanaPrincipal,
                            modeloGrado_Alumno modeloGrado_Alumno) {
        
        this.vistaReinscripcion = vistaReinscripcion;
        this.modeloUsuario = modeloUsuario;
        this.ventanaPrincipal = ventanaPrincipal;
        this.modeloGrado_Alumno = modeloGrado_Alumno;
        vistaReinscripcion.jButton1.addActionListener(this::botonReinscribir);
    }

    
    private void fechaActual(){
        sqlReinscribir sqlReinscribir = new sqlReinscribir(modeloUsuario);
        
        try {
            Date fechaActual = sqlReinscribir.obtenerFechaActual();
            System.out.println("fechaActual = " + fechaActual);
        } catch (SQLException ex) {
            Logger.getLogger(controlVistaReinscripcion.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Diferencia de fechas: ");
        
    }
    
    public void botonReinscribir(ActionEvent e){
        fechaActual();
        sqlReinscribir sqlReinscribir=new sqlReinscribir(modeloUsuario);
        int nuevoGrado = Integer.parseInt(String.valueOf(vistaReinscripcion.boxGrado.getSelectedItem()));
        modeloGrado_Alumno.setIdgrado(nuevoGrado);
        modeloGrado_Alumno.setIdcicloescolar(String.valueOf(vistaReinscripcion.boxCicloEscolar.getSelectedItem()));
        
        //Verificar que el alumno no esté inscrito/reinscrito en el ciclo actual
        //Si es 0 se puede reinscribir y si es mayor que cero no se registra
        int existe = 0;
        try {
            existe = sqlReinscribir.existe(modeloGrado_Alumno.getNocontrol(), modeloGrado_Alumno.getIdcicloescolar());
        } catch (SQLException ex) {
            Logger.getLogger(controlVistaReinscripcion.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (existe == 0) {
            //Reinscribir
        
        }else{
            //Aviso de que el alumno ya se encuentra inscrito/reinscrito en el sistema
            JOptionPane.showMessageDialog(null, "El alumno ya esta inscrito/reinscrito en este ciclo escolar");
        }
        
    }
}

package controlador;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.modeloSesionUsuario;
import modeloSQL.sqlCiclosEscolares;
import vista.vistaCiclosEscolares;
/**
 * @author Dizan
 */
public class controlVistaCiclosEscolares {
    
    vistaCiclosEscolares vistaCiclosEscolares;
    modeloSesionUsuario modeloUsuario;

    controlVistaCiclosEscolares(vistaCiclosEscolares vistaCiclosEscolares, modeloSesionUsuario modeloUsuario) {
        this.vistaCiclosEscolares = vistaCiclosEscolares;
        this.modeloUsuario = modeloUsuario;
        vistaCiclosEscolares.botonCrear.addActionListener(this::botonCrear);
        vistaCiclosEscolares.botonActualizar.addActionListener(this::botonActualizar);
        vistaCiclosEscolares.botonEliminar.addActionListener(this::botonEliminar);
    }
    
    private void botonCrear(ActionEvent e){
        sqlCiclosEscolares sqlCiclosEscolares = new sqlCiclosEscolares(modeloUsuario);
        
        String cicloescolar = "XXXX-XXXX";
        if (!"XXXX-XXXX".equals(vistaCiclosEscolares.fieldCicloEscolar.getText())) {
             cicloescolar = vistaCiclosEscolares.fieldCicloEscolar.getText();
        }
       
        String diaInicio = String.valueOf(vistaCiclosEscolares.boxDiaInicio.getSelectedItem());
        String mesInicio = String.valueOf(vistaCiclosEscolares.boxMesInicio.getSelectedItem());
        String añoInicio = String.valueOf(vistaCiclosEscolares.boxAñoInicio.getSelectedItem());
        String fechaInicio = añoInicio+"-"+mesInicio+"-"+diaInicio;
        
        String diaFin = String.valueOf(vistaCiclosEscolares.boxDiaFin.getSelectedItem());
        String mesFin = String.valueOf(vistaCiclosEscolares.boxMesFin.getSelectedItem());
        String añoFin = String.valueOf(vistaCiclosEscolares.boxAñoFin.getSelectedItem());
        String fechaFin = añoFin+"-"+mesFin+"-"+diaFin;
        
        try {
            sqlCiclosEscolares.nuevoCicloEscolar(cicloescolar, fechaInicio, fechaFin);
            JOptionPane.showMessageDialog(null, "Ciclo escolar creado correctamente");
            JOptionPane.showMessageDialog(null, "Reinicie la aplicacion para obtener los cambios");
        } catch (SQLException ex) {
            Logger.getLogger(controlVistaCiclosEscolares.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error: verifique los datos");
        }
    }
    
    private void botonActualizar(ActionEvent e){
        sqlCiclosEscolares sqlCiclosEscolares = new sqlCiclosEscolares(modeloUsuario);
        
        String cicloescolar = "XXXX-XXXX";
        if (!"XXXX-XXXX".equals(vistaCiclosEscolares.fieldCicloEscolar.getText())) {
             cicloescolar = vistaCiclosEscolares.fieldCicloEscolar.getText();
        }
       
        String diaInicio = String.valueOf(vistaCiclosEscolares.boxDiaInicio.getSelectedItem());
        String mesInicio = String.valueOf(vistaCiclosEscolares.boxMesInicio.getSelectedItem());
        String añoInicio = String.valueOf(vistaCiclosEscolares.boxAñoInicio.getSelectedItem());
        String fechaInicio = añoInicio+"-"+mesInicio+"-"+diaInicio;
        
        String diaFin = String.valueOf(vistaCiclosEscolares.boxDiaFin.getSelectedItem());
        String mesFin = String.valueOf(vistaCiclosEscolares.boxMesFin.getSelectedItem());
        String añoFin = String.valueOf(vistaCiclosEscolares.boxAñoFin.getSelectedItem());
        String fechaFin = añoFin+"-"+mesFin+"-"+diaFin;
        
        try {
            sqlCiclosEscolares.actualizarCicloEscolar(cicloescolar, fechaInicio, fechaFin);
            JOptionPane.showMessageDialog(null, "Ciclo escolar actualizado correctamente");
        } catch (SQLException ex) {
            Logger.getLogger(controlVistaCiclosEscolares.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error: verifique los datos");
        }
    }
    
    private void botonEliminar(ActionEvent e){
        sqlCiclosEscolares sqlCiclosEscolares = new sqlCiclosEscolares(modeloUsuario);
        String cicloescolar = "XXXX-XXXX";
        if (!"XXXX-XXXX".equals(vistaCiclosEscolares.fieldCicloEscolar.getText())) {
             cicloescolar = vistaCiclosEscolares.fieldCicloEscolar.getText();
        }
        int respuesta =  JOptionPane.showConfirmDialog(vistaCiclosEscolares, "¿Realmente desea eliminar el ciclo escolar?");
        
        if (respuesta == JOptionPane.YES_OPTION) {
           
            try {
                sqlCiclosEscolares.eliminar(cicloescolar);
                JOptionPane.showMessageDialog(null, "Reinicie la aplicacion para obtener los cambios");
            } catch (SQLException ex) {
                Logger.getLogger(controlVistaCiclosEscolares.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "¡¡No se puede eliminar un ciclo escolar asociado a algun alumno!!");
            }
        } 
    }
}

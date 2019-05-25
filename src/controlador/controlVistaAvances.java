package controlador;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.modeloAvances;
import modelo.modeloSesionUsuario;
import modeloSQL.sqlAvances;
import vista.vistaAvances;
import vista.vistaPrincipal;
/**
 * @author Dizan
 */
public class controlVistaAvances {
    vistaAvances vistaAvances;
    modeloSesionUsuario modeloUsuario;
    vistaPrincipal ventanaPrincipal;
    modeloAvances modeloAvances;
            

    controlVistaAvances(vistaAvances vistaAvances, 
                        modeloSesionUsuario modeloUsuario, 
                        vistaPrincipal ventanaPrincipal,
                        modeloAvances modeloAvances) {
        
       this.vistaAvances = vistaAvances;
       this.modeloUsuario = modeloUsuario;
       this.ventanaPrincipal = ventanaPrincipal;
       this.modeloAvances = modeloAvances;
       vistaAvances.boxTrimestre.addActionListener(this::boxTrimestre);
       vistaAvances.boxGrado.addActionListener(this::boxGrado);
       vistaAvances.botonGuardar.addActionListener(this::botonGuardar);
    }
    
    private void boxTrimestre(ActionEvent e){
       System.out.println("Entre en evento de boxTrimestre");
       sqlAvances sqlAvances = new sqlAvances(modeloUsuario);
       String itemTrimestre = (String) vistaAvances.boxTrimestre.getSelectedItem();
       modeloAvances.setTrimestre(Integer.parseInt(itemTrimestre));
       vistaAvances.labelTituloT1.setText("Trimestre "+ itemTrimestre);
       
        //nocontrol, idgrado ,idcicloescolar, trimestre = etapa
        //si la consulta de la etapa regresa 0 entonces se limpian 
        //los checks
        int idgrado_alumno = sqlAvances.obtenerIdgrado_alumno(modeloAvances.getNocontrol(), 
                                                                modeloAvances.getIdgrado(), 
                                                                modeloAvances.getIdcicloescolar());
        System.out.println("idgrado_alumno = " + idgrado_alumno);
        
        int etapa = 0;
        
        try {
            etapa = sqlAvances.obtenerEtapa(idgrado_alumno, Integer.parseInt(itemTrimestre));
        } catch (SQLException ex) {
            Logger.getLogger(controlVistaAvances.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("busqueda Etapa: " + etapa);
       
        if ("1".equals(itemTrimestre)) {
            
            if (etapa == 0) {
                //Limpiar los checks
                vistaAvances.grupoEtapas.clearSelection();
            
            }else{
                //Asignar la etapa en el check correspondiente
                if (etapa == 1) {
                    vistaAvances.checkEtapa1.setSelected(true);
                }
                if (etapa == 2) {
                    vistaAvances.checkEtapa2.setSelected(true);
                }
                if (etapa == 3) {
                    vistaAvances.checkEtapa3.setSelected(true);
                }
                if (etapa == 4) {
                    vistaAvances.checkEtapa4.setSelected(true);
                }
                if (etapa == 5) {
                    vistaAvances.checkEtapa5.setSelected(true);
                }
                if (etapa == 6) {
                    vistaAvances.checkEtapa6.setSelected(true);
                }
                if (etapa == 7) {
                    vistaAvances.checkEtapa7.setSelected(true);
                }
            }
        }
        
        if ("2".equals(itemTrimestre)) {
            if (etapa == 0) {
                vistaAvances.grupoEtapas.clearSelection();
            }else{
                //Asignar la etapa en el check correspondiente
                if (etapa == 1) {
                    vistaAvances.checkEtapa1.setSelected(true);
                }
                if (etapa == 2) {
                    vistaAvances.checkEtapa2.setSelected(true);
                }
                if (etapa == 3) {
                    vistaAvances.checkEtapa3.setSelected(true);
                }
                if (etapa == 4) {
                    vistaAvances.checkEtapa4.setSelected(true);
                }
                if (etapa == 5) {
                    vistaAvances.checkEtapa5.setSelected(true);
                }
                if (etapa == 6) {
                    vistaAvances.checkEtapa6.setSelected(true);
                }
                if (etapa == 7) {
                    vistaAvances.checkEtapa7.setSelected(true);
                }
            }
        }
        if ("3".equals(itemTrimestre)) {
            if (etapa == 0) {
                System.out.println("Desactivar checks trimestre 3");
                vistaAvances.grupoEtapas.clearSelection();

            }else{
                //Asignar la etapa en el check correspondiente
                if (etapa == 1) {
                    vistaAvances.checkEtapa1.setSelected(true);
                }
                if (etapa == 2) {
                    vistaAvances.checkEtapa2.setSelected(true);
                }
                if (etapa == 3) {
                    vistaAvances.checkEtapa3.setSelected(true);
                }
                if (etapa == 4) {
                    vistaAvances.checkEtapa4.setSelected(true);
                }
                if (etapa == 5) {
                    vistaAvances.checkEtapa5.setSelected(true);
                }
                if (etapa == 6) {
                    vistaAvances.checkEtapa6.setSelected(true);
                }
                if (etapa == 7) {
                    vistaAvances.checkEtapa7.setSelected(true);
                }
            }
        }
    }
    
    private void botonGuardar(ActionEvent e){
        sqlAvances sqlAvances = new sqlAvances(modeloUsuario);
        String itemTrimestre = (String) vistaAvances.boxTrimestre.getSelectedItem();
        String checkSeleccionado = vistaAvances.grupoEtapas.getSelection().getActionCommand();
        int etapaSeleccionada = Integer.parseInt(checkSeleccionado.substring(6, 7));
        
        int trimestre = 0;
        
        try{
            trimestre = Integer.parseInt(itemTrimestre); 
	}catch(NumberFormatException ex){
            vistaAvances.labelMensaje.setText("Selecciona el trimestre");
            vistaAvances.labelMensaje.setForeground(new Color(204,51,0));
    	}
        
        modeloAvances.setTrimestre(trimestre);
        modeloAvances.setIdetapa(etapaSeleccionada);
       
        //Buscar idgrado_alumno
        int idgrado_alumno = sqlAvances.obtenerIdgrado_alumno(modeloAvances.getNocontrol(), 
                modeloAvances.getIdgrado(), modeloAvances.getIdcicloescolar());
        modeloAvances.setIdgrado_alumno(idgrado_alumno);

        System.out.println("Nocontrol: "+ modeloAvances.getNocontrol());
        System.out.println("ApellidoPaterno: "+modeloAvances.getApe_paterno());
        System.out.println("ApellidoMatenro: "+ modeloAvances.getApe_materno());
        System.out.println("ApellidoMatenro: "+ modeloAvances.getNombre());
        System.out.println("Cicloescolar: "+modeloAvances.getIdcicloescolar());
        System.out.println("Grado: "+modeloAvances.getIdgrado());
        System.out.println("itemTrimestre = " + modeloAvances.getTrimestre());
        System.out.println("etapaSeleccionada = " + etapaSeleccionada);
        System.out.println("idgrado_alumno: " + modeloAvances.getIdgrado_alumno());
        
        //Consultar si ya existe un registro de idetapa en el trimestre seleccionado
        //si la consulta retorna un 0 no existe el registro y > 0 si existe
        int existeTrimestre = 0;
        try {
            existeTrimestre = sqlAvances.existeAvanceTrimestre(idgrado_alumno);
        } catch (SQLException ex) {
            Logger.getLogger(controlVistaAvances.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Insertar en la tabla avance
        if (trimestre == 0) {
            try {
                sqlAvances.insertarAvance(idgrado_alumno, etapaSeleccionada, Integer.parseInt(itemTrimestre));
                vistaAvances.labelMensaje.setText("¡Avance guardado correctamente!");
                vistaAvances.labelMensaje.setForeground(new Color(0,204,102));
            } catch (SQLException ex) {
                Logger.getLogger(controlVistaAvances.class.getName()).log(Level.SEVERE, null, ex);
                vistaAvances.labelMensaje.setText("Algo salió mal");
                vistaAvances.labelMensaje.setForeground(new Color(204,51,0));
            }  
        }
        else{
            vistaAvances.labelMensaje.setText("Ya existe un registro en el trimestre seleccionado, proceda a actualizar");
            vistaAvances.labelMensaje.setForeground(new Color(204,51,0));
        }
    }
    
    private void boxGrado(ActionEvent e){
       
    }
}

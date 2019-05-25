package controlador;
import java.awt.event.ActionEvent;
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
        
        int etapa = sqlAvances.obtenerEtapa(idgrado_alumno, Integer.parseInt(itemTrimestre));
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
        
        modeloAvances.setTrimestre(Integer.parseInt(itemTrimestre));
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
    }
}

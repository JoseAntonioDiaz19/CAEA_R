package controlador;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import modelo.modeloAvancesCapturas;
import modelo.modeloSesionUsuario;
import modeloSQL.sqlAvancesCapturas;
import modeloSQL.sqlDatosAlumno;
import modeloSQL.sqlPrincipal;
import vista.vistaAvancesCapturas;

/**
 * @author Dizan
 */
public class controlVistaAvancesCapturas {
    vistaAvancesCapturas vistaAvancesCapturas; 
    modeloSesionUsuario modeloUsuario;

    controlVistaAvancesCapturas(vistaAvancesCapturas vistaAvancesCapturas, 
                                modeloSesionUsuario modeloUsuario) {
        this.modeloUsuario = modeloUsuario;
        this.vistaAvancesCapturas = vistaAvancesCapturas;
        
        vistaAvancesCapturas.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                close();
            }

            private void close() {
                vistaAvancesCapturas.dispose();
            }
        });
        
        llenarCiclosEscolares();
        llenarGrados();
        llenarRegiones();
        llenarSituaciones();
        
        vistaAvancesCapturas.boxCicloEscolar.addItemListener(this::boxCicloEscolar);
        vistaAvancesCapturas.boxRegion.addItemListener(this::boxRegion);
        vistaAvancesCapturas.boxGrado.addItemListener(this::boxGrado);
        vistaAvancesCapturas.boxSituacion.addItemListener(this::boxSituacion);
    }
    
    private void llenarCiclosEscolares(){
        sqlPrincipal sqlPrincipal = new sqlPrincipal(modeloUsuario);
        ArrayList <String> ciclosEscolares;
        ciclosEscolares = sqlPrincipal.ciclosEscolares();
        int iteraciones = ciclosEscolares.size();
        for (int i = 0; i < iteraciones; i++) {
            vistaAvancesCapturas.boxCicloEscolar.addItem(ciclosEscolares.get(i));
        } 
    }
    
    private void llenarRegiones(){
       sqlPrincipal sqlPrincipal = new sqlPrincipal(modeloUsuario);
       ArrayList <String> regiones;
       regiones = sqlPrincipal.regiones();
       int iteraciones = regiones.size();
       for (int i = 0; i < iteraciones; i++) {
           vistaAvancesCapturas.boxRegion.addItem(regiones.get(i));
       }
   }
    
    private void llenarGrados(){
        sqlPrincipal sqlPrincipal = new sqlPrincipal(modeloUsuario);
        ArrayList <String>  grados;
        grados = sqlPrincipal.grados();
        int iteraciones = grados.size();
        for (int i = 0; i < iteraciones; i++) {
           vistaAvancesCapturas.boxGrado.addItem(grados.get(i));
       }
   }
    
    private void llenarSituaciones(){
        //llenar situacion final
        sqlDatosAlumno sqlDatosAlumno = new sqlDatosAlumno(modeloUsuario);
        ArrayList <String>  situacionFinal;
        situacionFinal = sqlDatosAlumno.situacionFinal();
        int iteracionesSituacionFinal = situacionFinal.size();
        for (int i = 0; i < iteracionesSituacionFinal; i++) {
            vistaAvancesCapturas.boxSituacion.addItem(situacionFinal.get(i));
        }
    }
        
    
    private void boxCicloEscolar(ItemEvent eventItem){
        String itemCiclo = (String) vistaAvancesCapturas.boxCicloEscolar.getSelectedItem();
        String itemRegion = (String) vistaAvancesCapturas.boxRegion.getSelectedItem();
        String itemGrado = (String) vistaAvancesCapturas.boxGrado.getSelectedItem();
        
        if (!itemCiclo.equals("- Seleccione Ciclo Escolar -")) {
            buscarPorCicloEscolar();
        }
        
        if (!itemCiclo.equals("- Seleccione Ciclo Escolar -") && !itemRegion.equals("- Seleccione Region -")) {
            buscarCicloRegion(); 
        }
        
        if (!itemCiclo.equals("- Seleccione Ciclo Escolar -") && !itemGrado.equals("- Seleccione Grado -")) {
            buscarCicloGrado();
        }
        
        if (!itemCiclo.equals("- Seleccione Ciclo Escolar -") 
                && !itemRegion.equals("- Seleccione Region -") && !itemGrado.equals("- Seleccione Grado -")) {
            buscarCicloRegionGrado();
        }  
        
    }
    
    private void boxRegion(ItemEvent eventItem){
        String itemCiclo = (String) vistaAvancesCapturas.boxCicloEscolar.getSelectedItem();
        String itemRegion = (String) vistaAvancesCapturas.boxRegion.getSelectedItem();
        String itemGrado = (String) vistaAvancesCapturas.boxGrado.getSelectedItem();
        
        if (!itemRegion.equals("- Seleccione Region -")) {
            buscarPorRegion();
        }
        
        if (!itemCiclo.equals("- Seleccione Ciclo Escolar -") && !itemRegion.equals("- Seleccione Region -")) {
            buscarCicloRegion(); 
        }
        
        if (!itemGrado.equals("- Seleccione Grado -") && !itemRegion.equals("- Seleccione Region -")) {
            buscarRegionGrado();
        }  
       if (!itemCiclo.equals("- Seleccione Ciclo Escolar -") 
                && !itemRegion.equals("- Seleccione Region -") && !itemGrado.equals("- Seleccione Grado -")) {
            buscarCicloRegionGrado();
        }  
    }
    
    private void boxGrado(ItemEvent eventItem){
        String itemGrado = (String) vistaAvancesCapturas.boxGrado.getSelectedItem();
        String itemCiclo = (String) vistaAvancesCapturas.boxCicloEscolar.getSelectedItem();
        String itemRegion = (String) vistaAvancesCapturas.boxRegion.getSelectedItem();
        
        if (!itemGrado.equals("- Seleccione Grado -")) {
             buscarPorGrado();
        }
        
        if (!itemGrado.equals("- Seleccione Grado -") && !itemCiclo.equals("- Seleccione Ciclo Escolar -") ) {
            buscarCicloGrado();
        }
        
        if (!itemGrado.equals("- Seleccione Grado -") && !itemRegion.equals("- Seleccione Region -")) {
            buscarRegionGrado();
        } 
        if (!itemCiclo.equals("- Seleccione Ciclo Escolar -") 
                && !itemRegion.equals("- Seleccione Region -") && !itemGrado.equals("- Seleccione Grado -")) {
            buscarCicloRegionGrado();
        } 
    }
    
    private void boxSituacion(ItemEvent eventItem){
        String itemGrado = (String) vistaAvancesCapturas.boxGrado.getSelectedItem();
        String itemCiclo = (String) vistaAvancesCapturas.boxCicloEscolar.getSelectedItem();
        String itemRegion = (String) vistaAvancesCapturas.boxRegion.getSelectedItem();
        String itemSituacion = (String) vistaAvancesCapturas.boxSituacion.getSelectedItem();
        
        if (!itemSituacion.equals("- Situacion actual/final -")) {
             buscarSituacion();
        }
        
        if (!itemSituacion.equals("- Situacion actual/final -") && !itemGrado.equals("- Seleccione Grado -")) {
            buscarGradoSituacion();
        } 
        
        if (!itemSituacion.equals("- Situacion actual/final -") && !itemRegion.equals("- Seleccione Region -")) {
            buscarRegionSituacion();
        }
        
        if (!itemSituacion.equals("- Situacion actual/final -") && !itemRegion.equals("- Seleccione Region -") && !itemGrado.equals("- Seleccione Grado -")) {
            buscarRegionGradoSituacion();
        }
        
        if (!itemSituacion.equals("- Situacion actual/final -") && !itemCiclo.equals("- Seleccione Ciclo Escolar -") && !itemGrado.equals("- Seleccione Grado -")) {
            buscarCicloescolarGradoSituacion();
        }
        if (!itemSituacion.equals("- Situacion actual/final -") && !itemCiclo.equals("- Seleccione Ciclo Escolar -") && !itemRegion.equals("- Seleccione Region -")) {
            buscarCicloescolarRegionSituacion();
        }
        if (!itemSituacion.equals("- Situacion actual/final -") && !itemCiclo.equals("- Seleccione Ciclo Escolar -") && !itemRegion.equals("- Seleccione Region -") && !itemGrado.equals("- Seleccione Grado -")) {
            buscarCicloescolarRegionGradoSituacion();
        }
    }
   
    private void buscarPorCicloEscolar(){
        vistaAvancesCapturas.modeloTabla.setRowCount(0);
        String cicloSeleccionado = (String) vistaAvancesCapturas.boxCicloEscolar.getSelectedItem();
        sqlAvancesCapturas sqlAvancesCapturas= new sqlAvancesCapturas(modeloUsuario);
        
        ArrayList <modeloAvancesCapturas>  busqueda;
        busqueda = sqlAvancesCapturas.buscarPorCicloEscolar(cicloSeleccionado);
        int iteraciones =  busqueda.size();

        for (int i = 0; i < iteraciones; i++) {
                vistaAvancesCapturas.modeloTabla.addRow(new Object[]{
                                                    busqueda.get(i).getIdcicloescolar(),
                                                    busqueda.get(i).getRegion(),
                                                    busqueda.get(i).getNocontrol(),
                                                    busqueda.get(i).getIdgrado(),
                                                    busqueda.get(i).getApe_paterno(),
                                                    busqueda.get(i).getApe_materno(),
                                                    busqueda.get(i).getNombre(),
                                                    busqueda.get(i).getT1(),
                                                    busqueda.get(i).getT2(),
                                                    busqueda.get(i).getT3(),
                                                    busqueda.get(i).getEstado_actual_final()
            });
       }    
    }
    
    private void buscarPorRegion(){
        vistaAvancesCapturas.modeloTabla.setRowCount(0);
        String region = (String) vistaAvancesCapturas.boxRegion.getSelectedItem();
        region = region.substring(0,region.length());
       sqlAvancesCapturas sqlAvancesCapturas= new sqlAvancesCapturas(modeloUsuario);
        
        ArrayList <modeloAvancesCapturas>  busqueda;
        busqueda = sqlAvancesCapturas.buscarPorRegion(region);
        int iteraciones =  busqueda.size();

        for (int i = 0; i < iteraciones; i++) {
                vistaAvancesCapturas.modeloTabla.addRow(new Object[]{
                                                    busqueda.get(i).getIdcicloescolar(),
                                                    busqueda.get(i).getRegion(),
                                                    busqueda.get(i).getNocontrol(),
                                                    busqueda.get(i).getIdgrado(),
                                                    busqueda.get(i).getApe_paterno(),
                                                    busqueda.get(i).getApe_materno(),
                                                    busqueda.get(i).getNombre(),
                                                    busqueda.get(i).getT1(),
                                                    busqueda.get(i).getT2(),
                                                    busqueda.get(i).getT3(),
                                                    busqueda.get(i).getEstado_actual_final()
            });
       }    
    }
    
    private void buscarPorGrado(){
        vistaAvancesCapturas.modeloTabla.setRowCount(0);
        int itemSeleccionado = Integer.parseInt((String) vistaAvancesCapturas.boxGrado.getSelectedItem());
        sqlAvancesCapturas sqlAvancesCapturas= new sqlAvancesCapturas(modeloUsuario);
        
        ArrayList <modeloAvancesCapturas>  busqueda;
        busqueda = sqlAvancesCapturas.buscarPorGrado(itemSeleccionado);
        int iteraciones =  busqueda.size();

        for (int i = 0; i < iteraciones; i++) {
                vistaAvancesCapturas.modeloTabla.addRow(new Object[]{
                                    busqueda.get(i).getIdcicloescolar(),
                                                    busqueda.get(i).getRegion(),
                                                    busqueda.get(i).getNocontrol(),
                                                    busqueda.get(i).getIdgrado(),
                                                    busqueda.get(i).getApe_paterno(),
                                                    busqueda.get(i).getApe_materno(),
                                                    busqueda.get(i).getNombre(),
                                                    busqueda.get(i).getT1(),
                                                    busqueda.get(i).getT2(),
                                                    busqueda.get(i).getT3(),
                                                    busqueda.get(i).getEstado_actual_final()
            });
       }    
    }
    
    private void buscarCicloRegion(){
        vistaAvancesCapturas.modeloTabla.setRowCount(0);
        String itemCiclo = (String) vistaAvancesCapturas.boxCicloEscolar.getSelectedItem();
        String itemRegion = (String) vistaAvancesCapturas.boxRegion.getSelectedItem();
        itemRegion = itemRegion.substring(0,itemRegion.length());
        sqlAvancesCapturas sqlAvancesCapturas= new sqlAvancesCapturas(modeloUsuario);
        
        ArrayList <modeloAvancesCapturas>  busqueda;
        busqueda = sqlAvancesCapturas.buscarCicloRegion(itemCiclo, itemRegion);
        int iteraciones =  busqueda.size();

        for (int i = 0; i < iteraciones; i++) {
                vistaAvancesCapturas.modeloTabla.addRow(new Object[]{
                                busqueda.get(i).getIdcicloescolar(),
                                                    busqueda.get(i).getRegion(),
                                                    busqueda.get(i).getNocontrol(),
                                                    busqueda.get(i).getIdgrado(),
                                                    busqueda.get(i).getApe_paterno(),
                                                    busqueda.get(i).getApe_materno(),
                                                    busqueda.get(i).getNombre(),
                                                    busqueda.get(i).getT1(),
                                                    busqueda.get(i).getT2(),
                                                    busqueda.get(i).getT3(),
                                                    busqueda.get(i).getEstado_actual_final()
            });
       }      
    }
    
    private void buscarCicloGrado(){
        vistaAvancesCapturas.modeloTabla.setRowCount(0);
        String itemCiclo = (String) vistaAvancesCapturas.boxCicloEscolar.getSelectedItem();
        int itemGrado = Integer.parseInt((String) vistaAvancesCapturas.boxGrado.getSelectedItem());
        sqlAvancesCapturas sqlAvancesCapturas= new sqlAvancesCapturas(modeloUsuario);
        
        ArrayList <modeloAvancesCapturas>  busqueda;
        busqueda = sqlAvancesCapturas.buscarCicloGrado(itemCiclo, itemGrado);
        int iteraciones =  busqueda.size();

        for (int i = 0; i < iteraciones; i++) {
                vistaAvancesCapturas.modeloTabla.addRow(new Object[]{
                                   busqueda.get(i).getIdcicloescolar(),
                                                    busqueda.get(i).getRegion(),
                                                    busqueda.get(i).getNocontrol(),
                                                    busqueda.get(i).getIdgrado(),
                                                    busqueda.get(i).getApe_paterno(),
                                                    busqueda.get(i).getApe_materno(),
                                                    busqueda.get(i).getNombre(),
                                                    busqueda.get(i).getT1(),
                                                    busqueda.get(i).getT2(),
                                                    busqueda.get(i).getT3(),
                                                    busqueda.get(i).getEstado_actual_final()
            });
       }      
    }
    
    private void buscarRegionGrado(){
        vistaAvancesCapturas.modeloTabla.setRowCount(0);
        int itemGrado = Integer.parseInt((String) vistaAvancesCapturas.boxGrado.getSelectedItem());
        String itemRegion = (String) vistaAvancesCapturas.boxRegion.getSelectedItem();
        itemRegion = itemRegion.substring(0,itemRegion.length());
        sqlAvancesCapturas sqlAvancesCapturas= new sqlAvancesCapturas(modeloUsuario);
        
        ArrayList <modeloAvancesCapturas>  busqueda;
        busqueda = sqlAvancesCapturas.buscarRegionGrado(itemRegion, itemGrado);
        int iteraciones =  busqueda.size();

        for (int i = 0; i < iteraciones; i++) {
                vistaAvancesCapturas.modeloTabla.addRow(new Object[]{
                                   busqueda.get(i).getIdcicloescolar(),
                                                    busqueda.get(i).getRegion(),
                                                    busqueda.get(i).getNocontrol(),
                                                    busqueda.get(i).getIdgrado(),
                                                    busqueda.get(i).getApe_paterno(),
                                                    busqueda.get(i).getApe_materno(),
                                                    busqueda.get(i).getNombre(),
                                                    busqueda.get(i).getT1(),
                                                    busqueda.get(i).getT2(),
                                                    busqueda.get(i).getT3(),
                                                    busqueda.get(i).getEstado_actual_final()
            });
       }      
    }
    
    private void buscarCicloRegionGrado(){
       vistaAvancesCapturas.modeloTabla.setRowCount(0);
        String itemCiclo = (String) vistaAvancesCapturas.boxCicloEscolar.getSelectedItem();
        int itemGrado = Integer.parseInt((String) vistaAvancesCapturas.boxGrado.getSelectedItem());
        String itemRegion = (String) vistaAvancesCapturas.boxRegion.getSelectedItem();
        itemRegion = itemRegion.substring(0,itemRegion.length());
        sqlAvancesCapturas sqlAvancesCapturas= new sqlAvancesCapturas(modeloUsuario);
        
        ArrayList <modeloAvancesCapturas>  busqueda;
        busqueda = sqlAvancesCapturas.buscarCicloRegionGrado(itemCiclo, itemRegion, itemGrado);
        int iteraciones =  busqueda.size();

        for (int i = 0; i < iteraciones; i++) {
                vistaAvancesCapturas.modeloTabla.addRow(new Object[]{
                                    busqueda.get(i).getIdcicloescolar(),
                                                    busqueda.get(i).getRegion(),
                                                    busqueda.get(i).getNocontrol(),
                                                    busqueda.get(i).getIdgrado(),
                                                    busqueda.get(i).getApe_paterno(),
                                                    busqueda.get(i).getApe_materno(),
                                                    busqueda.get(i).getNombre(),
                                                    busqueda.get(i).getT1(),
                                                    busqueda.get(i).getT2(),
                                                    busqueda.get(i).getT3(),
                                                    busqueda.get(i).getEstado_actual_final()
                });
            }      
        }
    
        private void buscarSituacion(){
        vistaAvancesCapturas.modeloTabla.setRowCount(0);
        String estado_actual_final = String.valueOf(vistaAvancesCapturas.boxSituacion.getSelectedItem());
        sqlAvancesCapturas sqlAvancesCapturas= new sqlAvancesCapturas(modeloUsuario);
        
        ArrayList <modeloAvancesCapturas>  busqueda;
        busqueda = sqlAvancesCapturas.buscarSituacion(estado_actual_final);
        int iteraciones =  busqueda.size();

        for (int i = 0; i < iteraciones; i++) {
                vistaAvancesCapturas.modeloTabla.addRow(new Object[]{
                                   busqueda.get(i).getIdcicloescolar(),
                                                    busqueda.get(i).getRegion(),
                                                    busqueda.get(i).getNocontrol(),
                                                    busqueda.get(i).getIdgrado(),
                                                    busqueda.get(i).getApe_paterno(),
                                                    busqueda.get(i).getApe_materno(),
                                                    busqueda.get(i).getNombre(),
                                                    busqueda.get(i).getT1(),
                                                    busqueda.get(i).getT2(),
                                                    busqueda.get(i).getT3(),
                                                    busqueda.get(i).getEstado_actual_final()
                });
            }      
        }
        
        private void buscarGradoSituacion(){
        vistaAvancesCapturas.modeloTabla.setRowCount(0);
        int itemGrado = Integer.parseInt((String) vistaAvancesCapturas.boxGrado.getSelectedItem());
        String estado_actual_final = String.valueOf(vistaAvancesCapturas.boxSituacion.getSelectedItem());
        sqlAvancesCapturas sqlAvancesCapturas= new sqlAvancesCapturas(modeloUsuario);
        
        ArrayList <modeloAvancesCapturas>  busqueda;
        busqueda = sqlAvancesCapturas.buscarGradoSituacion(estado_actual_final, itemGrado);
        int iteraciones =  busqueda.size();

        for (int i = 0; i < iteraciones; i++) {
                vistaAvancesCapturas.modeloTabla.addRow(new Object[]{
                                   busqueda.get(i).getIdcicloescolar(),
                                                    busqueda.get(i).getRegion(),
                                                    busqueda.get(i).getNocontrol(),
                                                    busqueda.get(i).getIdgrado(),
                                                    busqueda.get(i).getApe_paterno(),
                                                    busqueda.get(i).getApe_materno(),
                                                    busqueda.get(i).getNombre(),
                                                    busqueda.get(i).getT1(),
                                                    busqueda.get(i).getT2(),
                                                    busqueda.get(i).getT3(),
                                                    busqueda.get(i).getEstado_actual_final()
            });
       }      
    }
    
    private void buscarRegionSituacion(){
        vistaAvancesCapturas.modeloTabla.setRowCount(0);
        String itemRegion = (String) vistaAvancesCapturas.boxRegion.getSelectedItem();
        itemRegion = itemRegion.substring(0,itemRegion.length());
        String estado_actual_final = String.valueOf(vistaAvancesCapturas.boxSituacion.getSelectedItem());
        sqlAvancesCapturas sqlAvancesCapturas= new sqlAvancesCapturas(modeloUsuario);
        
        ArrayList <modeloAvancesCapturas>  busqueda;
        busqueda = sqlAvancesCapturas.buscarRegionSituacion(estado_actual_final, itemRegion);
        int iteraciones =  busqueda.size();

        for (int i = 0; i < iteraciones; i++) {
                vistaAvancesCapturas.modeloTabla.addRow(new Object[]{
                                   busqueda.get(i).getIdcicloescolar(),
                                                    busqueda.get(i).getRegion(),
                                                    busqueda.get(i).getNocontrol(),
                                                    busqueda.get(i).getIdgrado(),
                                                    busqueda.get(i).getApe_paterno(),
                                                    busqueda.get(i).getApe_materno(),
                                                    busqueda.get(i).getNombre(),
                                                    busqueda.get(i).getT1(),
                                                    busqueda.get(i).getT2(),
                                                    busqueda.get(i).getT3(),
                                                    busqueda.get(i).getEstado_actual_final()
            });
       }      
    }
    private void buscarRegionGradoSituacion(){
        vistaAvancesCapturas.modeloTabla.setRowCount(0);
        int itemGrado = Integer.parseInt((String) vistaAvancesCapturas.boxGrado.getSelectedItem());
        String itemRegion = (String) vistaAvancesCapturas.boxRegion.getSelectedItem();
        itemRegion = itemRegion.substring(0,itemRegion.length());
        String estado_actual_final = String.valueOf(vistaAvancesCapturas.boxSituacion.getSelectedItem());
        sqlAvancesCapturas sqlAvancesCapturas= new sqlAvancesCapturas(modeloUsuario);
        
        ArrayList <modeloAvancesCapturas>  busqueda;
        busqueda = sqlAvancesCapturas.buscarRegionGradoSituacion(estado_actual_final, itemGrado ,itemRegion);
        int iteraciones =  busqueda.size();

        for (int i = 0; i < iteraciones; i++) {
                vistaAvancesCapturas.modeloTabla.addRow(new Object[]{
                                   busqueda.get(i).getIdcicloescolar(),
                                                    busqueda.get(i).getRegion(),
                                                    busqueda.get(i).getNocontrol(),
                                                    busqueda.get(i).getIdgrado(),
                                                    busqueda.get(i).getApe_paterno(),
                                                    busqueda.get(i).getApe_materno(),
                                                    busqueda.get(i).getNombre(),
                                                    busqueda.get(i).getT1(),
                                                    busqueda.get(i).getT2(),
                                                    busqueda.get(i).getT3(),
                                                    busqueda.get(i).getEstado_actual_final()
            });
       }      
    }
    
    private void buscarCicloescolarSituacion(){
        vistaAvancesCapturas.modeloTabla.setRowCount(0);
        String estado_actual_final = String.valueOf(vistaAvancesCapturas.boxSituacion.getSelectedItem());
        String cicloescolar = String.valueOf(vistaAvancesCapturas.boxCicloEscolar.getSelectedItem());
        sqlAvancesCapturas sqlAvancesCapturas= new sqlAvancesCapturas(modeloUsuario);
        
        ArrayList <modeloAvancesCapturas>  busqueda;
        busqueda = sqlAvancesCapturas.buscarCicloescolarSituacion(estado_actual_final,cicloescolar);
        int iteraciones =  busqueda.size();

        for (int i = 0; i < iteraciones; i++) {
                vistaAvancesCapturas.modeloTabla.addRow(new Object[]{
                                   busqueda.get(i).getIdcicloescolar(),
                                                    busqueda.get(i).getRegion(),
                                                    busqueda.get(i).getNocontrol(),
                                                    busqueda.get(i).getIdgrado(),
                                                    busqueda.get(i).getApe_paterno(),
                                                    busqueda.get(i).getApe_materno(),
                                                    busqueda.get(i).getNombre(),
                                                    busqueda.get(i).getT1(),
                                                    busqueda.get(i).getT2(),
                                                    busqueda.get(i).getT3(),
                                                    busqueda.get(i).getEstado_actual_final()
            });
       }      
    }
    private void buscarCicloescolarGradoSituacion(){
        vistaAvancesCapturas.modeloTabla.setRowCount(0);
        int itemGrado = Integer.parseInt((String) vistaAvancesCapturas.boxGrado.getSelectedItem());
        String estado_actual_final = String.valueOf(vistaAvancesCapturas.boxSituacion.getSelectedItem());
        String cicloescolar = String.valueOf(vistaAvancesCapturas.boxCicloEscolar.getSelectedItem());
        sqlAvancesCapturas sqlAvancesCapturas= new sqlAvancesCapturas(modeloUsuario);
        
        ArrayList <modeloAvancesCapturas>  busqueda;
        busqueda = sqlAvancesCapturas.buscarCicloescolarGradoSituacion(estado_actual_final,cicloescolar, itemGrado);
        int iteraciones =  busqueda.size();

        for (int i = 0; i < iteraciones; i++) {
                vistaAvancesCapturas.modeloTabla.addRow(new Object[]{
                                   busqueda.get(i).getIdcicloescolar(),
                                                    busqueda.get(i).getRegion(),
                                                    busqueda.get(i).getNocontrol(),
                                                    busqueda.get(i).getIdgrado(),
                                                    busqueda.get(i).getApe_paterno(),
                                                    busqueda.get(i).getApe_materno(),
                                                    busqueda.get(i).getNombre(),
                                                    busqueda.get(i).getT1(),
                                                    busqueda.get(i).getT2(),
                                                    busqueda.get(i).getT3(),
                                                    busqueda.get(i).getEstado_actual_final()
            });
       }      
    }
    
    private void buscarCicloescolarRegionSituacion(){
        vistaAvancesCapturas.modeloTabla.setRowCount(0);
        String itemRegion = (String) vistaAvancesCapturas.boxRegion.getSelectedItem();
        itemRegion = itemRegion.substring(0,itemRegion.length());
        String estado_actual_final = String.valueOf(vistaAvancesCapturas.boxSituacion.getSelectedItem());
        String cicloescolar = String.valueOf(vistaAvancesCapturas.boxCicloEscolar.getSelectedItem());
        sqlAvancesCapturas sqlAvancesCapturas= new sqlAvancesCapturas(modeloUsuario);
        
        ArrayList <modeloAvancesCapturas>  busqueda;
        busqueda = sqlAvancesCapturas.buscarCicloescolarRegionSituacion(estado_actual_final,cicloescolar, itemRegion);
        int iteraciones =  busqueda.size();

        for (int i = 0; i < iteraciones; i++) {
                vistaAvancesCapturas.modeloTabla.addRow(new Object[]{
                                   busqueda.get(i).getIdcicloescolar(),
                                                    busqueda.get(i).getRegion(),
                                                    busqueda.get(i).getNocontrol(),
                                                    busqueda.get(i).getIdgrado(),
                                                    busqueda.get(i).getApe_paterno(),
                                                    busqueda.get(i).getApe_materno(),
                                                    busqueda.get(i).getNombre(),
                                                    busqueda.get(i).getT1(),
                                                    busqueda.get(i).getT2(),
                                                    busqueda.get(i).getT3(),
                                                    busqueda.get(i).getEstado_actual_final()
            });
       }      
    }
    
    private void buscarCicloescolarRegionGradoSituacion(){
        vistaAvancesCapturas.modeloTabla.setRowCount(0);
        int itemGrado = Integer.parseInt((String) vistaAvancesCapturas.boxGrado.getSelectedItem());
        String itemRegion = (String) vistaAvancesCapturas.boxRegion.getSelectedItem();
        itemRegion = itemRegion.substring(0,itemRegion.length());
        String estado_actual_final = String.valueOf(vistaAvancesCapturas.boxSituacion.getSelectedItem());
        String cicloescolar = String.valueOf(vistaAvancesCapturas.boxCicloEscolar.getSelectedItem());
        sqlAvancesCapturas sqlAvancesCapturas= new sqlAvancesCapturas(modeloUsuario);
        
        ArrayList <modeloAvancesCapturas>  busqueda;
        busqueda = sqlAvancesCapturas.buscarCicloescolarRegionGradoSituacion(estado_actual_final,cicloescolar, itemRegion, itemGrado);
        int iteraciones =  busqueda.size();

        for (int i = 0; i < iteraciones; i++) {
                vistaAvancesCapturas.modeloTabla.addRow(new Object[]{
                                   busqueda.get(i).getIdcicloescolar(),
                                                    busqueda.get(i).getRegion(),
                                                    busqueda.get(i).getNocontrol(),
                                                    busqueda.get(i).getIdgrado(),
                                                    busqueda.get(i).getApe_paterno(),
                                                    busqueda.get(i).getApe_materno(),
                                                    busqueda.get(i).getNombre(),
                                                    busqueda.get(i).getT1(),
                                                    busqueda.get(i).getT2(),
                                                    busqueda.get(i).getT3(),
                                                    busqueda.get(i).getEstado_actual_final()
            });
       }      
    }
}

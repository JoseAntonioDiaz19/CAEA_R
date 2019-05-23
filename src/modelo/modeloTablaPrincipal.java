package modelo;
/**
 * @author Dizan
 */
public class modeloTablaPrincipal {

    private int nocontrol;
    private String ape_paterno;
    private String ape_materno;
    private String nombre;
    private int grado;
    private String region;
    private String cicloescolar;
    private String situacion;
    private String estado;
    private String estado_actual_final;

    public modeloTablaPrincipal(int nocontrol, 
                                String ape_paterno, 
                                String ape_materno, 
                                String nombre, 
                                int grado, 
                                String region, 
                                String cicloescolar, 
                                String situacion, 
                                String estado, 
                                String estado_actual_final) {
        
        this.nocontrol = nocontrol;
        this.ape_paterno = ape_paterno;
        this.ape_materno = ape_materno;
        this.nombre = nombre;
        this.grado = grado;
        this.region = region;
        this.cicloescolar = cicloescolar;
        this.situacion = situacion;
        this.estado = estado;
        this.estado_actual_final = estado_actual_final;
    }
   
    /**
     * @return the nocontrol
     */
    public int getNocontrol() {
        return nocontrol;
    }

    /**
     * @param nocontrol the nocontrol to set
     */
    public void setNocontrol(int nocontrol) {
        this.nocontrol = nocontrol;
    }

    /**
     * @return the ape_paterno
     */
    public String getApe_paterno() {
        return ape_paterno;
    }

    /**
     * @param ape_paterno the ape_paterno to set
     */
    public void setApe_paterno(String ape_paterno) {
        this.ape_paterno = ape_paterno;
    }

    /**
     * @return the ape_materno
     */
    public String getApe_materno() {
        return ape_materno;
    }

    /**
     * @param ape_materno the ape_materno to set
     */
    public void setApe_materno(String ape_materno) {
        this.ape_materno = ape_materno;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the grado
     */
    public int getGrado() {
        return grado;
    }

    /**
     * @param grado the grado to set
     */
    public void setGrado(int grado) {
        this.grado = grado;
    }

    /**
     * @return the region
     */
    public String getRegion() {
        return region;
    }

    /**
     * @param region the region to set
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * @return the cicloescolar
     */
    public String getCicloescolar() {
        return cicloescolar;
    }

    /**
     * @param cicloescolar the cicloescolar to set
     */
    public void setCicloescolar(String cicloescolar) {
        this.cicloescolar = cicloescolar;
    }

    /**
     * @return the situacion
     */
    public String getSituacion() {
        return situacion;
    }

    /**
     * @param situacion the situacion to set
     */
    public void setSituacion(String situacion) {
        this.situacion = situacion;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the estado_actual_final
     */
    public String getEstado_actual_final() {
        return estado_actual_final;
    }

    /**
     * @param estado_actual_final the estado_actual_final to set
     */
    public void setEstado_actual_final(String estado_actual_final) {
        this.estado_actual_final = estado_actual_final;
    }

}

package modelo;
/**
 * @author Dizan
 */
public class modeloAvancesCapturas {
    private String idcicloescolar;
    private String region;
    private int nocontrol;
    private int idgrado;
    private String ape_paterno;
    private String ape_materno;
    private String nombre;
    private int t1;
    private int t2;
    private int t3;
    private String estado_actual_final;

    public modeloAvancesCapturas() {
    }

    public modeloAvancesCapturas(String idcicloescolar, 
                                String region, 
                                int nocontrol, 
                                int idgrado, 
                                String ape_paterno, 
                                String ape_materno, 
                                String nombre, 
                                int t1, 
                                int t2,
                                int t3, 
                                String estado_actual_final) {
        this.idcicloescolar = idcicloescolar;
        this.region = region;
        this.nocontrol = nocontrol;
        this.idgrado = idgrado;
        this.ape_paterno = ape_paterno;
        this.ape_materno = ape_materno;
        this.nombre = nombre;
        this.t1 = t1;
        this.t2 = t2;
        this.t3 = t3;
        this.estado_actual_final = estado_actual_final;
    }
    
    

    /**
     * @return the idcicloescolar
     */
    public String getIdcicloescolar() {
        return idcicloescolar;
    }

    /**
     * @param idcicloescolar the idcicloescolar to set
     */
    public void setIdcicloescolar(String idcicloescolar) {
        this.idcicloescolar = idcicloescolar;
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
     * @return the idgrado
     */
    public int getIdgrado() {
        return idgrado;
    }

    /**
     * @param idgrado the idgrado to set
     */
    public void setIdgrado(int idgrado) {
        this.idgrado = idgrado;
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
     * @return the t1
     */
    public int getT1() {
        return t1;
    }

    /**
     * @param t1 the t1 to set
     */
    public void setT1(int t1) {
        this.t1 = t1;
    }

    /**
     * @return the t2
     */
    public int getT2() {
        return t2;
    }

    /**
     * @param t2 the t2 to set
     */
    public void setT2(int t2) {
        this.t2 = t2;
    }

    /**
     * @return the t3
     */
    public int getT3() {
        return t3;
    }

    /**
     * @param t3 the t3 to set
     */
    public void setT3(int t3) {
        this.t3 = t3;
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

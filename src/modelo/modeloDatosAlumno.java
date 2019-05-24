package modelo;
/**
 * @author Dizan
 */
public class modeloDatosAlumno {
    private String nombre;
    private String ape_paterno;
    private String ape_materno;
    private String sexo;
    private String fecha_nacimiento;
    private int nocontrol;
    private String cicloescolar;
    private String region;
    private int grado;  
    private String situacion;
    private String situacion_final;

    public modeloDatosAlumno() {
        
    }

    public modeloDatosAlumno(String nombre, String ape_paterno, String ape_materno, String sexo, String fecha_nacimiento, int nocontrol, String cicloescolar, String region, int grado, String situacion, String situacion_final) {
        this.nombre = nombre;
        this.ape_paterno = ape_paterno;
        this.ape_materno = ape_materno;
        this.sexo = sexo;
        this.fecha_nacimiento = fecha_nacimiento;
        this.nocontrol = nocontrol;
        this.cicloescolar = cicloescolar;
        this.region = region;
        this.grado = grado;
        this.situacion = situacion;
        this.situacion_final = situacion_final;
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
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the fecha_nacimiento
     */
    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    /**
     * @param fecha_nacimiento the fecha_nacimiento to set
     */
    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
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
     * @return the situacion_final
     */
    public String getSituacion_final() {
        return situacion_final;
    }

    /**
     * @param situacion_final the situacion_final to set
     */
    public void setSituacion_final(String situacion_final) {
        this.situacion_final = situacion_final;
    } 
}

    
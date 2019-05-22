package modelo;
/**
 *
 * @author Dizan
 */
public class modeloAlumno {
    private int numeroControl;
    private int idRegion;
    private String nombre;
    private String ape_paterno;
    private String ape_materno;
    private char sexo;
    private String fecha_nacimiento;
    private String cicloEscolar;
    private int grado;  

    public modeloAlumno() {
        
    }

    public modeloAlumno(int numeroControl, 
                        int idRegion, 
                        String nombre, String ape_paterno, 
                        String ape_materno, 
                        char sexo, 
                        String fecha_nacimiento, 
                        String cicloEscolar, 
                        int grado) {
        
        this.numeroControl = numeroControl;
        this.idRegion = idRegion;
        this.nombre = nombre;
        this.ape_paterno = ape_paterno;
        this.ape_materno = ape_materno;
        this.sexo = sexo;
        this.fecha_nacimiento = fecha_nacimiento;
        this.cicloEscolar = cicloEscolar;
        this.grado = grado;
    }
    /**
     * @return the numeroControl
     */
    public int getNumeroControl() {
        return numeroControl;
    }

    /**
     * @param numeroControl the numeroControl to set
     */
    public void setNumeroControl(int numeroControl) {
        this.numeroControl = numeroControl;
    }

    /**
     * @return the idRegion
     */
    public int getIdRegion() {
        return idRegion;
    }

    /**
     * @param idRegion the idRegion to set
     */
    public void setIdRegion(int idRegion) {
        this.idRegion = idRegion;
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
    public char getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(char sexo) {
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
     * @return the cicloEscolar
     */
    public String getCicloEscolar() {
        return cicloEscolar;
    }

    /**
     * @param cicloEscolar the cicloEscolar to set
     */
    public void setCicloEscolar(String cicloEscolar) {
        this.cicloEscolar = cicloEscolar;
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
}

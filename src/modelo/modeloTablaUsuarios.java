package modelo;
/**
 * @author Dizan
 */
public class modeloTablaUsuarios {
    private int nocontrol;
    private String figura_educativa;
    private String ape_paterno;
    private String ape_materno;
    private String nombre;
    private String sexo;
    private String usuario;
    private String contraseña;
    private String vigencia;

    public modeloTablaUsuarios() {
        
    }

    public modeloTablaUsuarios(int nocontrol, String figura_educativa, String ape_paterno, String ape_materno, String nombre, String sexo, String usuario, String contraseña, String vigencia) {
        this.nocontrol = nocontrol;
        this.figura_educativa = figura_educativa;
        this.ape_paterno = ape_paterno;
        this.ape_materno = ape_materno;
        this.nombre = nombre;
        this.sexo = sexo;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.vigencia = vigencia;
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
     * @return the figura_educativa
     */
    public String getFigura_educativa() {
        return figura_educativa;
    }

    /**
     * @param figura_educativa the figura_educativa to set
     */
    public void setFigura_educativa(String figura_educativa) {
        this.figura_educativa = figura_educativa;
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
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the contraseña
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * @param contraseña the contraseña to set
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    /**
     * @return the vigencia
     */
    public String getVigencia() {
        return vigencia;
    }

    /**
     * @param vigencia the vigencia to set
     */
    public void setVigencia(String vigencia) {
        this.vigencia = vigencia;
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
}

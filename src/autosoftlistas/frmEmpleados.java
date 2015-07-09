package autosoftlistas;

/**
 *
 * @author Velasquez
 */
public class frmEmpleados {

    private String ID;
    private String nombre;
    private String apellido;
    private String fechaNacimiento;
    private int genero;
    private int estadoCivil;
    private String telefono;
    private String celular;
    private String pais;
    private String departamento;
    private String ciudad;
    private String direccion;
    private String correo;
    
    public frmEmpleados(String ID, String nombre, String apellido, String fechaNacimiento, int genero, int estadoCivil, String telefono, String celular, String pais, String departamento, String ciudad, String direccion, String correo){
        this.ID = ID;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.estadoCivil = estadoCivil;
        this.telefono = telefono;
        this.celular = celular;
        this.pais = pais;
        this.departamento = departamento;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.correo = correo;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }

    public int getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(int estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public String toString(){
        return ID + " " + nombre + " " + apellido + " " + fechaNacimiento + " " + genero + " " + estadoCivil + " " + telefono + " " + celular + " " + pais + " " + departamento + " " + ciudad + " " + direccion + " " + correo;
    }
}

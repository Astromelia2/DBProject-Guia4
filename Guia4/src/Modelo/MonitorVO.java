package Modelo;

public class MonitorVO {
    int id;
    String nombre,telefono,direccion,fechadeNacimiento,correo;

    public MonitorVO(int id, String nombre, String telefono, String direccion, String fechadeNacimiento, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.fechadeNacimiento = fechadeNacimiento;
        this.correo = correo;
    }

    public MonitorVO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFechadeNacimiento() {
        return fechadeNacimiento;
    }

    public void setFechadeNacimiento(String fechadeNacimiento) {
        this.fechadeNacimiento = fechadeNacimiento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    

}

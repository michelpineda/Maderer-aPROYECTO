import java.io.Serializable;

public class Clientes implements Serializable{
    private String nombre;
    private String telefono;
    private String email;
    private String ndecuenta;

//constructor
    public Clientes(String nombre, String telefono, String email, String ndecuenta) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.ndecuenta = ndecuenta;
    }

//metodos

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
         this.email = email;
    }
       
    public String getNdecuenta() {
        return ndecuenta;
    }

    public void setNdecuenta(String ndecuenta) {
        this.ndecuenta = ndecuenta;
    }

    @Override
    public String toString() {
        return "Proveedores{" + "nombre: '" + nombre + '\'' + ", telefono: " + telefono + "'" + " email: '" + email + "'" + "Ndecuenta" + ndecuenta + '}';
    }
}
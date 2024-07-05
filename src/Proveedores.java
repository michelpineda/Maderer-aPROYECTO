import java.io.Serializable;

public class Proveedores implements Serializable {
    private String nombre;
    private String telefono;

//constructor
    public Proveedores(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
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

    @Override
    public String toString() {
        return "Proveedores{" + "nombre: '" + nombre + '\'' + ", telefono: " + telefono + '}';
    }

}
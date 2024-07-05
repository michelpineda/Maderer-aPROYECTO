import java.util.ArrayList;

public class AgendaProveedores {
    private ArrayList<Proveedores> proveedores;

//constructor
    public AgendaProveedores() {
        this.proveedores = new ArrayList<>();
    }
    
//métodos
    public void agregarProveedores(Proveedores proveedor) {
        Proveedores existente = buscarProveedores(proveedor.getNombre());
        if (existente != null){
            actualizarProveedores(existente, proveedor);
        }else{
            proveedores.add(proveedor);
        }
    }
        
    public void actualizarProveedores(Proveedores existente, Proveedores nuevo) {
    String nuevoTelefono = existente.getTelefono();
    existente.setTelefono(nuevoTelefono);
    }
    
    public void eliminarProveedores(String nombre) {
        proveedores.removeIf(proveedor -> proveedor.getNombre().equals(nombre));
    }
    
    public Proveedores buscarProveedores(String nombre) {
        for (Proveedores proveedor : proveedores) {
            if (proveedor.getNombre().equals(nombre)) {
                return proveedor;
            }
        }
        return null;
    }
    
    public void mostrarAgendaProveedores() {
        for (Proveedores proveedor : proveedores) {
            System.out.println(proveedor);
        }
    }
}


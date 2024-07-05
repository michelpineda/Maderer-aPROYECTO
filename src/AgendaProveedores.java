// Para AgendaProveedores
import java.io.*;
import java.util.ArrayList;

public final class AgendaProveedores {
    private final ArrayList<Proveedores> proveedores;
    private final String archivo;

    public AgendaProveedores(String archivo) {
        this.proveedores = new ArrayList<>();
        this.archivo = archivo;
        cargarAgenda();
    }

    public void agregarProveedores(Proveedores proveedor) {
        Proveedores existente = buscarProveedores(proveedor.getNombre());
        if (existente != null) {
            actualizarProveedores(existente, proveedor);
        } else {
            proveedores.add(proveedor);
        }
    }

    public void actualizarProveedores(Proveedores existente, Proveedores nuevo) {
        existente.setTelefono(nuevo.getTelefono());
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

    public void guardarAgenda() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(proveedores);
        } catch (IOException e) {
            System.out.println("Error guardando la agenda de proveedores: " + e.getMessage());
        }
    }

    public void cargarAgenda() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            @SuppressWarnings("unchecked")
            ArrayList<Proveedores> loadedProveedores = (ArrayList<Proveedores>) ois.readObject();
            proveedores.addAll(loadedProveedores);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error cargando la agenda de proveedores: " + e.getMessage());
        }
    }
}
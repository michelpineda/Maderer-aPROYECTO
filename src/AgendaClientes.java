// Para AgendaClientes
import java.io.*;
import java.util.ArrayList;

public final class AgendaClientes {
    private final ArrayList<Clientes> clientes;
    private final String archivo;

    public AgendaClientes(String archivo) {
        this.clientes = new ArrayList<>();
        this.archivo = archivo;
        cargarAgenda();
    }

    public void agregarClientes(Clientes cliente) {
        Clientes existente = buscarClientes(cliente.getNombre());
        if (existente != null) {
            actualizarClientes(existente, cliente);
        } else {
            clientes.add(cliente);
        }
    }

    public void actualizarClientes(Clientes existente, Clientes nuevo) {
        existente.setTelefono(nuevo.getTelefono());
        existente.setEmail(nuevo.getEmail());
        existente.setNdecuenta(nuevo.getNdecuenta());
    }

    public void eliminarClientes(String nombre) {
        clientes.removeIf(cliente -> cliente.getNombre().equals(nombre));
    }

    public Clientes buscarClientes(String nombre) {
        for (Clientes cliente : clientes) {
            if (cliente.getNombre().equals(nombre)) {
                return cliente;
            }
        }
        return null;
    }

    public void mostrarAgendaClientes() {
        for (Clientes cliente : clientes) {
            System.out.println(cliente);
        }
    }

    public void guardarAgenda() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(clientes);
        } catch (IOException e) {
            System.out.println("Error guardando la agenda de clientes: " + e.getMessage());
        }
    }

    public void cargarAgenda() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            @SuppressWarnings("unchecked")
            ArrayList<Clientes> loadedClientes = (ArrayList<Clientes>) ois.readObject();
            clientes.addAll(loadedClientes);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error cargando la agenda de clientes: " + e.getMessage());
        }
    }
}
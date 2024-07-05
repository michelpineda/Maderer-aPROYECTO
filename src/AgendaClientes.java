import java.util.ArrayList;

public class AgendaClientes {
    private ArrayList<Clientes> clientes;

//constructor
    public AgendaClientes() {
        this.clientes = new ArrayList<>();
    }

//métodos
    public void agregarClientes(Clientes cliente) {
        Clientes existente = buscarClientes(cliente.getNombre());
        if (existente != null){
            actualizarClientes(existente, cliente);
        }else{
            clientes.add(cliente);
        }
    }

    public void actualizarClientes(Clientes existente, Clientes nuevo) {
    String nuevoTelefono = existente.getTelefono();
    existente.setTelefono(nuevoTelefono);
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
}

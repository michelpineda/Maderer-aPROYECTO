// Inventario.java
import java.io.*;
import java.util.ArrayList;

public final class Inventario {
    private final ArrayList<Producto> productos;
    private final String archivo;

    public Inventario(String archivo) {
        this.productos = new ArrayList<>();
        this.archivo = archivo;
        cargarInventario();
    }

    public void agregarProducto(Producto producto) {
        Producto existente = buscarProducto(producto.getNombre());
        if (existente != null) {
            actualizarProducto(existente, producto);
        } else {
            productos.add(producto);
        }
    }

    public void actualizarProducto(Producto existente, Producto nuevo) {
        existente.setCantidad(nuevo.getCantidad());
        existente.setPrecio(nuevo.getPrecio());
    }

    public void eliminarProducto(String nombre) {
        productos.removeIf(producto -> producto.getNombre().equals(nombre));
    }

    public Producto buscarProducto(String nombre) {
        for (Producto producto : productos) {
            if (producto.getNombre().equals(nombre)) {
                return producto;
            }
        }
        return null;
    }

    public void mostrarInventario() {
        for (Producto producto : productos) {
            System.out.println(producto);
        }
    }

    public void guardarInventario() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(productos);
        } catch (IOException e) {
            System.out.println("Error guardando el inventario: " + e.getMessage());
        }
    }

    public void cargarInventario() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            @SuppressWarnings("unchecked")
            ArrayList<Producto> loadedProductos = (ArrayList<Producto>) ois.readObject();
            productos.addAll(loadedProductos);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error cargando el inventario: " + e.getMessage());
        }
    }
}
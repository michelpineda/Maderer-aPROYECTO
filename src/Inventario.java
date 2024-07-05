import java.util.ArrayList;

public class Inventario {
    private ArrayList<Producto> productos;

//constructor
    public Inventario() {
        this.productos = new ArrayList<>();
    }

//métodos
    public void agregarProducto(Producto producto) {
        Producto existente = buscarProducto(producto.getNombre());
        if (existente != null){
            actualizarProducto(existente, producto);
        }else{
            productos.add(producto);
        }
    }
    
    public void actualizarProducto(Producto existente, Producto nuevo) {
    int nuevaCantidad = existente.getCantidad() + nuevo.getCantidad();
    double nuevoPrecio = ((existente.getPrecio() * existente.getCantidad()) + (nuevo.getPrecio() * nuevo.getCantidad())) / nuevaCantidad;
    existente.setCantidad(nuevaCantidad);
    existente.setPrecio(nuevoPrecio);
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
}

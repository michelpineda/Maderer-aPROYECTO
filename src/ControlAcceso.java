// ControlAcceso.java
import java.io.*;
import java.util.ArrayList;

public final class ControlAcceso {
    private final ArrayList<Usuario> usuarios;
    private final String archivo;

    public ControlAcceso(String archivo) {
        this.usuarios = new ArrayList<>();
        this.archivo = archivo;
        cargarUsuarios();
    }

    public void agregarUsuario(Usuario usuario) {
        Usuario existente = buscarUsuario(usuario.getNombreUsuario());
        if (existente != null) {
            actualizarUsuario(existente, usuario);
        } else {
            usuarios.add(usuario);
        }
    }

    public void actualizarUsuario(Usuario existente, Usuario nuevo) {
        existente.setContrasena(nuevo.getContrasena());
    }

    public boolean autenticarUsuario(String nombreUsuario, String contraseña) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNombreUsuario().equals(nombreUsuario) && usuario.getContrasena().equals(contraseña)) {
                return true;
            }
        }
        return false;
    }

    public Usuario buscarUsuario(String nombreUsuario) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNombreUsuario().equals(nombreUsuario)) {
                return usuario;
            }
        }
        return null;
    }

    public void guardarUsuarios() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(usuarios);
        } catch (IOException e) {
            System.out.println("Error guardando los usuarios: " + e.getMessage());
        }
    }

    public void cargarUsuarios() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            @SuppressWarnings("unchecked")
            ArrayList<Usuario> loadedUsuarios = (ArrayList<Usuario>) ois.readObject();
            usuarios.addAll(loadedUsuarios);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error cargando los usuarios: " + e.getMessage());
        }
    }
}
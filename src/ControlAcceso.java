import java.io.*;
import java.util.ArrayList;

public class ControlAcceso {
    final ArrayList<Usuario> usuarios;
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
        existente.setContraseña(nuevo.getContraseña());
    }

    public boolean autenticarUsuario(String nombreUsuario, String contraseña) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNombreUsuario().equals(nombreUsuario) && usuario.getContraseña().equals(contraseña)) {
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
        File file = new File(archivo);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Error creando el archivo de usuarios: " + e.getMessage());
            }
        }

        if (file.length() == 0) {
            return; // Archivo vacío, no cargar nada
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            ArrayList<Usuario> loadedUsuarios = (ArrayList<Usuario>) ois.readObject();
            usuarios.addAll(loadedUsuarios);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error cargando los usuarios: " + e.getMessage());
        }
    }
}
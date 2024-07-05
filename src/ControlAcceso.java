//Para control de acceso
import java.util.HashMap;
import java.util.Map;

public class ControlAcceso {
    private Map<String, Usuario> usuarios;

    public ControlAcceso() {
        usuarios = new HashMap<>();
        
        // Añadir usuarios predeterminados
        usuarios.put("admin", new Usuario("admin", "admin123"));
        usuarios.put("usuario", new Usuario("usuario", "usuario123"));
    }

    public boolean autenticarUsuario(String nombreUsuario, String contraseña) {
        Usuario usuario = usuarios.get(nombreUsuario);
        if (usuario != null) {
            return usuario.autenticar(contraseña);
        }
        return false;
    }

    public boolean registrarUsuario(String nombreUsuario, String contraseña) {
        if (usuarios.containsKey(nombreUsuario)) {
            return false; // Usuario ya existe
        }
        usuarios.put(nombreUsuario, new Usuario(nombreUsuario, contraseña));
        return true;
    }
}
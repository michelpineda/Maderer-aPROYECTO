import java.io.Serializable;

public class Usuario implements Serializable {
    private final String nombreUsuario;
    private final String contraseña;

    public Usuario(String nombreUsuario, String contraseña) {
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContrasena() {
        return contraseña;
    }

    public boolean autenticar(String contraseña) {
        return this.contraseña.equals(contraseña);
    }

    public void setContrasena(String contrasena) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setContrasena'");
    }
}

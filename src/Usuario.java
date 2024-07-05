import java.io.Serializable;

public class Usuario implements Serializable {
    private final String nombreUsuario;
    private final String contraseña;
    @SuppressWarnings("no usado")
    private  String contraseña2;

    public Usuario(String nombreUsuario, String contraseña, String contraseña2) {
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.contraseña2 = contraseña2;
    }
  
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public boolean autenticar(String contraseña) {
        return this.contraseña.equals(contraseña);
    }

    public void setContraseña(String contraseña2) {
    this.contraseña2 = contraseña2;
    }

}

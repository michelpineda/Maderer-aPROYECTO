public class Usuario {
    private String nombreUsuario;
    private String contraseña;

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
}

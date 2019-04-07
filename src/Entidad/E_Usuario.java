
package Entidad;

/**
 *
 * @author jescalaya
 */
public class E_Usuario {
    
    private int idUsuario;
    private String usua_usuario;
    private String usua_password;
    
    public E_Usuario() {
    }

    public E_Usuario(int idUsuario, String usua_usuario, String usua_password) {
        this.idUsuario = idUsuario;
        this.usua_usuario = usua_usuario;
        this.usua_password = usua_password;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsua_usuario() {
        return usua_usuario;
    }

    public void setUsua_usuario(String usua_usuario) {
        this.usua_usuario = usua_usuario;
    }

    public String getUsua_password() {
        return usua_password;
    }

    public void setUsua_password(String usua_password) {
        this.usua_password = usua_password;
    }


  
}

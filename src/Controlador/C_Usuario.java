package Controlador;

import BaseDeDatos.D_Usuario;
import Entidad.E_Usuario;

/**
 *
 * @author jescalaya
 */
public class C_Usuario {

   /* D_Usuario datos;
    E_Usuario entidad;

    public String encriptarPass(String password, boolean tipo) //"password", "tipo" = Si esta encriptando o desencriptando
    {
        String encriptado = "";

        String[] AEncritadoBase = {"ͷ", "ͷ", "ͷ", "ͷ", "ͷ", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "x", "y", "z", " ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "%", ".", "+", "-", "}", "_", "@", "##"};
        if (tipo) {
            for (int i = 0; i < password.length(); i++) {
                for (int j = 0; j < AEncritadoBase.length; j++) {
                    if
                    if (password[.toString().Equals(AEncritadoBase[j].toString())) {
                        encriptado = encriptado + AEncritadoBase[j + 5];
                    }
                }
            }
        } else {
            for (int i = 0; i < password.length(); i++) {
                for (int j = 0; j < AEncritadoBase.Length; j++) {
                    if (password[i].ToString().Equals(AEncritadoBase[j].ToString())) {
                        encriptado = encriptado + AEncritadoBase[j - 5].ToString();
                    }
                }
            }
        }

        return encriptado;
    }

    public String loguear(String nomUsuario, String password) {
        datos = new D_Usuario();
        return datos.login(nomUsuario, password);
    }

    public String insertar(String nomUsuario, String password, String privilegio) {
        String mensaje = "";
        try {
            datos = new D_Usuario();
            entidad = new E_Usuario();
            entidad.Usua_Descr = nomUsuario;
            entidad.Usua_Passw = encriptarPass(password, true);
            entidad.Usua_Privi = privilegio;
            mensaje = datos.insert(entidad);
            if (mensaje == string.Empty) {
                mensaje = "Registro Guardado!";
            }
        } catch (Exception e) {
            mensaje = e.Message;
        }
        return mensaje;
    }

    public String actualizar(String nomUsuario, String password, int idUsuario, String privilegio) {
        String mensaje = String.Empty;
        try {
            datos = new D_Usuario();
            entidad = new E_Usuario();
            entidad.Usua_Descr = nomUsuario;
            entidad.Usua_Passw = encriptarPass(password, true);
            entidad.IdUsuario = idUsuario;
            entidad.Usua_Privi = privilegio;
            mensaje = datos.update(entidad);
            if (mensaje == string.Empty) {
                mensaje = "Edición Guardada!";
            }
        } catch (Exception e) {
            mensaje = e.Message;
        }
        return mensaje;
    }*/

}

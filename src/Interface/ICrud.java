/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.util.List;

/**
 *
 * @author jescalaya
 */
public interface ICrud<Clase> {
    
    public String insertar(Clase c);
    public String actualizar(Clase c);
    public String darBaja (Object key);
    public List<Clase> listarRegistros();
    public List<Clase> listarBusquedaRegistro();
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

/**
 *
 * @author jescalaya
 */
public class E_Estado {

    private int idEstado;
    private String esta_Descr;

    public E_Estado(int idEstado, String esta_Descr) {
        this.idEstado = idEstado;
        this.esta_Descr = esta_Descr;
    }

    public E_Estado() {
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getEsta_Descr() {
        return esta_Descr;
    }

    public void setEsta_Descr(String esta_Descr) {
        this.esta_Descr = esta_Descr;
    }

}

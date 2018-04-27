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
public class E_Cultivo {
    private int idCultivo;
    private E_Estado idEstado;
    private String cult_Descr;

    public E_Cultivo() {
    }

    public E_Cultivo(int idCultivo, E_Estado idEstado, String cult_Descr) {
        this.idCultivo = idCultivo;
        this.idEstado = idEstado;
        this.cult_Descr = cult_Descr;
    }

    public int getIdCultivo() {
        return idCultivo;
    }

    public void setIdCultivo(int idCultivo) {
        this.idCultivo = idCultivo;
    }

    public E_Estado getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(E_Estado idEstado) {
        this.idEstado = idEstado;
    }

    public String getCult_Descr() {
        return cult_Descr;
    }

    public void setCult_Descr(String cult_Descr) {
        this.cult_Descr = cult_Descr;
    }
    
    
}

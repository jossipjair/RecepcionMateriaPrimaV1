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
public class E_RecepcionPalta {
       private int idRecepcionPalta;
    private E_Lote lote;
    private E_Estado estado;
    private String rPalta_FechRegistro;
    private String rPalta_Guia_Remis;
    private String rPalta_Viaje;
    private String rPalta_Obser;

    public E_RecepcionPalta() {
    }

    public E_RecepcionPalta(int idRecepcionPalta, E_Lote lote, E_Estado estado, String rPalta_FechRegistro, String rPalta_Guia_Remis, String rPalta_Viaje, String rPalta_Obser) {
        this.idRecepcionPalta = idRecepcionPalta;
        this.lote = lote;
        this.estado = estado;
        this.rPalta_FechRegistro = rPalta_FechRegistro;
        this.rPalta_Guia_Remis = rPalta_Guia_Remis;
        this.rPalta_Viaje = rPalta_Viaje;
        this.rPalta_Obser = rPalta_Obser;
    }

    public int getIdRecepcionPalta() {
        return idRecepcionPalta;
    }

    public void setIdRecepcionPalta(int idRecepcionPalta) {
        this.idRecepcionPalta = idRecepcionPalta;
    }

    public E_Lote getLote() {
        return lote;
    }

    public void setLote(E_Lote lote) {
        this.lote = lote;
    }

    public E_Estado getEstado() {
        return estado;
    }

    public void setEstado(E_Estado estado) {
        this.estado = estado;
    }

    public String getrPalta_FechRegistro() {
        return rPalta_FechRegistro;
    }

    public void setrPalta_FechRegistro(String rPalta_FechRegistro) {
        this.rPalta_FechRegistro = rPalta_FechRegistro;
    }

    public String getrPalta_Guia_Remis() {
        return rPalta_Guia_Remis;
    }

    public void setrPalta_Guia_Remis(String rPalta_Guia_Remis) {
        this.rPalta_Guia_Remis = rPalta_Guia_Remis;
    }

    public String getrPalta_Viaje() {
        return rPalta_Viaje;
    }

    public void setrPalta_Viaje(String rPalta_Viaje) {
        this.rPalta_Viaje = rPalta_Viaje;
    }

    public String getrPalta_Obser() {
        return rPalta_Obser;
    }

    public void setrPalta_Obser(String rPalta_Obser) {
        this.rPalta_Obser = rPalta_Obser;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

import java.util.Date;

/**
 *
 * @author jescalaya
 */
public class E_RecepcionFruta {
    
    private int idRecepcion;
    private E_Lote idLote;
    private E_Estado idEstado;
    private Date rFrut_FechRegistro;
    private String rFrut_Guia_Remis;
    private String rFrut_Viaje;
    private String rFrut_Obser;

    public E_RecepcionFruta() {
    }

    public E_RecepcionFruta(int idRecepcion, E_Lote idLote, E_Estado idEstado, Date rFrut_FechRegistro, String rFrut_Guia_Remis, String rFrut_Viaje, String rFrut_Obser) {
        this.idRecepcion = idRecepcion;
        this.idLote = idLote;
        this.idEstado = idEstado;
        this.rFrut_FechRegistro = rFrut_FechRegistro;
        this.rFrut_Guia_Remis = rFrut_Guia_Remis;
        this.rFrut_Viaje = rFrut_Viaje;
        this.rFrut_Obser = rFrut_Obser;
    }

    public int getIdRecepcion() {
        return idRecepcion;
    }

    public void setIdRecepcion(int idRecepcion) {
        this.idRecepcion = idRecepcion;
    }

    public E_Lote getIdLote() {
        return idLote;
    }

    public void setIdLote(E_Lote idLote) {
        this.idLote = idLote;
    }

    public E_Estado getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(E_Estado idEstado) {
        this.idEstado = idEstado;
    }

    public Date getrFrut_Fech_Pesa() {
        return rFrut_FechRegistro;
    }

    public void setrFrut_Fech_Pesa(Date rFrut_FechRegistro) {
        this.rFrut_FechRegistro = rFrut_FechRegistro;
    }

    public String getrFrut_Guia_Remis() {
        return rFrut_Guia_Remis;
    }

    public void setrFrut_Guia_Remis(String rFrut_Guia_Remis) {
        this.rFrut_Guia_Remis = rFrut_Guia_Remis;
    }

    public String getrFrut_Viaje() {
        return rFrut_Viaje;
    }

    public void setrFrut_Viaje(String rFrut_Viaje) {
        this.rFrut_Viaje = rFrut_Viaje;
    }

    public String getrFrut_Obser() {
        return rFrut_Obser;
    }

    public void setrFrut_Obser(String rFrut_Obser) {
        this.rFrut_Obser = rFrut_Obser;
    }
    
    
    
}

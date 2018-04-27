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
public class E_DetalleRecepcionFruta {

    private int idDetalleRecepcion;
    private E_RecepcionFruta idRecepcion;
    private String dRec_CoBar;
    private Date dRec_Fech_Pesa;    
    private Date dRec_Fech_Proc;
    private Double dRec_Tara;
    private Double dRec_Peso_Bruto;
    private int dRec_Canti;
    private Double dRec_Peso;
    private Double dRec_PTota;
    private Double dRec_PNeto;
    private byte dRec_esReproceso;

    public E_DetalleRecepcionFruta() {
    }

    public E_DetalleRecepcionFruta(int idDetalleRecepcion, E_RecepcionFruta idRecepcion, String dRec_CoBar, Date dRec_Fech_Pesa, Date dRec_Fech_Proc, Double dRec_Tara, Double dRec_Peso_Bruto, int dRec_Canti, Double dRec_Peso, Double dRec_PTota, Double dRec_PNeto, byte dRec_esReproceso) {
        this.idDetalleRecepcion = idDetalleRecepcion;
        this.idRecepcion = idRecepcion;
        this.dRec_CoBar = dRec_CoBar;
        this.dRec_Fech_Pesa = dRec_Fech_Pesa;
        this.dRec_Fech_Proc = dRec_Fech_Proc;
        this.dRec_Tara = dRec_Tara;
        this.dRec_Peso_Bruto = dRec_Peso_Bruto;
        this.dRec_Canti = dRec_Canti;
        this.dRec_Peso = dRec_Peso;
        this.dRec_PTota = dRec_PTota;
        this.dRec_PNeto = dRec_PNeto;
        this.dRec_esReproceso = dRec_esReproceso;
    }

    public int getIdDetalleRecepcion() {
        return idDetalleRecepcion;
    }

    public void setIdDetalleRecepcion(int idDetalleRecepcion) {
        this.idDetalleRecepcion = idDetalleRecepcion;
    }

    public E_RecepcionFruta getIdRecepcion() {
        return idRecepcion;
    }

    public void setIdRecepcion(E_RecepcionFruta idRecepcion) {
        this.idRecepcion = idRecepcion;
    }

    public String getdRec_CoBar() {
        return dRec_CoBar;
    }

    public void setdRec_CoBar(String dRec_CoBar) {
        this.dRec_CoBar = dRec_CoBar;
    }

    public Date getdRec_Fech_Pesa() {
        return dRec_Fech_Pesa;
    }

    public void setdRec_Fech_Pesa(Date dRec_Fech_Pesa) {
        this.dRec_Fech_Pesa = dRec_Fech_Pesa;
    }

    public Date getdRec_Fech_Proc() {
        return dRec_Fech_Proc;
    }

    public void setdRec_Fech_Proc(Date dRec_Fech_Proc) {
        this.dRec_Fech_Proc = dRec_Fech_Proc;
    }

    public Double getdRec_Tara() {
        return dRec_Tara;
    }

    public void setdRec_Tara(Double dRec_Tara) {
        this.dRec_Tara = dRec_Tara;
    }

    public Double getdRec_Peso_Bruto() {
        return dRec_Peso_Bruto;
    }

    public void setdRec_Peso_Bruto(Double dRec_Peso_Bruto) {
        this.dRec_Peso_Bruto = dRec_Peso_Bruto;
    }

    public int getdRec_Canti() {
        return dRec_Canti;
    }

    public void setdRec_Canti(int dRec_Canti) {
        this.dRec_Canti = dRec_Canti;
    }

    public Double getdRec_Peso() {
        return dRec_Peso;
    }

    public void setdRec_Peso(Double dRec_Peso) {
        this.dRec_Peso = dRec_Peso;
    }

    public Double getdRec_PTota() {
        return dRec_PTota;
    }

    public void setdRec_PTota(Double dRec_PTota) {
        this.dRec_PTota = dRec_PTota;
    }

    public Double getdRec_PNeto() {
        return dRec_PNeto;
    }

    public void setdRec_PNeto(Double dRec_PNeto) {
        this.dRec_PNeto = dRec_PNeto;
    }

    public byte getdRec_esReproceso() {
        return dRec_esReproceso;
    }

    public void setdRec_esReproceso(byte dRec_esReproceso) {
        this.dRec_esReproceso = dRec_esReproceso;
    }

    
    
}

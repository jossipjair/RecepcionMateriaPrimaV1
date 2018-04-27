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
public class E_Lote {
    private int idLote;
    private E_Estado idEstado;
    private E_Sucursal idSucursal;
    private E_Variedad idVariedad;
    private String lote_Descr;
    private String lote_NCort;

    public E_Lote() {
    }

    public E_Lote(int idLote, E_Estado idEstado, E_Sucursal idSucursal, E_Variedad idVariedad, String lote_Descr, String lote_NCort) {
        this.idLote = idLote;
        this.idEstado = idEstado;
        this.idSucursal = idSucursal;
        this.idVariedad = idVariedad;
        this.lote_Descr = lote_Descr;
        this.lote_NCort = lote_NCort;
    }

    public int getIdLote() {
        return idLote;
    }

    public void setIdLote(int idLote) {
        this.idLote = idLote;
    }

    public E_Estado getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(E_Estado idEstado) {
        this.idEstado = idEstado;
    }

    public E_Sucursal getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(E_Sucursal idSucursal) {
        this.idSucursal = idSucursal;
    }

    public E_Variedad getIdVariedad() {
        return idVariedad;
    }

    public void setIdVariedad(E_Variedad idVariedad) {
        this.idVariedad = idVariedad;
    }

    public String getLote_Descr() {
        return lote_Descr;
    }

    public void setLote_Descr(String lote_Descr) {
        this.lote_Descr = lote_Descr;
    }

    public String getLote_NCort() {
        return lote_NCort;
    }

    public void setLote_NCort(String lote_NCort) {
        this.lote_NCort = lote_NCort;
    }
    
    
}

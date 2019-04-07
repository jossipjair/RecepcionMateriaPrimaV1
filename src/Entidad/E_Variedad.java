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
public class E_Variedad {
    private int idVariedad;
    private E_Cultivo idCultivo;
    private E_Estado idEstado;
    private String vari_Descr;

    public E_Variedad() {
    }

    public E_Variedad(int idVariedad, E_Cultivo idCultivo, E_Estado idEstado, String vari_Descr) {
        this.idVariedad = idVariedad;
        this.idCultivo = idCultivo;
        this.idEstado = idEstado;
        this.vari_Descr = vari_Descr;
    }

    public int getIdVariedad() {
        return idVariedad;
    }

    public void setIdVariedad(int idVariedad) {
        this.idVariedad = idVariedad;
    }

    public E_Cultivo getIdCultivo() {
        return idCultivo;
    }

    public void setIdCultivo(E_Cultivo idCultivo) {
        this.idCultivo = idCultivo;
    }

    public E_Estado getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(E_Estado idEstado) {
        this.idEstado = idEstado;
    }

    public String getVari_Descr() {
        return vari_Descr;
    }

    public void setVari_Descr(String vari_Descr) {
        this.vari_Descr = vari_Descr;
    }
    @Override
    public String toString(){
        return getVari_Descr();
    }
    
}

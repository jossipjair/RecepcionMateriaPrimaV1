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
public class E_Sucursal {
    private int idSucursal;
    private E_Estado idEstado;
    private E_Empresa idEmpresa;
    private String sucu_Descr;

    public E_Sucursal() {
    }

    public E_Sucursal(int idSucursal, E_Estado idEstado, E_Empresa idEmpresa, String sucu_Descr) {
        this.idSucursal = idSucursal;
        this.idEstado = idEstado;
        this.idEmpresa = idEmpresa;
        this.sucu_Descr = sucu_Descr;
    }

    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    public E_Estado getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(E_Estado idEstado) {
        this.idEstado = idEstado;
    }

    public E_Empresa getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(E_Empresa idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getSucu_Descr() {
        return sucu_Descr;
    }

    public void setSucu_Descr(String sucu_Descr) {
        this.sucu_Descr = sucu_Descr;
    }
    
    
}

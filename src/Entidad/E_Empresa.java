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
public class E_Empresa {
    private int idEmpresa;
    private E_Estado idEstado;
    private String empr_Descr;

    public E_Empresa(int idEmpresa, E_Estado idEstado, String empr_Descr) {
        this.idEmpresa = idEmpresa;
        this.idEstado = idEstado;
        this.empr_Descr = empr_Descr;
    }

    public E_Empresa() {
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public E_Estado getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(E_Estado idEstado) {
        this.idEstado = idEstado;
    }

    public String getEmpr_Descr() {
        return empr_Descr;
    }

    public void setEmpr_Descr(String empr_Descr) {
        this.empr_Descr = empr_Descr;
    }
    
    
}

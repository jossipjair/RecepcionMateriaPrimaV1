
package Entidad;


/**
 *
 * @author jescalaya
 */
public class E_DetalleRecepcionPalta {

    private int idDetalleRecepcionPalta;
    private E_RecepcionPalta recepcionPalta;
    private E_Estado estado;
    private String dRPalta_CoBar;
    private String dRPalta_Fech_Pesa;
    private String dRPalta_Fech_Proc;
    private Double dRPalta_Tara;
    private Double dRPalta_Peso_Bruto;
    private int dRPalta_Canti;
    private Double dRPalta_Peso;
    private Double dRPalta_PTota;
    private Double dRPalta_PNeto;
    private byte dRPalta_esReproceso;
    private byte dRPalta_esProcesado;
    private String dRPalta_Observacion;

    public E_DetalleRecepcionPalta() {
    }

    public E_DetalleRecepcionPalta(int idDetalleRecepcionPalta, E_RecepcionPalta recepcionPalta, E_Estado estado, String dRPalta_CoBar, String dRPalta_Fech_Pesa, String dRPalta_Fech_Proc, Double dRPalta_Tara, Double dRPalta_Peso_Bruto, int dRPalta_Canti, Double dRPalta_Peso, Double dRPalta_PTota, Double dRPalta_PNeto, byte dRPalta_esReproceso, byte dRPalta_esProcesado, String dRPalta_Observacion) {
        this.idDetalleRecepcionPalta = idDetalleRecepcionPalta;
        this.recepcionPalta = recepcionPalta;
        this.estado = estado;
        this.dRPalta_CoBar = dRPalta_CoBar;
        this.dRPalta_Fech_Pesa = dRPalta_Fech_Pesa;
        this.dRPalta_Fech_Proc = dRPalta_Fech_Proc;
        this.dRPalta_Tara = dRPalta_Tara;
        this.dRPalta_Peso_Bruto = dRPalta_Peso_Bruto;
        this.dRPalta_Canti = dRPalta_Canti;
        this.dRPalta_Peso = dRPalta_Peso;
        this.dRPalta_PTota = dRPalta_PTota;
        this.dRPalta_PNeto = dRPalta_PNeto;
        this.dRPalta_esReproceso = dRPalta_esReproceso;
        this.dRPalta_esProcesado = dRPalta_esProcesado;
        this.dRPalta_Observacion = dRPalta_Observacion;
    }

    public int getIdDetalleRecepcionPalta() {
        return idDetalleRecepcionPalta;
    }

    public void setIdDetalleRecepcionPalta(int idDetalleRecepcionPalta) {
        this.idDetalleRecepcionPalta = idDetalleRecepcionPalta;
    }

    public E_RecepcionPalta getRecepcionPalta() {
        return recepcionPalta;
    }

    public void setRecepcionPalta(E_RecepcionPalta recepcionPalta) {
        this.recepcionPalta = recepcionPalta;
    }

    public E_Estado getEstado() {
        return estado;
    }

    public void setEstado(E_Estado estado) {
        this.estado = estado;
    }

    public String getdRPalta_CoBar() {
        return dRPalta_CoBar;
    }

    public void setdRPalta_CoBar(String dRPalta_CoBar) {
        this.dRPalta_CoBar = dRPalta_CoBar;
    }

    public String getdRPalta_Fech_Pesa() {
        return dRPalta_Fech_Pesa;
    }

    public void setdRPalta_Fech_Pesa(String dRPalta_Fech_Pesa) {
        this.dRPalta_Fech_Pesa = dRPalta_Fech_Pesa;
    }

    public String getdRPalta_Fech_Proc() {
        return dRPalta_Fech_Proc;
    }

    public void setdRPalta_Fech_Proc(String dRPalta_Fech_Proc) {
        this.dRPalta_Fech_Proc = dRPalta_Fech_Proc;
    }

    public Double getdRPalta_Tara() {
        return dRPalta_Tara;
    }

    public void setdRPalta_Tara(Double dRPalta_Tara) {
        this.dRPalta_Tara = dRPalta_Tara;
    }

    public Double getdRPalta_Peso_Bruto() {
        return dRPalta_Peso_Bruto;
    }

    public void setdRPalta_Peso_Bruto(Double dRPalta_Peso_Bruto) {
        this.dRPalta_Peso_Bruto = dRPalta_Peso_Bruto;
    }

    public int getdRPalta_Canti() {
        return dRPalta_Canti;
    }

    public void setdRPalta_Canti(int dRPalta_Canti) {
        this.dRPalta_Canti = dRPalta_Canti;
    }

    public Double getdRPalta_Peso() {
        return dRPalta_Peso;
    }

    public void setdRPalta_Peso(Double dRPalta_Peso) {
        this.dRPalta_Peso = dRPalta_Peso;
    }

    public Double getdRPalta_PTota() {
        return dRPalta_PTota;
    }

    public void setdRPalta_PTota(Double dRPalta_PTota) {
        this.dRPalta_PTota = dRPalta_PTota;
    }

    public Double getdRPalta_PNeto() {
        return dRPalta_PNeto;
    }

    public void setdRPalta_PNeto(Double dRPalta_PNeto) {
        this.dRPalta_PNeto = dRPalta_PNeto;
    }

    public byte getdRPalta_esReproceso() {
        return dRPalta_esReproceso;
    }

    public void setdRPalta_esReproceso(byte dRPalta_esReproceso) {
        this.dRPalta_esReproceso = dRPalta_esReproceso;
    }

    public byte getdRPalta_esProcesado() {
        return dRPalta_esProcesado;
    }

    public void setdRPalta_esProcesado(byte dRPalta_esProcesado) {
        this.dRPalta_esProcesado = dRPalta_esProcesado;
    }

    public String getdRPalta_Observacion() {
        return dRPalta_Observacion;
    }

    public void setdRPalta_Observacion(String dRPalta_Observacion) {
        this.dRPalta_Observacion = dRPalta_Observacion;
    }
    
    
    
    

    

    
}

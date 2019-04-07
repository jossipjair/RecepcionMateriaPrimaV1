package BaseDeDatos;

import Conexion.Conexion;
import Entidad.E_DetalleRecepcionPalta;
import Interface.ICrud;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jescalaya
 */
public class D_DetalleRecepcionPalta implements ICrud<E_DetalleRecepcionPalta> {

    private final String INSERTAR = "{call spInsertarDetalleRecepcionPalta(?,?,?,?,?,?,?,?,?,?,?)}";
    private final String ACTUALIZAR = "{call spActualizarDetalleRecepcionPalta(?,?,?,?,?,?,?,?,?,?,?,?)}";
    private final String DAR_BAJA = "{call spDarBajaDetalleRecepcionPalta(?)";
    private final String MOSTRAR = "SELECT  dr.idDetalleRecepcionPalta,dr.dRPalta_Fech_Pesa,dr.dRPalta_Peso_Bruto, dr.dRPalta_Tara, dr.dRPalta_Canti, dr.dRPalta_Peso, dr.dRPalta_PTota, dr.dRPalta_PNeto, dr.dRPalta_esReproceso, dr.dRPalta_esProcesado, dr.dRPalta_Observacion, dr.dRPalta_Fech_Proc, dr.dRPalta_CoBar FROM DETALLE_RECEPCION_PALTA AS dr WHERE dr.idEstado = 1 AND dr.idRecepcionPalta = ";
    private final String MOSTRAR_SP = "{call spMostrarDetalleRecepcionPalta(?)}";
    
    private PreparedStatement pstm;
    private CallableStatement cstm;
    private Statement stm;
    private ResultSet rs;
    private final Conexion INSTANCIA = Conexion.getInstancia();
    private String mensaje = "";
    
    @Override
    public String insertar(E_DetalleRecepcionPalta c) {
    
        try {
            cstm = INSTANCIA.getConexion().prepareCall(INSERTAR);
            cstm.setInt(1, c.getRecepcionPalta().getIdRecepcionPalta());
            cstm.setString(2, c.getdRPalta_CoBar());
            cstm.setString(3, c.getdRPalta_Fech_Pesa());
            cstm.setDouble(4, c.getdRPalta_Tara());
            cstm.setDouble(5, c.getdRPalta_Peso_Bruto());
            cstm.setDouble(6, c.getdRPalta_Canti());
            cstm.setDouble(7, c.getdRPalta_Peso());
            cstm.setDouble(8, c.getdRPalta_PTota());
            cstm.setDouble(9, c.getdRPalta_PNeto());
            cstm.setByte(10, c.getdRPalta_esReproceso());
            cstm.setString(11, c.getdRPalta_Observacion());
            if(cstm.executeUpdate() > 0){
                mensaje = "¡Registro Salvado!";
            }
        } catch (SQLException e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

    @Override
    public String actualizar(E_DetalleRecepcionPalta c) {
        try {
            cstm = INSTANCIA.getConexion().prepareCall(ACTUALIZAR);
            cstm.setInt(1, c.getRecepcionPalta().getIdRecepcionPalta());
            cstm.setString(2, c.getdRPalta_CoBar());
            cstm.setString(3, c.getdRPalta_Fech_Pesa());
            cstm.setDouble(4, c.getdRPalta_Tara());
            cstm.setDouble(5, c.getdRPalta_Peso_Bruto());
            cstm.setDouble(6, c.getdRPalta_Canti());
            cstm.setDouble(7, c.getdRPalta_Peso());
            cstm.setDouble(8, c.getdRPalta_PTota());
            cstm.setDouble(9, c.getdRPalta_PNeto());
            cstm.setByte(10, c.getdRPalta_esReproceso());
            cstm.setString(11, c.getdRPalta_Observacion());
            cstm.setInt(12, c.getIdDetalleRecepcionPalta());
            if(cstm.executeUpdate() > 0){
                mensaje = "¡Edición Salvada!";
            }
        } catch (SQLException e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

    @Override
    public String darBaja(E_DetalleRecepcionPalta c) {
        try {
            cstm = INSTANCIA.getConexion().prepareCall(DAR_BAJA);
            cstm.setInt(1, c.getIdDetalleRecepcionPalta());
            if(cstm.executeUpdate() > 0){
                mensaje = "Registro Eliminado";
            }
        } catch (SQLException e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

    @Override
    public List<E_DetalleRecepcionPalta> listarRegistros() {
        throw new UnsupportedOperationException("Not supported yet.");
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<E_DetalleRecepcionPalta> listarBusquedaRegistro(int buscar) {
        List<E_DetalleRecepcionPalta> lista = new ArrayList<>();
        try {
            cstm = INSTANCIA.getConexion().prepareCall(MOSTRAR_SP);
            cstm.setInt(1, buscar);
            rs = cstm.executeQuery();
            while(rs.next()){
                E_DetalleRecepcionPalta eDetalle = new E_DetalleRecepcionPalta();
                eDetalle.setIdDetalleRecepcionPalta(rs.getInt(1));
                eDetalle.setdRPalta_Fech_Pesa(rs.getString(2));
                eDetalle.setdRPalta_Peso_Bruto(rs.getDouble(3));
                eDetalle.setdRPalta_Tara(rs.getDouble(4));
                eDetalle.setdRPalta_Canti(rs.getInt(5));
                eDetalle.setdRPalta_Peso(rs.getDouble(6));
                eDetalle.setdRPalta_PTota(rs.getDouble(7));
                eDetalle.setdRPalta_PNeto(rs.getDouble(8));
                eDetalle.setdRPalta_esReproceso(rs.getByte(9));
                eDetalle.setdRPalta_esProcesado(rs.getByte(10));
                eDetalle.setdRPalta_Observacion(rs.getString(11));
                eDetalle.setdRPalta_Fech_Proc(rs.getString(12));
                eDetalle.setdRPalta_CoBar(rs.getString(13));
                lista.add(eDetalle);
            }
            
        } catch (SQLException e) {
        }
        return lista;
    }

    @Override
    public List<Object[]> listarRegitrosObject() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

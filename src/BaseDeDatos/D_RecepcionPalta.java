package BaseDeDatos;

import Conexion.Conexion;
import Entidad.E_RecepcionPalta;
import Interface.ICrud;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author jescalaya
 */
public class D_RecepcionPalta implements ICrud<E_RecepcionPalta> {

    private final String INSERTAR = "{call spInsertarRecepcionPalta(?, ?, ?, ?, ?)}";
    private final String ACTUALIZAR = "{call spActualizarRecepcionPalta(?, ?, ?, ?, ?, ?)}";
    private final String DAR_BAJA = "";
    private final String MOSTRAR = "SELECT rp.idRecepcionPalta, lot.lote_NCort, vari.vari_Descr, rp.rPalta_FechRegistro, rp.rPalta_Guia_Remis, rp.rPalta_Viaje, rp.rPalta_Obser FROM RECEPCION_PALTA AS rp INNER JOIN LOTE AS lot ON rp.idLote = lot.idLote INNER JOIN VARIEDAD AS vari ON lot.idVariedad = vari.idVariedad";
    private final String MOSTRAR_SP = "{call spMostrarRecepcionPalta()}";
    private final Conexion INSTANCIA = Conexion.getInstancia();
    private PreparedStatement pstm;
    private CallableStatement cstm;
    private Statement stm;
    private ResultSet rs;
    private String mensaje = "";

    @Override
    public String insertar(E_RecepcionPalta c) {
        try {
            cstm = INSTANCIA.getConexion().prepareCall(INSERTAR);
            cstm.setInt(1, c.getLote().getIdLote());
            String fechaFormato = c.getrPalta_FechRegistro();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date fechaTemporal = null;
            try {

                fechaTemporal = sdf.parse(fechaFormato);
            } catch (ParseException ex) {
                Logger.getLogger(D_RecepcionPalta.class.getName()).log(Level.SEVERE, null, ex);
            }
            SimpleDateFormat salidaformato = new SimpleDateFormat("dd-MM-yyyy");
            cstm.setString(2, salidaformato.format(fechaTemporal));
            cstm.setString(3, c.getrPalta_Guia_Remis());
            cstm.setString(4, c.getrPalta_Viaje());
            cstm.setString(5, c.getrPalta_Obser());
            if (cstm.executeUpdate() > 0) {
                mensaje = "¡Registro salvado!";
            }
        } catch (SQLException e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

    @Override
    public String actualizar(E_RecepcionPalta c) {
        try {
            cstm = INSTANCIA.getConexion().prepareCall(ACTUALIZAR);
            cstm.setInt(1, c.getLote().getIdLote());
            //GUARDAR FORMATO FECHA
            String fechaFormato = c.getrPalta_FechRegistro();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date fechaTemporal = null;
            try {
                fechaTemporal = sdf.parse(fechaFormato);
            } catch (ParseException ex) {
                Logger.getLogger(D_RecepcionPalta.class.getName()).log(Level.SEVERE, null, ex);
            }
            SimpleDateFormat salidaformato = new SimpleDateFormat("dd-MM-yyyy");

            cstm.setString(2, salidaformato.format(fechaTemporal));
            //FIN DE FORMATO FECHA
            cstm.setString(3, c.getrPalta_Guia_Remis());
            cstm.setString(4, c.getrPalta_Viaje());
            cstm.setString(5, c.getrPalta_Obser());
            cstm.setInt(6, c.getIdRecepcionPalta());

            if (cstm.executeUpdate() > 0) {
                mensaje = "¡Edición salvada!";
            }

        } catch (Exception e) {
            mensaje = "Error\n" + e.getMessage();
        }
        return mensaje;
    }

    @Override
    public String darBaja(E_RecepcionPalta c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<E_RecepcionPalta> listarRegistros() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<E_RecepcionPalta> listarBusquedaRegistro(int buscar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object[]> listarRegitrosObject() {
        List<Object[]> lista = new ArrayList<>();
        try {
            cstm = INSTANCIA.getConexion().prepareCall(MOSTRAR_SP);
            rs = cstm.executeQuery();
            while (rs.next()) {
                Object variable[] = new Object[7];
                variable[0] = rs.getInt(1);
                variable[1] = rs.getString(2);
                variable[2] = rs.getString(3);
                variable[3] = rs.getString(4);
                variable[4] = rs.getString(5);
                variable[5] = rs.getString(6);
                variable[6] = rs.getString(7);

                lista.add(variable);

            }
        } catch (SQLException e) {
        }
        return lista;
    }

}

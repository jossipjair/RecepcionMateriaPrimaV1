package BaseDeDatos;

import Entidad.E_RecepcionFruta;
import Interface.ICrud;
import Conexion.Conexion;
import Entidad.E_Lote;
import java.sql.Connection;
import java.sql.Date;
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
public class D_RecepcionFruta implements ICrud<E_RecepcionFruta> {

    //private final String INSERTAR = "INSERT INTO RECEPCION_FRUTA (idLote, idEstado,rFrut_Fech_Pesa, rFrut_Fech_Proc, rFrut_Guia_Remis, rFrut_Viaje, rFrut_Tara, rFrut_Peso_Bruto,"
     //       + " rFrut_Canti, rFrut_Peso, rFrut_PTota, rFrut_PNeto, rFrut_Obser, rFrut_esReproceso, rFrut_esProcesado) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private final String ACTUALIZAR = "UPDATE RECEPCION_FRUTA SET idLote = ?, rFrut_CodBar = ?, rFrut_Fech_Pesa = ?,  rFrut_Guia_Remis = ?, rFrut_Viaje = ?, rFrut_Tara = ?, rFrut_Peso_Bruto = ?,  rFrut_Canti = ?, rFrut_Peso = ?,rFrut_PTota = ?,rFrut_PNeto = ?, rFrut_Obser = ?, rFrut_esReproceso = ?, rFrut_esProcesado = ?";
    private final String MOSTRAR = "SELECT rf.idRecepcion, lo.lote_NCort, rf.rFrut_Fech_Pesa, rf.rFrut_Fech_Proc, rf.rFrut_Guia_Remis, rf.rFrut_Viaje, rf.rFrut_Peso_Bruto, rf.rFrut_Canti, rf.rFrut_Tara, rf.rFrut_Peso, rf.rFrut_PTota, rf.rFrut_PNeto\n" +
                                    "FROM RECEPCION_FRUTA AS rf \n" +
                                    "INNER JOIN LOTE AS lo ON rf.idLote = lo.idLote \n" +
                                    "INNER JOIN ESTADO AS es ON rf.idEstado = es.idEstado";

    private Conexion instancia = Conexion.getInstancia();

    private PreparedStatement pstm;
    private Statement stm;
    private ResultSet rs;
    private String mensaje = "";

    @Override
    public String insertar(E_RecepcionFruta c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String actualizar(E_RecepcionFruta c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String darBaja(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<E_RecepcionFruta> listarRegistros() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<E_RecepcionFruta> listarBusquedaRegistro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



}

package BaseDeDatos;

import Conexion.Conexion;
import Entidad.E_Empresa;
import Entidad.E_Estado;
import Entidad.E_Sucursal;
import Interface.ICrud;
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
public class D_Sucursal implements ICrud<E_Sucursal> {

    private final String INSERTAR = "INSERT INTO SUCURSAL (idEstado, idEmpresa, sucu_Descr) VALUES(?,?,?)";
    private final String ACTUALIZAR = "UPDATE SUCURSAL SET idEmpresa =?, sucu_Descr = ? WHERE idSucursal  = ?";
    private final String DAR_BAJA = "UPDATE SUCURSAL SET idEstado = ? WHERE idSucursal = ?";
    private final String MOSTRAR = "SELECT sucu.idSucursal , emp.empr_Descr, sucu.sucu_Descr, est.esta_Descr FROM SUCURSAL AS sucu INNER JOIN ESTADO AS est ON sucu.idEstado = est.idEstado INNER JOIN EMPRESA AS emp ON emp.idEmpresa = sucu.idEmpresa";

    private final Conexion INSTANCIA = Conexion.getInstancia();
    private PreparedStatement pstm;
    private Statement stm;
    private ResultSet rs;
    private String mensaje = "";

    @Override
    public String insertar(E_Sucursal c) {
        try {
            pstm = INSTANCIA.getConexion().prepareStatement(INSERTAR);
            pstm.setInt(1, c.getIdEstado().getIdEstado());
            pstm.setInt(2, c.getIdEmpresa().getIdEmpresa());
            pstm.setString(3, c.getSucu_Descr());
            if (pstm.executeUpdate() > 0) {
                mensaje = "¡Registro Salvado!";
            }
        } catch (SQLException e) {
            mensaje = "¡Error!\n" + e;
        } 
        return mensaje;
    }

    @Override
    public String actualizar(E_Sucursal c) {
        try {
            pstm = INSTANCIA.getConexion().prepareStatement(ACTUALIZAR);
            pstm.setInt(1, c.getIdEmpresa().getIdEmpresa());
            pstm.setString(2, c.getSucu_Descr());
            pstm.setInt(3, c.getIdSucursal());
            if (pstm.executeUpdate() > 0) {
                mensaje = "¡Edición Salvada!";
            }
        } catch (SQLException e) {
            mensaje = "¡Error!\n" + e;
        } 
        return mensaje;
    }

    @Override
    public String darBaja(E_Sucursal c) {
        try {
            pstm = INSTANCIA.getConexion().prepareStatement(DAR_BAJA);
            pstm.setInt(1, c.getIdEstado().getIdEstado());
            pstm.setInt(2, c.getIdSucursal());
            if (pstm.executeUpdate() > 0) {
                mensaje = "¡Registro inactivo!";
            }
        } catch (SQLException e) {
            mensaje = "¡Error!\n" + e;
        } 
        return mensaje;
    }

    @Override
    public List<E_Sucursal> listarRegistros() {
        List<E_Sucursal> lista = new ArrayList<>();
        try {
            stm = INSTANCIA.getConexion().createStatement();
            rs = stm.executeQuery(MOSTRAR);
            while (rs.next()) {
                E_Sucursal sucursal = new E_Sucursal();
                E_Empresa empresa = new E_Empresa();
                E_Estado estado = new E_Estado();
                sucursal.setIdSucursal(Integer.parseInt(rs.getString("idSucursal")));
                empresa.setEmpr_Descr(rs.getString("empr_Descr"));
                sucursal.setIdEmpresa(empresa);
                sucursal.setSucu_Descr(rs.getString("sucu_Descr"));
                estado.setEsta_Descr(rs.getString("esta_Descr"));
                sucursal.setIdEstado(estado);
                lista.add(sucursal);
            }
        } catch (SQLException e) {
        } 
        return lista;
    }

    @Override
    public List<E_Sucursal> listarBusquedaRegistro(int buscar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object[]> listarRegitrosObject() {
        List<Object[]> lista = new ArrayList<>();
        try {
            stm = INSTANCIA.getConexion().createStatement();
            rs = stm.executeQuery(MOSTRAR);
            while (rs.next()) {
                Object variable[] = new Object[4];
                variable[0] = rs.getString("idSucursal");
                variable[1] = rs.getString("empr_Descr");
                variable[2] = rs.getString("sucu_Descr");
                variable[3] = rs.getString("esta_Descr");
                lista.add(variable);
            }
        } catch (SQLException e) {
        } 
        return lista;
    }

}

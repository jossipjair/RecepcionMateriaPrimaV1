package BaseDeDatos;

import Conexion.Conexion;
import Entidad.E_Empresa;
import Entidad.E_Estado;
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
public class D_Empresa implements ICrud<E_Empresa> {
    
    private final String INSERTAR = "INSERT INTO EMPRESA (idEstado, empr_Descr) VALUES(?,?)";
    private final String ACTUALIZAR = "UPDATE EMPRESA SET empr_Descr =? WHERE idEmpresa = ?";
    private final String DAR_BAJA = "UPDATE EMPRESA SET idEstado = ? WHERE idEmpresa = ?";
    private final String MOSTRAR = "SELECT emp.idEmpresa, emp.empr_Descr, est.esta_Descr FROM EMPRESA AS emp INNER JOIN ESTADO AS est ON emp.idEstado = est.idEstado";
    
    private final Conexion INSTANCIA = Conexion.getInstancia();
    private PreparedStatement pstm;
    private Statement stm;
    private ResultSet rs;
    private String mensaje = "";
    
    @Override
    public String insertar(E_Empresa c) {
        try {
            pstm = INSTANCIA.getConexion().prepareStatement(INSERTAR);
            pstm.setInt(1, c.getIdEstado().getIdEstado());
            pstm.setString(2, c.getEmpr_Descr());
            if (pstm.executeUpdate() > 0) {
                mensaje = "¡Registro Salvado!";
            }
        } catch (SQLException e) {
            mensaje = "¡Error!\n" + e;
        } 
        return mensaje;
    }
    
    @Override
    public String actualizar(E_Empresa c) {
        try {
            pstm = INSTANCIA.getConexion().prepareStatement(ACTUALIZAR);
            pstm.setString(1, c.getEmpr_Descr());
            pstm.setInt(2, c.getIdEmpresa());
            if (pstm.executeUpdate() > 0) {
                mensaje = "¡Edición Salvada!";
            }
        } catch (SQLException e) {
            mensaje = "¡Error!\n" + e;
        } 
        return mensaje;
    }
    
    @Override
    public String darBaja(E_Empresa c) {
        try {
            pstm = INSTANCIA.getConexion().prepareStatement(DAR_BAJA);
            pstm.setInt(1, c.getIdEstado().getIdEstado());
            pstm.setInt(2, c.getIdEmpresa());
            if (pstm.executeUpdate() > 0) {
                mensaje = "¡Registro inactivo!";
            }
        } catch (SQLException e) {
            mensaje = "¡Error!\n" + e;
        } 
        return mensaje;
    }
    
    @Override
    public List<E_Empresa> listarRegistros() {
        List<E_Empresa> lista = new ArrayList<>();
        try {
            stm = INSTANCIA.getConexion().createStatement();
            rs = stm.executeQuery(MOSTRAR);
            while (rs.next()) {
                E_Empresa empresa = new E_Empresa();
                E_Estado estado = new E_Estado();
                empresa.setIdEmpresa(rs.getInt("idEmpresa"));
                empresa.setEmpr_Descr(rs.getString("empr_Descr"));
                estado.setEsta_Descr(rs.getString("esta_Descr"));
                empresa.setIdEstado(estado);
                lista.add(empresa);
            }
        } catch (SQLException e) {
        }
        return lista;
    }
    
    @Override
    public List<E_Empresa> listarBusquedaRegistro(int buscar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<Object[]> listarRegitrosObject() {
        List<Object[]> lista = new ArrayList<>();
        try {
            stm = INSTANCIA.getConexion().createStatement();
            rs = stm.executeQuery(MOSTRAR);
            while (rs.next()) {
                Object variable[] = new Object[3];
                variable[0] = rs.getString("idEmpresa");
                variable[1] = rs.getString("empr_Descr");
                variable[2] = rs.getString("esta_Descr");
                lista.add(variable);
            }
        } catch (SQLException e) {
        }
        return lista;
    }
    
}

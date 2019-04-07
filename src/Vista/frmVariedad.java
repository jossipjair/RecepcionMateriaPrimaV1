package Vista;

import Controlador.C_Controles;
import Controlador.C_Cultivo;
import Controlador.C_Variedad;
import Entidad.E_Cultivo;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jescalaya
 */
public class frmVariedad extends javax.swing.JInternalFrame {

    C_Variedad controlador = new C_Variedad();
    DefaultTableModel tabla;

    public frmVariedad() {
        initComponents();
        bloquearElementos(true);
        controlador.mostrarVariedad(tblGridDatos);
        llenarComboCultivo();
    }

    private void llenarModeloDatos() {
        tabla = (DefaultTableModel) this.tblGridDatos.getModel();
    }

    private void llenarComboCultivo() {
        C_Cultivo cultivo = new C_Cultivo();
        cultivo.llenarComboCultivo(cboCultivo);
    }

    //OPERACIONES
    private boolean operacion;

    private void limpiar() {
        // this.txtId.setText("");
        this.txtDescripcion.setText("");
        this.txtDescripcion.setFocusable(true);
        this.cboCultivo.setSelectedIndex(0);
    }

    private void bloquearElementos(boolean xx) {
        //BOTONES
        this.btnNuevo.setEnabled(xx);
        this.btnCancelar.setEnabled(!xx);
        this.btnCerrar.setEnabled(xx);
        this.btnEditar.setEnabled(xx);
        this.btnGuardar.setEnabled(!xx);

        //CAJA DE TEXTO
        this.txtId.setEnabled(false);
        this.txtDescripcion.setEnabled(!xx);
        this.tblGridDatos.setEnabled(xx);
        this.cboCultivo.setEnabled(!xx);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblGridDatos = new javax.swing.JTable();
        btnNuevo = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        lblEstadoRegistro = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cboCultivo = new javax.swing.JComboBox<>();
        btnEditar = new javax.swing.JButton();

        setTitle("MANTENIMIENTO - VARIEDAD");

        btnGuardar.setForeground(new java.awt.Color(0, 15, 131));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/GRABAR1 copia.png"))); // NOI18N
        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setForeground(new java.awt.Color(0, 15, 131));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/cancelar copia.png"))); // NOI18N
        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnCerrar.setForeground(new java.awt.Color(0, 15, 131));
        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/close copia.png"))); // NOI18N
        btnCerrar.setText("CERRAR");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        tblGridDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblGridDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGridDatosMouseClicked(evt);
            }
        });
        tblGridDatos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblGridDatosKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblGridDatos);

        btnNuevo.setForeground(new java.awt.Color(0, 15, 131));
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/nuevo copia.png"))); // NOI18N
        btnNuevo.setText("NUEVO");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("ID");

        jLabel2.setText("VARIEDAD:");

        lblEstadoRegistro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEstadoRegistro.setText("ACTIVO");
        lblEstadoRegistro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setText("CULTIVO:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 576, Short.MAX_VALUE)
                        .addComponent(lblEstadoRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboCultivo, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblEstadoRegistro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(cboCultivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        btnEditar.setForeground(new java.awt.Color(0, 15, 131));
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/modifica copia.png"))); // NOI18N
        btnEditar.setText("EDITAR");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                        .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnEditar)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar)
                    .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        bloquearElementos(false);
        limpiar();
        cboCultivo.removeAllItems();
        llenarComboCultivo();
        operacion = true;

        try {
            if (this.txtId.getText().equals("")) {
                this.txtId.setText("1");
            } else {
                int filasTabla = this.tblGridDatos.getRowCount() - 1;
                String valor = this.tblGridDatos.getValueAt(filasTabla, 0).toString();
                this.txtId.setText(String.valueOf(Integer.parseInt(valor) + 1));
            }

        } catch (Exception e) {
        }

    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        bloquearElementos(false);
        cboCultivo.removeAllItems();
        llenarComboCultivo();
        operacion = false;
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        C_Controles control = new C_Controles();

        if (control.mensajeGuardado()) {
            C_Variedad variedad = new C_Variedad();
            int idCultivo = cboCultivo.getItemAt(cboCultivo.getSelectedIndex()).getIdCultivo();
            String mensaje = variedad.insertarVariedad(txtId, txtDescripcion, idCultivo, operacion);
            JOptionPane.showMessageDialog(null, mensaje);
        }
        bloquearElementos(true);
        this.tblGridDatos.removeAll();
        controlador.mostrarVariedad(tblGridDatos);
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void tblGridDatosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblGridDatosKeyReleased
        llenarModeloDatos();
        cboCultivo.removeAllItems();
        E_Cultivo cultivo = new E_Cultivo();
        this.txtId.setText(String.valueOf(this.tabla.getValueAt(this.tblGridDatos.getSelectedRow(), 0)));
        this.txtDescripcion.setText(String.valueOf(this.tabla.getValueAt(this.tblGridDatos.getSelectedRow(), 1)));
        cultivo.setCult_Descr(String.valueOf(this.tabla.getValueAt(this.tblGridDatos.getSelectedRow(), 2)));
        this.cboCultivo.addItem(cultivo);
        this.lblEstadoRegistro.setText(String.valueOf(this.tabla.getValueAt(this.tblGridDatos.getSelectedRow(), 3)));
    }//GEN-LAST:event_tblGridDatosKeyReleased

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        bloquearElementos(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void tblGridDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGridDatosMouseClicked
        llenarModeloDatos();
        cboCultivo.removeAllItems();
        E_Cultivo cultivo = new E_Cultivo();
        this.txtId.setText(String.valueOf(this.tabla.getValueAt(this.tblGridDatos.getSelectedRow(), 0)));
        this.txtDescripcion.setText(String.valueOf(this.tabla.getValueAt(this.tblGridDatos.getSelectedRow(), 1)));
        cultivo.setCult_Descr(String.valueOf(this.tabla.getValueAt(this.tblGridDatos.getSelectedRow(), 2)));
        this.cboCultivo.addItem(cultivo);
        this.lblEstadoRegistro.setText(String.valueOf(this.tabla.getValueAt(this.tblGridDatos.getSelectedRow(), 3)));
    }//GEN-LAST:event_tblGridDatosMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox<E_Cultivo> cboCultivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblEstadoRegistro;
    private javax.swing.JTable tblGridDatos;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables
}

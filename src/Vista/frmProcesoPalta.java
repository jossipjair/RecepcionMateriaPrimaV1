package Vista;

import Controlador.C_CodigoQR;
import Controlador.C_Controles;
import Controlador.C_DetalleRecepcionPalta;
import Controlador.C_Lote;
import Controlador.C_RecepcionPalta;
import Entidad.E_Lote;
import Reporte.rptImprimeTarja;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jescalaya
 */
public class frmProcesoPalta extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmProcesoPalt
     */
    public frmProcesoPalta() {
        initComponents();
        llenarCombo();
        llenarGridRecepcion();
        bloquearElementos(true);
        bloquearElementosDetalle(true);
        fechaSistema();
        llenarComboViajes();
        this.lblIdRecepcion.setVisible(true);
        this.txtIdDetalle.setVisible(true);
        this.jLabel21.setVisible(true);
        validarSiEsProcesado();
    }

    private boolean operacion = false;

    private void llenarCombo() {
        C_Lote cLote = new C_Lote();
        cLote.llenarComboLote(cboLote);
    }

    private void llenarGridRecepcion() {
        C_RecepcionPalta palta = new C_RecepcionPalta();
        palta.llenarGridRecepcionPalta(tblDatosRecepcion);
    }

    private void fechaSistema() {
        Date fhora = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        this.dtcFechaRegistro.setText(formatoFecha.format(fhora));
    }

    private void fechayHora() {
        Date fhora = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        this.txtFechaHoraPesado.setText(formatoFecha.format(fhora));
    }

    private void nuevoCodigoBarra() {
        long aleatorio = System.currentTimeMillis();
        this.lblCodigoBarraNumerico.setText(String.valueOf(aleatorio));
    }

    private void bloquearElementos(boolean xx) {
        this.btnNuevo.setEnabled(xx);
        this.btnEditar.setEnabled(xx);
        this.btnGuardar.setEnabled(!xx);
        this.btnCancelar.setEnabled(!xx);
        this.btnCerrar.setEnabled(xx);

        this.txtId.setEnabled(false);
        this.cboLote.setEnabled(!xx);
        this.txtVariedad.setEditable(false);
        this.dtcFechaRegistro.setEnabled(!xx);
        this.txtGuiaRemision.setEnabled(!xx);
        this.cboViaje.setEnabled(!xx);
        this.txtObservacion.setEnabled(!xx);
        this.tblDatosRecepcion.setEnabled(xx);
    }

    private void limpiarProcesoRecepcion() {
        this.txtId.setText("");
        this.cboLote.removeAllItems();
        llenarCombo();
        this.txtVariedad.setText("");
        this.txtGuiaRemision.setText("");
        this.txtObservacion.setText("");
    }

    private void limpiarProcesoDetalleRecepcion() {
        this.txtFechaHoraPesado.setText("");
        this.txtPesoBruto.setText("");
        this.txtTara.setText("");
        this.txtJabas.setText("");
        this.txtPesoTotal.setText("");
        this.txtPesoNeto.setText("");
        this.chkReproceso.setSelected(false);
        this.txtObservacion.setText("");
        this.lblCodigoBarraNumerico.setText("");
        this.lblcode.setText("");
        this.lblFechaProceso.setText("");
        this.lblEstadoRegistroRecepcion.setText("NO PROCESADO");
    }

    private void calculaPallets_PNeto_Jabas() {
        double pallets;
        double peso = 0.0;
        double jabas = 0.0;

        pallets = tblRegistros.getRowCount();

        for (int i = 0; i < pallets; i++) {
            peso += Double.parseDouble(String.valueOf(tblRegistros.getValueAt(i, 7)));
            jabas += Double.parseDouble(String.valueOf(tblRegistros.getValueAt(i, 4)));
        }
        this.lblCantidadPallets.setText("CANT. PALLETS: " + String.format("%.2f",pallets));
        this.lblTotalPesoNeto.setText("TOTAL PESO NETO: " + String.format("%.2f", peso));
        this.lblCantidadJabas.setText("CANT. JABAS: " + jabas);
    }

    private void guardarRecepcionPalta() {

        C_Controles control = new C_Controles();
        if (control.mensajeGuardado()) {
            C_RecepcionPalta palta = new C_RecepcionPalta();
            int idLote = cboLote.getItemAt(cboLote.getSelectedIndex()).getIdLote();
             palta.insertarRecepcionPalta(idLote, 1, dtcFechaRegistro, txtGuiaRemision, cboViaje, txtObservacion, txtId, operacion);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cboLote = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        txtVariedad = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtGuiaRemision = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cboViaje = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtObservacion = new javax.swing.JTextArea();
        jLabel15 = new javax.swing.JLabel();
        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDatosRecepcion = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        dtcFechaRegistro = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        lblTotalPesoNeto = new javax.swing.JLabel();
        lblCantidadJabas = new javax.swing.JLabel();
        lblCantidadPallets = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        chkReproceso = new javax.swing.JCheckBox();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRegistros = new javax.swing.JTable();
        btnNuevoDetalle = new javax.swing.JButton();
        btnEditarDetalle = new javax.swing.JButton();
        btnGuardarDetalle = new javax.swing.JButton();
        btnCancelarDetalle = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        lblEstadoRegistroRecepcion = new javax.swing.JLabel();
        lblcode = new javax.swing.JLabel();
        lblCodigoBarraNumerico = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtObservacionDetallePeso = new javax.swing.JTextArea();
        jLabel16 = new javax.swing.JLabel();
        txtPesoBruto = new javax.swing.JTextField();
        txtJabas = new javax.swing.JTextField();
        txtPesoNeto = new javax.swing.JTextField();
        txtPeso = new javax.swing.JTextField();
        txtPesoTotal = new javax.swing.JTextField();
        txtTara = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        lblFechaProceso = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtIdDetalle = new javax.swing.JTextField();
        btnEliminarDetalle = new javax.swing.JButton();
        txtFechaHoraPesado = new javax.swing.JTextField();
        lblIdRecepcion = new javax.swing.JLabel();

        setClosable(true);
        setTitle("RECEPCION MATERIA PRIMA: PALTA");
        setToolTipText("");
        setAutoscrolls(true);
        setPreferredSize(new java.awt.Dimension(1169, 673));

        jLabel1.setText("ID:");

        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });
        txtId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdKeyTyped(evt);
            }
        });

        jLabel2.setText("LOTE:");

        jLabel18.setText("VARIEDAD:");

        jLabel4.setText("FECHA:");

        jLabel7.setText("GUIA REMISION:");

        txtGuiaRemision.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGuiaRemisionActionPerformed(evt);
            }
        });

        jLabel8.setText("VIAJE:");

        txtObservacion.setColumns(20);
        txtObservacion.setRows(5);
        jScrollPane2.setViewportView(txtObservacion);

        jLabel15.setText("OBSERVACION:");

        btnNuevo.setForeground(new java.awt.Color(0, 15, 131));
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/nuevo copia.png"))); // NOI18N
        btnNuevo.setText("NUEVO");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnEditar.setForeground(new java.awt.Color(0, 15, 131));
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/modifica copia.png"))); // NOI18N
        btnEditar.setText("EDITAR");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

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

        tblDatosRecepcion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblDatosRecepcion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDatosRecepcionMouseClicked(evt);
            }
        });
        tblDatosRecepcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblDatosRecepcionKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblDatosRecepcionKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(tblDatosRecepcion);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(153, 153, 0));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("PALTA");

        lblTotalPesoNeto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTotalPesoNeto.setText("TOTAL PESO NETO: 000000000");
        lblTotalPesoNeto.setToolTipText("");

        lblCantidadJabas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblCantidadJabas.setText("CANT. JABAS: 00000");

        lblCantidadPallets.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblCantidadPallets.setText("CANT. PALLETS: 000");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(lblTotalPesoNeto)
                        .addGap(26, 26, 26)
                        .addComponent(lblCantidadPallets))
                    .addComponent(lblCantidadJabas, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotalPesoNeto)
                    .addComponent(lblCantidadPallets))
                .addGap(12, 12, 12)
                .addComponent(lblCantidadJabas)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboLote, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel18))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtVariedad, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dtcFechaRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtGuiaRemision, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboViaje, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(52, 52, 52)
                                        .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(22, 22, 22)
                                .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(cboLote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel18)
                        .addComponent(txtVariedad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(dtcFechaRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(txtGuiaRemision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)
                        .addComponent(cboViaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnNuevo)
                                    .addComponent(btnEditar)
                                    .addComponent(btnGuardar)
                                    .addComponent(btnCancelar))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(11, 11, 11)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("DATOS RECEPCION", jPanel1);

        jLabel5.setText("FECHA PESADO:");

        jLabel9.setText("TARA:");

        jLabel10.setText("PESO BRUTO:");

        jLabel11.setText("CANT. JABAS:");

        chkReproceso.setText("Reproceso");
        chkReproceso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkReprocesoActionPerformed(evt);
            }
        });

        jLabel12.setText("PESO:");

        jLabel13.setText("PESO TOTAL:");

        jLabel14.setText("PESO NETO:");

        tblRegistros.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tblRegistros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblRegistros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRegistrosMouseClicked(evt);
            }
        });
        tblRegistros.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblRegistrosKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblRegistrosKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblRegistros);

        btnNuevoDetalle.setForeground(new java.awt.Color(0, 15, 131));
        btnNuevoDetalle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/nuevo copia.png"))); // NOI18N
        btnNuevoDetalle.setText("NUEVO");
        btnNuevoDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoDetalleActionPerformed(evt);
            }
        });

        btnEditarDetalle.setForeground(new java.awt.Color(0, 15, 131));
        btnEditarDetalle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/modifica copia.png"))); // NOI18N
        btnEditarDetalle.setText("EDITAR");
        btnEditarDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarDetalleActionPerformed(evt);
            }
        });

        btnGuardarDetalle.setForeground(new java.awt.Color(0, 15, 131));
        btnGuardarDetalle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/GRABAR1 copia.png"))); // NOI18N
        btnGuardarDetalle.setText("GUARDAR");
        btnGuardarDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarDetalleActionPerformed(evt);
            }
        });

        btnCancelarDetalle.setForeground(new java.awt.Color(0, 15, 131));
        btnCancelarDetalle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/cancelar copia.png"))); // NOI18N
        btnCancelarDetalle.setText("CANCELAR");
        btnCancelarDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarDetalleActionPerformed(evt);
            }
        });

        btnImprimir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnImprimir.setForeground(new java.awt.Color(28, 0, 115));
        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/imprimir.png"))); // NOI18N
        btnImprimir.setText("IMPRIMIR");
        btnImprimir.setName("btnImprimir"); // NOI18N
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        lblEstadoRegistroRecepcion.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        lblEstadoRegistroRecepcion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEstadoRegistroRecepcion.setText("NO PROCESADO");
        lblEstadoRegistroRecepcion.setAutoscrolls(true);
        lblEstadoRegistroRecepcion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblcode.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblcode.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblCodigoBarraNumerico.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        lblCodigoBarraNumerico.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCodigoBarraNumerico.setText("00000000000000000");

        jLabel6.setText("OBSERVACION:");

        txtObservacionDetallePeso.setColumns(20);
        txtObservacionDetallePeso.setRows(5);
        jScrollPane4.setViewportView(txtObservacionDetallePeso);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(153, 153, 0));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("PALTA");

        txtPesoBruto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesoBrutoActionPerformed(evt);
            }
        });
        txtPesoBruto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPesoBrutoFocusLost(evt);
            }
        });

        txtJabas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJabasActionPerformed(evt);
            }
        });
        txtJabas.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtJabasFocusLost(evt);
            }
        });

        txtPesoNeto.setEditable(false);
        txtPesoNeto.setBackground(new java.awt.Color(255, 255, 204));
        txtPesoNeto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        txtPeso.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtPeso.setText("1.8");

        txtPesoTotal.setEditable(false);
        txtPesoTotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        txtTara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTaraActionPerformed(evt);
            }
        });
        txtTara.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTaraFocusLost(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel19.setText("FECHA PROCESO:");

        lblFechaProceso.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        lblFechaProceso.setText("00/00/0000 00:00:00 PM");

        jLabel21.setText("ID");

        txtIdDetalle.setEditable(false);
        txtIdDetalle.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtIdDetalle.setForeground(new java.awt.Color(0, 51, 51));
        txtIdDetalle.setBorder(null);
        txtIdDetalle.setCaretColor(new java.awt.Color(240, 240, 240));
        txtIdDetalle.setDisabledTextColor(new java.awt.Color(240, 240, 240));
        txtIdDetalle.setSelectedTextColor(new java.awt.Color(240, 240, 240));

        btnEliminarDetalle.setForeground(new java.awt.Color(0, 15, 131));
        btnEliminarDetalle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/elimina copia.png"))); // NOI18N
        btnEliminarDetalle.setText("Eliminar");
        btnEliminarDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarDetalleActionPerformed(evt);
            }
        });

        txtFechaHoraPesado.setEditable(false);

        lblIdRecepcion.setForeground(new java.awt.Color(240, 240, 240));
        lblIdRecepcion.setText("id rep");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblCodigoBarraNumerico, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(556, 556, 556))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(txtFechaHoraPesado))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPesoBruto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel21)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtIdDetalle))
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblIdRecepcion, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnNuevoDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEditarDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnGuardarDetalle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancelarDetalle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEliminarDetalle))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblEstadoRegistroRecepcion, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel19)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblFechaProceso, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTara, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtJabas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPesoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(txtPesoNeto, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(chkReproceso)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblcode, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(499, 499, 499))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnNuevoDetalle)
                                    .addComponent(btnEditarDetalle)
                                    .addComponent(btnGuardarDetalle)
                                    .addComponent(btnCancelarDetalle)
                                    .addComponent(btnEliminarDetalle)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtFechaHoraPesado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel14)
                                                .addComponent(jLabel13))
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel12)
                                                .addComponent(jLabel11))
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel9)
                                                .addComponent(jLabel10)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtPesoNeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtPesoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtJabas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtTara, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtPesoBruto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(chkReproceso))))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(13, 13, 13)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel21)
                                            .addComponent(txtIdDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblIdRecepcion, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addGap(62, 62, 62)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnImprimir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblEstadoRegistroRecepcion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblFechaProceso, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel16))
                        .addGap(0, 16, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblcode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCodigoBarraNumerico, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("DETALLE DE PESOS", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtGuiaRemisionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGuiaRemisionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGuiaRemisionActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        limpiarProcesoRecepcion();
        operacion = true;
        fechaSistema();
        this.cboLote.removeAllItems();
        llenarCombo();
        llenarComboViajes();
        bloquearElementos(false);
        try {
            if (this.txtId.getText().equals("")) {
                this.txtId.setText("1");
            } else {
                int filasTabla = this.tblDatosRecepcion.getRowCount() - 1;
                String valor = this.tblDatosRecepcion.getValueAt(filasTabla, 0).toString();
                this.txtId.setText(String.valueOf(Integer.parseInt(valor) + 1));
            }
        } catch (NumberFormatException e) {
        }
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void activarBotonNuevoDetalle() {
        limpiarProcesoDetalleRecepcion();
        nuevoCodigoBarra();
        muestraCodigoQR();
        fechayHora();
        operacion = true;
        bloquearElementosDetalle(false);
        try {
            if (this.txtIdDetalle.getText().equals("")) {
                this.txtIdDetalle.setText("1");
            } else {
                int filasTabla = this.tblRegistros.getRowCount();
                JOptionPane.showMessageDialog(null, filasTabla);
                String valor = this.tblRegistros.getValueAt(filasTabla, 0).toString();
                this.txtIdDetalle.setText(String.valueOf(Integer.parseInt(valor) + 1));
            }
        } catch (NumberFormatException e) {
        }
    }

    private void btnNuevoDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoDetalleActionPerformed
        activarBotonNuevoDetalle();
              int filasTabla = this.tblRegistros.getRowCount();
                JOptionPane.showMessageDialog(null, filasTabla);
    }//GEN-LAST:event_btnNuevoDetalleActionPerformed

    private void calcularPesoNeto() {
        Double pesoBruto = 0.0;
        Double tara = 0.0;
        Double cantidad = 0.0;
        Double peso = 0.0;

        try {
            pesoBruto = Double.parseDouble(this.txtPesoBruto.getText());
        } catch (NumberFormatException e) {

        }

        try {
            tara = Double.parseDouble(this.txtTara.getText());
        } catch (NumberFormatException e) {

        }

        try {
            cantidad = Double.parseDouble(this.txtJabas.getText());
        } catch (NumberFormatException e) {

        }

        try {
            peso = Double.parseDouble(this.txtPeso.getText());
        } catch (NumberFormatException e) {

        }

        Double pesoTotal;
        Double pesoNeto;

        //FORMAT DOS DECIMALES 
        pesoTotal = cantidad * peso;
        pesoNeto = pesoBruto - tara - pesoTotal;

        this.txtPesoTotal.setText(pesoTotal.toString());
        this.txtPesoNeto.setText(pesoNeto.toString());

    }
    DefaultTableModel tabla;

    private void llenarModeloDatos(boolean tipo) {
        if (tipo) {
            tabla = (DefaultTableModel) this.tblDatosRecepcion.getModel();
        } else {
            tabla = (DefaultTableModel) this.tblRegistros.getModel();
        }
    }

    private void llenarComboViajes() {
        this.cboViaje.removeAllItems();
        String viajes[] = {"DESCARTE EMBALAJE", "DESCARTE MAQUINA", "REPROCESO", "VENTA", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21"};
        for (String viaje : viajes) {
            this.cboViaje.addItem(viaje);
        }
    }

    private void llenarCjsTextoRecepcion() {
        llenarModeloDatos(true);
        C_DetalleRecepcionPalta detalle = new C_DetalleRecepcionPalta();
        String idRecep = String.valueOf(this.tabla.getValueAt(this.tblDatosRecepcion.getSelectedRow(), 0));
        this.lblIdRecepcion.setText(idRecep);
        this.txtId.setText(idRecep);
        detalle.mostrarDetalleRecepcion(tblRegistros, Integer.parseInt(idRecep));
        this.cboLote.removeAllItems();
        E_Lote lote = new E_Lote();
        lote.setLote_NCort(String.valueOf(this.tabla.getValueAt(this.tblDatosRecepcion.getSelectedRow(), 1)));
        this.cboLote.addItem(lote);
        this.txtVariedad.setText(String.valueOf(this.tabla.getValueAt(this.tblDatosRecepcion.getSelectedRow(), 2)));
        Date fecha = null;
        this.dtcFechaRegistro.setText(String.valueOf(this.tabla.getValueAt(this.tblDatosRecepcion.getSelectedRow(), 3)));
        this.txtGuiaRemision.setText(String.valueOf(this.tabla.getValueAt(this.tblDatosRecepcion.getSelectedRow(), 4)));
        this.cboViaje.removeAllItems();
        this.cboViaje.addItem(String.valueOf(this.tabla.getValueAt(this.tblDatosRecepcion.getSelectedRow(), 5)));
        this.txtObservacion.setText(String.valueOf(this.tabla.getValueAt(this.tblDatosRecepcion.getSelectedRow(), 6)));
        calculaPallets_PNeto_Jabas();
    }

    /*
     DETALLE RECEPCION PALTA
     */
    C_DetalleRecepcionPalta detalle;

    private void llenarGridDetalle() {
        tblDatosRecepcion.removeAll();
        detalle = new C_DetalleRecepcionPalta();
        detalle.mostrarDetalleRecepcion(tblRegistros, Integer.parseInt(this.txtId.getText()));
    }

    private void mostrarCjsDetalleRecepcion() {
        llenarModeloDatos(false);

        try {
            this.txtIdDetalle.setText(String.valueOf(this.tabla.getValueAt(this.tblRegistros.getSelectedRow(), 0)));
            this.txtFechaHoraPesado.setText(String.valueOf(this.tabla.getValueAt(this.tblRegistros.getSelectedRow(), 1)));
            this.txtPesoBruto.setText(String.valueOf(this.tabla.getValueAt(this.tblRegistros.getSelectedRow(), 2)));
            this.txtTara.setText(String.valueOf(this.tabla.getValueAt(this.tblRegistros.getSelectedRow(), 3)));
            this.txtJabas.setText(String.valueOf(this.tabla.getValueAt(this.tblRegistros.getSelectedRow(), 4)));
            this.txtPeso.setText(String.valueOf(this.tabla.getValueAt(this.tblRegistros.getSelectedRow(), 5)));
            this.txtPesoTotal.setText(String.valueOf(this.tabla.getValueAt(this.tblRegistros.getSelectedRow(), 6)));
            this.txtPesoNeto.setText(String.valueOf(this.tabla.getValueAt(this.tblRegistros.getSelectedRow(), 7)));
            byte esReproceso = Byte.parseByte(String.valueOf(this.tabla.getValueAt(this.tblRegistros.getSelectedRow(), 8)));
            byte esProcesado = Byte.parseByte(String.valueOf(this.tabla.getValueAt(this.tblRegistros.getSelectedRow(), 9)));
            this.txtObservacion.setText(String.valueOf(this.tabla.getValueAt(this.tblRegistros.getSelectedRow(), 10)));
            this.lblFechaProceso.setText(String.valueOf(this.tabla.getValueAt(this.tblRegistros.getSelectedRow(), 11)));
            this.lblCodigoBarraNumerico.setText(String.valueOf(this.tabla.getValueAt(this.tblRegistros.getSelectedRow(), 12)));
            if (esReproceso == 1) {
                this.chkReproceso.setSelected(true);
            } else {
                this.chkReproceso.setSelected(false);
            }

            if (esProcesado == 1) {
                this.lblEstadoRegistroRecepcion.setText("PROCESADO");

            } else {
                this.lblEstadoRegistroRecepcion.setText("NO PROCESADO");
            }
            validarSiEsProcesado();
            muestraCodigoQR();
            calculaPallets_PNeto_Jabas();
        } catch (NumberFormatException e) {
        }

    }

    private void validarSiEsProcesado() {
        if (this.lblEstadoRegistroRecepcion.getText().equals("NO PROCESADO")) {
            this.lblEstadoRegistroRecepcion.setForeground(Color.red);
        } else {
            this.lblEstadoRegistroRecepcion.setForeground(Color.blue);
        }
    }

    private void insertarDetalleRecepcion() {
        detalle = new C_DetalleRecepcionPalta();
        detalle.insertarDetalleRecepcionPalta(txtId, lblCodigoBarraNumerico, txtFechaHoraPesado, txtTara, txtPesoBruto, txtJabas, txtPeso, txtPesoTotal, txtPesoNeto, chkReproceso, txtObservacion, txtIdDetalle, operacion);
        llenarGridDetalle();
        impresionTarja();
        if (operacion) {
            activarBotonNuevoDetalle();
        } else {
            bloquearElementosDetalle(true);
        }

    }

    private void impresionTarja() {
        C_CodigoQR codigo = new C_CodigoQR();
        String datos = "";
        codigo.renderizarImagenQR(this.lblCodigoBarraNumerico.getText(), datos);
        rptImprimeTarja imprime = new rptImprimeTarja();
        imprime.llenarReporte(Integer.parseInt(this.txtIdDetalle.getText()), this.lblCodigoBarraNumerico.getText());
    }

    private void bloquearElementosDetalle(boolean xx) {
        this.btnNuevoDetalle.setEnabled(xx);
        this.btnEditarDetalle.setEnabled(xx);
        this.btnGuardarDetalle.setEnabled(!xx);
        this.btnCancelarDetalle.setEnabled(!xx);
        this.btnEliminarDetalle.setEnabled(!xx);

        this.txtPesoBruto.setEnabled(!xx);
        this.txtTara.setEnabled(!xx);
        this.txtJabas.setEnabled(!xx);
        this.txtPeso.setEnabled(!xx);
        this.txtObservacionDetallePeso.setEditable(!xx);
        this.tblRegistros.setEnabled(xx);
    }

    private void eliminarDetalleRecepcion() {
        detalle = new C_DetalleRecepcionPalta();
        detalle.darBajaDetalleRecepcion(txtIdDetalle);
    }

    private void muestraCodigoQR() {

        C_CodigoQR qr = new C_CodigoQR();
        String data = this.lblIdRecepcion.getText() + "," + this.cboLote.getSelectedItem().toString() + ",P," + this.txtVariedad.getText() + "," + this.cboViaje.getSelectedItem().toString() + "," + this.txtJabas.getText() + "," +this.txtPesoNeto.getText();
        qr.generarQr("", data, lblcode);

    }

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed

        impresionTarja();

    }//GEN-LAST:event_btnImprimirActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        tblDatosRecepcion.removeAll();
        guardarRecepcionPalta();
        llenarGridRecepcion();
        bloquearElementos(true);
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        this.cboLote.removeAllItems();
        this.cboViaje.removeAllItems();
        llenarCombo();
        llenarComboViajes();
        operacion = false;
        bloquearElementos(false);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        bloquearElementos(true);        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void chkReprocesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkReprocesoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkReprocesoActionPerformed

    private void txtPesoBrutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesoBrutoActionPerformed
        calcularPesoNeto();
    }//GEN-LAST:event_txtPesoBrutoActionPerformed

    private void txtTaraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTaraActionPerformed
        calcularPesoNeto();
    }//GEN-LAST:event_txtTaraActionPerformed

    private void txtJabasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJabasActionPerformed
        calcularPesoNeto();
    }//GEN-LAST:event_txtJabasActionPerformed

    private void txtPesoBrutoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPesoBrutoFocusLost
        calcularPesoNeto();
    }//GEN-LAST:event_txtPesoBrutoFocusLost

    private void txtTaraFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTaraFocusLost
        calcularPesoNeto();
    }//GEN-LAST:event_txtTaraFocusLost

    private void txtJabasFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtJabasFocusLost
        calcularPesoNeto();
    }//GEN-LAST:event_txtJabasFocusLost

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        llenarGridDetalle();
    }//GEN-LAST:event_txtIdActionPerformed

    private void btnGuardarDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarDetalleActionPerformed
        insertarDetalleRecepcion();
        //bloquearElementosDetalle(true);

        llenarGridDetalle();

    }//GEN-LAST:event_btnGuardarDetalleActionPerformed

    private void btnEditarDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarDetalleActionPerformed
        operacion = false;
        bloquearElementosDetalle(false);
    }//GEN-LAST:event_btnEditarDetalleActionPerformed

    private void btnCancelarDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarDetalleActionPerformed
        bloquearElementosDetalle(true);
        llenarGridDetalle();
    }//GEN-LAST:event_btnCancelarDetalleActionPerformed

    private void btnEliminarDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarDetalleActionPerformed
        eliminarDetalleRecepcion();

    }//GEN-LAST:event_btnEliminarDetalleActionPerformed

    private void tblDatosRecepcionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblDatosRecepcionKeyPressed
        llenarCjsTextoRecepcion();
    }//GEN-LAST:event_tblDatosRecepcionKeyPressed

    private void tblDatosRecepcionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDatosRecepcionMouseClicked
        llenarCjsTextoRecepcion();
    }//GEN-LAST:event_tblDatosRecepcionMouseClicked

    private void tblDatosRecepcionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblDatosRecepcionKeyReleased
        llenarCjsTextoRecepcion();
    }//GEN-LAST:event_tblDatosRecepcionKeyReleased

    private void txtIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdKeyTyped

    }//GEN-LAST:event_txtIdKeyTyped

    private void tblRegistrosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblRegistrosKeyPressed
        mostrarCjsDetalleRecepcion();
    }//GEN-LAST:event_tblRegistrosKeyPressed

    private void tblRegistrosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblRegistrosKeyReleased
        mostrarCjsDetalleRecepcion();
    }//GEN-LAST:event_tblRegistrosKeyReleased

    private void tblRegistrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRegistrosMouseClicked
        mostrarCjsDetalleRecepcion();
    }//GEN-LAST:event_tblRegistrosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCancelarDetalle;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEditarDetalle;
    private javax.swing.JButton btnEliminarDetalle;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnGuardarDetalle;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnNuevoDetalle;
    private javax.swing.JComboBox<E_Lote> cboLote;
    private javax.swing.JComboBox<String> cboViaje;
    private javax.swing.JCheckBox chkReproceso;
    private javax.swing.JTextField dtcFechaRegistro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblCantidadJabas;
    private javax.swing.JLabel lblCantidadPallets;
    private javax.swing.JLabel lblCodigoBarraNumerico;
    private javax.swing.JLabel lblEstadoRegistroRecepcion;
    private javax.swing.JLabel lblFechaProceso;
    private javax.swing.JLabel lblIdRecepcion;
    private javax.swing.JLabel lblTotalPesoNeto;
    private javax.swing.JLabel lblcode;
    private javax.swing.JTable tblDatosRecepcion;
    private javax.swing.JTable tblRegistros;
    private javax.swing.JTextField txtFechaHoraPesado;
    private javax.swing.JTextField txtGuiaRemision;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtIdDetalle;
    private javax.swing.JTextField txtJabas;
    private javax.swing.JTextArea txtObservacion;
    private javax.swing.JTextArea txtObservacionDetallePeso;
    private javax.swing.JTextField txtPeso;
    private javax.swing.JTextField txtPesoBruto;
    private javax.swing.JTextField txtPesoNeto;
    private javax.swing.JTextField txtPesoTotal;
    private javax.swing.JTextField txtTara;
    private javax.swing.JTextField txtVariedad;
    // End of variables declaration//GEN-END:variables
}

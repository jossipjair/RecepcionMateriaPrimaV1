/*
 * Hecho para TI ♥
 */
package Vista;

import Controlador.C_VersionSoftware;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;

/**
 *
 * @author jescalaya
 */
public class frmPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form frmPrincipal
     */

    C_VersionSoftware version = new C_VersionSoftware();
    public frmPrincipal() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
       
//      this.setTitle("Control Recepción de Materia Prima v" + version.validarVersionActiva("1.0"));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dkpFondoMenu = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuMantenimientoTablas = new javax.swing.JMenu();
        mnuMantenimientoTablasEmpresa = new javax.swing.JMenuItem();
        mnuMantenimientoTablasSucursal = new javax.swing.JMenuItem();
        mnuMantenimientoTablasCultivo = new javax.swing.JMenuItem();
        mnuMantenimientoTablasVariedad = new javax.swing.JMenuItem();
        mnuMantenimientoTablasLote = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mnuMantenimientoTablasSalir = new javax.swing.JMenuItem();
        mnuMovimientos = new javax.swing.JMenu();
        mnuMovimientoRegistroMateriaPrima = new javax.swing.JMenu();
        mnuMovimientoRegistroMateriaPrimaArandano = new javax.swing.JMenuItem();
        mnuMovimientoRegistroMateriaPrimaCitrico = new javax.swing.JMenuItem();
        mnuMovimientoRegistroMateriaPrimaPalta = new javax.swing.JMenuItem();
        mnuMovimientoRegistroMateriaPrimaUva = new javax.swing.JMenuItem();
        mnuMovimientoRegistroReimprimirPaleta = new javax.swing.JMenuItem();
        mnuReporte = new javax.swing.JMenu();
        mnuReporteCuadroResumen = new javax.swing.JMenuItem();
        mnuReportePaletaProceso = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Control Recepción de Materia Prima");
        setName("frmPrincipal"); // NOI18N

        javax.swing.GroupLayout dkpFondoMenuLayout = new javax.swing.GroupLayout(dkpFondoMenu);
        dkpFondoMenu.setLayout(dkpFondoMenuLayout);
        dkpFondoMenuLayout.setHorizontalGroup(
            dkpFondoMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1242, Short.MAX_VALUE)
        );
        dkpFondoMenuLayout.setVerticalGroup(
            dkpFondoMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 572, Short.MAX_VALUE)
        );

        mnuMantenimientoTablas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/mantenimientoTablas.png"))); // NOI18N
        mnuMantenimientoTablas.setText("Mantenimiento Tablas");
        mnuMantenimientoTablas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuMantenimientoTablasActionPerformed(evt);
            }
        });

        mnuMantenimientoTablasEmpresa.setText("Taba Empresa");
        mnuMantenimientoTablasEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuMantenimientoTablasEmpresaActionPerformed(evt);
            }
        });
        mnuMantenimientoTablas.add(mnuMantenimientoTablasEmpresa);

        mnuMantenimientoTablasSucursal.setText("Tabla Sucursal");
        mnuMantenimientoTablasSucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuMantenimientoTablasSucursalActionPerformed(evt);
            }
        });
        mnuMantenimientoTablas.add(mnuMantenimientoTablasSucursal);

        mnuMantenimientoTablasCultivo.setText("Tabla Cultivo");
        mnuMantenimientoTablasCultivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuMantenimientoTablasCultivoActionPerformed(evt);
            }
        });
        mnuMantenimientoTablas.add(mnuMantenimientoTablasCultivo);

        mnuMantenimientoTablasVariedad.setText("Tabla Variedad");
        mnuMantenimientoTablasVariedad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuMantenimientoTablasVariedadActionPerformed(evt);
            }
        });
        mnuMantenimientoTablas.add(mnuMantenimientoTablasVariedad);

        mnuMantenimientoTablasLote.setText("Tabla Lote");
        mnuMantenimientoTablasLote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuMantenimientoTablasLoteActionPerformed(evt);
            }
        });
        mnuMantenimientoTablas.add(mnuMantenimientoTablasLote);
        mnuMantenimientoTablas.add(jSeparator1);

        mnuMantenimientoTablasSalir.setText("Salir");
        mnuMantenimientoTablas.add(mnuMantenimientoTablasSalir);

        jMenuBar1.add(mnuMantenimientoTablas);

        mnuMovimientos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/movimientos.png"))); // NOI18N
        mnuMovimientos.setText("Movimientos");

        mnuMovimientoRegistroMateriaPrima.setText("Recepción de Materia Prima");

        mnuMovimientoRegistroMateriaPrimaArandano.setText("Proceso Arandano");
        mnuMovimientoRegistroMateriaPrimaArandano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuMovimientoRegistroMateriaPrimaArandanoActionPerformed(evt);
            }
        });
        mnuMovimientoRegistroMateriaPrima.add(mnuMovimientoRegistroMateriaPrimaArandano);

        mnuMovimientoRegistroMateriaPrimaCitrico.setText("Proceso Cítrico");
        mnuMovimientoRegistroMateriaPrima.add(mnuMovimientoRegistroMateriaPrimaCitrico);

        mnuMovimientoRegistroMateriaPrimaPalta.setText("Proceso Palta");
        mnuMovimientoRegistroMateriaPrimaPalta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuMovimientoRegistroMateriaPrimaPaltaActionPerformed(evt);
            }
        });
        mnuMovimientoRegistroMateriaPrima.add(mnuMovimientoRegistroMateriaPrimaPalta);

        mnuMovimientoRegistroMateriaPrimaUva.setText("Proceso Uva");
        mnuMovimientoRegistroMateriaPrimaUva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuMovimientoRegistroMateriaPrimaUvaActionPerformed(evt);
            }
        });
        mnuMovimientoRegistroMateriaPrima.add(mnuMovimientoRegistroMateriaPrimaUva);

        mnuMovimientos.add(mnuMovimientoRegistroMateriaPrima);

        mnuMovimientoRegistroReimprimirPaleta.setText("Reimprimir Paleta");
        mnuMovimientoRegistroReimprimirPaleta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuMovimientoRegistroReimprimirPaletaActionPerformed(evt);
            }
        });
        mnuMovimientos.add(mnuMovimientoRegistroReimprimirPaleta);

        jMenuBar1.add(mnuMovimientos);

        mnuReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/reporte.png"))); // NOI18N
        mnuReporte.setText("Reportes");

        mnuReporteCuadroResumen.setText("Cuadro Resumen");
        mnuReporte.add(mnuReporteCuadroResumen);

        mnuReportePaletaProceso.setText("Paletas en Proceso");
        mnuReporte.add(mnuReportePaletaProceso);

        jMenuBar1.add(mnuReporte);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dkpFondoMenu)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dkpFondoMenu)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

  private boolean operacion;   
    
    private void mnuMovimientoRegistroReimprimirPaletaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuMovimientoRegistroReimprimirPaletaActionPerformed
        frmReimprimePaleta reimprime = new frmReimprimePaleta();
        this.dkpFondoMenu.add(reimprime);
        reimprime.setVisible(true);
    }//GEN-LAST:event_mnuMovimientoRegistroReimprimirPaletaActionPerformed

    private void mnuMantenimientoTablasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuMantenimientoTablasActionPerformed
    
    }//GEN-LAST:event_mnuMantenimientoTablasActionPerformed

    private void mnuMantenimientoTablasEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuMantenimientoTablasEmpresaActionPerformed
        frmEmpresa empresa = new frmEmpresa();
        this.dkpFondoMenu.add(empresa);
        empresa.setVisible(true);
    }//GEN-LAST:event_mnuMantenimientoTablasEmpresaActionPerformed

    private void mnuMantenimientoTablasSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuMantenimientoTablasSucursalActionPerformed
        frmSucursal sucursal = new frmSucursal();
        this.dkpFondoMenu.add(sucursal);
        sucursal.setVisible(true);
    }//GEN-LAST:event_mnuMantenimientoTablasSucursalActionPerformed

    private void mnuMantenimientoTablasVariedadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuMantenimientoTablasVariedadActionPerformed
        frmVariedad variedad = new frmVariedad();
        this.dkpFondoMenu.add(variedad);
        variedad.setVisible(true);
    }//GEN-LAST:event_mnuMantenimientoTablasVariedadActionPerformed

    private void mnuMantenimientoTablasLoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuMantenimientoTablasLoteActionPerformed
        frmLote lote = new frmLote();
        this.dkpFondoMenu.add(lote);
        lote.setVisible(true);
    }//GEN-LAST:event_mnuMantenimientoTablasLoteActionPerformed

    private void mnuMantenimientoTablasCultivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuMantenimientoTablasCultivoActionPerformed
        frmCultivo cultivo = new frmCultivo();
        this.dkpFondoMenu.add(cultivo);
        cultivo.setVisible(true);
    }//GEN-LAST:event_mnuMantenimientoTablasCultivoActionPerformed

    private void mnuMovimientoRegistroMateriaPrimaArandanoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuMovimientoRegistroMateriaPrimaArandanoActionPerformed
       
    }//GEN-LAST:event_mnuMovimientoRegistroMateriaPrimaArandanoActionPerformed

    private void mnuMovimientoRegistroMateriaPrimaPaltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuMovimientoRegistroMateriaPrimaPaltaActionPerformed
     frmProcesoPalta palta = new frmProcesoPalta();
        this.dkpFondoMenu.add(palta);
        palta.setVisible(true);
    }//GEN-LAST:event_mnuMovimientoRegistroMateriaPrimaPaltaActionPerformed

    private void mnuMovimientoRegistroMateriaPrimaUvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuMovimientoRegistroMateriaPrimaUvaActionPerformed

    }//GEN-LAST:event_mnuMovimientoRegistroMateriaPrimaUvaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane dkpFondoMenu;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenu mnuMantenimientoTablas;
    private javax.swing.JMenuItem mnuMantenimientoTablasCultivo;
    private javax.swing.JMenuItem mnuMantenimientoTablasEmpresa;
    private javax.swing.JMenuItem mnuMantenimientoTablasLote;
    private javax.swing.JMenuItem mnuMantenimientoTablasSalir;
    private javax.swing.JMenuItem mnuMantenimientoTablasSucursal;
    private javax.swing.JMenuItem mnuMantenimientoTablasVariedad;
    private javax.swing.JMenu mnuMovimientoRegistroMateriaPrima;
    private javax.swing.JMenuItem mnuMovimientoRegistroMateriaPrimaArandano;
    private javax.swing.JMenuItem mnuMovimientoRegistroMateriaPrimaCitrico;
    private javax.swing.JMenuItem mnuMovimientoRegistroMateriaPrimaPalta;
    private javax.swing.JMenuItem mnuMovimientoRegistroMateriaPrimaUva;
    private javax.swing.JMenuItem mnuMovimientoRegistroReimprimirPaleta;
    private javax.swing.JMenu mnuMovimientos;
    private javax.swing.JMenu mnuReporte;
    private javax.swing.JMenuItem mnuReporteCuadroResumen;
    private javax.swing.JMenuItem mnuReportePaletaProceso;
    // End of variables declaration//GEN-END:variables
}

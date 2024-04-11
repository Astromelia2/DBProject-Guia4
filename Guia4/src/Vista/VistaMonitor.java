package Vista;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
public class VistaMonitor extends javax.swing.JFrame {

    
    public VistaMonitor() {
        
        initComponents();
     
    }
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        comboxMonitores = new javax.swing.JComboBox<>();
        btnLista = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnSeleccionar = new javax.swing.JButton();
        txtDireccion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        txtCorreo = new javax.swing.JTextField();
        txtFechadeNacimiento = new javax.swing.JTextField();
        btnLimpiar = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        btnCrear = new javax.swing.JButton();
        txtFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        comboxMonitores.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        comboxMonitores.setForeground(new java.awt.Color(51, 51, 51));
        comboxMonitores.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboxMonitoresItemStateChanged(evt);
            }
        });
        comboxMonitores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboxMonitoresActionPerformed(evt);
            }
        });
        getContentPane().add(comboxMonitores, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 140, -1));

        btnLista.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        btnLista.setForeground(new java.awt.Color(51, 51, 51));
        btnLista.setText("Lista");
        btnLista.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, null, new java.awt.Color(102, 102, 102)));
        btnLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaActionPerformed(evt);
            }
        });
        getContentPane().add(btnLista, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 140, -1));

        btnEliminar.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(51, 51, 51));
        btnEliminar.setText("Eliminar");
        btnEliminar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, null, new java.awt.Color(102, 102, 102)));
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 140, -1));

        btnModificar.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        btnModificar.setForeground(new java.awt.Color(51, 51, 51));
        btnModificar.setText("Modificar");
        btnModificar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, null, new java.awt.Color(102, 102, 102)));
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        getContentPane().add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 140, -1));

        btnSeleccionar.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        btnSeleccionar.setForeground(new java.awt.Color(51, 51, 51));
        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, null, new java.awt.Color(102, 102, 102)));
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });
        getContentPane().add(btnSeleccionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 140, -1));

        txtDireccion.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        txtDireccion.setForeground(new java.awt.Color(51, 51, 51));
        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });
        getContentPane().add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 160, 260, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 3, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 51, 0));
        jLabel4.setText("Fecha de Nacimiento");
        jLabel4.setToolTipText("");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, 180, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 3, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 0));
        jLabel3.setText("Correo");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 290, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 3, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 51, 0));
        jLabel5.setText("Direccion");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, -1, -1));

        btnVolver.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        btnVolver.setForeground(new java.awt.Color(51, 51, 51));
        btnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/volver.png"))); // NOI18N
        btnVolver.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, null, new java.awt.Color(102, 102, 102)));
        btnVolver.setPreferredSize(new java.awt.Dimension(68, 20));
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        getContentPane().add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 70, 20));

        txtCorreo.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        txtCorreo.setForeground(new java.awt.Color(51, 51, 51));
        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });
        getContentPane().add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 290, 260, -1));

        txtFechadeNacimiento.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        txtFechadeNacimiento.setForeground(new java.awt.Color(51, 51, 51));
        txtFechadeNacimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechadeNacimientoActionPerformed(evt);
            }
        });
        getContentPane().add(txtFechadeNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 200, 260, -1));

        btnLimpiar.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        btnLimpiar.setForeground(new java.awt.Color(51, 51, 51));
        btnLimpiar.setText("Limpiar");
        btnLimpiar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, null, new java.awt.Color(102, 102, 102)));
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 340, 450, -1));

        txtNombre.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(51, 51, 51));
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 110, 260, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 3, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 51, 0));
        jLabel6.setText("Nombre");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, -1, -1));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 0));
        jLabel1.setText("MONITORES");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 3, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 51, 0));
        jLabel7.setText("ID");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 20, -1));

        txtId.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        txtId.setForeground(new java.awt.Color(51, 51, 51));
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });
        getContentPane().add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 60, 260, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 3, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 51, 0));
        jLabel8.setText("Telefono");
        jLabel8.setToolTipText("");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 240, -1, -1));

        txtTelefono.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        txtTelefono.setForeground(new java.awt.Color(51, 51, 51));
        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });
        getContentPane().add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 240, 260, -1));

        btnCrear.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        btnCrear.setForeground(new java.awt.Color(51, 51, 51));
        btnCrear.setText("Crear");
        btnCrear.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, null, new java.awt.Color(102, 102, 102)));
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });
        getContentPane().add(btnCrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 140, -1));

        txtFondo.setBackground(new java.awt.Color(255, 255, 255));
        txtFondo.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        txtFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/Fondo insmo.jpg"))); // NOI18N
        getContentPane().add(txtFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-610, 0, 1370, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboxMonitoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboxMonitoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboxMonitoresActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarActionPerformed

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoActionPerformed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
      limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void comboxMonitoresItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboxMonitoresItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_comboxMonitoresItemStateChanged

    private void txtFechadeNacimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechadeNacimientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechadeNacimientoActionPerformed

    private void btnListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnListaActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed

    }//GEN-LAST:event_btnVolverActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCrearActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCrear;
    public javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnLimpiar;
    public javax.swing.JButton btnLista;
    public javax.swing.JButton btnModificar;
    public javax.swing.JButton btnSeleccionar;
    public javax.swing.JButton btnVolver;
    public javax.swing.JComboBox<String> comboxMonitores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    public javax.swing.JTextField txtCorreo;
    public javax.swing.JTextField txtDireccion;
    public javax.swing.JTextField txtFechadeNacimiento;
    private javax.swing.JLabel txtFondo;
    public javax.swing.JTextField txtId;
    public javax.swing.JTextField txtNombre;
    public javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
//Imagen de fondo// End of variables declaration                   
//Imagen de fondo

   public void limpiar() {//Acción boton limpiar
       txtId.setText(""); 
       txtNombre.setText(""); 
       txtDireccion.setText("");
       txtFechadeNacimiento.setText("");
       txtTelefono.setText(""); 
       txtCorreo.setText("");
       txtId.setEditable(true);
    }
   public void error(String txt){
       JOptionPane.showMessageDialog(null, txt, "Error",JOptionPane.ERROR_MESSAGE);
   }

   public void errorConsola(String txt){
       System.out.print(txt);
   }
    public void msg(String txt){
       JOptionPane.showMessageDialog(null, txt, "Eliminada",JOptionPane.INFORMATION_MESSAGE);
   }
    
    
   
}
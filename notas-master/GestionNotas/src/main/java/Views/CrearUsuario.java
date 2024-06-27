/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import Controllers.CursosController;
import Controllers.TiposDocsController;
import Controllers.UsuarioController;
import Helpers.CursosCBox;
import Models.TiposDocsModel;
import Models.UsuarioModel;
import java.util.Date;
import Views.Profesor.VerProfesores;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author NEW PC MDMS
 */
public class CrearUsuario extends javax.swing.JFrame {

    private int _perfil_alumno_id = 3;
    private Date _fechaNacimiento;
    private String _nombres, _apellidos, _direccion, _email, _telefono, _password, _confirPass, _n_doc, _title_modal;
    private int _idusuario, _id_tipo_doc, _idPerfilNewUsuario, _tipo_accion, _curso_id, _old_curso_id;
    private JTable tableDinamica;

    /**
     * Creates new form
     */
    public CrearUsuario() {
        initComponents();
        lblCurso.setVisible(false);
        cbxCursos.setVisible(false);

        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Date actual = new Date();
        jDFechaNacimiento.setDate(actual);

        TiposDocsController tipoDoc = new TiposDocsController();
        tipoDoc.loadData(jCTipoDocumento);

        CursosController cursosController = new CursosController();
        cursosController.loadDataCBox(cbxCursos);

        jCTipoDocumento.addActionListener(e -> {
            TiposDocsModel selectedTipo = (TiposDocsModel) jCTipoDocumento.getSelectedItem();
            if (selectedTipo != null) {
                _id_tipo_doc = selectedTipo.getId();
            }
        });

        cbxCursos.addActionListener(e -> {
            CursosCBox selectedTipo = (CursosCBox) cbxCursos.getSelectedItem();
            if (selectedTipo != null) {
                _curso_id = selectedTipo.getId();
            }
        });
    }

    public void infoCampos(UsuarioModel usuario, int perfilNewUsuario, int tipoAccion, JTable table, int cursoId) {
        _old_curso_id = cursoId;
        this._curso_id = cursoId;
        this.tableDinamica = table;
        this._idPerfilNewUsuario = perfilNewUsuario;
        _tipo_accion = tipoAccion;
        String accion = "";

        if (_tipo_accion == 1) {

            btnGuardar.setText("Guardar");
            accion = "CREAR";

            txtNombres.setText("");
            txtApellidos.setText("");
            txtDNI.setText("");
            txtDireccion.setText("");
            txtEmail.setText("");
            txtTelefono.setText("");
            jDFechaNacimiento.setDate(new Date());

            jCTipoDocumento.setSelectedIndex(0);
            cbxCursos.setSelectedIndex(0);
        } else {
            btnGuardar.setText("Actualizar");
            accion = "EDITAR";

            _idusuario = usuario.getIdUsuario();
            txtNombres.setText(usuario.getNombres());
            txtApellidos.setText(usuario.getApellidos());
            txtDNI.setText(usuario.getN_doc());
            txtDireccion.setText(usuario.getDireccion());
            txtEmail.setText(usuario.getEmail());
            txtTelefono.setText(usuario.getTelefono());
            jDFechaNacimiento.setDate(usuario.getFecha_nacimiento());

            jCTipoDocumento.setSelectedIndex(usuario.getId_tipo_doc());

        }

        switch (_idPerfilNewUsuario) {
            case 1:
                //RECTOR
                _title_modal = accion + " RECTOR";
                break;
            case 2:
                //usuario
                _title_modal = accion + " PROFESOR";
                break;
            default:
                //ALUMNO
                _title_modal = accion + " ALUMNO";

                break;
        }

        if (perfilNewUsuario == _perfil_alumno_id) {
            lblCurso.setVisible(true);
            cbxCursos.setVisible(true);
        }

        if (usuario != null) {
            CursosCBox cursoBox = new CursosCBox(usuario.getId_curso(), usuario.getNom_curso());
            cbxCursos.setSelectedItem(cursoBox);
        }

        jLTitulo.setText(_title_modal);
        setTitle(_title_modal);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        txtNombres = new javax.swing.JTextField();
        txtDNI = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtClave = new javax.swing.JPasswordField();
        jLTitulo = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtConfirClave = new javax.swing.JPasswordField();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jDFechaNacimiento = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        jCTipoDocumento = new javax.swing.JComboBox<>();
        lblCurso = new javax.swing.JLabel();
        cbxCursos = new javax.swing.JComboBox<>();
        btnEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Nombres");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Apellidos");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("No. Documento");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Dirección");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Email");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Telefono");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Clave");

        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        jLTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLTitulo.setText("CREAR PROFESOR");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Confirmar Clave");

        btnGuardar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Fecha Nacimiento");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Tipo de Documento");

        lblCurso.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCurso.setText("Curso");

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel8)
                                    .addComponent(lblCurso))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cbxCursos, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jDFechaNacimiento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jCTipoDocumento, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLTitulo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                                    .addComponent(txtNombres, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtClave, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(69, 69, 69)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtApellidos)
                            .addComponent(txtTelefono)
                            .addComponent(txtConfirClave)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel2))
                            .addComponent(txtDNI, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLTitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtConfirClave, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(lblCurso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxCursos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        _fechaNacimiento = jDFechaNacimiento.getDate();
        _nombres = txtNombres.getText();
        _apellidos = txtApellidos.getText();
        _n_doc = txtDNI.getText();
        _direccion = txtDireccion.getText();
        _email = txtEmail.getText();
        _telefono = txtTelefono.getText();
        _password = new String(txtClave.getPassword());
        _confirPass = new String(txtConfirClave.getPassword());

        String[] fields = {_nombres, _apellidos, _n_doc, _direccion, _email, _telefono, _fechaNacimiento.toString()};
        boolean campoVacio = java.util.Arrays.stream(fields).anyMatch(String::isEmpty);
        if (campoVacio) {
            JOptionPane.showMessageDialog(null, "¡Hay campos vacíos!", "Error", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if (_id_tipo_doc == 0) {
            JOptionPane.showMessageDialog(null, "¡Seleccione el tipo de documento!", "Error", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if (_n_doc.length() > 12) {
            JOptionPane.showMessageDialog(null, "¡El numero de documento debe tener maximo 12 caracteres!", "Error", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if (_telefono.length() > 12) {
            JOptionPane.showMessageDialog(null, "¡El numero de telefono debe tener maximo 12 caracteres!", "Error", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if (!_confirPass.equals(_password)) {
            JOptionPane.showMessageDialog(null, "¡No coinciden las contraseñas!", "Error", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if (_idPerfilNewUsuario == _perfil_alumno_id) {

            if (_curso_id == 0) {
                JOptionPane.showMessageDialog(null, "¡Seleccione un curso!", "Error", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }

        UsuarioModel usuario = new UsuarioModel();
        usuario.setNombres(_nombres);
        usuario.setApellidos(_apellidos);
        usuario.setFecha_nacimiento(_fechaNacimiento);
        usuario.setId_tipo_doc(_id_tipo_doc);
        usuario.setN_doc(_n_doc);
        usuario.setDireccion(_direccion);
        usuario.setEmail(_email);
        usuario.setTelefono(_telefono);
        usuario.setPassword(_password);
        usuario.setFecha_nacimiento(_fechaNacimiento);
        usuario.setId_perfil(_idPerfilNewUsuario);
        usuario.setId_curso(_curso_id);

        UsuarioController controller = new UsuarioController();

        if (_tipo_accion == 1) {
            //CREAR
            String[] fieldsPass = {_password, _confirPass};
            boolean passVacia = java.util.Arrays.stream(fieldsPass).anyMatch(String::isEmpty);
            if (passVacia) {
                JOptionPane.showMessageDialog(null, "¡Hay campos vacíos!", "Error", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            boolean esGuardado = controller.crearUsuario(usuario, _curso_id);
            if (!esGuardado) {
                return;
            }
        } else {
            //EDITAR
            usuario.setIdUsuario(_idusuario);
            boolean esActualizado = controller.actualizarUsuario(usuario);
            if (!esActualizado) {
                return;
            }
        }
        dispose();
        controller.obtenerUsuariosPerfil(_idPerfilNewUsuario, this.tableDinamica, _old_curso_id);

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int res = JOptionPane.showConfirmDialog(null, "¿Desea eliminar este registro?", "Eliminar", JOptionPane.YES_NO_OPTION);
        if (res == 0) {
            UsuarioController controller = new UsuarioController();
            boolean esEliminado = controller.eliminarUsuario(_idusuario);
            if (esEliminado) {
                controller.obtenerUsuariosPerfil(_idPerfilNewUsuario, this.tableDinamica, _old_curso_id);
                dispose();
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

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
            java.util.logging.Logger.getLogger(CrearUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrearUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cbxCursos;
    private javax.swing.JComboBox<String> jCTipoDocumento;
    private com.toedter.calendar.JDateChooser jDFechaNacimiento;
    private javax.swing.JLabel jLTitulo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblCurso;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JPasswordField txtClave;
    private javax.swing.JPasswordField txtConfirClave;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
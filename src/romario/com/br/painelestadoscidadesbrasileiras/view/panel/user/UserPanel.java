package romario.com.br.painelestadoscidadesbrasileiras.view.panel.user;

import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;

import romario.com.br.painelestadoscidadesbrasileiras.controller.user.UserGetAllController;
import romario.com.br.painelestadoscidadesbrasileiras.controller.user.UserSaveController;
import romario.com.br.painelestadoscidadesbrasileiras.controller.user.UserUpdateController;
import romario.com.br.painelestadoscidadesbrasileiras.domain.Page;
import romario.com.br.painelestadoscidadesbrasileiras.domain.ResponseInterface;
import romario.com.br.painelestadoscidadesbrasileiras.domain.dto.ErrorDTO;
import romario.com.br.painelestadoscidadesbrasileiras.domain.dto.UserDTO;
import romario.com.br.painelestadoscidadesbrasileiras.domain.form.UserForm;
import romario.com.br.painelestadoscidadesbrasileiras.shared.Util;
import romario.com.br.painelestadoscidadesbrasileiras.view.dialog.DialogView;

/**
 *
 * @author Romario
 */
public class UserPanel extends javax.swing.JPanel {

    private final Util util;

    private int page = 0;
    private Page<UserDTO> pageUser;
    private ResponseInterface response;

    private DefaultTableModel model;
    private int selectedRow;

    private Long idUser = null;
    private Long idProfile = null;

    public UserPanel() {
        initComponents();
        buttonSalvar.setEnabled(true);
        buttonAlterar.setEnabled(false);

        this.util = new Util();

        java.awt.EventQueue.invokeLater(() -> {
            getAllUsers(this);
        });
    }

    private void getAllUsers(UserPanel userPanel) {

        new SwingWorker<Void, Void>() {

            @Override
            protected Void doInBackground() {

                util.qualPanelExibir(jPanelLoading, userPanel);

                UserGetAllController userGetAllController = new UserGetAllController();

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }

                pageUser = userGetAllController.getAllUsers(page);

                return null;
            }

            @Override
            protected void done() {
                util.qualPanelExibir(jPanelSaveUser, userPanel);

                if (pageUser != null) {
                    model = (DefaultTableModel) jTable1.getModel();
                    jTable1.setRowHeight(30);

                    pageUser.getListDto().forEach(obj -> {
                        model.addRow(new Object[]{
                            obj.getId(),
                            obj.getName(),
                            obj.getEmail(),
                            obj.getProfile().getId(),
                            obj.getProfile().getProfileType()
                        });
                    });

                    util.zebrarTable(jTable1);
                }
            }
        }.execute();
    }

    private void save(UserPanel userPanel) {

        new SwingWorker<Void, Void>() {

            @Override
            protected Void doInBackground() {

                util.qualPanelExibir(jPanelLoading, userPanel);

                UserSaveController userSaveController = new UserSaveController();

                response = userSaveController.save(getForm(
                        jTextFieldNomeUsuario.getText().trim(),
                        jTextFieldEmail.getText().trim(),
                        jTextFieldSenha.getText().trim()
                ));

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }

                return null;
            }

            @Override
            protected void done() {
                util.qualPanelExibir(jPanelSaveUser, userPanel);

                if (response instanceof UserDTO) {
                    UserDTO userDTO = (UserDTO) response;

                    model = (DefaultTableModel) jTable1.getModel();
                    jTable1.setRowHeight(30);

                    model.addRow(new Object[]{
                        userDTO.getId(),
                        userDTO.getName(),
                        userDTO.getEmail(),
                        userDTO.getProfile().getId(),
                        userDTO.getProfile().getProfileType()
                    });

                    util.zebrarTable(jTable1);

                    clearFields();

                    DialogView dialog
                            = new DialogView(null,
                                    false,
                                    "/romario/com/br/painelestadoscidadesbrasileiras/assets/icon_success.png",
                                    "Sucesso",
                                    "Dados inseridos com Sucesso!",
                                    23,
                                    178,
                                    135
                            );

                    dialog.setVisible(true);
                } else if (response instanceof ErrorDTO) {
                    ErrorDTO errorDTO = (ErrorDTO) response;

                    DialogView dialog
                            = new DialogView(null,
                                    false,
                                    "/romario/com/br/painelestadoscidadesbrasileiras/assets/icon_warning.png",
                                    "Oops...",
                                    errorDTO.getMessage(),
                                    255,
                                    0,
                                    0
                            );

                    dialog.setVisible(true);
                } else {
                    DialogView dialog
                            = new DialogView(null,
                                    false,
                                    "/romario/com/br/painelestadoscidadesbrasileiras/assets/icon_warning.png",
                                    "Oops...",
                                    "Houve algum error inesperado!",
                                    255,
                                    200,
                                    0
                            );

                    dialog.setVisible(true);
                }
            }
        }.execute();
    }

    private void update(UserPanel userPanel) {

        new SwingWorker<Void, Void>() {

            @Override
            protected Void doInBackground() {

                util.qualPanelExibir(jPanelLoading, userPanel);

                UserUpdateController userUpdateController = new UserUpdateController();

                response = userUpdateController.update(
                        idUser,
                        idProfile,
                        getForm(
                                jTextFieldNomeUsuario.getText().trim().isEmpty() ? null : jTextFieldNomeUsuario.getText().trim(),
                                jTextFieldEmail.getText().trim().isEmpty() ? null : jTextFieldNomeUsuario.getText().trim(),
                                jTextFieldSenha.getText().trim().isEmpty() ? null : jTextFieldSenha.getText().trim()
                        )
                );

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }

                return null;
            }

            @Override
            protected void done() {
                util.qualPanelExibir(jPanelSaveUser, userPanel);

                if (response instanceof UserDTO) {
                    UserDTO userDTO = (UserDTO) response;

                    updateTable(userDTO);

                    clearFields();

                    DialogView dialog
                            = new DialogView(null,
                                    false,
                                    "/romario/com/br/painelestadoscidadesbrasileiras/assets/icon_success.png",
                                    "Sucesso",
                                    "Dados alteardos com Sucesso!",
                                    23,
                                    178,
                                    135
                            );

                    dialog.setVisible(true);
                } else if (response instanceof ErrorDTO) {
                    ErrorDTO errorDTO = (ErrorDTO) response;

                    DialogView dialog
                            = new DialogView(null,
                                    false,
                                    "/romario/com/br/painelestadoscidadesbrasileiras/assets/icon_warning.png",
                                    "Oops...",
                                    errorDTO.getMessage(),
                                    255,
                                    0,
                                    0
                            );

                    dialog.setVisible(true);
                } else {
                    DialogView dialog
                            = new DialogView(null,
                                    false,
                                    "/romario/com/br/painelestadoscidadesbrasileiras/assets/icon_warning.png",
                                    "Oops...",
                                    "Houve algum error inesperado!",
                                    255,
                                    200,
                                    0
                            );

                    dialog.setVisible(true);
                }
            }
        }.execute();
    }

    private UserForm getForm(String name, String email, String password) {
        UserForm userForm = new UserForm();
        userForm.setName(name);
        userForm.setEmail(email);
        userForm.setPassword(password);
        userForm.setCodProfile(getCodProfile());

        return userForm;
    }

    private int getCodProfile() {
        if (jRadioButtonAdmin.isSelected()) {
            return 1;
        } else {
            return 2;
        }
    }

    private void clearFields() {
        jTextFieldEmail.setText("");
        jTextFieldNomeUsuario.setText("");
        jTextFieldSenha.setText("");

        idUser = null;
        idProfile = null;

        buttonSalvar.setEnabled(true);
        buttonAlterar.setEnabled(false);
    }

    private void fillsFields() {
        jTextFieldEmail.setText(jTable1.getValueAt(jTable1.getSelectedRow(), jTable1.getColumn("E-MAIL").getModelIndex()).toString());
        jTextFieldNomeUsuario.setText(jTable1.getValueAt(jTable1.getSelectedRow(), jTable1.getColumn("NOME DO USUÁRIO").getModelIndex()).toString());

        idUser = Long.parseLong(jTable1.getValueAt(jTable1.getSelectedRow(), jTable1.getColumn("CÓDIGO").getModelIndex()).toString());
        idProfile = Long.parseLong(jTable1.getValueAt(jTable1.getSelectedRow(), jTable1.getColumn("COD PERFIL").getModelIndex()).toString());

        if (jTable1.getValueAt(jTable1.getSelectedRow(), jTable1.getColumn("PERFIL USUÁRIO").getModelIndex()).toString().equals("ADMIN")) {
            jRadioButtonAdmin.setSelected(true);
        } else {
            jRadioButtonCliente.setSelected(true);
        }
    }

    private void updateTable(UserDTO userDTO) {
        jTable1.setValueAt(userDTO.getName(), selectedRow, jTable1.getColumn("NOME DO USUÁRIO").getModelIndex());
        jTable1.setValueAt(userDTO.getEmail(), selectedRow, jTable1.getColumn("E-MAIL").getModelIndex());
        jTable1.setValueAt(userDTO.getProfile().getProfileType(), selectedRow, jTable1.getColumn("PERFIL USUÁRIO").getModelIndex());
    }

    //private get
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanelSaveUser = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldNomeUsuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldSenha = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        buttonSalvar = new javax.swing.JButton();
        buttonAlterar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jRadioButtonAdmin = new javax.swing.JRadioButton();
        jRadioButtonCliente = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanelLoading = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.CardLayout());

        jPanelSaveUser.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Nome do Usuário.:*");

        jTextFieldNomeUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("E-Mail.:*");

        jTextFieldEmail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Senha.:*");

        jTextFieldSenha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CÓDIGO", "NOME DO USUÁRIO", "E-MAIL", "COD PERFIL", "PERFIL USUÁRIO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(60);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(220);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(220);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(60);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(120);
        }

        buttonSalvar.setBackground(new java.awt.Color(76, 41, 211));
        buttonSalvar.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        buttonSalvar.setForeground(new java.awt.Color(255, 255, 255));
        buttonSalvar.setText("Salvar");
        buttonSalvar.setToolTipText("Clique aqui para salvar um usuário");
        buttonSalvar.setBorderPainted(false);
        buttonSalvar.setContentAreaFilled(false);
        buttonSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonSalvar.setFocusPainted(false);
        buttonSalvar.setOpaque(true);
        buttonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSalvarActionPerformed(evt);
            }
        });

        buttonAlterar.setBackground(new java.awt.Color(76, 41, 211));
        buttonAlterar.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        buttonAlterar.setForeground(new java.awt.Color(255, 255, 255));
        buttonAlterar.setText("Alterar");
        buttonAlterar.setToolTipText("Clique aqui para alterar usuário");
        buttonAlterar.setBorderPainted(false);
        buttonAlterar.setContentAreaFilled(false);
        buttonAlterar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonAlterar.setFocusPainted(false);
        buttonAlterar.setOpaque(true);
        buttonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAlterarActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Selecione o perfil do funcionário", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jRadioButtonAdmin.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jRadioButtonAdmin);
        jRadioButtonAdmin.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jRadioButtonAdmin.setSelected(true);
        jRadioButtonAdmin.setText("ADMIN");

        jRadioButtonCliente.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jRadioButtonCliente);
        jRadioButtonCliente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jRadioButtonCliente.setText("CLIENTE");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioButtonAdmin)
                .addGap(18, 18, 18)
                .addComponent(jRadioButtonCliente)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonAdmin)
                    .addComponent(jRadioButtonCliente))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Campos com * são obrigatórios para salvar.");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("OBS: Para alterar você pode deixar em branco os campos que não forem necessários.\n");

        javax.swing.GroupLayout jPanelSaveUserLayout = new javax.swing.GroupLayout(jPanelSaveUser);
        jPanelSaveUser.setLayout(jPanelSaveUserLayout);
        jPanelSaveUserLayout.setHorizontalGroup(
            jPanelSaveUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSaveUserLayout.createSequentialGroup()
                .addGroup(jPanelSaveUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelSaveUserLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(buttonSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonAlterar))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelSaveUserLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanelSaveUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldSenha, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldEmail, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldNomeUsuario)
                            .addComponent(jScrollPane1)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(19, 19, 19))
        );

        jPanelSaveUserLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {buttonAlterar, buttonSalvar});

        jPanelSaveUserLayout.setVerticalGroup(
            jPanelSaveUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSaveUserLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelSaveUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonAlterar)
                    .addComponent(buttonSalvar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanelSaveUser, "card13");

        jPanelLoading.setBackground(new java.awt.Color(255, 255, 255));
        jPanelLoading.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/romario/com/br/painelestadoscidadesbrasileiras/assets/Eclipse-1s-256px.gif"))); // NOI18N

        javax.swing.GroupLayout jPanelLoadingLayout = new javax.swing.GroupLayout(jPanelLoading);
        jPanelLoading.setLayout(jPanelLoadingLayout);
        jPanelLoadingLayout.setHorizontalGroup(
            jPanelLoadingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLoadingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelLoadingLayout.setVerticalGroup(
            jPanelLoadingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLoadingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 645, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(jPanelLoading, "card14");
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSalvarActionPerformed
        if (jTextFieldNomeUsuario.getText().isEmpty()) {
            return;
        }

        if (jTextFieldEmail.getText().isEmpty()) {
            return;
        }

        if (jTextFieldSenha.getText().isEmpty()) {
            return;
        }

        java.awt.EventQueue.invokeLater(() -> {
            save(this);
        });
    }//GEN-LAST:event_buttonSalvarActionPerformed

    private void buttonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAlterarActionPerformed
        if (idUser == null && idProfile == null) {
            DialogView dialog
                    = new DialogView(null,
                            false,
                            "/romario/com/br/painelestadoscidadesbrasileiras/assets/icon_warning.png",
                            "Oops...",
                            "Você deve selecionar um usuário antes de alterar!",
                            255,
                            200,
                            0
                    );

            dialog.setVisible(true);
        } else {
            java.awt.EventQueue.invokeLater(() -> {
                update(this);
            });
        }
    }//GEN-LAST:event_buttonAlterarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if (evt.getClickCount() == 2) {
            buttonSalvar.setEnabled(false);
            buttonAlterar.setEnabled(true);

            this.selectedRow = jTable1.getSelectedRow();

            fillsFields();
        }
    }//GEN-LAST:event_jTable1MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAlterar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton buttonSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelLoading;
    private javax.swing.JPanel jPanelSaveUser;
    private javax.swing.JRadioButton jRadioButtonAdmin;
    private javax.swing.JRadioButton jRadioButtonCliente;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldNomeUsuario;
    private javax.swing.JTextField jTextFieldSenha;
    // End of variables declaration//GEN-END:variables
}

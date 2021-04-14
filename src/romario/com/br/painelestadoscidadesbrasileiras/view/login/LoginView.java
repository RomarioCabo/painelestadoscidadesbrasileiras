package romario.com.br.painelestadoscidadesbrasileiras.view.login;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingWorker;
import romario.com.br.painelestadoscidadesbrasileiras.controller.login.LoginController;
import romario.com.br.painelestadoscidadesbrasileiras.domain.ResponseInterface;
import romario.com.br.painelestadoscidadesbrasileiras.domain.dto.ErrorDTO;
import romario.com.br.painelestadoscidadesbrasileiras.domain.dto.UserDTO;
import romario.com.br.painelestadoscidadesbrasileiras.domain.form.LoginForm;

/**
 *
 * @author Romario
 */
public class LoginView extends javax.swing.JFrame {

    private ResponseInterface response;

    public LoginView() {
        initComponents();

        jTextFieldEmail.setText("romariocabo2012@gmail.com");
        jPasswordFieldSenha.setText("123");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelParent = new javax.swing.JPanel();
        jPanelLogin = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPasswordFieldSenha = new javax.swing.JPasswordField();
        jButtonLogar = new javax.swing.JButton();
        jPanelLoading = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanelParent.setBackground(new java.awt.Color(255, 255, 255));
        jPanelParent.setForeground(new java.awt.Color(255, 255, 255));
        jPanelParent.setLayout(new java.awt.CardLayout());

        jPanelLogin.setBackground(new java.awt.Color(255, 255, 255));
        jPanelLogin.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Efetuar Login no Sistema");

        jLabel2.setText("E-mail.:");

        jLabel3.setText("Password.:");

        jButtonLogar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButtonLogar.setText("Entrar");
        jButtonLogar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonLogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelLoginLayout = new javax.swing.GroupLayout(jPanelLogin);
        jPanelLogin.setLayout(jPanelLoginLayout);
        jPanelLoginLayout.setHorizontalGroup(
            jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLoginLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanelLoginLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonLogar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextFieldEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addComponent(jPasswordFieldSenha)))
                        .addContainerGap(18, Short.MAX_VALUE))))
        );

        jPanelLoginLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel2, jPasswordFieldSenha, jTextFieldEmail});

        jPanelLoginLayout.setVerticalGroup(
            jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordFieldSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jButtonLogar)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanelLoginLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel2, jPasswordFieldSenha, jTextFieldEmail});

        jPanelParent.add(jPanelLogin, "card8");

        jPanelLoading.setBackground(new java.awt.Color(255, 255, 255));
        jPanelLoading.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Verificando suas credências");

        javax.swing.GroupLayout jPanelLoadingLayout = new javax.swing.GroupLayout(jPanelLoading);
        jPanelLoading.setLayout(jPanelLoadingLayout);
        jPanelLoadingLayout.setHorizontalGroup(
            jPanelLoadingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLoadingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelLoadingLayout.setVerticalGroup(
            jPanelLoadingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLoadingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanelParent.add(jPanelLoading, "card3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelParent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelParent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogarActionPerformed
        java.awt.EventQueue.invokeLater(() -> {
            authenticate();
        });
    }//GEN-LAST:event_jButtonLogarActionPerformed

    private void authenticate() {

        new SwingWorker<Void, Void>() {

            @Override
            protected Void doInBackground() {

                qualPanelExibir(jPanelLoading, jPanelParent);

                LoginController loginController = new LoginController();

                response = loginController.authenticate(getLoginForm(jTextFieldEmail.getText().trim(), new String(jPasswordFieldSenha.getPassword()).trim()));

                return null;
            }

            @Override
            protected void done() {
                qualPanelExibir(jPanelLogin, jPanelParent);

                if (response instanceof UserDTO) {
                    UserDTO userDTO = (UserDTO) response;

                    JOptionPane.showMessageDialog(null, userDTO.getId() + "\n"
                            + userDTO.getName() + "\n"
                            + userDTO.getEmail() + "\n"
                            + userDTO.getProfile() + "\n"
                            + userDTO.getToken(), "Sucesso", JOptionPane.PLAIN_MESSAGE);
                } else if (response instanceof ErrorDTO) {
                    ErrorDTO errorDTO = (ErrorDTO) response;

                    JOptionPane.showMessageDialog(null, errorDTO.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Houve algum erro não esperado", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        }.execute();
    }

    public void qualPanelExibir(JPanel panelAdiconar, JPanel panelPai) {
        panelPai.removeAll();
        panelPai.add(panelAdiconar);
        panelPai.repaint();
        panelPai.revalidate();
    }

    private LoginForm getLoginForm(String email, String senha) {
        LoginForm loginForm = new LoginForm();
        loginForm.setEmail(email);
        loginForm.setPassword(senha);

        return loginForm;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLogar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanelLoading;
    private javax.swing.JPanel jPanelLogin;
    private javax.swing.JPanel jPanelParent;
    private javax.swing.JPasswordField jPasswordFieldSenha;
    private javax.swing.JTextField jTextFieldEmail;
    // End of variables declaration//GEN-END:variables
}

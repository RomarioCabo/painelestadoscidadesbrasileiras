package romario.com.br.painelestadoscidadesbrasileiras.view.login;

import javax.swing.SwingWorker;
import romario.com.br.painelestadoscidadesbrasileiras.controller.login.LoginController;
import romario.com.br.painelestadoscidadesbrasileiras.domain.ResponseInterface;
import romario.com.br.painelestadoscidadesbrasileiras.domain.dto.ErrorDTO;
import romario.com.br.painelestadoscidadesbrasileiras.domain.AuthenticatedUser;
import romario.com.br.painelestadoscidadesbrasileiras.domain.form.LoginForm;
import romario.com.br.painelestadoscidadesbrasileiras.shared.Util;
import romario.com.br.painelestadoscidadesbrasileiras.view.dialog.DialogView;
import romario.com.br.painelestadoscidadesbrasileiras.view.home.ViewHome;

public class LoginView extends javax.swing.JFrame {

    private int xx, xy;

    private final Util util;

    private ResponseInterface response;

    public LoginView() {
        initComponents();

        this.textFieldEmail.setText("romariocabo2012@gmail.com");
        this.textFieldSenha.setText("123");

        this.util = new Util();
        this.util.setLogo("/romario/com/br/painelestadoscidadesbrasileiras/assets/cidade.jpg", labelLogo);

        this.exibirMenssagemCampoObrigatorioUsuario(false);
        this.exibirMenssagemCampoObrigatorioSenha(false);
    }

    /**
     * Métdo reponsável por exibir o label labelMensagemUsuario caso seja true
     *
     * @param exibirMensagem booleano para exibir a mensagem
     * @return Void.class
     */
    private void exibirMenssagemCampoObrigatorioUsuario(boolean exibirMensagem) {
        if (!exibirMensagem) {
            labelMensagemUsuario.setText("");
        } else {
            labelMensagemUsuario.setText("Campo obrigatório");
        }
    }

    /**
     * Métdo reponsável por exibir o label labelMensagemSenha caso seja true
     *
     * @param exibirMensagem booleano para exibir a mensagem
     * @return Void.class
     */
    private void exibirMenssagemCampoObrigatorioSenha(boolean exibirMensagem) {
        if (!exibirMensagem) {
            labelMensagemSenha.setText("");
        } else {
            labelMensagemSenha.setText("Campo obrigatório");
        }
    }

    /**
     * Métdo reponsável por efetuar o login no sistema, verificando se os campos
     * obrigatórios estão preenchidos.
     */
    private void efetuarLogin() {
        if (textFieldEmail.getText().isEmpty() && textFieldSenha.getPassword().length == 0) {
            exibirMenssagemCampoObrigatorioUsuario(true);
            exibirMenssagemCampoObrigatorioSenha(true);

            textFieldEmail.requestFocus();
        } else if (textFieldEmail.getText().isEmpty()) {
            exibirMenssagemCampoObrigatorioUsuario(true);
            exibirMenssagemCampoObrigatorioSenha(false);

            textFieldEmail.requestFocus();
        } else if (textFieldSenha.getPassword().length == 0) {
            exibirMenssagemCampoObrigatorioUsuario(false);
            exibirMenssagemCampoObrigatorioSenha(true);

            textFieldSenha.requestFocus();
        } else {
            java.awt.EventQueue.invokeLater(() -> {
                authenticate(this);
            });
        }
    }

    private void authenticate(LoginView loginView) {

        new SwingWorker<Void, Void>() {

            @Override
            protected Void doInBackground() {

                util.qualPanelExibir(panelLoading, panelPai);

                LoginController loginController = new LoginController();

                response = loginController.authenticate(getLoginForm(textFieldEmail.getText().trim(), new String(textFieldSenha.getPassword()).trim()));

                return null;
            }

            @Override
            protected void done() {
                if (response instanceof AuthenticatedUser) {
                    AuthenticatedUser userDTO = (AuthenticatedUser) response;

                    ViewHome viewHome = new ViewHome();
                    viewHome.setVisible(true);

                    loginView.dispose();
                } else if (response instanceof ErrorDTO) {
                    util.qualPanelExibir(panelLogin, panelPai);

                    ErrorDTO errorDTO = (ErrorDTO) response;

                    DialogView dialog
                            = new DialogView(loginView,
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
                            = new DialogView(loginView,
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPai = new javax.swing.JPanel();
        panelLogin = new javax.swing.JPanel();
        labelLogo = new javax.swing.JLabel();
        labelTitulo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        textFieldEmail = new javax.swing.JTextField();
        separetorUsuario = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        textFieldSenha = new javax.swing.JPasswordField();
        separetorSenha = new javax.swing.JSeparator();
        labelMensagemUsuario = new javax.swing.JLabel();
        labelMensagemSenha = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        buttonEntrar = new javax.swing.JButton();
        labelFechar = new javax.swing.JLabel();
        panelLoading = new javax.swing.JPanel();
        labelLoading = new javax.swing.JLabel();
        labelTexto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        panelPai.setBackground(java.awt.Color.white);
        panelPai.setLayout(new java.awt.CardLayout());

        panelLogin.setBackground(java.awt.Color.white);

        labelTitulo.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        labelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitulo.setText("Login");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/romario/com/br/painelestadoscidadesbrasileiras/assets/contacts_18px.png"))); // NOI18N

        textFieldEmail.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        textFieldEmail.setToolTipText("Digite seu usuário");
        textFieldEmail.setBorder(null);

        separetorUsuario.setForeground(new java.awt.Color(0, 0, 0));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/romario/com/br/painelestadoscidadesbrasileiras/assets/unlock_18px.png"))); // NOI18N

        textFieldSenha.setFont(new java.awt.Font("Carlito", 0, 16)); // NOI18N
        textFieldSenha.setToolTipText("Digite sua senha");
        textFieldSenha.setBorder(null);

        separetorSenha.setForeground(new java.awt.Color(0, 0, 0));

        labelMensagemUsuario.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        labelMensagemUsuario.setForeground(java.awt.Color.red);
        labelMensagemUsuario.setText("Campo obrtigatório");

        labelMensagemSenha.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        labelMensagemSenha.setForeground(java.awt.Color.red);
        labelMensagemSenha.setText("Campo obrtigatório");

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Copyright © 2020. Todos os Direitos Reservados");

        buttonEntrar.setBackground(new java.awt.Color(76, 41, 211));
        buttonEntrar.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        buttonEntrar.setForeground(new java.awt.Color(255, 255, 255));
        buttonEntrar.setText("Entrar");
        buttonEntrar.setToolTipText("Clique aqui para ter acesso ao sitema");
        buttonEntrar.setBorderPainted(false);
        buttonEntrar.setContentAreaFilled(false);
        buttonEntrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonEntrar.setFocusPainted(false);
        buttonEntrar.setOpaque(true);
        buttonEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEntrarActionPerformed(evt);
            }
        });

        labelFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/romario/com/br/painelestadoscidadesbrasileiras/assets/icons8_Multiply_18px.png"))); // NOI18N
        labelFechar.setToolTipText("Fechar");
        labelFechar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelFechar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelFecharMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelLoginLayout = new javax.swing.GroupLayout(panelLogin);
        panelLogin.setLayout(panelLoginLayout);
        panelLoginLayout.setHorizontalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonEntrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelLoginLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelMensagemUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panelLoginLayout.createSequentialGroup()
                                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(textFieldEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                                    .addComponent(separetorUsuario, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(0, 17, Short.MAX_VALUE))))
                    .addGroup(panelLoginLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelMensagemSenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panelLoginLayout.createSequentialGroup()
                                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textFieldSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(separetorSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(panelLoginLayout.createSequentialGroup()
                        .addComponent(labelFechar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(labelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelLoginLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {separetorSenha, separetorUsuario, textFieldEmail, textFieldSenha});

        panelLoginLayout.setVerticalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelFechar)
                .addGap(24, 24, 24)
                .addComponent(labelTitulo)
                .addGap(18, 18, 18)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(textFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separetorUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelMensagemUsuario)
                .addGap(29, 29, 29)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(textFieldSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(separetorSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelMensagemSenha)
                .addGap(65, 65, 65)
                .addComponent(buttonEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addContainerGap())
            .addComponent(labelLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panelPai.add(panelLogin, "card2");

        panelLoading.setBackground(java.awt.Color.white);
        panelLoading.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));

        labelLoading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelLoading.setIcon(new javax.swing.ImageIcon(getClass().getResource("/romario/com/br/painelestadoscidadesbrasileiras/assets/Eclipse-1s-256px.gif"))); // NOI18N

        labelTexto.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        labelTexto.setForeground(new java.awt.Color(76, 41, 211));
        labelTexto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTexto.setText("Efetuando Login");
        labelTexto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelLoadingLayout = new javax.swing.GroupLayout(panelLoading);
        panelLoading.setLayout(panelLoadingLayout);
        panelLoadingLayout.setHorizontalGroup(
            panelLoadingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelLoading, javax.swing.GroupLayout.DEFAULT_SIZE, 798, Short.MAX_VALUE)
            .addGroup(panelLoadingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTexto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelLoadingLayout.setVerticalGroup(
            panelLoadingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoadingLayout.createSequentialGroup()
                .addComponent(labelLoading, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelTexto, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelPai.add(panelLoading, "card3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonEntrarActionPerformed(java.awt.event.ActionEvent evt) {
        efetuarLogin();
    }

    private void labelFecharMouseClicked(java.awt.event.MouseEvent evt) {
        System.exit(0);
    }

    private void formMousePressed(java.awt.event.MouseEvent evt) {
        xx = evt.getX();
        xy = evt.getY();
    }

    private void formMouseDragged(java.awt.event.MouseEvent evt) {
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        this.setLocation(x - xx, y - xy);
    }

    private LoginForm getLoginForm(String email, String senha) {
        LoginForm loginForm = new LoginForm();
        loginForm.setEmail(email);
        loginForm.setPassword(senha);

        return loginForm;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonEntrar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel labelFechar;
    private javax.swing.JLabel labelLoading;
    private javax.swing.JLabel labelLogo;
    private javax.swing.JLabel labelMensagemSenha;
    private javax.swing.JLabel labelMensagemUsuario;
    private javax.swing.JLabel labelTexto;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JPanel panelLoading;
    private javax.swing.JPanel panelLogin;
    private javax.swing.JPanel panelPai;
    private javax.swing.JSeparator separetorSenha;
    private javax.swing.JSeparator separetorUsuario;
    private javax.swing.JTextField textFieldEmail;
    private javax.swing.JPasswordField textFieldSenha;
    // End of variables declaration//GEN-END:variables
}

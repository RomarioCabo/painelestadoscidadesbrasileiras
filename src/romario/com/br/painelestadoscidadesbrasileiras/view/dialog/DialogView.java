package romario.com.br.painelestadoscidadesbrasileiras.view.dialog;

import romario.com.br.painelestadoscidadesbrasileiras.shared.Util;

/**
 *
 * @author Romário Cabó
 */
public class DialogView extends javax.swing.JDialog {

    public DialogView(java.awt.Frame parent, boolean modal, String caminhoFoto, String titulo, String body, int R, int G, int B) {
        super(parent, modal);
        initComponents();
        
        Util util = new Util();
        util.setLogo(caminhoFoto, labelIcone);

        labelTitulo.setText(titulo);
        labelBody.setText(body);
        jLabelFechar.setForeground(new java.awt.Color(R, G, B));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelTitulo = new javax.swing.JLabel();
        labelIcone = new javax.swing.JLabel();
        labelBody = new javax.swing.JLabel();
        jLabelFechar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        labelTitulo.setFont(new java.awt.Font("Century Gothic", 1, 22)); // NOI18N
        labelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitulo.setText("Oops...");

        labelIcone.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        labelBody.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        labelBody.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelBody.setText("Campo obrigatório");

        jLabelFechar.setFont(new java.awt.Font("Candara", 0, 18)); // NOI18N
        jLabelFechar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFechar.setText("FECHAR");
        jLabelFechar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelFechar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelFecharMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(labelIcone, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelBody, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.CENTER, jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(labelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelIcone, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelTitulo)
                .addGap(18, 18, 18)
                .addComponent(labelBody, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelFecharMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelFecharMouseClicked
       this.dispose();
    }//GEN-LAST:event_jLabelFecharMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelFechar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelBody;
    private javax.swing.JLabel labelIcone;
    private javax.swing.JLabel labelTitulo;
    // End of variables declaration//GEN-END:variables
}

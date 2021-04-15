package romario.com.br.painelestadoscidadesbrasileiras.view.home;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import romario.com.br.painelestadoscidadesbrasileiras.domain.AuthenticatedUser;
import romario.com.br.painelestadoscidadesbrasileiras.shared.Util;
import romario.com.br.painelestadoscidadesbrasileiras.view.panel.user.UserPanel;

/**
 *
 * @author Romário Cabó
 */
public class ViewHome extends javax.swing.JFrame {

    private int xx, xy;

    private boolean isSelectedUsuarios = true;
    private boolean isSelectedEtapas = false;
    private boolean isSelectedFuncoes = false;

    private final AuthenticatedUser userDTO;

    private final Util util;

    public ViewHome() {
        initComponents();

        UserPanel userPanel = new UserPanel();

        this.util = new Util();
        util.qualPanelExibir(userPanel, jPanelPai);

        userDTO = new AuthenticatedUser();

        this.setColor(this.panelUsuario);
        this.enableSelectorIndicator(this.panelSeletorUsuario, true);

        this.jLabelDiadaSemanaData.setText("");
        this.jLabelHora.setText("");

        java.awt.EventQueue.invokeLater(this::diaDataSemana);

        java.awt.EventQueue.invokeLater(() -> {
            Timer timer = new Timer(1000, new hora());
            timer.start();
        });

        this.labelNomeEmpresa.setText(userDTO.getName());
    }

    private void diaDataSemana() {
        String nomeSemana = "", data;

        Date d = new Date();

        Calendar c = new GregorianCalendar();
        c.setTime(d);

        int dia = c.get(Calendar.DAY_OF_WEEK);

        switch (dia) {
            case Calendar.SUNDAY:
                nomeSemana = "domingo";
                break;
            case Calendar.SATURDAY:
                nomeSemana = "sábado";
                break;
            case Calendar.MONDAY:
                nomeSemana = "segunda-feira";
                break;
            case Calendar.TUESDAY:
                nomeSemana = "terça-feira";
                break;
            case Calendar.WEDNESDAY:
                nomeSemana = "quarta-feira";
                break;
            case Calendar.THURSDAY:
                nomeSemana = "quinta-feira";
                break;
            case Calendar.FRIDAY:
                nomeSemana = "sexta-feira";
                break;
        }

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        data = dateFormat.format(d);

        jLabelDiadaSemanaData.setText(nomeSemana + ", " + data);
    }

    class hora implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Calendar now = Calendar.getInstance();
            jLabelHora.setText(String.format("%1$tH:%1$tM:%1$tS", now));
        }
    }

    private void setColor(JPanel panel) {
        panel.setBackground(new Color(103, 61, 197));
    }

    private void resetColor(JPanel panel) {
        panel.setBackground(new Color(76, 41, 211));
    }

    private void enableSelectorIndicator(JPanel panel, boolean isOpaque) {
        panel.setOpaque(isOpaque);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        panelMenus = new javax.swing.JPanel();
        jLabelSejaBemVindo = new javax.swing.JLabel();
        labelNomeEmpresa = new javax.swing.JLabel();
        jLabelCadastros = new javax.swing.JLabel();
        panelUsuario = new javax.swing.JPanel();
        labelIconUsuario = new javax.swing.JLabel();
        panelSeletorUsuario = new javax.swing.JPanel();
        labelUsuario = new javax.swing.JLabel();
        panelEstados = new javax.swing.JPanel();
        labelEstados = new javax.swing.JLabel();
        panelSeletorEstados = new javax.swing.JPanel();
        labelEstado = new javax.swing.JLabel();
        panelCidades = new javax.swing.JPanel();
        labelIconCidades = new javax.swing.JLabel();
        panelSeletorCidade = new javax.swing.JPanel();
        labelCidade = new javax.swing.JLabel();
        jLabelVersao = new javax.swing.JLabel();
        labelFechar = new javax.swing.JLabel();
        labelMaximizar = new javax.swing.JLabel();
        labelMinimizar = new javax.swing.JLabel();
        jPanelDataHoraDiaSemana = new javax.swing.JPanel();
        jLabelHora = new javax.swing.JLabel();
        jLabelDiadaSemanaData = new javax.swing.JLabel();
        jPanelPai = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(6);
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

        panelPrincipal.setBackground(new java.awt.Color(255, 255, 255));

        panelMenus.setBackground(new java.awt.Color(76, 41, 211));

        jLabelSejaBemVindo.setBackground(new java.awt.Color(204, 204, 204));
        jLabelSejaBemVindo.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabelSejaBemVindo.setForeground(new java.awt.Color(204, 204, 204));
        jLabelSejaBemVindo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelSejaBemVindo.setText("Seja Bem Vindo(a)");

        labelNomeEmpresa.setBackground(new java.awt.Color(204, 204, 204));
        labelNomeEmpresa.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        labelNomeEmpresa.setForeground(new java.awt.Color(204, 204, 204));
        labelNomeEmpresa.setText("Cerâmica Boa Vista ");

        jLabelCadastros.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelCadastros.setForeground(new java.awt.Color(153, 153, 153));
        jLabelCadastros.setText("CADASTROS");

        panelUsuario.setBackground(new java.awt.Color(76, 41, 211));
        panelUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        labelIconUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/romario/com/br/painelestadoscidadesbrasileiras/assets/icons8_member_36px.png"))); // NOI18N
        labelIconUsuario.setToolTipText("Clique para cadastar produto");
        labelIconUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelIconUsuarioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelIconUsuarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelIconUsuarioMouseExited(evt);
            }
        });

        panelSeletorUsuario.setOpaque(false);
        panelSeletorUsuario.setPreferredSize(new java.awt.Dimension(4, 36));

        javax.swing.GroupLayout panelSeletorUsuarioLayout = new javax.swing.GroupLayout(panelSeletorUsuario);
        panelSeletorUsuario.setLayout(panelSeletorUsuarioLayout);
        panelSeletorUsuarioLayout.setHorizontalGroup(
            panelSeletorUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4, Short.MAX_VALUE)
        );
        panelSeletorUsuarioLayout.setVerticalGroup(
            panelSeletorUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );

        labelUsuario.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        labelUsuario.setForeground(new java.awt.Color(204, 204, 204));
        labelUsuario.setText("Usuário");
        labelUsuario.setToolTipText("Clique para cadastar Usuário");
        labelUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelUsuarioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelUsuarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelUsuarioMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelUsuarioLayout = new javax.swing.GroupLayout(panelUsuario);
        panelUsuario.setLayout(panelUsuarioLayout);
        panelUsuarioLayout.setHorizontalGroup(
            panelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelUsuarioLayout.createSequentialGroup()
                .addComponent(panelSeletorUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelIconUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelUsuarioLayout.setVerticalGroup(
            panelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelIconUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelUsuarioLayout.createSequentialGroup()
                .addComponent(panelSeletorUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(labelUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panelEstados.setBackground(new java.awt.Color(76, 41, 211));
        panelEstados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        labelEstados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/romario/com/br/painelestadoscidadesbrasileiras/assets/icons8_todo_list_36px.png"))); // NOI18N
        labelEstados.setToolTipText("Clique para cadastar uma esteira de produção");
        labelEstados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelEstadosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelEstadosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelEstadosMouseExited(evt);
            }
        });

        panelSeletorEstados.setOpaque(false);
        panelSeletorEstados.setPreferredSize(new java.awt.Dimension(4, 36));

        javax.swing.GroupLayout panelSeletorEstadosLayout = new javax.swing.GroupLayout(panelSeletorEstados);
        panelSeletorEstados.setLayout(panelSeletorEstadosLayout);
        panelSeletorEstadosLayout.setHorizontalGroup(
            panelSeletorEstadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4, Short.MAX_VALUE)
        );
        panelSeletorEstadosLayout.setVerticalGroup(
            panelSeletorEstadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );

        labelEstado.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        labelEstado.setForeground(new java.awt.Color(204, 204, 204));
        labelEstado.setText("Estado");
        labelEstado.setToolTipText("Clique para cadastar uma esteira de produção");
        labelEstado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelEstadoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelEstadoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelEstadoMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelEstadosLayout = new javax.swing.GroupLayout(panelEstados);
        panelEstados.setLayout(panelEstadosLayout);
        panelEstadosLayout.setHorizontalGroup(
            panelEstadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEstadosLayout.createSequentialGroup()
                .addComponent(panelSeletorEstados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelEstados, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelEstadosLayout.setVerticalGroup(
            panelEstadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelEstados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelEstadosLayout.createSequentialGroup()
                .addComponent(panelSeletorEstados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(labelEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panelCidades.setBackground(new java.awt.Color(76, 41, 211));
        panelCidades.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        labelIconCidades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/romario/com/br/painelestadoscidadesbrasileiras/assets/icons8_futures_36px.png"))); // NOI18N
        labelIconCidades.setToolTipText("Clique para cadastar uma esteira de produção");
        labelIconCidades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelIconCidadesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelIconCidadesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelIconCidadesMouseExited(evt);
            }
        });

        panelSeletorCidade.setOpaque(false);
        panelSeletorCidade.setPreferredSize(new java.awt.Dimension(4, 36));

        javax.swing.GroupLayout panelSeletorCidadeLayout = new javax.swing.GroupLayout(panelSeletorCidade);
        panelSeletorCidade.setLayout(panelSeletorCidadeLayout);
        panelSeletorCidadeLayout.setHorizontalGroup(
            panelSeletorCidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4, Short.MAX_VALUE)
        );
        panelSeletorCidadeLayout.setVerticalGroup(
            panelSeletorCidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );

        labelCidade.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        labelCidade.setForeground(new java.awt.Color(204, 204, 204));
        labelCidade.setText("Cidades");
        labelCidade.setToolTipText("Clique para cadastar uma cidade ");
        labelCidade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelCidadeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelCidadeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelCidadeMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelCidadesLayout = new javax.swing.GroupLayout(panelCidades);
        panelCidades.setLayout(panelCidadesLayout);
        panelCidadesLayout.setHorizontalGroup(
            panelCidadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCidadesLayout.createSequentialGroup()
                .addComponent(panelSeletorCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelIconCidades, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelCidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelCidadesLayout.setVerticalGroup(
            panelCidadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelIconCidades, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelCidadesLayout.createSequentialGroup()
                .addComponent(panelSeletorCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(labelCidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabelVersao.setBackground(new java.awt.Color(204, 204, 204));
        jLabelVersao.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabelVersao.setForeground(new java.awt.Color(204, 204, 204));
        jLabelVersao.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelVersao.setText("Versão 1.0.0");

        javax.swing.GroupLayout panelMenusLayout = new javax.swing.GroupLayout(panelMenus);
        panelMenus.setLayout(panelMenusLayout);
        panelMenusLayout.setHorizontalGroup(
            panelMenusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelEstados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelCidades, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelMenusLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMenusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelNomeEmpresa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelSejaBemVindo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                    .addComponent(jLabelVersao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelCadastros, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelMenusLayout.setVerticalGroup(
            panelMenusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenusLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabelSejaBemVindo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelNomeEmpresa)
                .addGap(60, 60, 60)
                .addComponent(jLabelCadastros)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelEstados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelCidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 397, Short.MAX_VALUE)
                .addComponent(jLabelVersao)
                .addContainerGap())
        );

        labelFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/romario/com/br/painelestadoscidadesbrasileiras/assets/icons8_close_window_18px.png"))); // NOI18N
        labelFechar.setToolTipText("Fechar");
        labelFechar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelFechar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelFecharMouseClicked(evt);
            }
        });

        labelMaximizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/romario/com/br/painelestadoscidadesbrasileiras/assets/icons8_maximize_button_18px.png"))); // NOI18N
        labelMaximizar.setToolTipText("Rest. Tamanho");
        labelMaximizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelMaximizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                labelMaximizarMousePressed(evt);
            }
        });

        labelMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/romario/com/br/painelestadoscidadesbrasileiras/assets/icons8_minimize_window_18px.png"))); // NOI18N
        labelMinimizar.setToolTipText("Minimizar");
        labelMinimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                labelMinimizarMousePressed(evt);
            }
        });

        jPanelDataHoraDiaSemana.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabelHora.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabelHora.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelHora.setText("16:38:10");

        jLabelDiadaSemanaData.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabelDiadaSemanaData.setText("Sábado 20/03/2020");

        javax.swing.GroupLayout jPanelDataHoraDiaSemanaLayout = new javax.swing.GroupLayout(jPanelDataHoraDiaSemana);
        jPanelDataHoraDiaSemana.setLayout(jPanelDataHoraDiaSemanaLayout);
        jPanelDataHoraDiaSemanaLayout.setHorizontalGroup(
            jPanelDataHoraDiaSemanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDataHoraDiaSemanaLayout.createSequentialGroup()
                .addContainerGap(602, Short.MAX_VALUE)
                .addComponent(jLabelDiadaSemanaData)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelHora)
                .addContainerGap())
        );
        jPanelDataHoraDiaSemanaLayout.setVerticalGroup(
            jPanelDataHoraDiaSemanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelHora, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
            .addComponent(jLabelDiadaSemanaData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanelPai.setBackground(new java.awt.Color(255, 255, 255));
        jPanelPai.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addComponent(panelMenus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelDataHoraDiaSemana, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                                .addComponent(labelMinimizar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelMaximizar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelFechar)
                                .addContainerGap())
                            .addComponent(jPanelPai, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMenus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelMinimizar)
                    .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(labelMaximizar)
                        .addComponent(labelFechar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelPai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelDataHoraDiaSemana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void labelUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelUsuarioMouseClicked

        isSelectedUsuarios = true;
        isSelectedEtapas = false;
        isSelectedFuncoes = false;

        setColor(panelUsuario);
        resetColor(panelEstados);
        resetColor(panelCidades);

        enableSelectorIndicator(panelSeletorUsuario, true);
        enableSelectorIndicator(panelSeletorEstados, false);
        enableSelectorIndicator(panelSeletorCidade, false);

//        FormProduto formProduto = new FormProduto(this, true);
//        formProduto.setVisible(true);
    }//GEN-LAST:event_labelUsuarioMouseClicked

    private void labelIconUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelIconUsuarioMouseClicked

        isSelectedUsuarios = true;
        isSelectedEtapas = false;
        isSelectedFuncoes = false;

        setColor(panelUsuario);
        resetColor(panelEstados);
        resetColor(panelCidades);

        enableSelectorIndicator(panelSeletorUsuario, true);
        enableSelectorIndicator(panelSeletorEstados, false);
        enableSelectorIndicator(panelSeletorCidade, false);

//        FormProduto formProduto = new FormProduto(this, true);
//        formProduto.setVisible(true);
    }//GEN-LAST:event_labelIconUsuarioMouseClicked

    private void labelFecharMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelFecharMouseClicked
        System.exit(0);
    }//GEN-LAST:event_labelFecharMouseClicked

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_formMouseDragged

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void labelMaximizarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelMaximizarMousePressed
        if (ViewHome.this.getExtendedState() == MAXIMIZED_BOTH) {
            ViewHome.this.setExtendedState(JFrame.NORMAL);
        } else {
            ViewHome.this.setExtendedState(MAXIMIZED_BOTH);
        }
    }//GEN-LAST:event_labelMaximizarMousePressed

    private void labelMinimizarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelMinimizarMousePressed
        ViewHome.this.setState(Frame.ICONIFIED);
    }//GEN-LAST:event_labelMinimizarMousePressed

    private void labelUsuarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelUsuarioMouseEntered
        if (!isSelectedUsuarios) {
            setColor(panelUsuario);
            enableSelectorIndicator(panelSeletorUsuario, true);
        }
    }//GEN-LAST:event_labelUsuarioMouseEntered

    private void labelUsuarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelUsuarioMouseExited
        if (!isSelectedUsuarios) {
            resetColor(panelUsuario);
            enableSelectorIndicator(panelSeletorUsuario, false);
        }
    }//GEN-LAST:event_labelUsuarioMouseExited

    private void labelIconUsuarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelIconUsuarioMouseEntered
        if (!isSelectedUsuarios) {
            setColor(panelUsuario);
            enableSelectorIndicator(panelSeletorUsuario, true);
        }
    }//GEN-LAST:event_labelIconUsuarioMouseEntered

    private void labelIconUsuarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelIconUsuarioMouseExited
        if (!isSelectedUsuarios) {
            resetColor(panelUsuario);
            enableSelectorIndicator(panelSeletorUsuario, false);
        }
    }//GEN-LAST:event_labelIconUsuarioMouseExited

    private void labelCidadeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelCidadeMouseExited
        if (!isSelectedFuncoes) {
            resetColor(panelCidades);
            enableSelectorIndicator(panelSeletorCidade, false);
        }
    }//GEN-LAST:event_labelCidadeMouseExited

    private void labelCidadeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelCidadeMouseEntered
        if (!isSelectedFuncoes) {
            setColor(panelCidades);
            enableSelectorIndicator(panelSeletorCidade, true);
        }
    }//GEN-LAST:event_labelCidadeMouseEntered

    private void labelCidadeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelCidadeMouseClicked
        isSelectedUsuarios = false;
        isSelectedEtapas = false;
        isSelectedFuncoes = true;

        resetColor(panelUsuario);
        resetColor(panelEstados);
        setColor(panelCidades);

        enableSelectorIndicator(panelSeletorCidade, true);
        enableSelectorIndicator(panelSeletorUsuario, false);
        enableSelectorIndicator(panelSeletorEstados, false);

//        FormFuncaoEtapa funcaoEtapa = new FormFuncaoEtapa(null, true);
//        funcaoEtapa.setVisible(true);
    }//GEN-LAST:event_labelCidadeMouseClicked

    private void labelIconCidadesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelIconCidadesMouseExited
        if (!isSelectedFuncoes) {
            resetColor(panelCidades);
            enableSelectorIndicator(panelSeletorCidade, false);
        }
    }//GEN-LAST:event_labelIconCidadesMouseExited

    private void labelIconCidadesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelIconCidadesMouseEntered
        if (!isSelectedFuncoes) {
            setColor(panelCidades);
            enableSelectorIndicator(panelSeletorCidade, true);
        }
    }//GEN-LAST:event_labelIconCidadesMouseEntered

    private void labelIconCidadesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelIconCidadesMouseClicked
        isSelectedUsuarios = false;
        isSelectedEtapas = false;
        isSelectedFuncoes = true;

        resetColor(panelUsuario);
        resetColor(panelEstados);
        setColor(panelCidades);

        enableSelectorIndicator(panelSeletorCidade, true);
        enableSelectorIndicator(panelSeletorUsuario, false);
        enableSelectorIndicator(panelSeletorEstados, false);

//        FormFuncaoEtapa funcaoEtapa = new FormFuncaoEtapa(null, true);
//        funcaoEtapa.setVisible(true);
    }//GEN-LAST:event_labelIconCidadesMouseClicked

    private void labelEstadoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelEstadoMouseExited
        if (!isSelectedEtapas) {
            resetColor(panelEstados);
            enableSelectorIndicator(panelSeletorEstados, false);
        }
    }//GEN-LAST:event_labelEstadoMouseExited

    private void labelEstadoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelEstadoMouseEntered
        if (!isSelectedEtapas) {
            setColor(panelEstados);
            enableSelectorIndicator(panelSeletorEstados, true);
        }
    }//GEN-LAST:event_labelEstadoMouseEntered

    private void labelEstadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelEstadoMouseClicked

        isSelectedUsuarios = false;
        isSelectedEtapas = true;
        isSelectedFuncoes = false;

        setColor(panelEstados);
        resetColor(panelUsuario);
        resetColor(panelCidades);

        enableSelectorIndicator(panelSeletorCidade, false);
        enableSelectorIndicator(panelSeletorUsuario, false);
        enableSelectorIndicator(panelSeletorEstados, true);

        //FormEtapaProduto formEtapaProduto = new FormEtapaProduto(this, true);
        //formEtapaProduto.setVisible(true);
    }//GEN-LAST:event_labelEstadoMouseClicked

    private void labelEstadosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelEstadosMouseExited
        if (!isSelectedEtapas) {
            resetColor(panelEstados);
            enableSelectorIndicator(panelSeletorEstados, false);
        }
    }//GEN-LAST:event_labelEstadosMouseExited

    private void labelEstadosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelEstadosMouseEntered
        if (!isSelectedEtapas) {
            setColor(panelEstados);
            enableSelectorIndicator(panelSeletorEstados, true);
        }
    }//GEN-LAST:event_labelEstadosMouseEntered

    private void labelEstadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelEstadosMouseClicked

        isSelectedUsuarios = false;
        isSelectedEtapas = true;
        isSelectedFuncoes = false;

        setColor(panelEstados);
        resetColor(panelUsuario);
        resetColor(panelCidades);

        enableSelectorIndicator(panelSeletorCidade, false);
        enableSelectorIndicator(panelSeletorUsuario, false);
        enableSelectorIndicator(panelSeletorEstados, true);
    }//GEN-LAST:event_labelEstadosMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelCadastros;
    private javax.swing.JLabel jLabelDiadaSemanaData;
    private javax.swing.JLabel jLabelHora;
    private javax.swing.JLabel jLabelSejaBemVindo;
    private javax.swing.JLabel jLabelVersao;
    private javax.swing.JPanel jPanelDataHoraDiaSemana;
    private javax.swing.JPanel jPanelPai;
    private javax.swing.JLabel labelCidade;
    private javax.swing.JLabel labelEstado;
    private javax.swing.JLabel labelEstados;
    private javax.swing.JLabel labelFechar;
    private javax.swing.JLabel labelIconCidades;
    private javax.swing.JLabel labelIconUsuario;
    private javax.swing.JLabel labelMaximizar;
    private javax.swing.JLabel labelMinimizar;
    private javax.swing.JLabel labelNomeEmpresa;
    private javax.swing.JLabel labelUsuario;
    private javax.swing.JPanel panelCidades;
    private javax.swing.JPanel panelEstados;
    private javax.swing.JPanel panelMenus;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelSeletorCidade;
    private javax.swing.JPanel panelSeletorEstados;
    private javax.swing.JPanel panelSeletorUsuario;
    private javax.swing.JPanel panelUsuario;
    // End of variables declaration//GEN-END:variables
}

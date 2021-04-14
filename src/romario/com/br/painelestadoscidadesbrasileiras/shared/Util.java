package romario.com.br.painelestadoscidadesbrasileiras.shared;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import romario.com.br.painelestadoscidadesbrasileiras.view.dialog.DialogView;

/**
 *
 * @author Romário Cabó
 */
public class Util {

    private URL url = null;
    private Image image = null;

    /**
     * Métdo reponsável por setar uma imagem preservando a qualidade
     *
     * @param caminhoImagem
     * @param label
     */
    public void setLogo(String caminhoImagem, JLabel label) {
        try {
            url = getClass().getResource(caminhoImagem);
            image = ImageIO.read(url);

            label.setIcon(new ImageIcon(image
                    .getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Métdo reponsável por redesenhar a tela de acordo com JPanel informado
     *
     * @param panelAdiconar JPanel - Panel que deseja exibir
     * @param panelPai JPanel - Panel pai da aplicacao
     */
    public void qualPanelExibir(JPanel panelAdiconar, JPanel panelPai) {
        panelPai.removeAll();
        panelPai.add(panelAdiconar);
        panelPai.repaint();
        panelPai.revalidate();
    }

    public void zebrarTable(JTable jTable1) {
        jTable1.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {

                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);

                if (isSelected) {
                    setBackground(new Color(51, 153, 255));
                    setForeground(Color.WHITE);
                } else if (row % 2 == 0) {
                    setBackground(new Color(248, 248, 248));
                    setForeground(Color.BLACK);
                } else {
                    setBackground(table.getBackground());
                    setForeground(table.getForeground());
                }

                return this;
            }
        });

        jTable1.repaint();
    }

    public void centralizarLinhasTabelas(JTable jTable1, List<Integer> indicesLinhas) {
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);

        indicesLinhas.forEach(obj -> {
            jTable1.getColumnModel().getColumn(obj).setCellRenderer(centralizado);
        });
    }

    public void buildMessage(String caminhoIcone, String titulo, String message, int R, int G, int B) {
        DialogView dialogView
                = new DialogView(null,
                        true,
                        caminhoIcone,
                        titulo,
                        message,
                        R,
                        G,
                        B
                );

        dialogView.setVisible(true);
    }

    public void setEnable(
            JButton buttonNovo,
            JButton buttonSalvar,
            JButton buttonAlterar,
            boolean buttonNovoIsEnable,
            boolean buttonSalvarIsEnable,
            boolean buttonAlterarIsEnable) {

        buttonNovo.setEnabled(buttonNovoIsEnable);
        buttonSalvar.setEnabled(buttonSalvarIsEnable);
        buttonAlterar.setEnabled(buttonAlterarIsEnable);

        if (buttonNovoIsEnable) {
            buttonNovo.setBackground(new Color(76, 41, 211));
        } else {
            buttonNovo.setBackground(new Color(158, 158, 158));
        }

        if (buttonSalvarIsEnable) {
            buttonSalvar.setBackground(new Color(76, 41, 211));
        } else {
            buttonSalvar.setBackground(new Color(158, 158, 158));
        }

        if (buttonAlterarIsEnable) {
            buttonAlterar.setBackground(new Color(76, 41, 211));
        } else {
            buttonAlterar.setBackground(new Color(158, 158, 158));
        }
    }

    public String formatarStringParaDouble(String stringParaFormatar) {
        if (stringParaFormatar.isEmpty()) {
            return null;
        } else {
            return stringParaFormatar.replaceAll("\\.", "").replace(",", ".").replaceAll("\"", "");
        }
    }

    public String formatarParaMoeda(Double valorFormatar) {
        if (valorFormatar == null) {
            return null;
        } else {
            return NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(valorFormatar);
        }
    }

    public LocalDate stringToLocalDate(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(dateString, formatter);
    }

    public String localDateToString(LocalDate localDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return localDate.format(formatter);
    }
}

package BancoDigitale;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_Registrare extends JFrame{
    private JButton B_procede;
    private JTextField F_nome;
    private JTextField F_codici;
    private JPasswordField P_chiave;
    private JPanel mainPanel;
    private SistemaContos sistema;

    GUI_Registrare(SistemaContos sistema){
        this.sistema = sistema;

        B_procede.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String nome = F_nome.getText();
                int codici = Integer.parseInt(F_codici.getText());
                String chiave = new String(P_chiave.getPassword());

                SistemaContos sistema = new SistemaContos();
                ContoStruttura novoConto = sistema.cadastro(codici, nome, chiave, null);

                JOptionPane.showMessageDialog(null, "utente " + novoConto.getNome()+ " creato benvenuto");
                GUI_Design.esecutore(sistema);
            }
        });
    }
    public static void esecutore(SistemaContos sistema){
        GUI_Registrare registrare = new GUI_Registrare(sistema);
        registrare.setContentPane(registrare.mainPanel);
        registrare.setTitle("regitra Frame");
        registrare.setSize(400, 300);
        registrare.setVisible(true);
        registrare.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}

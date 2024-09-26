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

    GUI_Registrare(){
        B_procede.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String nome = F_nome.getText();
                int codici = Integer.parseInt(F_codici.getText());
                String chiave = new String(P_chiave.getPassword());

                SistemaContos sistema = new SistemaContos();
                ContoStruttura novoConto = sistema.cadastro(codici, nome, chiave, null);

                JOptionPane.showMessageDialog(null, "utente " + novoConto.getNome()+ " creato benvenuto");
            }
        });
    }
    public static void main(String args[]){
        GUI_Registrare registrare = new GUI_Registrare();
        registrare.setContentPane(registrare.mainPanel);
        registrare.setTitle("regitra Frame");
        registrare.setSize(400, 300);
        registrare.setVisible(true);
        registrare.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}

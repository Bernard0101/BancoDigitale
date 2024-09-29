package BancoDigitale;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_Design extends JFrame {
    private JTextField F_name;
    private JPasswordField F_password;
    private JPanel mainPanel;
    private JButton B_continua;
    private JButton B_registrare;
    private SistemaContos sistema;

    // Costruttore che accetta l'istanza esistente di SistemaContos
    public GUI_Design(SistemaContos sistema) {
        this.sistema = sistema;

        B_continua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String nome = F_name.getText();
                String password = new String(F_password.getPassword());

                // Usa l'istanza di sistema passata, non crearne una nuova
                if (sistema.login(nome, password)) {
                    JOptionPane.showMessageDialog(null, "Benvenuto nuovamente " + nome);
                } else {
                    JOptionPane.showMessageDialog(null, "Nome o password errati. Riprova.");
                }
            }
        });

        B_registrare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // Nascondi la finestra di login e apri quella di registrazione
                setVisible(false);
                GUI_Registrare.esecutore(sistema); // Apri la finestra di registrazione con l'istanza di SistemaContos
            }
        });
    }

    public static void esecutore(SistemaContos sistema) {
        GUI_Design GUI = new GUI_Design(sistema);
        GUI.setContentPane(GUI.mainPanel);
        GUI.setTitle("Java Applicazione bancaria - Login");
        GUI.setSize(400, 300);
        GUI.setVisible(true);
        GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}


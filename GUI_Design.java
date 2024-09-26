package BancoDigitale;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_Design extends JFrame {
    private JTextField F_name;
    private JPasswordField F_password;
    private JPanel mainPanel;
    private JButton B_continua;
    private JButton registrareButton;


    public GUI_Design() {
        B_continua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String nome = F_name.getText();
                String password = new String(F_password.getPassword());

                SistemaContos sistema = new SistemaContos();


                ContoStruttura GiorgioConto=sistema.cadastro(150920, "Giorgio", "Ba090", null);


                if(sistema.login(nome, password)){
                    JOptionPane.showMessageDialog(null, "benvenuto novamente " + GiorgioConto.getNome());
                }
                else
                    JOptionPane.showMessageDialog(null, "codici o nome sbagliato riprova");
            }
        });
    }
    public static void main(String[] args){
        GUI_Design GUI = new GUI_Design();
        GUI.setContentPane(GUI.mainPanel);
        GUI.setTitle("Java Aplicazione bancaria");
        GUI.setSize(400, 300);
        GUI.setVisible(true);
        GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
package BancoDigitale;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import BancoDigitale.ContoStruttura;


class UserConto{
    static Scanner scan = new Scanner(System.in);
    private ContoStruttura conto;
    private List <ContoStruttura> contos = new ArrayList <ContoStruttura>();


    public UserConto(ContoStruttura conto){
        this.conto = conto;
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public ContoStruttura cadastro(int codiciFiscale, String nome, int etta, String segna, double denaro, List contati){
        ContoStruttura conto = new ContoStruttura(codiciFiscale, nome, etta, segna, denaro, contati);
        contos.add(conto);
        System.out.println("utenti " + nome + " creato con sucesso!");
        return conto;
    }

    public boolean login(String nome, String segna){
        if(this.conto.getSegna().equals(segna) && this.conto.getNome().equals(nome)){
            System.out.println("benvenuto novamente "+ conto.getNome());
            return true;
        }
        else{
            System.out.println("segna sbagliata, dovrai riprovare");
            return false;
        }
    }
    
    public static void main(String[] args){
        //facendo cadastro de due utenti
        UserConto SistemaContos = new UserConto(null);

        ContoStruttura GiorgioConto=SistemaContos.cadastro(830382, "Giorgio", 28, "1234", 1000.00, null);
        ContoStruttura FernandaConto=SistemaContos.cadastro(150934, "Fernanda", 27, "3456", 1000.00, null);
        
        
        SistemaContos.login("Giorgio", "1234");
        SistemaContos.login("Fernanda", "3456");


        System.out.println("digita qui la quantita de denaro");
        int denaro=scan.nextInt();
        GiorgioConto.adizionareDenaro(denaro);
        System.out.println("denaro atuale: " + GiorgioConto.getDenaro());

        GiorgioConto.adizionareContato(FernandaConto);
        GiorgioConto.trasferireDenaro(500, 150278);
    }

    
}
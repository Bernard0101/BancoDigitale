package BancoDigitale;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import BancoDigitale.ContoStruttura;


public class SistemaContos{
    static Scanner scan = new Scanner(System.in);
    private ContoStruttura conto;
    private List <ContoStruttura> contos = new ArrayList <ContoStruttura>();


    public SistemaContos(){
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public ContoStruttura cadastro(int codiciFiscale, String nome, String segna, List contati){
        ContoStruttura conto = new ContoStruttura(codiciFiscale, nome, segna, contati);
        contos.add(conto);
        System.out.println("utenti " + nome + " creato con sucesso!");
        return conto;
    }

    public boolean login(String nome, String segna){
        for(ContoStruttura conto : contos){
            if(conto.getSegna().equals(segna) && conto.getNome().equals(nome)){
                System.out.println("benvenuto novamente "+ conto.getNome());
                return true;
            }
        }
        System.out.println("segna sbagliata, dovrai riprovare");
        return false;
    }
    
    public static void main(String[] args){
        //facendo cadastro de due utenti
        SistemaContos sistema = new SistemaContos();


        ContoStruttura GiorgioConto=sistema.cadastro(830382, "Giorgio", "1234", null);
        ContoStruttura FernandaConto=sistema.cadastro(150934, "Fernanda", "3456", null);
        

        sistema.login("Giorgio", "1234");
        sistema.login("Fernanda", "3456");


        System.out.println("digita qui la quantita de denaro");
        int denaro=scan.nextInt();
        GiorgioConto.adizionareDenaro(denaro);
        System.out.println("denaro atuale: " + GiorgioConto.getDenaro());

        GiorgioConto.adizionareContato(FernandaConto);
        GiorgioConto.trasferireDenaro(500, 150934);
        System.out.println(FernandaConto.getNome()+" suo strato atuale nella banca e de " + FernandaConto.getDenaro());
    }
}
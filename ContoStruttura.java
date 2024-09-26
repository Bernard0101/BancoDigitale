package BancoDigitale;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class ContoStruttura{
    private int codiciFiscale;
    private String nome;
    private String segna;
    private double denaro;
    private List <ContoStruttura> contati;
    Scanner scan = new Scanner(System.in);

    //construtore 
    public ContoStruttura(int codiciFiscale, String nome, String segna, List <ContoStruttura> contati){
        this.codiciFiscale=codiciFiscale;
        this.nome=nome;
        this.segna=segna;
        this.denaro=1000;
        this.contati=contati = new ArrayList<>();
    }
    //metodi getter & getter
    public int getCodiciFiscale(){return this.codiciFiscale;}
    public String getNome(){return this.nome;}
    public String getSegna(){return this.segna;}
    public double getDenaro(){return this.denaro;}
    public List <ContoStruttura> getContati(){return this.contati;}
    public void setDenaro(double denaro){this.denaro=denaro;}

    //metodi di interazione del conto
    public void prendereDenaro(float quantita){gestioneTransazione(quantita, false);}
    public void adizionareDenaro(float quantita){gestioneTransazione(quantita, true);}

    public boolean verificaSegna(String inputSegna){return inputSegna.equals(this.segna);}

    public void adizionareContato(ContoStruttura contato){
        contati.add(contato);
        System.out.println(this.getNome()+" adizionato ai tuoi contati");
    }

    private boolean gestioneTransazione(float quantita, boolean aggiunta){
        int limite = 1000;

        if(quantita > limite){
            System.out.println("Operazione sopra il limite. Inserisci la tua segna:");
            int tentativi = 0;
            while(tentativi < 3){
                String inputSegna = scan.nextLine();
                if(verificaSegna(inputSegna)){
                    break;
                }
                tentativi++;
                System.out.println("Segna errata. Riprova.");
            }
            if(tentativi == 3){
                System.out.println("Tentativi esauriti. Riprova più tardi.");
                return false;
            }
        }

        if(aggiunta){
            this.denaro += quantita;
            System.out.println("Denaro depositato: " + quantita + " Euro");
        }else if(this.denaro >= quantita){
            this.denaro -= quantita;
            System.out.println("Denaro prelevato: " + quantita + " Euro");
        }else{
            System.out.println("Saldo insufficiente per prelevare " + quantita + " Euro.");
            return false;
        }

        return true;
    }

    public void trasferireDenaro(float quantita, int codiciTarget){
        boolean trovato=false;

        if(quantita > this.denaro){
            System.out.println("non hai tutto questo denaro riprova con una quantita minore");
        }
        else{
            for (ContoStruttura contato : this.contati) {
                if(contato.getCodiciFiscale() == codiciTarget){
                    contato.setDenaro(contato.getDenaro() + quantita);
                    this.denaro -= quantita;
                    System.out.println("denaro e stato trasferito per " + contato.getNome() + " in un valore de: " + quantita + " Euro");
                    trovato=true;
                    break;
                }
            }
            if (!trovato) {
                System.out.println("contato non sta nella lista, riprova adizzionarlo");
            }
        }
    }
}

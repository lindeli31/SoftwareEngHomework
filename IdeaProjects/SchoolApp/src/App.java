import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
public class App {
    private List<Percorso> percorsi;
    private Percorso pSelezionato;
    public App(){
        percorsi = new ArrayList<Percorso>();
    }
    public void aggiungiPercorso(String nome){//costruttore con nome da input
        Percorso p = new Percorso(nome);
        percorsi.add(p);
        DataBaseMenager.savePercorso(p);
    }
    public void aggiungiPercorso(Percorso p){
        percorsi.add(p);
        DataBaseMenager.savePercorso(p);
    }
    public void selezionaPercorso(String nome){
        for(Percorso p : percorsi){
            if(p.getNome().equals(nome)){
                pSelezionato = p;
                break;
            }
        }
    }
    public void aggiungiVoto(String materia, int voto, int crediti){
        if(pSelezionato != null){
            Voto newvoto = new Voto(materia, voto, crediti);
            pSelezionato.aggiungiVoto(newvoto);
            DataBaseMenager.saveVoto(newvoto, pSelezionato.getId());
        }
        else {
            System.out.println("Percorso non trovato");
        }

    }
    public float media(){
        if(pSelezionato != null){return pSelezionato.media();
        }
        else {
            System.out.println("Percorso non trovato");
            return 0;
        }

    }
    public float mediaPonderata(){
        if(pSelezionato != null){return pSelezionato.mediaPonderata();}
        else{
            System.out.println("Percorso non trovato");
            return 0;
        }
    }
    public float prediciMedia(ArrayList<Voto> lista){
        if(pSelezionato != null){
            return pSelezionato.predicimedia(lista);
        }
        else{
            System.out.println("Percorso non trovato");
            return 0;
        }

    }
    public Percorso getPercorso(){
        return pSelezionato;
    }



}

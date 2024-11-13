import java.util.ArrayList;
import java.util.List;
public class Percorso {
    private int id;
    private String nome;
    private ArrayList<Voto> voti;
    private int totCrediti;
    public Percorso(String nome) {
        this.nome = nome;
        voti = new ArrayList<>();
    }
    public void aggiungiVoto(Voto voto){
        voti.add(voto);
        totCrediti += voto.getCrediti();
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setVoti(ArrayList<Voto> voti){
        this.voti = voti;
    }

    public ArrayList<Voto> getVoti() {
        return voti;

    }

    public float media() {
        if (voti.isEmpty()) {
            return 0;
        }
        float  somma = 0;
        for(Voto voto: voti) {
            somma+= voto.getVoto();
        }
        return somma/voti.size();
    }
    public float mediaPonderata() {
        if (voti.isEmpty()) {
            return 0;
        }
        float somma = 0;

        for (Voto voto : voti) {
            somma += voto.getVoto() * voto.getCrediti();
        }
        return somma / totCrediti;
    }
    public float predicimedia(ArrayList<Voto> lista){ //predico la media ponderata
        ArrayList<Voto> newvoti = new ArrayList<>();
        newvoti.addAll(voti);
        newvoti.addAll(lista);
        int ncrediti = totCrediti;
        for(Voto voto: lista){
            ncrediti+= voto.getCrediti();
        }
        int sum =0;
        for(Voto voto: newvoti){
            sum += voto.getVoto()*voto.getCrediti();
        }
        return (float)sum/ncrediti;
    }

}

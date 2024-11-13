import java.util.List;
import java.util.ArrayList;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        App app = new App();
        app.aggiungiPercorso("Laurea A");
        app.aggiungiPercorso("Laurea B");
        // Seleziona il percorso "Laurea B"
        app.selezionaPercorso("Laurea B");

        // Aggiungi un voto al percorso selezionato
        app.aggiungiVoto("Matematica", 28, 12);

        // Calcola la media del percorso selezionato
        float media = app.media();
        System.out.println("Media: " + media);

        // Previsione della media futura
        ArrayList<Voto> votiPrevisti = new ArrayList<>();
        votiPrevisti.add(new Voto("Fisica", 30, 12));
        float mediaFutura = app.prediciMedia(votiPrevisti);
        System.out.println("Media futura: " + mediaFutura);
    }
}

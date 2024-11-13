import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.List;
import java.util.ArrayList;
import javafx.util.Callback;

public class MainApp extends Application {

    private App app = new App();
    private TableView<Voto> votiTable; // Dichiarazione della tabella dei voti come campo della classe
    private List<Voto> votiIpotetici = new ArrayList<>();
    private Label mediaLabel;
    private Label mediaFuturaLabel;
    private Label mediaPonderataLabel;
    private Label mediaFuturaPonderataLabel;

    public void start(Stage primaryStage) {
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10, 10, 10, 10));

        HBox percorsoAddLayout = new HBox(10);
        TextField percorsoField = new TextField();
        percorsoField.setPromptText("Percorso");
        Button aggiungiButton = new Button("Aggiungi percorso");
        ComboBox<String> percorsoComboBox = new ComboBox<>();
        aggiungiButton.setOnAction(e -> {
            String percorso = percorsoField.getText();
            app.aggiungiPercorso(percorso);
            percorsoComboBox.getItems().add(percorso);
            percorsoField.clear();
        });
        percorsoAddLayout.getChildren().addAll(new Label("Aggiungi percorso"), percorsoField, aggiungiButton);
        //sezione di selezione del percorso
        HBox percorsoLayout = new HBox(10);
        percorsoComboBox.setOnAction(e -> {
            String selectedPercorso = percorsoComboBox.getValue();
            app.selezionaPercorso(selectedPercorso);
            updateVotiTable(votiTable);
            updateMediaLabels();
        });
        percorsoLayout.getChildren().addAll(new Label("Seleziona Percorso:"), percorsoComboBox);

        //selezione di aggiunta voti
        HBox votoLayout = new HBox(10);
        TextField materiaField = new TextField();
        materiaField.setPromptText("Materia");
        TextField votoField = new TextField();
        votoField.setPromptText("Voto");
        Button aggiungiVotoButton = new Button("Aggiungi Voto");
        TextField creditiField = new TextField();
        creditiField.setPromptText("Crediti");
        aggiungiVotoButton.setOnAction(e -> {
            try {

                String materia = materiaField.getText();
                int voto = Integer.parseInt(votoField.getText());
                int crediti = Integer.parseInt(votoField.getText());
                if (voto < 18 || voto > 31 || crediti < 6 || crediti > 12) {
                    throw new NumberFormatException();
                }
                app.aggiungiVoto(materia, voto, crediti);
                updateVotiTable(votiTable);
                updateMediaLabels();
            }catch(NumberFormatException ex) {
                    showAlert("Errore", "i valori inseriti non sono validi");
            }
        });
        votoLayout.getChildren().addAll(new Label("Materia:"), materiaField, new Label("Voto:"), votoField, new Label("Crediti:"), creditiField, aggiungiVotoButton);
        // Sezione di aggiunta voti ipotetici
        HBox votoIpoteticoLayout = new HBox(10);
        TextField materiaIpoteticaField = new TextField();
        materiaIpoteticaField.setPromptText("Materia");
        TextField votoIpoteticoField = new TextField();
        votoIpoteticoField.setPromptText("Voto");
        TextField creditiIpoteticiField = new TextField();
        creditiIpoteticiField.setPromptText("Crediti");
        Button aggiungiVotoIpoteticoButton = new Button("Aggiungi Voto : ");
        aggiungiVotoIpoteticoButton.setOnAction(e -> {
            String materia = materiaIpoteticaField.getText();
            int voto = Integer.parseInt(votoIpoteticoField.getText());
            int crediti = Integer.parseInt(creditiIpoteticiField.getText());
            Voto votoIpotetico = new Voto(materia, voto, crediti);
            votiIpotetici.add(votoIpotetico);
            updateMediaLabels();
        });
        votoIpoteticoLayout.getChildren().addAll(new Label("Materia Ipotetica:"), materiaIpoteticaField, new Label("Voto Ipotetico:"), votoIpoteticoField, new Label("Crediti Ipotetici:"), creditiIpoteticiField, aggiungiVotoIpoteticoButton);
        //Bottone per la rimozione di voti ipotetici
        Button rimuoviVotiIpoteticiButton = new Button("Rimuovi Voti Ipotetici");
        rimuoviVotiIpoteticiButton.setOnAction(e -> {
            votiIpotetici.clear();
            updateMediaLabels();
        });

        // Tabella dei voti
        votiTable = new TableView<>();
        TableColumn<Voto, String> materiaColumn = new TableColumn<>("Materia");
        materiaColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMateria()));
        TableColumn<Voto, Integer> votoColumn = new TableColumn<>("Voto");
        votoColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getVoto()).asObject());
        TableColumn<Voto, Integer> creditiColumn = new TableColumn<>("Crediti");
        votoColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getCrediti()).asObject());
        votiTable.getColumns().addAll(materiaColumn, votoColumn, creditiColumn);

        // Sezione delle medie
        mediaLabel = new Label("Media corrente: 0");
        mediaFuturaLabel = new Label("Media futura: 0");
        mediaPonderataLabel = new Label("Media ponderata: 0");
        mediaFuturaPonderataLabel = new Label("Media futura ponderata: 0");

        // Aggiungi tutte le sezioni al layout principale
        layout.getChildren().addAll(percorsoAddLayout, percorsoLayout, votoLayout, votiTable, mediaLabel, mediaFuturaLabel, mediaPonderataLabel, mediaFuturaPonderataLabel);
// Mostra la scena
        Scene scene = new Scene(layout, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();

//colorazione delle celle in base al voto
        votoColumn.setCellFactory(new Callback<TableColumn<Voto, Integer>, TableCell<Voto, Integer>>() {
            @Override
            public TableCell<Voto, Integer> call(TableColumn<Voto, Integer> param) {
                return new TableCell<Voto, Integer>() {
                    @Override
                    protected void updateItem(Integer item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item != null) {
                            setText(String.valueOf(item));
                            setStyle("-fx-background-color: " + getColorForScore(item) + "; -fx-alignment: CENTER;");
                        } else {
                            setText(null);
                            setStyle("");
                        }
                    }
                };
            }
        });

        // Colonna per modificare ed eliminare voti
        TableColumn<Voto, Void> actionsColumn = new TableColumn<>("Azioni");
        actionsColumn.setCellFactory(param -> new TableCell<Voto, Void>() {
            private final Button editButton = new Button("Modifica");
            private final Button deleteButton = new Button("Elimina");

            {
                editButton.setOnAction(e -> {
                    Voto voto = getTableView().getItems().get(getIndex());
                    showEditDialog(voto);
                });
                deleteButton.setOnAction(e -> {
                    Voto voto = getTableView().getItems().get(getIndex());
                    app.getPercorso().getVoti().remove(voto);
                    updateVotiTable(votiTable);
                    updateMediaLabels();
                });
            }

        });
    }




    private void updateVotiTable(TableView<Voto> votiTable) {
        votiTable.getItems().clear();
        if (app.getPercorso() != null) {
            votiTable.getItems().addAll(app.getPercorso().getVoti());
        }
    }

    private void updateMediaLabels() {
        if (app.getPercorso() != null) {
            float media = app.media();
            float mediap = app.mediaPonderata();
            ArrayList<Voto> nuovalistaIpotetica = new ArrayList<>();
            nuovalistaIpotetica.addAll(app.getPercorso().getVoti());
            nuovalistaIpotetica.addAll(votiIpotetici);
            mediaLabel.setText("Media corrente: " + media);
            mediaPonderataLabel.setText("Media ponderata: " + mediap);
            mediaFuturaPonderataLabel.setText("Media futura ponderata: " + getmediaPonderata(nuovalistaIpotetica));
            mediaFuturaPonderataLabel.setText("Media futura: " + getMedia(nuovalistaIpotetica));
        }
    }
    private float getmediaPonderata(ArrayList<Voto> voti) {
        int sum = 0;
        int crediti = 0;
        for(Voto voto: voti){
            sum += voto.getVoto()*voto.getCrediti();
            crediti += voto.getCrediti();
        }
        return sum/crediti;

    }
    private float getMedia(ArrayList<Voto> voti) {
        int sum = 0;
        for(Voto voto: voti){
            sum += voto.getVoto();
        }
        return sum/voti.size();
    }

    public static void main(String args[]) {
        launch(args);
    }
    private String getColorForScore(int score) {
        int green = (score - 18) * 255 / 12;
        int red = 255 - green;
        return String.format("rgb(%d, %d, 0)", red, green);
    }
    private void showEditDialog(Voto voto) {
        Stage dialog = new Stage();
        VBox dialogVBox = new VBox(10);
        dialogVBox.setPadding(new Insets(10, 10, 10, 10));

        TextField materiaField = new TextField(voto.getMateria());
        TextField votoField = new TextField(String.valueOf(voto.getVoto()));
        TextField creditiField = new TextField(String.valueOf(voto.getCrediti()));
        Button saveButton = new Button("Salva");

        saveButton.setOnAction(e -> {
            voto.setMateria(materiaField.getText());
            voto.setVoto(Integer.parseInt(votoField.getText()));
            voto.setCrediti(Integer.parseInt(creditiField.getText()));
            updateVotiTable(votiTable);
            updateMediaLabels();
            dialog.close();
        });

        dialogVBox.getChildren().addAll(new Label("Materia:"), materiaField, new Label("Voto:"), votoField, new Label("Crediti:"), creditiField, saveButton);

        Scene dialogScene = new Scene(dialogVBox, 300, 200);
        dialog.setScene(dialogScene);
        dialog.show();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }





}

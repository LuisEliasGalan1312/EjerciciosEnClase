import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Label;
import javafx.scene.control.Alert;
import java.util.ArrayList;
import java.util.List;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;

public class App extends Application {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField nombreField;
    @FXML
    private ComboBox<String> razaCombo;
    @FXML
    private TextField poderField;
    @FXML
    private TextField planetaField;
    @FXML
    private TextField tecnicaField;
    @FXML
    private TextField edadField;
    @FXML
    private AnchorPane listPane;
    @FXML
    private Button Agregar;

    private List<Personaje> personajes = new ArrayList<>();
    private GridPane personajesGrid;
    private int currentRow = 1;

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Style.fxml"));
        loader.setController(this);
        Scene scene = new Scene(loader.load());
        primaryStage.setTitle("Gestión de Personajes");
        primaryStage.setScene(scene);
        primaryStage.show();

        razaCombo.getItems().addAll("Saiyajin", "Humano", "Namekiano", "Androide", "Majin", "Freezer Race");

    }

    @FXML
    void AGSPersonage(ActionEvent event) {
        String nombre = nombreField.getText().trim();
        String raza = razaCombo.getValue();
        String poderText = poderField.getText().trim();
        String planeta = planetaField.getText().trim();
        String tecnica = tecnicaField.getText().trim();
        String edadText = edadField.getText().trim();

        if (nombre.isEmpty() || raza == null || poderText.isEmpty() || planeta.isEmpty() || tecnica.isEmpty() || edadText.isEmpty()) {
            showAlert("Error", "Todos los campos deben estar llenos.");
            return;
        }

        int poder;
        int edad;
        try {
            poder = Integer.parseInt(poderText);
            if (poder <= 0) {
                showAlert("Error", "El nivel de poder debe ser mayor que 0.");
                return;
            }
        } catch (NumberFormatException e) {
            showAlert("Error", "El nivel de poder debe ser un número válido.");
            return;
        }

        try {
            edad = Integer.parseInt(edadText);
            if (edad <= 0) {
                showAlert("Error", "La edad debe ser mayor que 0.");
                return;
            }
        } catch (NumberFormatException e) {
            showAlert("Error", "La edad debe ser un número válido.");
            return;
        }

        Personaje p = new Personaje(nombre, raza, poder, planeta, tecnica, edad);
        personajes.add(p);

        personajesGrid.add(new Label(p.getNombre()), 0, currentRow);
        personajesGrid.add(new Label(p.getRaza()), 1, currentRow);
        personajesGrid.add(new Label(String.valueOf(p.getNivelPoder())), 2, currentRow);
        personajesGrid.add(new Label(p.getPlanetaOrigen()), 3, currentRow);
        personajesGrid.add(new Label(p.getTecnicaEspecial()), 4, currentRow);
        personajesGrid.add(new Label(String.valueOf(p.getEdad())), 5, currentRow);

        currentRow++;

        nombreField.clear();
        razaCombo.setValue(null);
        poderField.clear();
        planetaField.clear();
        tecnicaField.clear();
        edadField.clear();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    public void initialize() {
        assert Agregar != null : "fx:id=\"Agregar\" was not injected: check your FXML file 'Style.fxml'.";
        assert nombreField != null : "fx:id=\"nombreField\" was not injected: check your FXML file 'Style.fxml'.";
        assert razaCombo != null : "fx:id=\"razaCombo\" was not injected: check your FXML file 'Style.fxml'.";
        assert poderField != null : "fx:id=\"poderField\" was not injected: check your FXML file 'Style.fxml'.";
        assert planetaField != null : "fx:id=\"planetaField\" was not injected: check your FXML file 'Style.fxml'.";
        assert tecnicaField != null : "fx:id=\"tecnicaField\" was not injected: check your FXML file 'Style.fxml'.";
        assert edadField != null : "fx:id=\"edadField\" was not injected: check your FXML file 'Style.fxml'.";
        assert listPane != null : "fx:id=\"listPane\" was not injected: check your FXML file 'Style.fxml'.";

        listPane.getChildren().removeIf(node ->
            node instanceof Label && ((Label) node).getText().contains("Nombre |"));

        personajesGrid = new GridPane();
        personajesGrid.setHgap(10);
        personajesGrid.setVgap(5);
        personajesGrid.setLayoutY(30);

        personajesGrid.add(new Label("Nombre"), 0, 0);
        personajesGrid.add(new Label("Raza"), 1, 0);
        personajesGrid.add(new Label("Poder"), 2, 0);
        personajesGrid.add(new Label("Planeta"), 3, 0);
        personajesGrid.add(new Label("Técnica"), 4, 0);
        personajesGrid.add(new Label("Edad"), 5, 0);

        listPane.getChildren().add(personajesGrid);

        Personaje goku = new Personaje("Goku","Saiyajin",9000,"Vegeta","Kamehameha",35);
        personajes.add(goku);
        personajesGrid.add(new Label(goku.getNombre()), 0, currentRow);
        personajesGrid.add(new Label(goku.getRaza()), 1, currentRow);
        personajesGrid.add(new Label(String.valueOf(goku.getNivelPoder())), 2, currentRow);
        personajesGrid.add(new Label(goku.getPlanetaOrigen()), 3, currentRow);
        personajesGrid.add(new Label(goku.getTecnicaEspecial()), 4, currentRow);
        personajesGrid.add(new Label(String.valueOf(goku.getEdad())), 5, currentRow);
        currentRow++;
    }

    public static void main(String[] args) throws Exception {
        launch(args);
    }
}

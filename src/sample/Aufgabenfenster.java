package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class Aufgabenfenster {
    public static VBox aufgabenScreen(Lehrer l){
    // main Container
        VBox aufgabenBox = new VBox(10);
        aufgabenBox.setPadding(new Insets(10,0,0,20));
    //setup Combobox
        ObservableList<Klasse> klassen = l.getKlist();

        ComboBox klassenCB = new ComboBox(klassen);
        klassenCB.getSelectionModel().selectFirst();
    //Setup Table

        TableView<Person>klassenTable = new TableView<Person>();

        klassenTable.setMaxWidth(300);
        klassenTable.setMaxHeight(300);

        TableColumn<Person,String> firstNameCol = new TableColumn<Person,String>("Vorname");
        TableColumn<Person, String> lastNameCol = new TableColumn<Person, String>("Nachname");
        //Spalten der Tabelle hinzufügen
        klassenTable.getColumns().addAll(firstNameCol,lastNameCol);

        //Daten aus der Tabelle
        firstNameCol.setCellValueFactory(new PropertyValueFactory("firstName"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory("lastName"));
        //
        klassenCB.valueProperty().addListener(new ChangeListener<Klasse>() {
            @Override
            public void changed(ObservableValue<? extends Klasse> observable, Klasse oldValue, Klasse newValue) {
                klassenTable.setItems(newValue.getKlassenListe());
            }
        });


        //Daten in Tableview Editierbar und in Klassenliste speichern
        klassenTable.setEditable(true);

        firstNameCol.setCellFactory(TextFieldTableCell.<Person>forTableColumn());

        firstNameCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Person, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Person, String> event) {
               String newValue = event.getNewValue();
               TablePosition<Person, String>position = event.getTablePosition();

                System.out.println(newValue + " " + position.getColumn() + " " + position.getRow());

                Person person = event.getTableView().getItems().get(position.getRow());
                person.setFirstName(newValue);
            }
        });




        aufgabenBox.getChildren().addAll(klassenCB, klassenTable);

        return aufgabenBox;
    }

}

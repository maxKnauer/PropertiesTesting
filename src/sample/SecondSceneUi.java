package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTabPane;
import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.time.format.TextStyle;

public class SecondSceneUi {
    public VBox secondScene(Stage stage){

        Menu option = new Menu("Option");
        MenuItem neu = new MenuItem("New");
        MenuItem save = new MenuItem("Save");
        option.getItems().addAll(neu, save);
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(option);

        String[] tabContent = {
                "Klassen",
                "Aufgaben",
                "Tests"
        };

        Text iconBook = GlyphsDude.createIcon(FontAwesomeIcon.BOOK);
        iconBook.setFill(Color.web("#edeef2"));
        Text iconPencil = GlyphsDude.createIcon(FontAwesomeIcon.PENCIL);
        iconPencil.setFill(Color.web("#edeef2"));
        Text iconClass = GlyphsDude.createIcon(FontAwesomeIcon.CHILD);
        iconClass.setFill(Color.web("#edeef2"));

        //Äusserster Container
        VBox vbox = new VBox(menuBar);
        vbox.setPrefSize(800.0, 500);

        //TabPane Container
        JFXTabPane tabPane = new JFXTabPane();
        tabPane.setPrefSize(625,500);

    //Tabs
        Tab start = new Tab("");
        Tab tabKlasse = new Tab("Klassen");
        Tab tabAufgabe = new Tab("Aufgaben");
        Tab tabTest = new Tab("Tests");
    //Icons
        tabKlasse.setGraphic(iconClass);
        tabAufgabe.setGraphic(iconBook);
        tabTest.setGraphic(iconPencil);
     //setContent
        start.setContent(new Label("Guten Tag Herr/Frau ...."));
        start.getStyleClass().add("starttab");

        a4.getKlassenListe().addAll(p1,p2);
        b4.getKlassenListe().addAll(p3,p4);
        l1.getKlist().addAll(a4,b4);

        VBox klassenBox = Aufgabenfenster.aufgabenScreen(l1);
        tabKlasse.setContent(klassenBox);

        tabAufgabe.setContent(new Label("Aufgaben"));
        tabTest.setContent(new Label("Test"));
        tabPane.getTabs().addAll(start,tabKlasse,tabAufgabe,tabTest);

        // HBox Button
        HBox btnBox = new HBox();
        //Region abstandRegio = new Region();
        //HBox.setHgrow(abstandRegio, Priority.ALWAYS);
        JFXButton logoutBtn = new JFXButton("Abmelden");
        logoutBtn.getStyleClass().add("raised-button");

        logoutBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("Test");
                Platform.exit();
            }
        });

        btnBox.getChildren().add(logoutBtn);
        btnBox.setPadding(new Insets(5,5,5,25));

        vbox.getChildren().addAll(tabPane, btnBox);
        return vbox;
    }
    Lehrer l1 = new Lehrer("Müller");

    Klasse a4 = new Klasse("4a");
    Klasse b4 = new Klasse("4b");

    Person p1 = new Person("Max", "Knauer");
    Person p2 = new Person("Andi", "Fresse");
    Person p3 = new Person("John", "Doe");
    Person p4 = new Person("Hans", "Gruber");

}

package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Klasse {
    private final SimpleStringProperty bezeichnung;
    private ObservableList<Person> klassenListe = FXCollections.observableArrayList();

    public Klasse(String bez) {
        this.bezeichnung = new SimpleStringProperty(bez);
    }

    public ObservableList<Person> getKlassenListe() {
        return klassenListe;
    }

    public void setKlassenListe(ObservableList<Person> klassenListe) {
        this.klassenListe = klassenListe;
    }

    public String getBezeichnung() {
        return bezeichnung.get();
    }
    public void setBezeichnung(String bez){
        bezeichnung.set(bez);
    }

    @Override
    public String toString() {
        return "Klasse: " + bezeichnung.get();
    }
}

package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Lehrer {
    private final SimpleStringProperty name;
    private ObservableList<Klasse> klist = FXCollections.observableArrayList();


    public Lehrer(String name) {
        this.name = new SimpleStringProperty(name);
    }

    public ObservableList<Klasse> getKlist() {
        return klist;
    }

    public void setKlist(ObservableList<Klasse> klist) {
        this.klist = klist;
    }

    public String getName() {
        return name.get();
    }
    public void setName(String name){
        this.name.set(name);
    }
}

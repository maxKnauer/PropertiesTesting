package sample;

import javafx.beans.property.SimpleStringProperty;

public class Person {
    private final SimpleStringProperty firstName;
    private final SimpleStringProperty lastName;


    public Person(String firstName, String lastName) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
    }

    public String getFirstName(){
        return firstName.get();
    }
    public void setFirstName(String fname){
        firstName.set(fname);
    }
    public String getLastName(){
        return lastName.get();
    }
    public void setLastName(String lname){
        lastName.set(lname);
    }

}

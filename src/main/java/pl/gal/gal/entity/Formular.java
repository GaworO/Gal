package pl.gal.gal.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "form")
public class Formular {


    @Id
    @GeneratedValue
    private long id ;

    private String name ;
    private String surname ;
    private String number ;

    private String email ;
    private String message ;

    public Formular(String name, String surname, String number, String email, String message) {
        this.name = name;
        this.surname = surname;
        this.number = number;
        this.email = email;
        this.message = message;
    }

    public Formular() {
    }

    public Formular allData(String name , String surname , String email , String message) {
        Formular formular = new Formular() ;
        formular.setEmail(email);
        formular.setMessage(message);
        formular.setName(name);
        formular.setSurname(surname);
        return  formular ;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

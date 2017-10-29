package pl.gal.gal.entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "form")
public class Formular {


    @Id
    @GeneratedValue
    private long id ;

    @NotBlank
    private String subject;
    @NotBlank
    private String name ;
    @NotBlank
    private String surname ;
    @NotBlank
    private String number ;
    @Email
    private String email ;
    @NotBlank
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

    public Formular(String subject, String name, String surname, String number, String email, String message) {
        this.subject = subject;
        this.name = name;
        this.surname = surname;
        this.number = number;
        this.email = email;
        this.message = message;
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}

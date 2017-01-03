package org.kset.brucx.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marin on 17.12.2016..
 */
public class Student {

    private String jmbag;

    private String nfcId;

    private String name;

    private String surname;

    private String email;

    /**
     * Base64 encoded image
     */
    private String image;

    private List<Ticket> tickets = new ArrayList<>();

    private Boolean freshmen;

    public String getJmbag() {
        return jmbag;
    }

    public void setJmbag(String jmbag) {
        this.jmbag = jmbag;
    }

    public String getNfcId() {
        return nfcId;
    }

    public void setNfcId(String nfcId) {
        this.nfcId = nfcId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public Boolean getFreshmen() {
        return freshmen;
    }

    public void setFreshmen(Boolean freshmen) {
        this.freshmen = freshmen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (jmbag != null ? !jmbag.equals(student.jmbag) : student.jmbag != null) return false;
        return nfcId != null ? nfcId.equals(student.nfcId) : student.nfcId == null;

    }

    @Override
    public int hashCode() {
        return jmbag != null ? jmbag.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Student{" +
                "jmbag='" + jmbag + '\'' +
                ", nfcId='" + nfcId + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", image='" + image + '\'' +
                ", tickets=" + tickets +
                ", freshmen=" + freshmen +
                '}';
    }
}

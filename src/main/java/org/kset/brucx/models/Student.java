package org.kset.brucx.models;

import java.util.Arrays;

/**
 * Created by marin on 17.12.2016..
 */
public class Student {

    private String jmbag;

    private String nfcId;

    private String name;

    private String surname;

    private String email;

    private Byte[] image;

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

    public Byte[] getImage() {
        return image;
    }

    public void setImage(Byte[] image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        return jmbag != null ? jmbag.equals(student.jmbag) : student.jmbag == null;

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
                ", image=" + Arrays.toString(image) +
                '}';
    }
}

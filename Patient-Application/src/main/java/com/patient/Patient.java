package com.patient;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
class Patient {

    @Id @GeneratedValue
    private Long id;

    private String name;
    private String symptom;
    private int department;
    private int section;
    private int post;

    Patient() {}

    Patient(String name, String symptom) {
        this.name = name;
        this.symptom = symptom;
        this.department = 0;
        this.section = 0;
        this.post = 0;
    }

    Patient(String name, String symptom, int department, int section, int post) {
        this.name = name;
        this.symptom = symptom;
        this.department = department;
        this.section = section;
        this.post = post;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getSymptom() {
        return this.symptom;
    }

    public int getDepartment() {
        return this.department;
    }

    public int getSection() {
        return this.section;
    }

    public int getPost() {
        return this.post;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSection(int section) {
        this.section = section;
    }

    public void setPost(int post) {
        this.post = post;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Patient))
            return false;
            Patient patient = (Patient) o;
        return Objects.equals(this.id, patient.id) && Objects.equals(this.name, patient.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.symptom, this.department, this.section, this.post);
    }

    @Override
    public String toString() {
        return "Patient{" + "id=" + this.id + 
        ", name='" + this.name + '\'' + 
        ", symptom='" + this.symptom + '\'' + 
        ", department='" + this.department + '\'' +
        ", section='" + this.section + '\'' +
        ", post='" + this.post + '\'' + '}';
    }
}
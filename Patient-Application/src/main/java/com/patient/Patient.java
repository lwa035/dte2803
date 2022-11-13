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
    private int visits;

    Patient() {}

    Patient(String name, String symptom) {
        this.name = name;
        this.symptom = symptom;
        this.visits = 0;
    }

    Patient(String name, String symptom, int visits) {
        this.name = name;
        this.symptom = symptom;
        this.visits = visits;
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

    public int getVisits() {
        return this.visits;
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

    public void setSymptom(int visits) {
        this.visits = visits;
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
        return Objects.hash(this.id, this.name, this.symptom, this.visits);
    }

    @Override
    public String toString() {
        return "Patient{" + "id=" + this.id + ", name='" + this.name + '\'' + ", symptom='" + this.symptom + '\'' + ", visits='" + this.visits + '\'' + '}';
    }
}
package com.patient;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
class Patient {

    private @Id @GeneratedValue Long id;
    private String name;
    private String symptom;

    Patient() {}

    Patient(String name, String symptom) {
        this.name = name;
        this.symptom = symptom;
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Patient))
            return false;
            Patient patient = (Patient) o;
        return Objects.equals(this.id, patient.id) && Objects.equals(this.name, patient.name)
            && Objects.equals(this.symptom, patient.symptom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.symptom);
    }

    @Override
    public String toString() {
        return "Patient{" + "id=" + this.id + ", name='" + this.name + '\'' + ", role='" + this.symptom + '\'' + '}';
    }
}
package com.patient;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

class Patient {
	private UUID id;

    private String name;
    private Set<String> symptoms;
    private int department;
    private int section;
    private int post;

    Patient() {}

    Patient(UUID id, String name, Set<String> symptoms) {
        this.id = id;
        this.name = name;
        this.symptoms = symptoms;
        this.department = 0;
        this.section = 0;
        this.post = 0;
    }

    Patient(UUID id, String name, Set<String> symptoms, int department, int section, int post) {
        this.id = id;
        this.name = name;
        this.symptoms = symptoms;
        this.department = department;
        this.section = section;
        this.post = post;
    }

    public UUID getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Set<String> getSymptoms() {
        return this.symptoms;
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

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSymptom(Set<String> symptoms) {
        this.symptoms = symptoms;
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
        return Objects.hash(this.id, this.name, this.symptoms, this.department, this.section, this.post);
    }

    @Override
    public String toString() {
        return "Patient{" + "id=" + this.id + 
        ", name='" + this.name + '\'' + 
        ", symptom='" + String.join(", ", symptoms) + '\'' + 
        ", department='" + this.department + '\'' +
        ", section='" + this.section + '\'' +
        ", post='" + this.post + '\'' + '}';
    }
}
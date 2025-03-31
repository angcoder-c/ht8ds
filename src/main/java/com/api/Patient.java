package com.api;

public class Patient implements Comparable<Patient> {
    private String name;
    private String priority; // A, B, C, etc.
    private String diagnosis;

    public Patient(String name, String priority, String diagnosis) {
        this.name = name;
        this.priority = priority;
        this.diagnosis = diagnosis;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    @Override
    public int compareTo(Patient other) {
        // Reverse the natural order to make it descending (A > B > C > D > E)
        return this.priority.compareTo(other.priority);
    }

    @Override
    public String toString() {
        return "Patiente name: '" + name + "', prioridad: " + priority + ", diagnostico: '" + diagnosis + "'";
    }
}

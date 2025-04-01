package com.api;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class TextController {
    /**
     * Reads patient data from a file and returns a list of Patient objects.
     *
     * @param filePath the path to the file containing patient data
     * @return a list of Patient objects
     */
    // Method made by Marco Alejandro Díaz Castañeda
    // created on 30-03-2025
    public List<Patient> readPatientsFromFile(String filePath) {
        List<Patient> patients = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] attributes = line.split(",");
                if (attributes.length == 3) {
                    String name = attributes[0];
                    String priority = attributes[2];
                    String condition = attributes[1];
                    patients.add(new Patient(name,priority, condition));
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error parsing age: " + e.getMessage());
        }
        return patients;
    }
}
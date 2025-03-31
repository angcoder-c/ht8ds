
package com.api;

import java.util.List;
import java.util.Scanner;

/**
 * Main application class that demonstrates the use of a priority queue
 * for managing patients based on their priority.
 * 
 * <p>This program allows the user to select an implementation of a priority queue
 * (Java Collections Framework or Vector) and then processes a list of patients
 * read from a file. The patients are added to the selected priority queue and
 * displayed in order of their priority.</p>
 * 
 * <p>Method made by Marco Alejandro Díaz Castañeda</p>
 * <p>Created on 30-03-2025</p>
 */
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {

            System.out.println("Seleccione la implementación a utilizar:");
            System.out.println("1. Java Collections Framework (JCF)");
            System.out.println("2. Vector");
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            InterfacePriority<Patient> heap = FactoryPriorityQueue.getInstanceFactory(choice);
            if (heap == null) {
                System.out.println("Opción no válida. Intente de nuevo.");
                continue;
            } else {
                flag = false;
            }
            System.out.println("Implementación seleccionada: " + heap.getClass().getSimpleName());
        
        TextController textController = new TextController();
        List<Patient> patients = textController.readPatientsFromFile("./src/resources/pacientes.txt");
        if (patients.isEmpty()) {
            System.out.println("No se encontraron pacientes en el archivo.");
            return;
        }
        for (Patient patient : patients) {
            heap.add(patient);

        }

        System.out.println("Pacientes ordenados por prioridad:");
        while (!heap.isEmpty()) {
            System.out.println(heap.poll());
        }

        scanner.close();
    }
    }
}

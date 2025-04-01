package com.api;

public class FactoryPriorityQueue {
    /* 
     * This method returns an instance of a priority queue based on the specified type.
     * @param type The type of priority queue to create (1 for Java Collections Framework, 2 for Vector).
     * @param <E> The type of elements in the priority queue.
     * @return An instance of InterfacePriority<E> based on the specified type.
     * Method made by Marco Alejandro Díaz Castañeda
     * created on 30-03-2025
     */
    public static <E extends Comparable<E>> InterfacePriority<E> getInstanceFactory(int type) {
        if (type == 1) {
            return new JavaPriorityQueue<E>();
        } else if (type== 2) {
            return new VectorHeap<E>();
        }
        return null; 
}}
package com.api;

public class FactoryPriorityQueue {
    public static <E extends Comparable<E>> InterfacePriority<E> getInstanceFactory(String type) {
        if (type.equals("java")) {
            return new javaPriorityQueue<E>();
        } else if (type.equals("vector")) {
            return new VectorHeap<E>();
        }
        return null; 
}}
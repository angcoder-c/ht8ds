package com.api;

import java.util.PriorityQueue;

public class javaPriorityQueue<E extends Comparable<E>> implements InterfacePriority<E> {
    private PriorityQueue<E> queue;

    public javaPriorityQueue() {
        queue = new PriorityQueue<>();
    }

    @Override
    public E peek() {
        return queue.peek();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public E poll() {
        return queue.poll();
    }

    @Override
    public void add(E value) {
        queue.add(value);
    }

    @Override
    public void clear() {
        queue.clear();
    }
}

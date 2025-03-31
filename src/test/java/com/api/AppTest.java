package com.api;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.PriorityQueue;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void testVectorHeapAndPriorityQueueAdd() {
        VectorHeap<Integer> vectorHeap = new VectorHeap<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        vectorHeap.add(10);
        priorityQueue.add(10);

        vectorHeap.add(5);
        priorityQueue.add(5);

        vectorHeap.add(20);
        priorityQueue.add(20);

        assertEquals(priorityQueue.peek(), vectorHeap.peek());
    }

    @Test
    public void testVectorHeapAndPriorityQueueRemove() {
        VectorHeap<Integer> vectorHeap = new VectorHeap<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        vectorHeap.add(10);
        priorityQueue.add(20);

        priorityQueue.add(5);
        priorityQueue.add(10);

        vectorHeap.add(20);
        vectorHeap.add(5);
        assertEquals(priorityQueue.poll(), vectorHeap.poll());
        assertEquals(priorityQueue.poll(), vectorHeap.poll());
        assertEquals(priorityQueue.poll(), vectorHeap.poll());
    }

    @Test
    public void testVectorHeapAndPriorityQueueIsEmpty() {
        VectorHeap<Integer> vectorHeap = new VectorHeap<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        assertEquals(priorityQueue.isEmpty(), vectorHeap.isEmpty());

        vectorHeap.add(10);
        priorityQueue.add(10);

        assertEquals(priorityQueue.isEmpty(), vectorHeap.isEmpty());

        vectorHeap.poll();
        priorityQueue.poll();

        assertEquals(priorityQueue.isEmpty(), vectorHeap.isEmpty());
    }
    @Test
    public void testVectorHeapAddSingleElement() {
        VectorHeap<Integer> vectorHeap = new VectorHeap<>();
        vectorHeap.add(15);
        assertEquals(15, vectorHeap.peek());
    }

    @Test
    public void testVectorHeapRemoveSingleElement() {
        VectorHeap<Integer> vectorHeap = new VectorHeap<>();
        vectorHeap.add(30);
        int removedElement = vectorHeap.poll();
        assertEquals(30, removedElement);
        assertEquals(true, vectorHeap.isEmpty());
    }

    @Test
    public void testVectorHeapAddMultipleElements() {
        VectorHeap<Integer> vectorHeap = new VectorHeap<>();
        vectorHeap.add(25);
        vectorHeap.add(10);
        vectorHeap.add(40);
        assertEquals(10, vectorHeap.peek());
    }

    @Test
    public void testVectorHeapRemoveMultipleElements() {
        VectorHeap<Integer> vectorHeap = new VectorHeap<>();
        vectorHeap.add(50);
        vectorHeap.add(20);
        vectorHeap.add(30);
        assertEquals(20, vectorHeap.poll());
        assertEquals(30, vectorHeap.poll());
        assertEquals(50, vectorHeap.poll());
        assertEquals(true, vectorHeap.isEmpty());
    }
}

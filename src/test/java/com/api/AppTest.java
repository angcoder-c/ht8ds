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
}

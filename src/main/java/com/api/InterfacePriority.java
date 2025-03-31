package com.api;

/**
 * Interface for a priority queue.
 * 
 * @param <E> the type of elements in the priority queue, which must be comparabl
 *   this class was based on the one whos from the book "Data Structures and Algorithms in Java" 
 * Method made by Marco Alejandro Díaz Castañeda</p>
 * <p>Created on 30-03-2025</p>
 */


	public interface InterfacePriority<E extends Comparable<E>>{

	public E peek();
	// pre: !isEmpty()
	// post: returns the minimum value in priority queue
	
	public E poll();
	// pre: !isEmpty()
	// post: returns and removes minimum value from queue
	
	public void add(E value);
	// pre: value is non-null comparable
	// post: value is added to priority queue
	
	public boolean isEmpty();
	// post: returns true iff no elements are in queue
	
	public int size();
	// post: returns number of elements within queue
	
	public void clear();
	// post: removes all elements from queue
	}


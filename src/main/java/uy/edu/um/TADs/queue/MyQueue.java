package uy.edu.um.TADs.queue;

public interface MyQueue<T> {

	void enqueue(T value);

	T dequeue() throws EmptyQueueException;
	
	boolean contains(T value);

	T get(int i);
	
	int size();

	boolean isEmpty();
}

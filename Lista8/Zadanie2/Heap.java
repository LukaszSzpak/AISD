package Zadanie2;

import java.util.ArrayList;

public class Heap {
	
	private ArrayList<Integer> list;
	
	public Heap() {
		list = new ArrayList<Integer>();
	}
	
	public void enqueue(Integer value) {
		list.add(value);
		swim(list.size() - 1);
	}
	
	public void clear() {
		list.clear(); 
	}
	
	public int size() {
		return list.size(); 
	}
	public boolean isEmpty(){
		return list.isEmpty();
	}

	public boolean isFull() {
		return false;
	}
	
	public Integer first() throws EmptyQueueException {
		if (isEmpty()) 
			throw new EmptyQueueException();
		
		return list.get(0);
	}
	
	public Integer dequeue() throws EmptyQueueException {
		if (isEmpty()) 
			throw new EmptyQueueException();
		
		Integer result = list.get(0);
		if (list.size() > 1) {
			list.set(0, list.get(list.size() - 1));
			sink(0);
		}
		
		list.remove(list.size() - 1);
		return result;
	}
	
	public void change(Integer value, int index) throws IndexOutOfBoundsException {
		
		if (index >= list.size())
			throw new IndexOutOfBoundsException();
		if (value > list.get(index)) {
			list.set(index, value);
			swim(index);
		} else {
			list.set(index, value);
			sink(index);
		}
		
	}
	
	private void swim(int index) {
		 int parent;
		 
		 while(index != 0 && list.get(index) < list.get(parent = (index - 1) / 2) ) {
			 swap(index, parent);
			 index = parent;
		 }
	}
	
	private void sink(int index) {
		
		 boolean isDone=false;
		 int child;
		 
		 while(!isDone && (child = 2 * index + 1 ) < list.size()) {
			 if (child < list.size()- 1 && list.get(child) > list.get(child + 1) )
				 child++;
			
			 if (list.get(index) > list.get(child) ) {
				 swap(index, child);
				 index = child;
				 
			 } else 
				 isDone=true;
		 }
	}
	
	private void swap(int index1, int index2) {
		 Integer temp = list.get(index1);
		 list.set(index1, list.get(index2));
		 list.set(index2, temp);
		 
		}
}

class EmptyQueueException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}
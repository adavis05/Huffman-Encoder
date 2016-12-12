package edu.Frostburg.COSC310_Aaron_Davis_Huffman_Encoder;

/**
 * 
 * This class defines a priority queue
 * @author aarondavis
 *
 */
public class PriorityQueue {

	//Heap that maintains the queue
	public Heap heap;
	
	//Max size of the queue 
	private int maxSize;
	
	/**
	 * Constructor
	 * Creates a heap of size = maxSize
	 * @param size
	 */
	PriorityQueue(int maxSize){
		
		this.maxSize = maxSize;
		heap = new Heap(maxSize);
	}
	
	/**
	 * Creates a priority queue
	 * @param size
	 * @return the Priority queue
	 */
	public static PriorityQueue startHeap(int size) {
		
		PriorityQueue priorQ = new PriorityQueue(size);
		return priorQ;
	}
	
	/**
	 * Insert a new node in the queue
	 * @param node
	 */
	public void insert(TreeNode node) {
		
		if(node.getFreq() <= 0)
			return;
		
		//If Heap is full
		if(heap.heapSize >= maxSize)
			System.out.println("This heap is full");
		
		else {
			heap.heapSize++;
			heap.nodes[heap.heapSize] = node;
			heap.heapifyUp(heap.heapSize);
		}
	}
	
	/**
	 * @return - the root node
	 * Since with the Heap, the minimum is the first number in the array
	 */
	public TreeNode findMin() {
		
		return heap.nodes[1];
	}
	
	/**
	 * @return - root node
	 * Also deletes the root node
	 */
	public TreeNode pop() {
		
		TreeNode node = findMin();
		delete(1);
		return node;
	}
	
	/**
	 * Deletes the node at index var of the heap
	 * I.E. extract Min delete's first element in Array
	 * @param var
	 */
	private void delete(int var) {
		
		if(heap.heapSize < 1) 
			System.out.println("Heap is empty.");
		
		else{
			heap.nodes[var] = heap.nodes[heap.heapSize];
			heap.nodes[heap.heapSize] = null;
			heap.heapSize--;
			
			//Calls this method to fix Heap array
			heap.heapifyDown(var);
		}
	}
	
	/**
	 * Locate node in Queue and change it's value
	 * @param node
	 * @param a
	 */
	public void changeValue(TreeNode node, int a) {
		
		int temp = 0;
		for(temp = 1; temp <= maxSize; temp++) {
			if(heap.nodes[temp].getLetter() == node.getLetter())
				break;
		}
		
		if(heap.nodes[temp].getFreq() <= a) {
			heap.nodes[temp].setFreq(a);
			heap.heapifyDown(temp);
		}
		
		else {
			heap.nodes[temp].setFreq(a);
			heap.heapifyUp(temp);
		}
	}
}

package edu.Frostburg.COSC310_Aaron_Davis_Huffman_Encoder;

/**
 * 
 * This class defines a Heap as an array
 * @author aarondavis
 *
 */
public class Heap {

	//Array of nodes
	TreeNode[] nodes;
	
	//Number of nodes in the heap
	int heapSize;
	
	/**
	 * Constructor for Heap class
	 * @param size
	 */
	public Heap(int size){
		
		nodes = new TreeNode[size + 1];
		heapSize = 0;
	}
	
	/**
	 * Re-arranges the heap to maintain the correct order
	 * Heap is rearranged based upon frequency of a node
	 * - Textbook implementation
	 */
	public void heapifyUp(int var){
		
		if(var > 1){
			
			int temp = var/2;
			if(nodes[var].getFreq() < nodes[temp].getFreq()){
				
				swap(var, temp);
				heapifyUp(temp);
			}
		}
	}
	
	/**
	 * Re-arranges the heap to maintain the correct order
	 * Heap is rearranged based on frequency of a node
	 * - Textbook implementation of method
	 * @param temp
	 */
	public void heapifyDown(int var){
		
		int left = 2 * var;
		int right = 2 * var + 1;
		
		//Smallest element
		int min = var;
		
		//Construct tree to the left
		//Ends when min is the smallest node
		if(left <= heapSize && nodes[left].getFreq() < nodes[var].getFreq()) 
			min = left;
		else
			min = var;
		
		//Construct tree to the right
		if(right <= heapSize && nodes[right].getFreq() < nodes[var].getFreq())
			min = right;
		
		//Swap var and min and continue
		if(min != var) {
			
			swap(min, var);
			heapifyDown(min);
		}
	}
	
	/**
	 * Swap 2 nodes
	 * @param a
	 * @param b
	 */
	private void swap(int a, int b){
		
		TreeNode temp = nodes[b];
		nodes[b] = nodes[a];
		nodes[a] = temp;
	}
}

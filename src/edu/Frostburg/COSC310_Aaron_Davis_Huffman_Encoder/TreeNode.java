package edu.Frostburg.COSC310_Aaron_Davis_Huffman_Encoder;

/**
 * 
 * This class defines a node of a tree and contains methods to access data members
 * - Help from this class came from Stack Overflow
 * Node will store the letter with it's calculated frequency
 * @author aarondavis
 *
 */
public class TreeNode {

	//Symbol associated with the node
	private char letter;
	
	//Frequency with which the symbol appears
	private float freq;
	
	//Left child
	private TreeNode left;
	
	//Right child
	private TreeNode right;
	
	/**
	 * Constructor
	 * @param letter
	 * @param frequency
	 * @param left
	 * @param right
	 */
	public TreeNode(char letter, float frequency, TreeNode left, TreeNode right){
		
		setLetter(letter);
		setFreq(frequency);
		setLeftChild(left);
		setRightChild(right);
	}

	/**
	 * Sets letter
	 * @param letter
	 */
	public void setLetter(char letter){
		this.letter = letter;
	}
	
	/**
	 * 
	 * @return - letter of the node
	 */
	public char getLetter(){
		return letter;
	}
	
	/**
	 * Frequency of the letter
	 * @param frequency
	 */
	public void setFreq(float freq){
		this.freq = freq;
	}
	
	/**
	 * 
	 * @return - The frequency of the letter
	 */
	public float getFreq() {
		return freq;
	}
	
	/**
	 * Sets the left child of the node
	 * @param left
	 */
	public void setLeftChild(TreeNode left) {
		this.left = left;
	}
	
	/**
	 * Returns the left child of the node
	 * @return
	 */
	public TreeNode getLeftChild() {
		return left;
	}
	
	/**
	 * Sets the right child of the node
	 * @param right
	 */
	public void setRightChild(TreeNode right) {
		this.right = right;
	}
	
	/**
	 * Returns the right child of the node
	 * @return
	 */
	public TreeNode getRightChild() {
		return right;
	}
}

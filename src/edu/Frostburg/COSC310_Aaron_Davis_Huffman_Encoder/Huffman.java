package edu.Frostburg.COSC310_Aaron_Davis_Huffman_Encoder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Huffman {

	// Number of letters in the alphabet;
	private int num = 26;

	//holds all letters a to z
	private char[] characters;

	//Holds the frequency of a character
	private float[] freq;

	//Holds huffman Codes
	private String[] codes;

	//Used to generate Huffman tree
	private PriorityQueue priorityQueue;

	// input file name
	public String fileName;

	// the total number of letters in the input file
	private int totalLetters;
	// private int num = numOfCharacters(fileName);

	/**
	 * Initializes the arrays characters, freq and codes
	 * 
	 * @param _n
	 */
	public Huffman() {

		// initializes characters with the characters from a to z
		this.characters = new char[num + 1];
		char j = 'a';
		for (int i = 1; i <= num; i++) {
			characters[i] = j;
			j++;
		}

		// initialize total letters and P with 0
		totalLetters = 0;
		this.freq = new float[num + 1];
		for (int i = 1; i <= num; i++) {
			freq[i] = 0;
		}

		// initializes code
		this.codes = new String[num + 1];
		for (int i = 1; i <= num; i++) {
			codes[i] = "";
		}

	}

	/**
	 * Borrowed idea from Stack Overflow Call all methods, in order you'd like
	 * them to be called in a method
	 * 
	 * @throws Exception
	 */
	public void runThis() throws Exception {

		readFile(fileName);
		fillQueue();
		huffmanTreeCode();
		TreeNode node = priorityQueue.pop();
		depthFirst(node, "");
		printOut();
	}

	/**
	 * Generates an output file containing the symbols, their frequencies and
	 * code.
	 */
	public void printOut() {

		// Building the output as a string
		StringBuilder output = new StringBuilder();

		for (int i = 1; i <= num; i++) {
			output.append(characters[i] + ": " + freq[i] + "\t-> " + codes[i] + "\n");
		}

		System.out.println(output.toString());
	}

	/**
	 * Traverses depth first to generate huffman code character
	 * 
	 * @param node
	 * @param code
	 */
	public void depthFirst(TreeNode node, String code) {

		// Check to see if tree is empty
		if (node == null) {
			//
			//System.out.println("This tree is empty!");
		}

		else {
			int index = 0;
			for (int i = 0; i < num; i++) {
				if (characters[i] == node.getLetter()) {
					index = i;
					break;
				}
			}

			//Store the current code in the code array at the index of the code
			this.codes[index] = code;

			// Traverse left on the tree first, then right
			depthFirst(node.getLeftChild(), code + "1");
			depthFirst(node.getRightChild(), code + "0");
		}

	}

	/**
	 * Generates the Huffman tree
	 */
	public void huffmanTreeCode() {

		for (int i = 1; i < num - 1; i++) {
			
			//Creating the tree
			TreeNode parent = new TreeNode(' ', 0, null, null);

			//Small number goes to the right now
			TreeNode rightChild = priorityQueue.pop();
			parent.setRightChild(rightChild);

			//Larger number becomes left node
			TreeNode leftChild = priorityQueue.pop();
			parent.setLeftChild(leftChild);

			//Sets frequency of parent then places in Queue
			parent.setFreq(rightChild.getFreq() + leftChild.getFreq());
			priorityQueue.insert(parent);
		}
	}

	/**
	 * Build the priority queue with the letter with least frequency on top of
	 * the queue - Method style taken from Stack Overflow. Used to fill
	 * priorityQueue
	 */
	public void fillQueue() {
		priorityQueue = PriorityQueue.startHeap(num);
		TreeNode node;
		for (int i = 1; i <= num; i++) {
			node = new TreeNode(characters[i], freq[i], null, null);
			priorityQueue.insert(node);
		}
	}

	/**
	 * Parses the input file to fill in Characters and total up the number of total letters
	 * 
	 * @param fileName
	 * @throws IOException
	 */
	public void readFile(String fileName) throws IOException {
		BufferedReader input = new BufferedReader(new FileReader(fileName));
		StringBuilder contents = new StringBuilder();

		String line = "";
		while ((line = input.readLine()) != null) {
			contents.append(line.trim().toLowerCase());
		}
		input.close();

		String s = contents.toString();
		int letter;

		// Filling frequency array
		// Only with letters, no special symbols or numbers
		// Also keep tabs of total letters
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
				letter = s.charAt(i);
				freq[letter - 96] = freq[letter - 96] + 1;
				totalLetters++;
			}

		}

		//For each character, the equivalent frequency is stored in the index of freq
		for (int i = 1; i <= num; i++)
			freq[i] = freq[i] / totalLetters;
	}

	/**
	 * Number of unique characters in a string Method isn't used for this
	 * implementation
	 * 
	 * @param s
	 * @return
	 */
	public int numOfCharacters(String s) {
		HashMap<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			Integer value = map.get(new Character(c));

			if (value != null) {
				map.put(c, new Integer(value + 1));
			}

			else {
				map.put(c, 1);
			}
		}
		return map.size();
	}

	/*
	 * public char charAtPos(HashMap temp, int i){ return temp.get(i); }
	 * 
	 * public int numAtPos(HashMap ) { HashMap<Character, Integer> map = new
	 * HashMap<>();
	 * 
	 * for(int i = 0; i < map.size(); i++){
	 * 
	 * } }
	 */
}

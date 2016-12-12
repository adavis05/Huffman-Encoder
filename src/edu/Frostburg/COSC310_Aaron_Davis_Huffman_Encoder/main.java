package edu.Frostburg.COSC310_Aaron_Davis_Huffman_Encoder;

import java.io.FileNotFoundException;

public class main {
	
	public static void main(String[] args) throws Exception {
		
		if(args.length < 1){
			System.out.println("Please enter file as a command line argument.");
		}
		
		Huffman huffman = new Huffman();
		huffman.fileName = args[0];
		huffman.runThis();
	}
}

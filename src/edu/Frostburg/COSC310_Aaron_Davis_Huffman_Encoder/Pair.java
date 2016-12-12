package edu.Frostburg.COSC310_Aaron_Davis_Huffman_Encoder;

public class Pair {

	private Character letter;
	private int num;
	
	public Pair(Object object, int num){
		this.letter = (Character) object;
		this.num = num;
	}
	
	public char getLetter(){
		return letter;
	}
	
	public int getNum(){
		return num;
	}
	
	public int setNum(int num){
		this.num = num;
		return num;
	}
}

package edu.c3341;

public class No1 implements No {
	private Tokenizer t;
	int NoVal;
	public No1(Tokenizer t) {
		this.t = t;
	}
	
	public void ParseNo() {
		t.getToken();
		this.NoVal = t.intVal();
		t.skipToken();
	}
	
	public void PrintNo() {
		System.out.print(this.NoVal);
	}
	
	public int ExecNo() {
		
		return this.NoVal;
	}
}

package edu.c3341;

public class Assign1 implements Assign {
	private Id1 id;
	private Exp1 exp;
	private Tokenizer t;
	private int indent;
	
	public Assign1(Tokenizer t, int indent) {
		this.id = null;
		this.exp = null;
		this.t = t;
		this.indent = indent;
	}
	
	public void ParseAssign() {
		id = Id1.ParseIdForSS();
		t.getToken();
		t.skipToken();
		exp = new Exp1(t);
		exp.ParseExp();
		t.skipToken();
	}
	
	public void PrintAssign() {
		Helper.PrintIndentation(indent);
		this.id.PrintId();
		System.out.print(" = ");
		this.exp.PrintExp();
		System.out.println(";");
	}
	
	public void ExecAssign() {
		this.id.val = this.exp.ExecExp();
		this.id.initialized = true;
	}
}

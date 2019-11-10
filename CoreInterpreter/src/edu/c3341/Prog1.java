package edu.c3341;

import java.util.Iterator;

public class Prog1 implements Prog {
	private DS1 declSeq;
	private SS1 stmtSeq;
	private Tokenizer t;
	private Iterator<String> itStr;
	private int indent;
	public Prog1(Tokenizer t, Iterator<String> itString) {
		this.declSeq = null;
		this.stmtSeq = null;
		this.t = t;
		this.itStr = itString;
		this.indent = 0;
	}
	public void ParseProg() {
		t.skipToken();
		this.declSeq = new DS1(t, this.indent+1);
		this.declSeq.ParseDS();
		t.skipToken();
		this.stmtSeq = new SS1(t, this.itStr, this.indent+1);
		this.stmtSeq.ParseSS();
		t.skipToken();
	}
	public void PrintProg() {
		System.out.println("program");
		this.declSeq.PrintDS();
		System.out.println("begin");
		this.stmtSeq.PrintSS();
		System.out.println("end");
	}
	public void ExecProg() {
		this.declSeq.ExecDS();
		this.stmtSeq.ExecSS();
	}
	
	
}

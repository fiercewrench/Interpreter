package edu.c3341;

import java.util.Iterator;

public class Loop1 implements Loop {
	private Cond1 c;
	private SS1 ss;
	private Tokenizer t;
	private Iterator<String> itStr;
	private int indent;
	public Loop1(Tokenizer t, Iterator<String> itString, int indent) {
		this.c = null;
		this.ss = null;
		this.t = t;
		this.itStr = itString;
		this.indent = indent;
	}
	
	public void ParseLoop() {
		t.skipToken();
		this.c = new Cond1(t);
		this.c.ParseCond();
		t.skipToken();
		this.ss = new SS1(t, this.itStr, this.indent+1);
		this.ss.ParseSS();
		t.skipToken();
		t.skipToken();
	}
	
	public void PrintLoop() {
		Helper.PrintIndentation(this.indent);
		System.out.print("while ");
		this.c.PrintCond();
		System.out.println(" loop");
		this.ss.PrintSS();
		Helper.PrintIndentation(this.indent);
		System.out.println("end;");
	}
	
	public void ExecLoop() {
		while(this.c.ExecCond()) {
			this.ss.ExecSS();
		}
	}
}

package edu.c3341;

import java.util.Iterator;

public class If1 implements If {
	private Cond1 c;
	private SS1 ss1;
	private SS1 ss2;
	private Tokenizer t;
	private int altNo;
	private Iterator<String> itStr;
	private int indent;
	
	public If1(Tokenizer t, Iterator<String> itString, int indent) {
		this.c = null;
		this.ss1 = null;
		this.ss2 = null;
		this.t = t;
		this.altNo = 1;
		this.itStr = itString;
		this.indent = indent;
	}
	
	public void ParseIf() {
		this.t.skipToken();
		c = new Cond1(t);
		c.ParseCond();
		this.t.skipToken();
		ss1 = new SS1(t, this.itStr, this.indent+1);
		ss1.ParseSS();
		if(t.getToken() == TokenKind.ELSE) {
			this.altNo = 2;
			this.t.skipToken();
			ss2 = new SS1(t, this.itStr, this.indent+1);
			ss2.ParseSS();
		}
		t.skipToken();
		t.skipToken();
	}
	
	public void PrintIf() {
		Helper.PrintIndentation(this.indent);
		System.out.print("If ");
		c.PrintCond();
		System.out.println(" then ");
		ss1.PrintSS();
		if(this.altNo == 2) {
			Helper.PrintIndentation(this.indent);
			System.out.println("else");
			ss2.PrintSS();
		}
		Helper.PrintIndentation(this.indent);
		System.out.println("end;");
	}
	
	public void ExecIf() {
		if(c.ExecCond()) {
			ss1.ExecSS();
		}else {
			if(this.altNo == 2) {
				ss2.ExecSS();
			}
		}
	}
}

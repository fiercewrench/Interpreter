package edu.c3341;

import java.util.Iterator;

public class SS1 implements SS {
	private SS1 stmtSeq;
	private Stmt1 stmt;
	private Tokenizer t;
	private int altNo;
	private Iterator<String> itStr;
	private int indent;
	public SS1(Tokenizer t, Iterator<String> itString, int indent) {
		this.stmtSeq = null;
		this.stmt = null;
		this.t = t;
		this.altNo = 1;
		this.itStr = itString;
		this.indent = indent;
	}
	public void ParseSS() {
		this.stmt = new Stmt1(t, this.itStr, this.indent);
		this.stmt.ParseStmt();
		if(t.getToken() != TokenKind.END && t.getToken() != TokenKind.ELSE) {
			this.altNo = 2;
			this.stmtSeq = new SS1(t, this.itStr, this.indent);
			this.stmtSeq.ParseSS();
		}
	}
	
	public void PrintSS() {
		this.stmt.PrintStmt();
		if(this.altNo == 2) {
			this.stmtSeq.PrintSS();
		}
	}
	
	public void ExecSS() {
		this.stmt.ExecStmt();
		if(this.altNo == 2) {
			this.stmtSeq.ExecSS();
		}
	}
}

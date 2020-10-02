package edu.c3341;

public class Op1 implements Op {
	private No1 no;
	private Id1 id;
	private Exp1 exp;
	private Tokenizer t;
	private int altNo;
	int opVal;
	public Op1(Tokenizer t) {
		this.no = null;
		this.id = null;
		this.exp = null;
		this.t = t;
	}
	
	public void ParseOp() {
		TokenKind kind = t.getToken();
		if(kind == TokenKind.INTEGER_CONSTANT) {
			this.altNo = 1;
			this.no = new No1(t);
			this.no.ParseNo();
		}else if(kind == TokenKind.IDENTIFIER) {
			this.altNo = 2;
			this.id = Id1.ParseIdForSS();
		}else if(kind == TokenKind.LEFT_PARENTHESIS) {
			this.altNo = 3;
			t.skipToken();
			exp.ParseExp();
			t.skipToken();
		}
	}
	
	public void PrintOp() {
		if(this.altNo == 1) {
			this.no.PrintNo();
		}else if(this.altNo == 2) {
			this.id.PrintId();
		}else if(this.altNo == 3) {
			System.out.print("(");
			this.exp.PrintExp();
			System.out.print(")");
		}
	}
	
	public int ExecOp() {
		if(this.altNo == 1) {
			this.opVal = this.no.ExecNo();
		}else if(this.altNo == 2) {
			this.opVal = this.id.ExecId(false);
		}else if(this.altNo == 3) {
			this.opVal = this.exp.ExecExp();
		}
		return this.opVal;
	}
}

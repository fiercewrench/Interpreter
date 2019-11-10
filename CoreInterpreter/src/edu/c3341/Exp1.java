package edu.c3341;

public class Exp1 implements Exp {
	private Trm1 trm;
	private Exp1 exp;
	private Tokenizer t;
	private int AltNo;
	int expVal;
	public Exp1(Tokenizer t) {
		this.trm = null;
		this.exp = null;
		this.t = t;
		this.AltNo = 1;
	}
	
	public void ParseExp() {
		trm = new Trm1(t);
		trm.ParseTrm();
		if(t.getToken() == TokenKind.ADDITION_OPERATOR) {
			this.AltNo = 2;
			t.skipToken();
			this.exp = new Exp1(t);
			exp.ParseExp();
		}else if (t.getToken() == TokenKind.SUBTRACTION_OPERATOR) {
			this.AltNo = 3;
			t.skipToken();
			this.exp = new Exp1(t);
			exp.ParseExp();
		}
	}
	
	public void PrintExp() {
		trm.PrintTrm();
		if(this.AltNo == 2) {
			System.out.print(" + ");
			exp.PrintExp();
		}else if(this.AltNo == 3) {
			System.out.print(" - ");
			exp.PrintExp();
		}
	}
	
	public int ExecExp() {
		int result = trm.ExecTrm();
		if(this.AltNo == 2) {
			result += exp.ExecExp();
		}else if(this.AltNo == 3) {
			result -= exp.ExecExp();
		}
		this.expVal = result;
		return this.expVal;
	}
}

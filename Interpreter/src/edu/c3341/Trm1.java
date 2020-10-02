package edu.c3341;

public class Trm1 implements Trm {
	private Op1 op;
	private Trm1 trm;
	private Tokenizer t;
	private int altNo;
	int TrmVal;
	public Trm1(Tokenizer t) {
		this.op = null;
		this.trm = null;
		this.t = t;
		this.altNo = 1;
	}
	public void ParseTrm() {
		this.op = new Op1(t);
		this.op.ParseOp();
		if(t.getToken() == TokenKind.MULTIPLICATION_OPERATOR) {
			this.altNo = 2;
			t.skipToken();
			this.trm = new Trm1(t);
			this.trm.ParseTrm();
		}
	}
	public void PrintTrm() {
		this.op.PrintOp();
		if(this.altNo == 2) {
			System.out.print(" * ");
			this.trm.PrintTrm();
		}	
	}
	
	public int ExecTrm() {
		int result = this.op.ExecOp();
		if(this.altNo == 2) {
			result *= ExecTrm();
		}
		this.TrmVal = result;
		return this.TrmVal;
	}
}

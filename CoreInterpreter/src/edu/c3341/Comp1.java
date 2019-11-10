package edu.c3341;

public class Comp1 implements Comp {
	private Op1 op1;
	private Op1 op2;
	private CompOp1 compOp;
	private Tokenizer t;
	public Comp1(Tokenizer t) {
		this.op1 = null;
		this.op2 = null;
		this.compOp = null;
		this.t = t;
	}
	
	public void ParseComp() {
		this.t.skipToken();
		this.op1 = new Op1(t);
		this.op1.ParseOp();
		this.compOp = new CompOp1(t);
		this.compOp.ParseCompOp();
		this.op2 = new Op1(t);
		this.op2.ParseOp();
		this.t.getToken();
		this.t.skipToken();
	}
	
	public void PrintComp() {
		System.out.print("(");
		this.op1.PrintOp();
		this.compOp.PrintCompOp();
		this.op2.PrintOp();
		System.out.print(")");
	}
	
	public boolean ExecComp() {
		this.op1.ExecOp();
		this.op2.ExecOp();
		return this.compOp.ExecCompOp(this.op1,this.op2);
		
	}
}

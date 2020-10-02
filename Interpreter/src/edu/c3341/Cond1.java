package edu.c3341;

public class Cond1 implements Cond {
	private Comp1 comp;
	private Cond1 cond1;
	private Cond1 cond2;
	private Tokenizer t;
	private int altNo;
	public Cond1(Tokenizer t) {
		this.comp = null;
		this.cond1 = null;
		this.cond2 = null;
		this.t = t;
	}
	
	public void ParseCond() {
		if(t.getToken() == TokenKind.NOT_OPERATOR) {
			this.altNo = 2;
			t.skipToken();
			this.cond1 = new Cond1(t);
			this.cond1.ParseCond();
		}else if(t.getToken() == TokenKind.LEFT_SQUARE_BRACKET) {
			t.skipToken();
			this.cond1 = new Cond1(t);
			this.cond1.ParseCond();
			if(t.getToken() == TokenKind.AND_OPERATOR) {
				this.altNo = 3;
			}else if(t.getToken() == TokenKind.OR_OPERATOR) {
				this.altNo = 4;
			}
			t.skipToken();
			this.cond2 = new Cond1(t);
			this.cond2.ParseCond();
			t.getToken();
			t.skipToken();
		}else {
			this.altNo = 1;
			this.comp = new Comp1(t);
			this.comp.ParseComp();
		}
	}
	
	public void PrintCond() {
		if(this.altNo == 1) {
			this.comp.PrintComp();
		}else if(this.altNo == 2) {
			System.out.print("!");
			this.cond1.PrintCond();
		}else if(this.altNo == 3) {
			System.out.print("[");
			this.cond1.PrintCond();
			System.out.print(" && ");
			this.cond2.PrintCond();
			System.out.print("]");
		}else if(this.altNo == 4) {
			System.out.print("[");
			this.cond1.PrintCond();
			System.out.print(" or ");
			this.cond2.PrintCond();
			System.out.print("]");
		}
	}
	
	public boolean ExecCond() {
		if(this.altNo == 1) {
			return this.comp.ExecComp();
		}else if(this.altNo == 2) {
			return !this.cond1.ExecCond();
		}else if(this.altNo == 3) {
			return this.cond1.ExecCond() && this.cond2.ExecCond();
		}else if(this.altNo == 4) {
			return this.cond2.ExecCond() || this.cond2.ExecCond();
		}
		return false;
	}
}

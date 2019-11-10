package edu.c3341;

public class DS1 implements DS {
	private DS1 declSeq;
	private Decl1 decl;
	private int altNo;
	private Tokenizer t;
	private int indent;
	public DS1(Tokenizer t, int indent) {
		this.declSeq = null;
		this.decl = null;
		this.altNo = 1;
		this.t = t;
		this.indent = indent;
	}
	public void ParseDS() {
		this.decl = new Decl1(t);
		this.decl.ParseDecl();
		if(t.getToken() != TokenKind.BEGIN) {
			this.altNo = 2;
			this.declSeq = new DS1(t, indent);
			this.declSeq.ParseDS();
		}
	}
	
	public void PrintDS() {
		Helper.PrintIndentation(indent);
		this.decl.PrintDecl();
		if(this.altNo == 2) {
			this.declSeq.PrintDS();
		}
	}
	
	public void ExecDS() {
		this.decl.ExecDecl();
		if(this.altNo == 2) {
			this.declSeq.ExecDS();
		}
	}
}

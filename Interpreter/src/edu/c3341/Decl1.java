package edu.c3341;

public class Decl1 implements Decl {
	private IdList1 idList;
	private Tokenizer t;
	public Decl1(Tokenizer t) {
		this.idList = null;
		this.t = t;
	}
	public void ParseDecl() {
		t.skipToken();
		this.idList = new IdList1(t);
		this.idList.ParseIdListForDS();
		t.skipToken();
	}
	public void PrintDecl() {
		System.out.print("int ");
		this.idList.PrintIdList();
		System.out.println(";");
	}
	public void ExecDecl() {
		//do nothing
	}
}

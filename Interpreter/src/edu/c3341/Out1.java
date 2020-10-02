package edu.c3341;

import java.util.Set;

public class Out1 implements Out {
	private IdList1 idList;
	private Tokenizer t;
	private int indent;
	public Out1(Tokenizer t, int indent) {
		this.idList = null;
		this.t = t;
		this.indent = indent;
	}
	
	public void ParseOut() {
		this.t.skipToken();
		this.idList = new IdList1(t);
		idList.ParseIdListForSS();
		this.t.skipToken();
	}
	
	public void PrintOut() {
		Helper.PrintIndentation(this.indent);
		System.out.print("write ");
		this.idList.PrintIdList();
		System.out.println(";");
	}
	
	public void ExecOut() {
		Set<String> idSet = this.idList.ExecIdList(false);
		for(Id1 id : Id1.eids) {
			if(id != null && idSet.contains(id.name) && id.initialized) {
				System.out.println(id.name + " = " + id.val);				
			}	
		}
	}
}

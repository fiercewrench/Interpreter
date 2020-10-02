package edu.c3341;

import java.util.Iterator;
import java.util.Set;

public class In1 implements In {
	private IdList1 idList;
	private Tokenizer t;
	private Iterator<String> itStr;
	private int indent;
	public In1(Tokenizer t, Iterator<String> itString, int indent) {
		this.idList = null;
		this.t = t;
		this.itStr = itString;
		this.indent = indent;
	}
	
	public void ParseIn() {
		this.t.skipToken();
		this.idList = new IdList1(t);
		idList.ParseIdListForSS();
		this.t.skipToken();
	}
	
	public void PrintIn() {
		Helper.PrintIndentation(this.indent);
		System.out.print("read ");
		this.idList.PrintIdList();
		System.out.println(";");
	}
	
	public void ExecIn() {
		Set<String> idSet = this.idList.ExecIdList(true);
		
		for(Id1 id:Id1.eids) {
			if(id != null && idSet.contains(id.name)) {
				if(this.itStr.hasNext()) {
					String valStr = this.itStr.next();
					id.val = Integer.parseInt(valStr);
					id.initialized = true;
				}
			}
		}
	}
}

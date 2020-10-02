package edu.c3341;

import java.util.HashSet;
import java.util.Set;

public class IdList1 implements IdList {
	private Id1 id;
	private IdList1 idList;
	private Tokenizer t;
	private int altNo;
	public IdList1(Tokenizer t) {
		this.id = null;
		this.idList = null;
		this.altNo = 1;
		this.t = t;
	}
	public void ParseIdListForDS() {
		this.id = Id1.ParseIdForDS();
		if(t.getToken() == TokenKind.COMMA) {
			t.skipToken();
			this.altNo = 2;
			this.idList = new IdList1(t);
			this.idList.ParseIdListForDS();
		}
	}
	
	public void ParseIdListForSS() {
		this.id = Id1.ParseIdForSS();
		if(t.getToken() == TokenKind.COMMA) {
			t.skipToken();
			this.altNo = 2;
			this.idList = new IdList1(t);
			this.idList.ParseIdListForSS();
		}
	}
	public void PrintIdList() {
		this.id.PrintId();
		if(this.altNo == 2) {
			System.out.print(", ");
			this.idList.PrintIdList();
		}
	}

	public Set<String> ExecIdList(boolean read) {	
		Set<String> idSet = new HashSet<>();
		Set<String> subIdSet = new HashSet<>();
		this.id.ExecId(read);
		idSet.add(this.id.name);
		if(this.altNo == 2) {
			subIdSet = this.idList.ExecIdList(read);
		}
		for(String name : subIdSet) {
			idSet.add(name);
		}
		return idSet;
	}
}

package edu.c3341;

public class Id1 implements Id {
	static Id1[] eids = new Id1[20];
	static int idCount = 0;
	private static Tokenizer t = Tokenizer1.instance();
	boolean initialized;
	int val;
	String name;
	private Id1(String name) {
		this.name = name;
		this.initialized = false;
	}
	public static Id1 ParseIdForDS() {
		t.getToken();
		String n = t.idName();
		for(Id1 id : eids) {
			if(id != null && id.name.equals(n)) {
				System.err.println(n + " has already been declared");
				t.skipToken();
				return null;
			}
		}
		Id1 nId = new Id1(n);
		for(int i = 0; i < eids.length; i++) {
			if(eids[i] == null) {
				eids[i] = nId;
				break;
			}
		}
		t.skipToken();
		return nId;
	}
	public static Id1 ParseIdForSS() {
		t.getToken();
		String n = t.idName();
		for(Id1 id : eids) {
			if(id != null && id.name.equals(n)) {
				
				t.skipToken();
				return id;
			}
		}
		t.skipToken();
		System.err.println(n + " has not been declared");
		return null;
	}
	public void PrintId() {
		t.getToken();
		System.out.print(this.name);
	}
	public int ExecId(boolean read) {
		if(!read && !this.initialized) {
			System.out.println("Error: Attempt to use variable " + this.name + " without prior initialization.");
			System.exit(1);
		}
		return this.val;
	}
}

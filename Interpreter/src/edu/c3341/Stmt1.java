package edu.c3341;

import java.util.Iterator;

public class Stmt1 implements Stmt{
	private Assign1 assign_obj;
	private If1 if_obj;
	private Loop1 loop_obj;
	private In1 in_obj;
	private Out1 out_obj;
	private int altNo;
	private Tokenizer t;
	private Iterator<String> itStr;
	private int indent;
	public Stmt1(Tokenizer t, Iterator<String> itString, int indent) {
		this.assign_obj = null;
		this.if_obj = null;
		this.loop_obj = null;
		this.in_obj = null;
		this.out_obj = null;
		this.t = t;
		this.itStr = itString;
		this.indent = indent;
	}
	
	public void ParseStmt() {
		TokenKind kind = t.getToken();
		switch(kind) {
		case IDENTIFIER:
			this.altNo = 1;
			this.assign_obj = new Assign1(t, this.indent);
			this.assign_obj.ParseAssign();
			break;
		case IF:
			this.altNo = 2;
			this.if_obj = new If1(t, this.itStr, this.indent);
			this.if_obj.ParseIf();
			break;
		case WHILE:
			this.altNo = 3;
			this.loop_obj = new Loop1(t, this.itStr, this.indent);
			this.loop_obj.ParseLoop();
			break;
		case READ:
			this.altNo = 4;
			this.in_obj = new In1(t, this.itStr, this.indent);
			this.in_obj.ParseIn();
			break;
		case WRITE:
			this.altNo = 5;
			this.out_obj = new Out1(t,this.indent);
			this.out_obj.ParseOut();
			break;
		default:
			break;
		}
	}
	
	public void PrintStmt() {
		switch(this.altNo) {
		case 1:
			this.assign_obj.PrintAssign();
			break;
		case 2:
			this.if_obj.PrintIf();
			break;
		case 3:
			this.loop_obj.PrintLoop();
			break;
		case 4:
			this.in_obj.PrintIn();
			break;
		case 5:
			this.out_obj.PrintOut();
			break;
		default:
			break;
		}
	}
	
	public void ExecStmt() {
		switch(this.altNo) {
		case 1:
			this.assign_obj.ExecAssign();
			break;
		case 2:
			this.if_obj.ExecIf();
			break;
		case 3:
			this.loop_obj.ExecLoop();
			break;
		case 4:
			this.in_obj.ExecIn();
			break;
		case 5:
			this.out_obj.ExecOut();
			break;
		default:
			break;
		}
	}
}

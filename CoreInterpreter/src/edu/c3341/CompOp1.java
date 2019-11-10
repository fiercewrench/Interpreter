package edu.c3341;

public class CompOp1 implements CompOp {
	private String symbol;
	private Tokenizer t;
	public CompOp1(Tokenizer t) {
		this.symbol = null;
		this.t = t;
	}
	
	public void ParseCompOp() {
		TokenKind kind = t.getToken();
		switch(kind) {
		case INEQUALITY_TEST:
			this.symbol = "!=";
			break;
		case EQUALITY_TEST:
			this.symbol = "==";
			break;
		case LESS_THAN:
			this.symbol = "<";
			break;
		case GREATER_THAN:
			this.symbol = ">";
			break;
		case LESS_THAN_OR_EQUAL:
			this.symbol = "<=";
			break;
		case GREATER_THAN_OR_EQUAL:
			this.symbol = ">=";
			break;
		default:
			break;
		}
		t.skipToken();
	}
	
	public void PrintCompOp() {
		System.out.print(" " + this.symbol + " ");
	}
	
	public boolean ExecCompOp(Op1 op1, Op1 op2) {
		switch(this.symbol) {
		case "!=":
			return op1.opVal != op2.opVal;
		case "==":
			return op1.opVal == op2.opVal;
		case "<":
			return op1.opVal < op2.opVal;
		case ">":
			return op1.opVal > op2.opVal;
		case "<=":
			return op1.opVal <= op2.opVal;
		case ">=":
			return op1.opVal >= op2.opVal;
		default:
			return false;
		}
	}

}

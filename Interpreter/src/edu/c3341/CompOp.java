package edu.c3341;

/**
 * CompOp non-terminal for the Core project
 * @author Renfei Wang
 *
 */
public interface CompOp {
	
	/**
	 * Parse the CompOp to a parse tree node
	 */
	public void ParseCompOp();
	
	/**
	 * Print the production of CompOp
	 */
	public void PrintCompOp();
	
	/**
	 * Execute the CompOp statement
	 * @param op1 the first operator
	 * @param op2 the second operator
	 * @return the result of evaluating CompOp
	 * 
	 */
	public boolean ExecCompOp(Op1 op1, Op1 op2);
}

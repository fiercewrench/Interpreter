package edu.c3341;

/**
 * Op non-terminal for the Core project
 * @author Renfei Wang
 *
 */
public interface Op {
	
	/**
	 * Parse the op to a parse tree node
	 */
	public void ParseOp();
	
	/**
	 * Print the production of op
	 */
	public void PrintOp();
	
	/**
	 * Execute the op statement
	 * @return the result of evaluating op
	 */
	public int ExecOp();
}

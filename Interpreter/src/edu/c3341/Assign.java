package edu.c3341;

/**
 * Assign non-terminal for the Core project
 * @author Renfei Wang
 *
 */
public interface Assign {
	
	/**
	 * Parse the assign to a parse tree node
	 */
	public void ParseAssign();
	
	/**
	 * Print the production of assign
	 */
	public void PrintAssign();
	
	/**
	 * Execute the assign statement
	 */
	public void ExecAssign();
}

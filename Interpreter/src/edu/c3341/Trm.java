package edu.c3341;

/**
 * Trm non-terminal for the Core project
 * @author Renfei Wang
 *
 */
public interface Trm {
	
	/**
	 * Parse the trm to a parse tree node
	 */
	public void ParseTrm();
	
	/**
	 * Print the production of trm
	 */
	public void PrintTrm();
	
	/**
	 * Execute the trm statement
	 * @return the result of evaluating Trm
	 */
	public int ExecTrm();
}

package edu.c3341;

/**
 * Out non-terminal for the Core project
 * @author Renfei Wang
 *
 */
public interface Out {
	
	/**
	 * Parse the out to a parse tree node
	 */
	public void ParseOut();
	
	/**
	 * Print the production of out
	 */
	public void PrintOut();
	
	/**
	 * Execute the out statement
	 */
	public void ExecOut();
}

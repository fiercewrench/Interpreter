package edu.c3341;

/**
 * Loop non-terminal for the Core project
 * @author Renfei Wang
 *
 */
public interface Loop {
	
	/**
	 * Parse the loop to a parse tree node
	 */
	public void ParseLoop();
	
	/**
	 * Print the production of loop
	 */
	public void PrintLoop();
	
	/**
	 * Execute the loop statement
	 */
	public void ExecLoop();
}

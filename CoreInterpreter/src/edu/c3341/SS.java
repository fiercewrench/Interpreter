package edu.c3341;

/**
 * SS non-terminal for the Core project
 * @author Renfei Wang
 *
 */
public interface SS {
	
	/**
	 * Parse the SS to a parse tree node
	 */
	public void ParseSS();
	
	/**
	 * Print the production of SS
	 */
	public void PrintSS();
	
	/**
	 * Execute the SS statement
	 */
	public void ExecSS();
}

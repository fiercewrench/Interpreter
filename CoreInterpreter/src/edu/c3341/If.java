package edu.c3341;

/**
 * If non-terminal for the Core project
 * @author Renfei Wang
 *
 */
public interface If {
	
	/**
	 * Parse the if to a parse tree node
	 */
	public void ParseIf();
	
	/**
	 * Print the production of if
	 */
	public void PrintIf();
	
	/**
	 * Execute the if statement
	 */
	public void ExecIf();
}

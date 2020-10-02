package edu.c3341;

/**
 * Cond non-terminal for the Core project
 * @author Renfei Wang
 *
 */
public interface Cond {
	
	/**
	 * Parse the cond to a parse tree node
	 */
	public void ParseCond();
	
	/**
	 * Print the production of cond
	 */
	public void PrintCond();
	
	/**
	 * Execute the cond statement
	 * @return the result of executing cond
	 */
	public boolean ExecCond();
}
